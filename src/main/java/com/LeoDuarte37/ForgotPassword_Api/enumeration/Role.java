package com.LeoDuarte37.ForgotPassword_Api.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN (1),
    MANAGER (2),
    COMMOM (3);

    private final int KEY;

    Role(int key) {
        this.KEY = key;
    }

    @JsonValue
    public int getKEY() {
        return KEY;
    }
}
