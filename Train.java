import java.util.ArrayList;

public class Train {
    
    private ArrayList<Car> carList;
    private final FuelType fuelType;
    private final double fuelCapacity;
    private int nCars; 
    private final int passengerCapacity;
    private final Engine engine;

    /**
     * Creates a train with the given engine and cars.
     * @param fuelType the train's engine's fuel type
     * @param fuelCapacity the train's engine's fuel capacity
     * @param nCars the number of cars the train has
     * @param passengerCapacity the maximum number of passengers
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.carList = new ArrayList<Car>(nCars);
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
        this.engine = new Engine(fuelType, fuelCapacity);
    }

    /**
     * Gets the engine and prints the fuel type and current fuel. 
     * @return The engine
     */
    public Engine getEngine(){
        System.out.println(engine.toString());
        return this.engine;
    }

    /**
     * Adds the car to the train.
     * @param c the car
     */
    private void addCar(Car c){
        if (carList.contains(c) ) {
            throw new RuntimeException("This car has already been added to the train.");
        } else if ((this.carList.size()+2) >= this.nCars){
            throw new RuntimeException("The train has reached the maximum amount of cars.");
        }
        this.carList.add(c);
        this.nCars +=1 ;
    }

    /**
     * Gets the car at a given index.
     * @param i the index of the car in the carList
     * @return A car at index i.
     */
    public Car getCar(int i){ 
        if (i <= this.carList.size()){
            System.out.print("Car "+ (i) +": ");
            return this.carList.get(i-1);
        } else {

            throw new RuntimeException("Car "+ i+ " does not exist");
        }
    }

    /**
     * Gets the maximum capacity of the train. 
     * @return An int representing the maximum capacity of the train
     */
    public int getMaxCapacity(){ 
        int maxCapacity = 0;
        for (int i = 0; i < nCars; i++){
            if (i < (carList.get(i)).getCapacity()){
                maxCapacity = (carList.get(i)).getCapacity();
            } 
        }
        return maxCapacity;
    }
    
    /**
     * Gets the seats remaining on the train.
     * @return An int representing the total remaining seats on the train. 
     */
    public int seatsRemaining(){
        int totalRemaining = 0;
        for (int i = 0; i < nCars; i++){
            if (i < (carList.get(i)).seatsRemaining()){
                totalRemaining = totalRemaining + (carList.get(i)).seatsRemaining();
            } 
        }
        return totalRemaining;
    }

    /**
     * Prints the passengers of each car.
     */
    public void printManifest(){
        for (int i = 0; i < nCars; i++){
            System.out.println("Car "+ (i+1)+":");
            carList.get(i).printManifest();  
        }
    }
}
