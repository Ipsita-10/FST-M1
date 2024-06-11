package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("Harry");
        arrList.add("Nancy");
        arrList.add("Carol");
        arrList.add("Milan");
        arrList.add("Ignis");  

        for(String names: arrList){
            System.out.println(names);
        }

        System.out.println("Name in 3rd position: "+arrList.get(2));

        System.out.println("Check name exists? "+arrList.contains("Carol"));

        System.err.println("Size of list: "+arrList.size());

        System.out.println("Remove name "+arrList.remove("Milan")+ " Size is now "+arrList.size());
    }
    
}
