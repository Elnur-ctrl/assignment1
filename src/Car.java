public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public double calculateInsuranceFee() {
        return getBasePrice() * 0.03 + getAge(java.time.Year.now().getValue()) * 50;
    }

    public void performService() {
        System.out.println("Car serviced: oil and filters.");
    }

    public int getServiceIntervalKm() {
        return 10000;
    }

    public String toString() {
        return super.toString() + ", doors=" + numberOfDoors;
    }
}
