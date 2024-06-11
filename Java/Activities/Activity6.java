package Activities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Rakesh");
        plane.onboard("Akash");
        plane.onboard("Simran");
        plane.onboard("Jagjeet");
        plane.onboard("Meena");

        plane.takeOff();

        System.out.println(plane.getPassesngers());

        Thread.sleep(5000);

        plane.land();

        System.out.println(plane.getLastTimeLanded());
    }
}

class Plane{
    private int maxPassengers;
    private List<String> passengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger){
        this.passengers.add(passenger);
    }

    public Date takeOff(){
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land(){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }

    public List<String> getPassesngers(){
        return passengers;
    }
}