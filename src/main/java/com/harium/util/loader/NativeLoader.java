package com.harium.util.loader;

import com.harium.util.OSDetector;
import cz.adamh.utils.NativeUtils;

import java.io.File;
import java.io.IOException;

public class NativeLoader {

    public static boolean DEBUG = false;
    private static final String STANDARD_DIR = "/libs/natives";

    public static boolean load(String path, String libname) {
        return loadLibrary(path, libname);
    }

    public static boolean load(String libname) {
        String folder = buildFolder();
        return loadLibrary(folder, libname);
    }

    private static boolean loadLibrary(String folder, String libname) {
        String libraryFile = System.mapLibraryName(libname);

        // If can't find the library inside the jar
        if (!loadLibraryFromJar(folder, libraryFile)) {
            // Tries to find the library inside a folder
            String localPath = System.getProperty("user.dir") + File.separator + folder;
            return loadLibraryFromFolder(localPath, libraryFile);
        }
        return true;
    }

    public static boolean loadLibraryFromJar(String path, String libname) {
        StringBuilder builder = new StringBuilder();

        if (!path.isEmpty()) {
            if (!path.startsWith(File.separator)) {
                builder.append(File.separator);
            }
            builder.append(path);
            if (!path.endsWith(File.separator)) {
                builder.append(File.separator);
            }
        } else {
            builder.append(File.separator);
        }

        builder.append(libname);

        String relativePath = builder.toString();

        try {
            NativeUtils.loadLibraryFromJar(relativePath);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean loadLibraryFromFolder(String path, String libname) {
        File nativesFolder = new File(path);

        if (!nativesFolder.exists()) {
            return false;
        }

        log("Loading libraries from: " + path);
        System.load(path + File.separator + libname);

        return true;
    }

    private static void log(String text) {
        if (!DEBUG) {
            return;
        }
        System.out.println(text);
    }

    public static String buildFolder() {
        return buildFolder(STANDARD_DIR);
    }

    private static String buildFolder(String path) {
        StringBuilder builder = new StringBuilder();
        builder.append(path);

        String osFolder = OSDetector.getOS().getName();
        String archFolder = OSDetector.getArchitecture().getFolder();

        if (osFolder.isEmpty()) {
            return builder.toString();
        }

        builder.append(File.separator);
        builder.append(osFolder);
        builder.append(File.separator);
        builder.append(archFolder);
        builder.append(File.separator);

        return builder.toString();
    }

}
