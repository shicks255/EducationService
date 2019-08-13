package com.steven.hicks.exceptions;

public class EntityNotFoundException extends RuntimeException
{
    private String message = "";

    public EntityNotFoundException(String message)
    {
        super(message);
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
