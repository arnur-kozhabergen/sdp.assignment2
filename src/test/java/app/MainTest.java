package app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    public static void main(String[] args) {
        checkRun(new String[]{"ROAD", "WINDOWS"}, "Truck", "Windows button", "Windows checkbox");
        checkRun(new String[]{"SEA", "WINDOWS"}, "Ship", "Windows button", "Windows checkbox");
        checkRun(new String[]{"ROAD", "MACOS"}, "Truck", "macOS button", "macOS checkbox");
        checkRun(new String[]{"SEA", "MACOS"}, "Ship", "macOS button", "macOS checkbox");
        checkRun(new String[]{"PLANE", "WINDOWS"}, "Unsupported delivery mode");
        checkRun(new String[]{"ROAD", "LINUX"}, "Unsupported UI platform");
        checkRun(new String[]{}, "Usage:");

        System.out.println("All integration tests passed");
    }

    private static void checkRun(String[] args, String... expectedParts) {
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(args);

        System.setOut(originalOutput);
        String result = output.toString();

        for (String expectedPart : expectedParts) {
            if (!result.contains(expectedPart)) {
                throw new AssertionError("Expected output to contain: " + expectedPart);
            }
        }
    }
}
