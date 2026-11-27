package com.sio.bookingsystem.common.handler;

import com.sio.bookingsystem.room.exceptions.RoomAlreadyExistsException;
import com.sio.bookingsystem.room.exceptions.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ProblemDetail handleNotFound (
        RoomNotFoundException e
    ) {
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );
    }

    @ExceptionHandler(RoomAlreadyExistsException.class)
    public ProblemDetail handleAlreadyExist (
            RoomAlreadyExistsException e
    ) {
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                e.getMessage()
        );
    }
}
