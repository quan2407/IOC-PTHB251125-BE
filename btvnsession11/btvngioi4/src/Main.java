import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Device> devices = new ArrayList<>();
        Device smartphone = new SmartPhone(1, "a");
        Device laptop = new Laptop(1, "a");
        Device television = new Television(1, "a");
        devices.add(smartphone);
        devices.add(laptop);
        devices.add(television);
        for (Device device : devices) {
            if (device instanceof Connectable) {
                ((Connectable) device).connectWifi();
            }
            if (device instanceof Chargeable) {
                ((Chargeable) device).charge();
            }
        }
    }
}