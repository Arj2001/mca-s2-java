class Vehicle{
    
    String color;
    int speed;

    Vehicle(String color, int speed){
        this.color = color;
        this.speed = speed;
    }

    void display(){
        System.out.println("Color: " +color+", speed: "+speed);
    }

}
class Car extends Vehicle{

    String fuelType;

    Car(String color, int speed, String fuelType){
        super(color, speed);
        this.fuelType = fuelType;
    }

    void displayFuelType(){
        System.out.println("Fuel Type: "+ fuelType);
    }
}
class Motorcycle extends Vehicle{

    String type;

    Motorcycle(String color, int speed, String type){
        
        super(color, speed);
        this.type = type;
    }

    void displayMType(){
        System.out.println("Motorcycle Type: "+ type);;
    }
}

public class InheritanceVehicle {

    public static void main(String[] args) {

        Vehicle v = new Vehicle("White", 70);
        v.display();

        Car c = new Car("Black", 90, "Petrol");
        c.display();
        c.displayFuelType();

        Motorcycle m = new Motorcycle("Red", 50,"Scooter" );
        m.display();
        m.displayMType();

    }
}

