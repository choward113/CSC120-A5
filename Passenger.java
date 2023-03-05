public class Passenger {
    
    private String name;
    /**
     * Creates a passenger with the given name.
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Get the name of the passenger.
     * @return a string representing the passenger's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Adds a passenger to the car.
     * @param c the car
     */
    public void boardCar(Car c){
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Removes a passenger from the car. 
     * @param c the car
     */
    public void getOffCar(Car c){
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}