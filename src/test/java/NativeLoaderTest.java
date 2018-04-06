import com.harium.util.loader.NativeLoader;
import org.junit.Assert;
import org.junit.Test;

public class NativeLoaderTest {

    private static final String LIB_HELLO = "hello";

    @Test
    public void testFindLibraryFolder() {
        boolean found = NativeLoader.load(LIB_HELLO);
        Assert.assertTrue(found);

        found = NativeLoader.load("libs/natives/unix/x86_64", LIB_HELLO);
        Assert.assertTrue(found);
    }

    @Test
    public void loadLibrary() {
        NativeLoader.load(LIB_HELLO);
        Assert.assertTrue("", new HelloWorld().printHelloWorld());
    }

}
