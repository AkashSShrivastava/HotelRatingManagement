package com.gold.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resources not found Exception");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
