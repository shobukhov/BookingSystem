package com.sio.bookingsystem.room.exceptions;

public class RoomAlreadyExistsException extends RuntimeException{
    public RoomAlreadyExistsException(String name) {
        super("Room " + name + " already exists");
    }
}
