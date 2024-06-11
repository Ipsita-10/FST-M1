package Activities;

public class Activity7 {
    public static void main(String[] args) {
        MountainBike mbk = new MountainBike(4,60, 10);
        System.out.println(mbk.bicycleDesc());
        mbk.speedUp(10);
        mbk.applyBrake(5);
        mbk.setHeight(12);
        System.out.println(mbk.bicycleDesc());
    }
}

interface BicycleParts{
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations{
    public int gears;
    public int currentSpeed;
    public Bicycle(int gears, int currentSpeed){
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

   public void applyBrake(int decrement){
        currentSpeed = this.currentSpeed - decrement;
        System.out.println("Current speed after applying brake is: "+currentSpeed);
    }

    public void speedUp(int increment){
        currentSpeed = this.currentSpeed + increment;
        System.out.println("Current speed after speeding up is: "+currentSpeed);
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle{
    int seatHeight;
    public MountainBike(int gears, int currentSpeed, int seatHeight){
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed + "\nSeat height is: " +seatHeight );
    }
}