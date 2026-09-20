package app;

import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: ROAD|SEA WINDOWS|MACOS");
            return;
        }

        String deliveryMode = args[0].toUpperCase();
        String uiPlatform = args[1].toUpperCase();

        Logistics logistics;
        switch (deliveryMode) {
            case "ROAD" -> logistics = new RoadLogistics();
            case "SEA" -> logistics = new SeaLogistics();
            default -> {
                System.out.println("Unsupported delivery mode: " + args[0]);
                return;
            }
        }

        GUIFactory guiFactory;
        switch (uiPlatform) {
            case "WINDOWS" -> guiFactory = new WindowsFactory();
            case "MACOS" -> guiFactory = new MacOSFactory();
            default -> {
                System.out.println("Unsupported UI platform: " + args[1]);
                return;
            }
        }

        System.out.println("Delivery mode: " + deliveryMode);
        System.out.println("UI platform: " + uiPlatform);

        DeliveryApplication application = new DeliveryApplication(guiFactory, logistics);
        application.run();
    }
}
