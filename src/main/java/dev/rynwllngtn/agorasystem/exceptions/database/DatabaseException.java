package dev.rynwllngtn.agorasystem.exceptions.database;

import lombok.Getter;

import java.util.UUID;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }

    @Getter
    public static class ResourceNotFoundException extends DatabaseException{

        private String className;

        public ResourceNotFoundException(Class<?> classType, UUID id) {
            super(String.format("%s com o ID: %s não foi encontrado!", classType.getSimpleName(), id));
            this.className = classType.getSimpleName();
        }
    }

}