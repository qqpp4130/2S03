import java.util.ArrayList;

class Car {

    // Current gas level in liters
    private double currentGasLevel;

    // Model of the car and its details.
    private CarModel model;

    // Plate number, which is supposed to be unique among all cars.
    private int plateNumber;

    // Trip recorder
    private ArrayList<Double> tripRecorder;

    /***
     * Creates a full-tank car from the given model.
     * @param model
     */
    Car(CarModel model, int plateNumber) {
        this.model = model;
        this.currentGasLevel = model.getGasTankSize();
        this.plateNumber = plateNumber;
        this.tripRecorder = new ArrayList<Double>();
    }

    void refill() {
        currentGasLevel = model.getGasTankSize();
    }

    /***
     The car goes on a trip and uses some fuel.
    @param distance The length of the trip in kilometers.
     @return true if the trip was successful, false if there was not enough fuel.
      */
    boolean trip(double distance) {
        double estimatedFuelConsumption = (distance/100.0)*model.getFuelEconomy();
        if (estimatedFuelConsumption > currentGasLevel) {
            currentGasLevel = 0;
            return false;
        }
        currentGasLevel -= estimatedFuelConsumption;
        tripRecorder.add(distance);
        return true;
    }

    int getTrips(double distance) {
        int Trips = 0;
        for (int i = 0; i < tripRecorder.size(); i++) {
            if (tripRecorder.get(i) >= distance) {
                Trips++;
            }
        }
        return Trips;
    }

    int getPlateNumber() {
        return plateNumber;
    }

    double getCurrentGasLevel() {
        return currentGasLevel;
    }
}
