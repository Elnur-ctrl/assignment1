public abstract class Vehicle {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model must not be null or empty");
        }
        this.model = model.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year < 1886 || year > currentYear + 1) { // 1886 — год первого автомобиля
            throw new IllegalArgumentException("Year is out of reasonable range");
        }
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be > 0");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return String.format("Vehicle{id=%d, model='%s', year=%d, basePrice=%.2f}", id, model, year, basePrice);
    }
}
