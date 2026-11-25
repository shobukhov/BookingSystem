package com.sio.bookingsystem.room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> findAll() {
        return repository.findAll();
    }

    public Optional<Room> findById(long id) {
        return repository.findById(id);
    }

    public Room create(String name, int capacity) {
        Room newRoom = new Room(null, name.strip(), capacity);
        return repository.save(newRoom);
    }
}
