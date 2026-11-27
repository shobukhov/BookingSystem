package com.sio.bookingsystem.room;

import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRoomRepository implements RoomRepository {
    private final Map<Long, Room> rooms = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(2);

    public InMemoryRoomRepository() {
        rooms.put(1L, new Room(1L, "B722", 4));
        rooms.put(2L, new Room(2L, "B723", 10));
    }

    @Override
    public List<Room> findAll() {
        return rooms.values().stream()
                .sorted(Comparator.comparingLong(Room::id))
                .toList();
    }

    @Override
    public Optional<Room> findById(long id) {
        return Optional.ofNullable(rooms.get(id));
    }

    @Override
    public boolean existsByName(String name) {
        return rooms.values().stream().anyMatch(room -> room.name().equals(name));
    }

    @Override
    public Room save(Room room) {
        long id = (room.id() == null) ? nextId.incrementAndGet() : room.id();
        Room saved = new Room(id, room.name(), room.capacity());
        rooms.put(id, saved);
        return saved;
    }

    @Override
    public boolean deleteById(long id) {
        return rooms.remove(id) != null;
    }
}

