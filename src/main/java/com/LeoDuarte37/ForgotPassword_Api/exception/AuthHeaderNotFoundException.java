package com.LeoDuarte37.ForgotPassword_Api.exception;

public class AuthHeaderNotFoundException extends Exception {

    public AuthHeaderNotFoundException(String message) {
        super(message);
    }

    public AuthHeaderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
