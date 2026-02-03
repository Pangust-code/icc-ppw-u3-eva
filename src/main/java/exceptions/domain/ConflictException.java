package exceptions.domain;

import org.springframework.http.HttpStatus;

import exceptions.base.ApplicationException;

public class ConflictException extends ApplicationException {

    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}