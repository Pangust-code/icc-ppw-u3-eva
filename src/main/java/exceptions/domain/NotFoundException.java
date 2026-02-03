package exceptions.domain;

import org.springframework.http.HttpStatus;

import exceptions.base.ApplicationException;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}