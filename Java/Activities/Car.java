package Activities.Activity1;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    
    public Car(){
        this.tyres = 4;
        this.doors = 4;
    }

    public void displayCharacteristics(){
        System.out.println("Color is "+this.color);
        System.out.println("Transmission is "+this.transmission);
        System.out.println("Make is:"+this.make);
        System.out.println("Tyres is:"+this.tyres);
        System.out.println("Doors is:"+this.doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    }

    public void brake(){
        System.out.println("Car has stopped.");
    }
}

