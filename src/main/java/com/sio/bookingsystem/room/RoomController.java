package com.sio.bookingsystem.room;

import com.sio.bookingsystem.room.dto.RoomRequest;
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
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(
            @Valid
            @RequestBody
            RoomRequest request
    ) {
        return service.create(request.name(), request.capacity());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room update(
            @PathVariable("id")
            long id,

            @Valid
            @RequestBody
            RoomRequest request
    ) {
        return service.update(id, request.name(), request.capacity());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id")
            long id
    ) {
        service.delete(id);
    }
}
