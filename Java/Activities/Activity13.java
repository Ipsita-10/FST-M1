package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:\n");
        ArrayList<Integer> inputList = new ArrayList<>();
        Random indexGen = new Random();
        
        while(sc.hasNextInt()) {
            inputList.add(sc.nextInt());
        }

        Integer numbers[] = inputList.toArray(new Integer[0]);
        int size = numbers.length;
        int index = indexGen.nextInt(size);
        System.out.println("Index generated is: "+index);
        System.out.println("Value at index is: "+numbers[index]);

        sc.close();
    }

    
}




