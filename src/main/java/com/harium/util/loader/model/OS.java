package com.harium.util.loader.model;

public enum OS {
    LINUX("unix"), MAC("mac"), SOLARIS("solaris"), SUN_OS("sun_os"), WINDOWS("windows"), UNKNOWN("");

    private final String folder;

    OS(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }
}
