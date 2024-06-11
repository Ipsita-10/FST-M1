package Activities;

class CustomException extends Exception {
    private String message;

    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

public class Activity8{

    static void exceptionTest (String str) throws CustomException{
        if(str == null){
            throw new CustomException("String value is null");
        }
        else{
            System.out.println("String value is: "+str);
        }

    }
    
    public static void main(String[] args) {
        try{
            Activity8.exceptionTest("Hello Java");
            Activity8.exceptionTest(null);
        }
        catch(CustomException msg){
            System.out.println("Catch block: "+msg.getMessage());
        }
        
    }
}
