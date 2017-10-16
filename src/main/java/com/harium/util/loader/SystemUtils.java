package com.harium.util.loader;

/**
 * Lightweight class forked from SystemUtils.java from Apache Commons Lang
 * https://raw.githubusercontent.com/apache/commons-lang/master/src/main/java/org/apache/commons/lang3/SystemUtils.java
 */
public class SystemUtils {

    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");

    /**
     * The prefix String for all Windows OS.
     */
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";

    // Operating system checks
    // -----------------------------------------------------------------------
    // These MUST be declared after those above as they depend on the
    // values being set up
    // OS names from http://www.vamphq.com/os.html
    // Selected ones included - please advise dev@commons.apache.org
    // if you want another added or a mistake corrected

    /**
     * <p>
     * Is {@code true} if this is AIX.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_AIX = getOSMatchesName("AIX");

    /**
     * <p>
     * Is {@code true} if this is HP-UX.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_HP_UX = getOSMatchesName("HP-UX");

    /**
     * <p>
     * Is {@code true} if this is IBM OS/400.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.3
     */
    public static final boolean IS_OS_400 = getOSMatchesName("OS/400");

    /**
     * <p>
     * Is {@code true} if this is Irix.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_IRIX = getOSMatchesName("Irix");

    /**
     * <p>
     * Is {@code true} if this is Linux.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_LINUX = getOSMatchesName("Linux") || getOSMatchesName("LINUX");

    /**
     * <p>
     * Is {@code true} if this is Mac.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_MAC = getOSMatchesName("Mac");

    /**
     * <p>
     * Is {@code true} if this is Mac.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Cheetah.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_CHEETAH = getOSMatches("Mac OS X", "10.0");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Puma.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_PUMA = getOSMatches("Mac OS X", "10.1");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Jaguar.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_JAGUAR = getOSMatches("Mac OS X", "10.2");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Panther.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_PANTHER = getOSMatches("Mac OS X", "10.3");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Tiger.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_TIGER = getOSMatches("Mac OS X", "10.4");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Leopard.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_LEOPARD = getOSMatches("Mac OS X", "10.5");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Snow Leopard.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD = getOSMatches("Mac OS X", "10.6");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Lion.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_LION = getOSMatches("Mac OS X", "10.7");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Mountain Lion.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION = getOSMatches("Mac OS X", "10.8");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Mavericks.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_MAVERICKS = getOSMatches("Mac OS X", "10.9");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X Yosemite.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_YOSEMITE = getOSMatches("Mac OS X", "10.10");

    /**
     * <p>
     * Is {@code true} if this is Mac OS X El Capitan.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.5
     */
    public static final boolean IS_OS_MAC_OSX_EL_CAPITAN = getOSMatches("Mac OS X", "10.11");

    /**
     * <p>
     * Is {@code true} if this is FreeBSD.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.1
     */
    public static final boolean IS_OS_FREE_BSD = getOSMatchesName("FreeBSD");

    /**
     * <p>
     * Is {@code true} if this is OpenBSD.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.1
     */
    public static final boolean IS_OS_OPEN_BSD = getOSMatchesName("OpenBSD");

    /**
     * <p>
     * Is {@code true} if this is NetBSD.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.1
     */
    public static final boolean IS_OS_NET_BSD = getOSMatchesName("NetBSD");

    /**
     * <p>
     * Is {@code true} if this is OS/2.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_OS2 = getOSMatchesName("OS/2");

    /**
     * <p>
     * Is {@code true} if this is Solaris.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_SOLARIS = getOSMatchesName("Solaris");

    /**
     * <p>
     * Is {@code true} if this is SunOS.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_SUN_OS = getOSMatchesName("SunOS");

    /**
     * <p>
     * Is {@code true} if this is a UNIX like system, as in any of AIX, HP-UX, Irix, Linux, MacOSX, Solaris or SUN OS.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.1
     */
    public static final boolean IS_OS_UNIX = IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX
            || IS_OS_SOLARIS || IS_OS_SUN_OS || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD;

