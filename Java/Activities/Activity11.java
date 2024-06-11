package Activities;

import java.util.Map;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colors = new HashMap<>();
        colors.put(1, "Red");
        colors.put(4, "Blue");
        colors.put(12, "Green");
        colors.put(10, "White");
        colors.put(6, "Yellow");
        colors.put(3, "Black");
        System.out.println("Map is: "+colors);

        System.out.println("Remove color: "+colors.remove(3));
        
        System.out.println("Check color green? "+colors.containsValue("Green"));

        System.out.println("Size of Map is: "+colors.size());
    }
}
