package com.steven.hicks.exceptions;

public class InvalidParamException extends Throwable
{
    private String message = "";

    public InvalidParamException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
