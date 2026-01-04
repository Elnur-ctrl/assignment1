// Bus.java
public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.02 + getAge(java.time.Year.now().getValue()) * 100;
    }

    @Override
    public void performService() {
        System.out.println("Bus serviced: brakes and safety check.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacity=" + passengerCapacity;
    }
}
