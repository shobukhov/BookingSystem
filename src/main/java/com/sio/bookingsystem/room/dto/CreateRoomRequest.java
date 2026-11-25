package com.sio.bookingsystem.room.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRoomRequest(
        @NotBlank
        String name,

        @NotNull
        @Min(1)
        Integer capacity
) {
}
