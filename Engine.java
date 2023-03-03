public class Engine {
    
    private FuelType fueltype; //what type of fuel
    private double currentFuel; //needs accessor(getter)
    private double fuelCapacity; //needs accessor(getter)

    public Engine(FuelType fueltype, double fuelCapacity){
        this.fueltype = fueltype;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;

    }

    public double getFuelCapacity(){
        return this.fuelCapacity;
    }

    public double getCurrentFuel(){
        return this.currentFuel;
    }

    public void refuel(){
        this.currentFuel =  this.fuelCapacity;
    }


    public void go(){
        if (this.currentFuel > 0) {
            System.out.println(this.currentFuel);
           this.currentFuel = this.currentFuel - 20;
        } else {
            throw new RuntimeException("Not enough fuel. Fuel level is: "+ this.currentFuel);
        }
        System.out.println("Remaining fuel level: "+ this.currentFuel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        System.out.println("Fuel: "+  myEngine.getCurrentFuel());
        try {
            while (true) {
                System.out.println("Fuel: "+  myEngine.getCurrentFuel());
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
        myEngine.refuel();
        System.out.println("Fuel: "+  myEngine.getCurrentFuel());
    }
}

/*a private `FuelType` attribute to indicate what type of fuel it uses, and `
    double`s to store the current and maximum fuel levels (along with an approproate accessors for each)
    - a constructor, which takes in initial values for the attributes named above and sets them appropriately
    - a method `public void refuel()` which will reset the `Engine`'s current fuel level to the maximum
    - a method `public void go()` which will decrease the current fuel level and 
    print some useful information (e.g. remaining fuel level) provided the fuel level is above 0 
    (otherwise it should throw a `RuntimeException` containing an informative message)*/