// Vehicle.java
public abstract class Vehicle implements Servicable {
    private static int idGen = 1;
    private final int id;
    private String model;
    private int year;
    private double basePrice;

    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getBasePrice() { return basePrice; }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return id + ": " + model + " (" + year + "), price=" + basePrice;
    }
}
