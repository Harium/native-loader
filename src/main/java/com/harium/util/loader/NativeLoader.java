package com.harium.util.loader;

import cz.adamh.utils.NativeUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class NativeLoader {

    public static boolean DEBUG = false;
    private static final String STANDARD_DIR = "/libs/natives";

    public static boolean load(String libname) {
        String folder = buildFolder();
        // If can't find the library inside the jar
        if (!loadLibraryFromJar(folder, libname)) {
            // Tries to find the library inside a folder
            String path = System.getProperty("user.dir");
            return loadLibraryFromFolder(path, libname);
        }

        return true;
    }

    public static boolean loadLibraryFromJar(String path, String libname) {
        String libraryFile = System.mapLibraryName(libname);

        try {
            NativeUtils.loadLibraryFromJar(path + File.separator + libraryFile);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static boolean loadLibraryFromFolder(String path, String libname) {
        File nativesFolder = new File(path + STANDARD_DIR);

        if (!nativesFolder.exists()) {
            return false;
        }

        String nativesPath = buildFolder(path);

        log("Loading libraries from: " + nativesPath);

        System.setProperty("java.library.path", nativesPath);

        //set sys_paths to null
        try {
            Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathsField.setAccessible(true);
            sysPathsField.set(null, null);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        System.loadLibrary(libname);

        return true;
    }

    private static void log(String text) {
        if (!DEBUG) {
            return;
        }
        System.out.println(text);
    }

    public static String buildFolder() {
        return buildFolder("");
    }

    private static String buildFolder(String path) {
        String osFolder = OSDiscover.getOS().getFolder();
        String archFolder = OSDiscover.getArchitecture().getFolder();

        if (osFolder.isEmpty()) {
            return path + STANDARD_DIR;
        }

        return path + STANDARD_DIR + File.separator + osFolder + File.separator + archFolder + File.separator;
    }

}
