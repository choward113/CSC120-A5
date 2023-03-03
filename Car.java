import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengerList;
    private int maximumCapacity;

    public Car(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.passengerList = new ArrayList<Passenger>(maximumCapacity);
    }

    public int getCapacity(){
        return this.maximumCapacity;
    }

    public int seatsRemaining(){
        return this.maximumCapacity - this.passengerList.size();
    }

    public void addPassenger(Passenger p){
        if (isAboard(p)){
            throw new RuntimeException("Passenger already on train");
        } else if (seatsRemaining() < 0){
            throw new RuntimeException("Not enough seats");
        }
        this.passengerList.add(p);
        //System.out.println("Added "+ name + "to the car. "+ seatsRemaining + "seats left");   
        } 

    private boolean isAboard(Passenger p){
        return this.passengerList.contains(p);
    }

    public void removePassenger(Passenger p){
        if (!isAboard(p)){
            throw new RuntimeException("Passenger is not on the train.");
        }
        this.passengerList.remove(p);
    }

    public void printManifest(){
        if(seatsRemaining() == this.maximumCapacity){
            System.out.println("This car is EMPTY");
        } else {
            for (int i = 0; i < passengerList.size(); i++){
                System.out.println(passengerList.get(i));
            }
        }
    }
}

/**- a private `ArrayList` where it will store the `Passenger`s currently onboard, and an `int` for the
 *  `Car`'s maximum capacity (since `ArrayList`s will expand as we add objects, we'll need to manually 
 * limit their size)
 -   - a constructor, which takes in an initial value for the `Car`'s maximum capacity and initializes 
 an appropriately-sized `ArrayList`
 - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` 
 that return the maximum capacity and remaining seats, respectively
 - methods `public void addPassenger(Passenger p)` and `public void removePassenger(Passenger p)` 
 to add or remove a `Passenger` from the `Car` (_Hint: don't forget to check that there are seats 
 available if someone wants to board, and to confirm that the `Passenger` is actually onboard before
  trying to remove them! If you encounter a problem, throw a `RuntimeException`._)
 - and a final method `public void printManifest()` that prints out a list of all `Passenger`s aboard 
 the car (or "This car is EMPTY." if there is no one on board)
 */