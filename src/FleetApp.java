import java.util.*;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": printAll(); break;
                case "2": addCar(); break;
                case "3": addBus(); break;
                case "4": showTotalInsurance(); break;
                case "5": showOlderThanN(); break;
                case "6": serviceAll(); break;
                case "7": return;
            }
        }
    }

    private void printAll() {
        if (vehicles.isEmpty()) System.out.println("No vehicles");
        else for (Vehicle v : vehicles) System.out.println(v);
    }

    private void addCar() {
        System.out.print("Model: "); String m = sc.nextLine();
        System.out.print("Year: "); int y = Integer.parseInt(sc.nextLine());
        System.out.print("Price: "); double p = Double.parseDouble(sc.nextLine());
        System.out.print("Doors: "); int d = Integer.parseInt(sc.nextLine());
        vehicles.add(new Car(m, y, p, d));
    }

    private void addBus() {
        System.out.print("Model: "); String m = sc.nextLine();
        System.out.print("Year: "); int y = Integer.parseInt(sc.nextLine());
        System.out.print("Price: "); double p = Double.parseDouble(sc.nextLine());
        System.out.print("Capacity: "); int c = Integer.parseInt(sc.nextLine());
        vehicles.add(new Bus(m, y, p, c));
    }

    private void showTotalInsurance() {
        double sum = 0;
        for (Vehicle v : vehicles) sum += v.calculateInsuranceFee();
        System.out.println("Total insurance: " + sum);
    }

    private void showOlderThanN() {
        System.out.print("Current year: "); int cy = Integer.parseInt(sc.nextLine());
        System.out.print("N: "); int n = Integer.parseInt(sc.nextLine());
        for (Vehicle v : vehicles) if (v.getAge(cy) > n) System.out.println(v);
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) v.performService();
    }
}
