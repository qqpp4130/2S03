class Car {

    // Current gas level in liters
    private double currentGasLevel;

    // Model of the car and its details.
    private CarModel model;

    // Plate number, which is supposed to be unique among all cars.
    private int plateNumber;

    // Trip recorder
    private ArrayList<double> tripRecorder;

    /***
     * Creates a full-tank car from the given model.
     * @param model
     */
    Car(CarModel model, int plateNumber) {
        this.model = model;
        this.currentGasLevel = model.getGasTankSize();
        this.plateNumber = plateNumber;
        this.tripRecoder = tripRecorder;
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

    ArrayList<double> getRecorder {
        return tripRecorder;
    }

    int getPlateNumber() {
        return plateNumber;
    }

    double getCurrentGasLevel() {
        return currentGasLevel;
    }
}
