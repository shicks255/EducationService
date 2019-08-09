package com.steven.hicks.controllers;

import com.steven.hicks.exceptions.InvalidParamException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler
{
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
//    {
//        String error = "something bad";
//        return new ResponseEntity<>(new InvalidParamError(error), status);
//    }

    @ExceptionHandler(InvalidParamException.class)
    protected ResponseEntity<Object> handleInvalidParamError(RuntimeException e, WebRequest request)
    {
        return handleExceptionInternal(e, e.getCause().getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
