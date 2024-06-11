package Activities.Activity1;

public class Activity1 {
    public static void main(String[] args) {
        Car hondaCity = new Car();
        hondaCity.make = 2014;
        hondaCity.color = "Black";
        hondaCity.transmission = "Manual";

        hondaCity.displayCharacteristics();
        hondaCity.accelarate();
        hondaCity.brake();
    }
    
}
