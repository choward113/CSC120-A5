public class Engine {
    
    private FuelType fueltype; //what type of fuel
    private double currentFuel; //needs accessor(getter)
    private double fuelCapacity; //needs accessor(getter)

    public Engine(FuelType fueltype, double fuelCapacity){
        this.fueltype = fueltype;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = fuelCapacity;

    }
    public String toString(){
        return "This train's engine is "+this.fueltype+". Current fuel: "+this.currentFuel+" of "+this.fuelCapacity;
    }

    public double getFuelCapacity(){
        return this.fuelCapacity;
    }

    public double getCurrentFuel(){
        return this.currentFuel;
    }

    public void refuel(){
        System.out.println("Refueled! Fuel level: "+ this.fuelCapacity);
        this.currentFuel =  this.fuelCapacity;
    }


    public void go(){
        if ((this.currentFuel - 20) > 0) {
           this.currentFuel = this.currentFuel - 20;
        } else {
            throw new RuntimeException("Not enough fuel. Fuel level is: "+ this.currentFuel +". Needs "+ (20-this.currentFuel)+ " more fuel.");
        }
        System.out.println("Going! Remaining fuel: "+ this.currentFuel);
    }

    
}
