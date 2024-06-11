package Activities.Activity2;

public class Activity2 {
    public static void main(String[] args) {
        int[] numArr = {10, 77, 10, 54, -11, 10};
        int numToSearch = 10;
        int expectedSum = 30;
        System.out.println("Final result is: "+searchAndAdd(numArr, numToSearch, expectedSum));
    }

    public static boolean searchAndAdd(int[] arrNum, int search, int sum){
        int result = 0;
        for(int num: arrNum){
            if(num == search){
                System.out.println("Number found "+num);
                result = result + num;
            }
            if(result >= sum){
                break;
            }
        }
        System.out.println("Sum is : " +result);
        return (result == sum);
    }
}
