package com.sio.bookingsystem.room;
import com.sio.bookingsystem.room.exceptions.RoomAlreadyExistsException;
import com.sio.bookingsystem.room.exceptions.RoomNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> findAll() {
        return repository.findAll();
    }

    public Room findById(long id) {
        return repository.findById(id).orElseThrow( () -> new RoomNotFoundException(id));
    }

    public Room create(String name, int capacity) {
        if (repository.existsByName(name.strip())) {
            throw new RoomAlreadyExistsException(name);
        }
        return repository.save(new Room(null, name.strip(), capacity));
    }

    public Room update(long id, String name, int capacity) {
        Room room = findById(id);
        if (!room.name().equals(name.strip()) && repository.existsByName(name.strip())) {
            throw new RoomAlreadyExistsException(name.strip());
        }
        return repository.save(new Room(id, name.strip(), capacity));
    }

    public void delete(long id) {
        if (!repository.deleteById(id)) {
            throw new RoomNotFoundException(id);
        }
    }
}
