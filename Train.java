import java.util.ArrayList;

public class Train {
    
    private ArrayList<Car> carList;
    private final FuelType fuelType;
    private final double fuelCapacity;
    private int nCars; 
    private final int passengerCapacity;
    private final Engine engine;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.carList = new ArrayList<Car>(nCars);
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
        this.engine = new Engine(fuelType, fuelCapacity);
    
    }

    public Engine getEngine(){
        System.out.println(engine.toString());
        return this.engine;
    }

    private void addCar(Car c){
        if (!carList.contains(c)) {
            this.carList.add(c);
        } else {
            throw new RuntimeException("This car has already been added to the train.");
        }
        
    }

    public Car getCar(int i){ /**Test this*/
        if (i+1 <= this.carList.size()){
            System.out.println("Car "+ (i) +this.carList.get(i-1).toString());
            return this.carList.get(i-1);
        } else {
            throw new RuntimeException("Car "+ i+ " does not exist");
        }
    }

    public int getMaxCapacity(){ 
        int maxCapacity = 0;
        for (int i = 0; i < nCars; i++){
            if (i < (carList.get(i)).getCapacity()){
                maxCapacity = (carList.get(i)).getCapacity();
            } 
        }
        return maxCapacity;
    }
    public int seatsRemaining(){
        int totalRemaining = 0;
        for (int i = 0; i < nCars; i++){
            if (i < (carList.get(i)).seatsRemaining()){
                totalRemaining = totalRemaining + (carList.get(i)).seatsRemaining();
            } 
        }
        return totalRemaining;
    }

    public void printManifest(){
        for (int i = 0; i < nCars; i++){
            System.out.println("Car "+ (i+1)+":");
            carList.get(i).printManifest();  
        }
    }
    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 100, 2, 2);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        train.addCar(car1);
        train.addCar(car2);
        
        Passenger p = new Passenger("John");
        car1.addPassenger(p);
        Passenger p2 = new Passenger("Mary");
        Passenger p3 = new Passenger("Lucy");
        car2.addPassenger(p2);
        car2.addPassenger(p3); 

        train.printManifest(); //Test manifest
        System.out.println("Max Capacity: "+train.getMaxCapacity()); //test maxCapacity
        try {
            while (true) {
                train.engine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
        System.out.println("Seats remaining: "+ train.seatsRemaining());
        train.getEngine();
        train.getCar(1);
    }
}

/**
 *  -  a private `Engine` attribute, which we will mark with the keyword `final` to establish the 
 * **composition** relationship (e.g. `private final Engine engine;`)
 -  a private `ArrayList` to keep track of the `Car`s currently attached
 -  a constructor `public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity)` 
 which will initialize the `Engine` and `Car`s and store them
 -  a couple of accessors: 
     -  `public Engine getEngine()`
     -  `public Car getCar(int i)` to return the `i`th car
     -  `public int getMaxCapacity()` which will return the maximum total capacity across all `Car`s
     -  `public int seatsRemaining()` which will return the number of remaining open seats across all `Car`s 
     -  `public void printManifest()` that prints a roster of all `Passenger`s onboard (_Hint: your `Car`s can help!_)

 */