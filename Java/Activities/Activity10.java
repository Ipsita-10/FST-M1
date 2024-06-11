package Activities;

import java.util.Set;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("Kolkata");
        mySet.add("Srinagar");
        mySet.add("Bangalore");
        mySet.add("Mumbai");
        mySet.add("Ranchi");
        mySet.add("Guwahati");
        for(String cities: mySet){
            System.out.println(cities);
        } 
        System.out.println("Size of hashset is: "+mySet.size());   
        System.out.println("Remove city from hashset: "+mySet.remove("Ranchi"));
        System.out.println("Remove city from hashset: "+mySet.remove("Delhi"));
        System.out.println("Check presence of city in hashset: "+mySet.contains("Srinagar"));
        for(String cities: mySet){
            System.out.println(cities);
        } 
    }
}
