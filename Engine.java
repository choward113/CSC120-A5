public class Engine {
    
    private FuelType fueltype; 
    private double currentFuel; 
    private double fuelCapacity; 
    /** 
     * Creates an engine with the given fueltype and fuelCapacity
     * @param fueltype the engine's fuel type
     * @param fuelCapacity the engine's maximum amount of fuel 
     */
    public Engine(FuelType fueltype, double fuelCapacity){
        this.fueltype = fueltype;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;

    }

    /** 
    * @return A string representing the engine. 
    */
    public String toString(){
        return "This train's engine is "+this.fueltype+". Current fuel: "+this.currentFuel+" of "+this.fuelCapacity;
    }

    /** 
    * Gets the engine’s fuel capacity.
    * @return A double representing the engine's fuel capacity.
    */
    public double getFuelCapacity(){
        return this.fuelCapacity;
    }

    /** 
    * Gets the engine’s current fuel level.
    * @return A double representing the engine's current fuel level.
    */
    public double getCurrentFuel(){
        return this.currentFuel;
    }

    /** 
    * Sets the currentFuel to the fuelCapacity.
    */
    public void refuel(){
        System.out.println("Refueled! Fuel level: "+ this.fuelCapacity);
        this.currentFuel =  this.fuelCapacity;
    }

    /** 
    * If the currentFuel minus 20 is greater than zero, subtracts 20 from currentFuel. Otherwise, a runtime error is thrown.
    */
    public void go(){
        if ((this.currentFuel - 20) > 0) {
           this.currentFuel = this.currentFuel - 20;
        } else {
            throw new RuntimeException("Not enough fuel. Fuel level is: "+ this.currentFuel +". Needs "+ (20-this.currentFuel)+ " more fuel.");
        }
        System.out.println("Going! Remaining fuel: "+ this.currentFuel);
    }

    
}
