package com.pydawan.dto;

/**
 * A DtoException is thrown when a Dto is not valid.
 */
public class DtoException extends RuntimeException {
    public DtoException(String message) {
        super(message);
    }

}
