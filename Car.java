import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengerList;
    private int maximumCapacity;

    public Car(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.passengerList = new ArrayList<Passenger>(maximumCapacity);
    }

    public String toString(){
        return "This car has "+ passengerList.size() +" of "+this.maximumCapacity +" seats filled.";
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
        } else if (seatsRemaining() <= 0){
            throw new RuntimeException("Car is full");
        }
        this.passengerList.add(p);
        System.out.println("Added "+ p.getName() + " to the car. "+ this.seatsRemaining() + " seats left");   
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
                System.out.println(passengerList.get(i).getName());
            }
        }
    }
}

