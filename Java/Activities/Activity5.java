package Activities;

abstract class Book{
    String title;

    abstract void setTitle(String str);

    String getTitle(){
        return title;
    }

}

class MyBook extends Book{
    public void setTitle(String s) {
        title = s;
    }
}


public class Activity5 {
    public static void main(String[] args) {
        Book newNovel = new MyBook();
        newNovel.setTitle("The Tempest");
        System.out.println("The title is: " + newNovel.getTitle());
    }
}

