# Native Loader
An utility tool to load native libraries

It uses [https://github.com/adamheinrich/native-utils](native-utils) to
load libraries from a jar (if your application is a single jar).
It also uses a custom implementation to load libraries from outside the
jar.

## How to use it
1. Add native-loader to your pom.xml
    ```
    <dependency>
        <groupId>com.harium</groupId>
        <artifactId>native-loader</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

2. Load your library
    ```
    NativeLoader.load("hello");
    ```


3. Place your files into a folder based on OS name.

    `/libs/natives/os_name/os_arch`

    E.g:

    *Windows 32 bits:*
    ```
    /libs/native/windows/i586
    ```

    *Linux 64 bits:*
    ```
    /libs/native/unix/x86_64
    ```
