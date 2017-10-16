package com.harium.util.loader;

import com.harium.util.loader.model.Architecture;
import com.harium.util.loader.model.OS;

public class OSDiscover {

    public static Architecture getArchitecture() {
        if (SystemUtils.OS_ARCH.endsWith("86")) {
            return Architecture.X32;
        } else if (SystemUtils.OS_ARCH.endsWith("64")) {
            return Architecture.X64;
        } else {
            return Architecture.UNKNOWN;
        }
    }

    public static OS getOS() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return OS.WINDOWS;
        } else if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
            return OS.MAC;
        } else if (SystemUtils.IS_OS_LINUX) {
            return OS.LINUX;
        } else if (SystemUtils.IS_OS_SOLARIS) {
            return OS.SOLARIS;
        } else if (SystemUtils.IS_OS_SUN_OS) {
            return OS.SUN_OS;
        } else {
            return OS.UNKNOWN;
        }
    }

}
