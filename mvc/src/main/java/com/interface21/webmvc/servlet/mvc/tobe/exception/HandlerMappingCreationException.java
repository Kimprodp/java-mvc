package com.interface21.webmvc.servlet.mvc.tobe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlerMappingCreationException extends  RuntimeException{

    private static final Logger log = LoggerFactory.getLogger(HandlerMappingCreationException.class);

    public HandlerMappingCreationException(String message, Throwable e) {
        super(message);
        log.error("HandlerMappingCreationException: {}: {}", e.getClass().getName(), message, e);
    }
}
