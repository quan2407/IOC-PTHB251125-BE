public class Laptop extends Device implements Connectable,Chargeable{
    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void charge() {
        System.out.println("Laptop charge");
    }

    @Override
    public void connectWifi() {
        System.out.println("Laptop connect wifi");
    }

    @Override
    public void turnOn() {
        System.out.println("Laptop turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("Laptop turn off");
    }
}
