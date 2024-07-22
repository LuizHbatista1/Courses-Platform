package com.api.lessons.infra.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(Long id){

        super("id not found" + id);

    }
}
