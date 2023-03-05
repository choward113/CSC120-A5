import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengerList;
    private int maximumCapacity;
    /**
     * Creates a Car with the given maximumCapacity.
     * @param maximumCapacity The maximum number of passengers on a car. 
     */
    public Car(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.passengerList = new ArrayList<Passenger>(maximumCapacity);
    }

    /** 
    * @return A string representing the engine. 
    */
    public String toString(){
        return "This car has "+ passengerList.size() +" of "+this.maximumCapacity +" seats filled.";
    }

    /** 
    * Gets the car’s passenger capacity.
    * @return An int representing the car’s passenger capacity.
    */
    public int getCapacity(){
        return this.maximumCapacity;
    }

    /** 
    * Gets the car's remaining seats.
    * @return An int representing the car's remaining seats.
    */
    public int seatsRemaining(){
        return this.maximumCapacity - this.passengerList.size();
    }

    /**
     * Adds a passenger to the passenger list if there are enough seats and the passenger is not already on the car.
     * @param p the passenger 
     */
    public void addPassenger(Passenger p){
        if (isAboard(p)){
            throw new RuntimeException("Passenger already on train");
        } else if (seatsRemaining() <= 0){
            throw new RuntimeException("Car is full");
        }
        this.passengerList.add(p);
        System.out.println("Added "+ p.getName() + " to the car. "+ this.seatsRemaining() + " seats left");   
        } 

    /**
     * Checks if the passenger is aboard the car.
     * @param p the passenger
     * @return A boolean representing if the passenger is on board or not.
     */
    private boolean isAboard(Passenger p){
        return this.passengerList.contains(p);
    }

    /**
     * Removes a passenger from the passenger list if the passenger is aboard the car. 
     * @param p the passenger
     */
    public void removePassenger(Passenger p){
        if (!isAboard(p)){
            throw new RuntimeException("Passenger is not on the train.");
        }
        this.passengerList.remove(p);
    }

    /**
     * Prints out a list of all passenger in the car. 
     */
    public void printManifest(){
        if(seatsRemaining() == this.maximumCapacity){
            System.out.println("This car is EMPTY");
        } else {
            for (int i = 0; i < passengerList.size(); i++){
                System.out.println("Passenger "+(i+1)+": "+passengerList.get(i).getName());
            }
        }
    }
}

