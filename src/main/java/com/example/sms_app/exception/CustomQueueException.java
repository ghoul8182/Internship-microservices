package com.example.sms_app.exception;

public class CustomQueueException extends CustomException {

    public CustomQueueException(String message) {
        super(message);
    }

    public CustomQueueException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
