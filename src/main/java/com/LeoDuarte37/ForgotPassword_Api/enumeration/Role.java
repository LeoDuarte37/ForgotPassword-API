package com.LeoDuarte37.ForgotPassword_Api.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <h1>Role</h1>
 * <p>
 *     This class is responsible for enumerating all
 *     available user roles.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
public enum Role {
    ADMIN (1),
    MANAGER (2),
    COMMON (3);

    private final int KEY;

    Role(int key) {
        this.KEY = key;
    }

    /**
     * Gets a Role by associated key
     *
     * @param key key associated with role.
     * @return Role by associated key
     */
    public static Role getRoleByKey(int key) {
        if (key == 1) {
            return ADMIN;
        } else if (key == 2) {
            return MANAGER;
        } else if (key == 3) {
            return COMMON;
        } else {
            return null;
        }
    }

    @JsonValue
    public int getKEY() {
        return KEY;
    }
}
