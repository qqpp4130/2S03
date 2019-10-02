import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // initialize a arraylist to store variables
        ArrayList<CarModel> models = new ArrayList<CarModel>();
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<double> Recodes = new ArrayList<double>;
        while (true) {
            String[] input = read.nextLine().split(" ");
            if (input[0].equals("MODEL")) {
                models.add(new CarModel(input[1], Float.parseFloat(input[2]), Double.parseDouble(input[3])));
            } else if (input[0].equals("CAR")) {
                for (int i = 0; i < models.size(); i++) {
                    if (models.get(i).getName().equals(input[1])) {
                        cars.add(new Car(models[i], Double.parseDouble(input[2])));
                    }
                }
            } else if (input[0].equals("TRIP")) {
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        if (cars.get(i).trip(Double.parseDouble(input[2]))) {
                            System.out.println("Trip completed successfully for #" + cars.get(i).getPlateNumber());
                        } else {
                            System.out.println("Not enough fuel for #" + cars.get(i).getPlateNumber());
                            everybodyStillHasFuel = false;
                        }
                    }
                }
            } else if (input[0].equals("REFILL")) {
                for (int i = 0; i < car.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        cars.get(i).refill();
                    }
                }
            } else if (input[0].equals("LONGTRIPS")) {
                for (int i = 0; i < car.size(); i++) {
                    if (cars.get(i).getPlateNumber().equals(input[1])) {
                        Recodes = cars.get(i).getRecords();
                        for (car.get(i))
                    }
                }
            } else if (input[0].equals("FINISH")) {
                break;
            }
        }

       /* In this example, all the cars go on the same
        trips. In particular, they all go on trips of
        length 350kms until one of them runs out of fuel.
         */
        boolean[] tripResults = new boolean[4];
        boolean everybodyStillHasFuel = true;
        while(everybodyStillHasFuel) {
            for (int j = 0; j < numCars; j++) {
                tripResults[j] = cars[j].trip(350);
                if (tripResults[j]) {
                    System.out.println("Trip completed successfully for #" + cars[j].getPlateNumber());
                } else {
                    System.out.println("Not enough fuel for #" + cars[j].getPlateNumber());
                    everybodyStillHasFuel = false;
                }
            }
        }
    }
}
