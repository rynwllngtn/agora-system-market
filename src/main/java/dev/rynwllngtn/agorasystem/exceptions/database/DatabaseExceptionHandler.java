package dev.rynwllngtn.agorasystem.exceptions.database;

import dev.rynwllngtn.agorasystem.exceptions.StandardError;
import dev.rynwllngtn.agorasystem.exceptions.ValidationError;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

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

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                .forEach(erro -> {
                    String field = erro.getField();
                    String message = erro.getDefaultMessage();
                    erros.put(field, message);});

        ValidationError exception = new ValidationError(Instant.now(),
                                                        status.value(),
                                                        erros,
                                                        request.getRequestURI());

        return ResponseEntity.status(status).body(exception);
    }

}