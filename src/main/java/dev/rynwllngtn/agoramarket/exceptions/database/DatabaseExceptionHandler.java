package dev.rynwllngtn.agoramarket.exceptions.database;

import dev.rynwllngtn.agoramarket.exceptions.StandardError;
import dev.rynwllngtn.agoramarket.exceptions.database.DatabaseException.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class DatabaseExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
                                                          HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = String.format("%s não encontrado!", e.getClassName());
        StandardError exception = new StandardError(Instant.now(),
                                                    status.value(),
                                                    error,
                                                    e.getMessage(),
                                                    request.getRequestURI());

        return ResponseEntity.status(status).body(exception);
    }

}