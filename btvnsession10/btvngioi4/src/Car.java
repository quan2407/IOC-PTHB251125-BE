public class Car {
    private int currentSpeed = 0;

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
        System.out.println("Current speed: " + currentSpeed);
    }
    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerate by " + speed + " km/h");
        System.out.println("Current speed: " + currentSpeed);

    }
    public void accelerate(int speed, int seconds) {
        int increase = speed*seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates by " + increase + " km/h");
        System.out.println("Current speed: " + currentSpeed);

    }
}
