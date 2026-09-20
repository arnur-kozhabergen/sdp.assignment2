package abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        GUIFactory windowsFactory = new WindowsFactory();
        GUIFactory macOSFactory = new MacOSFactory();

        check(windowsFactory.createButton() instanceof WindowsButton,
                "WindowsFactory must create a WindowsButton");
        check(windowsFactory.createCheckbox() instanceof WindowsCheckbox,
                "WindowsFactory must create a WindowsCheckbox");
        check(macOSFactory.createButton() instanceof MacOSButton,
                "MacOSFactory must create a MacOSButton");
        check(macOSFactory.createCheckbox() instanceof MacOSCheckbox,
                "MacOSFactory must create a MacOSCheckbox");

        windowsFactory.createButton().paint();
        windowsFactory.createCheckbox().paint();
        macOSFactory.createButton().paint();
        macOSFactory.createCheckbox().paint();

        System.out.println("Abstract Factory test passed");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
