package com.LeoDuarte37.ForgotPassword_Api.exception;

public class RegisterLoginException extends Exception{

    public RegisterLoginException(String message) {
        super(message);
    }

    public RegisterLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