    /**
     * <p>
     * Is {@code true} if this is Windows.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);

    /**
     * <p>
     * Is {@code true} if this is Windows 2000.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_2000 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 2000");

    /**
     * <p>
     * Is {@code true} if this is Windows 2003.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.1
     */
    public static final boolean IS_OS_WINDOWS_2003 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 2003");

    /**
     * <p>
     * Is {@code true} if this is Windows Server 2008.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.1
     */
    public static final boolean IS_OS_WINDOWS_2008 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Server 2008");

    /**
     * <p>
     * Is {@code true} if this is Windows Server 2012.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.4
     */
    public static final boolean IS_OS_WINDOWS_2012 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Server 2012");

    /**
     * <p>
     * Is {@code true} if this is Windows 95.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_95 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 95");

    /**
     * <p>
     * Is {@code true} if this is Windows 98.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_98 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 98");

    /**
     * <p>
     * Is {@code true} if this is Windows ME.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_ME = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Me");

    /**
     * <p>
     * Is {@code true} if this is Windows NT.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_NT = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " NT");

    /**
     * <p>
     * Is {@code true} if this is Windows XP.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.0
     */
    public static final boolean IS_OS_WINDOWS_XP = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " XP");

    // -----------------------------------------------------------------------
    /**
     * <p>
     * Is {@code true} if this is Windows Vista.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 2.4
     */
    public static final boolean IS_OS_WINDOWS_VISTA = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Vista");

    /**
     * <p>
     * Is {@code true} if this is Windows 7.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.0
     */
    public static final boolean IS_OS_WINDOWS_7 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 7");

    /**
     * <p>
     * Is {@code true} if this is Windows 8.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.2
     */
    public static final boolean IS_OS_WINDOWS_8 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 8");

    /**
     * <p>
     * Is {@code true} if this is Windows 10.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.5
     */
    public static final boolean IS_OS_WINDOWS_10 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 10");

    /**
     * <p>
     * Is {@code true} if this is z/OS.
     * </p>
     * <p>
     * The field will return {@code false} if {@code OS_NAME} is {@code null}.
     * </p>
     *
     * @since 3.5
     */
    // Values on a z/OS system I tested (Gary Gregory - 2016-03-12)
    // os.arch = s390x
    // os.encoding = ISO8859_1
    // os.name = z/OS
    // os.version = 02.02.00
    public static final boolean IS_OS_ZOS = getOSMatchesName("z/OS");

    /**
     * Decides if the operating system matches.
     * <p>
     * This method is package private instead of private to support unit test invocation.
     * </p>
     *
     * @param osName          the actual OS name
     * @param osVersion       the actual OS version
     * @param osNamePrefix    the prefix for the expected OS name
     * @param osVersionPrefix the prefix for the expected OS version
     * @return true if matches, or false if not or can't determine
     */
    static boolean isOSMatch(String osName, String osVersion, String osNamePrefix, String osVersionPrefix) {
        if (osName == null || osVersion == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix) && osVersion.startsWith(osVersionPrefix);
    }

    /**
     * Decides if the operating system matches.
     * <p>
     * This method is package private instead of private to support unit test invocation.
     * </p>
     *
     * @param osName       the actual OS name
     * @param osNamePrefix the prefix for the expected OS name
     * @return true if matches, or false if not or can't determine
     */
    static boolean isOSNameMatch(String osName, String osNamePrefix) {
        if (osName == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix);
    }

    /**
     * Decides if the operating system matches.
     *
     * @param osNamePrefix    the prefix for the os name
     * @param osVersionPrefix the prefix for the version
     * @return true if matches, or false if not or can't determine
     */
    private static boolean getOSMatches(String osNamePrefix, String osVersionPrefix) {
        return isOSMatch(OS_NAME, OS_VERSION, osNamePrefix, osVersionPrefix);
    }

    /**
     * Decides if the operating system matches.
     *
     * @param osNamePrefix the prefix for the os name
     * @return true if matches, or false if not or can't determine
     */
    private static boolean getOSMatchesName(String osNamePrefix) {
        return isOSNameMatch(OS_NAME, osNamePrefix);
    }

}
