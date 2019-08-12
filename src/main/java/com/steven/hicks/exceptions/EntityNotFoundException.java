package com.steven.hicks.exceptions;

public class EntityNotFoundException extends Throwable
{
    private String message = "";

    public EntityNotFoundException(String message)
    {
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
