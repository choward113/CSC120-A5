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
        if (i <= this.carList.size()){
            System.out.print("Car "+ (i) +": ");
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
}
