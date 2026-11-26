package com.sio.bookingsystem.room;

import com.sio.bookingsystem.room.dto.CreateRoomRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public List<Room> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Room findById(
            @PathVariable("id")
            long id
    ) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(
            @Valid
            @RequestBody
            CreateRoomRequest request
    ) {
        return service.create(request.name(), request.capacity());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(
            @PathVariable("id")
            long id,

            @Valid
            @RequestBody
            CreateRoomRequest request
    ) {
        return service.update(id, request.name(), request.capacity())
                .map(room -> ResponseEntity.ok(room))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id")
            long id
    ) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
