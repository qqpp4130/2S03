import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // initialize a arraylist to store variables
        ArrayList<CarModel> models = new ArrayList<CarModel>();
        ArrayList<Car> cars = new ArrayList<Car>();
        while (true) {
            String[] input = read.nextLine().split(" ");
            if (input[0].equals("MODEL")) {
                models.add(new CarModel(input[1], Float.parseFloat(input[2]), Double.parseDouble(input[3])));
            } else if (input[0].equals("CAR")) {
                for (int i = 0; i < models.size(); i++) {
                    if (models.get(i).getName().equals(input[1])) {
                        cars.add(new Car(models.get(i).getName(), Double.parseDouble(input[2])));
                        break;
                    }
                }
            } else if (input[0].equals("TRIP")) {
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        if (cars.get(i).trip(Double.parseDouble(input[2]))) {
                            System.out.println("Trip completed successfully for #" 
                            + cars.get(i).getPlateNumber());
                            break;
                        } else {
                            System.out.println("Not enough fuel for #" 
                            + cars.get(i).getPlateNumber());
                            break;
                        }
                    }
                }
            } else if (input[0].equals("REFILL")) {
                for (int i = 0; i < car.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        cars.get(i).refill();
                        break;
                    }
                }
            } else if (input[0].equals("LONGTRIPS")) {
                for (int i = 0; i < car.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        double distance = input[2];
                        System.out.println("#" + cars.get(i).getPlateNumber() 
                        + " made " + cars.get(i).getTrips(distance) + " trips longer than "
                        + Double.parseDouble(distance);
                        break;
                    }
                }
            } else if (input[0].equals("FINISH")) {
                break;
            }
        }
    }
}