public class SmartPhone extends Device implements Connectable,Chargeable{
    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void charge() {
        System.out.println("SmartPhone charge");
    }

    @Override
    public void connectWifi() {
        System.out.println("SmartPhone connectWifi");
    }

    @Override
    public void turnOn() {
        System.out.println("SmartPhone turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartPhone turn off");
    }
}
