package factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        Logistics seaLogistics = new SeaLogistics();

        if (!(roadLogistics.createTransport() instanceof Truck)) {
            throw new AssertionError("RoadLogistics must create a Truck");
        }

        if (!(seaLogistics.createTransport() instanceof Ship)) {
            throw new AssertionError("SeaLogistics must create a Ship");
        }

        roadLogistics.planDelivery("medical supplies", "Almaty warehouse");
        seaLogistics.planDelivery("medical supplies", "Aktau port");

        System.out.println("Factory Method test passed");
    }
}
