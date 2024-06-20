package Activities.Activity3;

public class Activity3 {
    public static void main(String[] args) {
        double givenSeconds = 1000000000;
        double earthSeconds = 31557600;
        double mercurySeconds = 0.2408467;
        double venusSeconds = 0.61519726;
        double marsSeconds = 1.8808158;
        double jupiterSeconds = 11.862615;
        double saturnSeconds = 29.447498;
        double uranusSeconds = 84.016846;
        double neptuneSeconds = 164.79132;

        System.out.println("Age in Mercury: "+givenSeconds/ earthSeconds/ mercurySeconds);
        System.out.println("Age in Venus: "+givenSeconds/ earthSeconds/ venusSeconds);
        System.out.println("Age in Earth: "+givenSeconds/ earthSeconds);
        System.out.println("Age in Mars: "+givenSeconds/ earthSeconds/ marsSeconds);
        System.out.println("Age in Jupiter: "+givenSeconds/ earthSeconds/ jupiterSeconds);
        System.out.println("Age in Saturn: "+givenSeconds/ earthSeconds/ saturnSeconds);
        System.out.println("Age in Uranus: "+givenSeconds/ earthSeconds/ uranusSeconds);
        System.out.println("Age in Neptune: "+givenSeconds/ earthSeconds/ neptuneSeconds);

    }
}
