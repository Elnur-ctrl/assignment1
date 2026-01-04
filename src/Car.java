public class Car extends Vehicle implements Servicable {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        int currentYear = java.time.Year.now().getValue();
        int age = getAge(currentYear);
        // Пример формулы: базовый процент от basePrice + надбавка за возраст
        double fee = getBasePrice() * 0.03 + Math.max(0, age) * 20;
        return fee;
    }

    @Override
    public void performService() {
        System.out.println("Car service: Checking engine, oil change, tire rotation for " + getModel());
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000; // пример: каждые 15k км
    }

    @Override
    public String toString() {
        return String.format("Car{id=%d, model='%s', year=%d, basePrice=%.2f, doors=%d}",
                getId(), getModel(), getYear(), getBasePrice(), numberOfDoors);
    }
}
