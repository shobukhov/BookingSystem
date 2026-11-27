package com.sio.bookingsystem.room.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(long id) {
        super("Room with ID " + id + " not found");
    }
}
