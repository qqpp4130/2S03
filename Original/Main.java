class Main {
    public static void main(String[] args) {

        // Creating two different car models
        CarModel model1 = new CarModel("Camry", 6.5, 58);
        CarModel model2 = new CarModel("Civic", 7.5, 52);

        // For this particular example, we have only 4 cars.
        final int numCars = 4;
        Car[] cars = new Car[numCars];
        cars[0] = new Car(model1, 1111);
        cars[1] = new Car(model1, 2222);
        cars[2] = new Car(model2, 3333);
        cars[3] = new Car(model2, 4444);

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
