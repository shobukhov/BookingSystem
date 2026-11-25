package com.sio.bookingsystem.room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    List<Room> findAll();
    Optional<Room> findById(long id);
    Room save(Room room);
}
