import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // initialize a arraylist to store variables
        ArrayList<CarModel> models = new ArrayList<CarModel>();
        ArrayList<Car> cars = new ArrayList<Car>();
        // while loop with a boolean to maximize the number of input lines
        boolean bool = true;
        while (bool) {
            String[] input = read.nextLine().split(" "); // split the readed line to list of phrases

            // run task for matching phrases of the first command using ifelseif
            if (input[0].equals("MODEL")) {
                // add new model to the models list
                models.add(new CarModel(input[1], Float.parseFloat(input[2])
                , Double.parseDouble(input[3])));
            } else if (input[0].equals("CAR")) {
                // for loop through the models list to find matching index for the model, make sure it breaks
                // to avoid extra looping throug the list
                for (int i = 0; i < models.size(); i++) {
                    if (models.get(i).getName().equals(input[1])) {
                        // add new car with founded model index and append to the cars list
                        cars.add(new Car(models.get(i), Integer.parseInt(input[2])));
                        break;
                    }
                }
            } else if (input[0].equals("TRIP")) {
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i).getPlateNumber() == Integer.parseInt(input[1])) {
                        // if statement determined by car.trip(double) and print out the result string
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
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i).getPlateNumber() == Integer.parseInt(input[1])) {
                        cars.get(i).refill();
                        break;
                    }
                }
            } else if (input[0].equals("LONGTRIPS")) {
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i).getPlateNumber() == Integer.parseInt(input[1])) {
                        float distance = Float.parseFloat(input[2]);
                        System.out.println("#" + cars.get(i).getPlateNumber() 
                        + " made " + cars.get(i).getTrips(distance) + " trips longer than "
                        + distance);
                        break;
                    }
                }
            } else if (input[0].equals("FINISH")) {
                bool = false; // finish and change the boolean to break the while
            }
        }
    }
}