package com.harium.util.loader.model;

public enum Architecture {
    X32("i586"), X64("x86_64"), UNKNOWN("");

    private final String folder;

    Architecture(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }
}
