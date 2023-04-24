package com.indua.blueva.utils;

// Primitive type enums
public enum BJPrimTypes {
    INT("Integer"),
    FLOAT("Float"),
    DOUBLE("Double"),
    LONG("Long"),
    SHORT("Short"),
    BYTE("Byte"),
    CHAR("Character"),
    BOOLEAN("Boolean"),
    VOID("Void"),
    STRING("String");

    private String className;

    BJPrimTypes (String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}