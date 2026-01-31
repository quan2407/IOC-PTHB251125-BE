public class Television extends Device implements Connectable{
    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void connectWifi() {
        System.out.println("Television wifi connected");
    }

    @Override
    public void turnOn() {
        System.out.println("Television turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("Television turn off");
    }
}
