import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        final double G = 9.8;
        double launchAngle = 0;
        double angle = 0;
        double launchVelocity = 0;
        final double PI = 3.1415926;

        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to Felix's simple 2D projectile motion simulator.");
        System.out.println("Please enter the initial conditions of the projectile.");

        System.out.println();
        System.out.println("launch angle (degrees 0 ~ 90): ");
        angle = Double.parseDouble(input.nextLine());
        launchAngle = angle/180 * PI;
        System.out.println("launch velocity (m/s) [I recommend keeping this below 30]: ");
        launchVelocity = input.nextDouble();

        Projectile bullet = new Projectile(launchAngle, launchVelocity, G);
        boolean[][] space = new boolean [bullet.getMaxHeight() + 5][bullet.getMaxDistance() + 5];

        double time = 0;
        while((bullet.getPositionY(time) < bullet.getMaxHeight()+3 && (bullet.getPositionY(time) >= 0))){
            int x = bullet.getPositionX(time);
            int y = bullet.getMaxHeight()+4 - bullet.getPositionY(time);
            space[y][x] = true;
            time = time + 0.25;
        }

        space[bullet.getMaxHeight()+4][bullet.getMaxDistance()] = true;
        space[4][bullet.getMaxDistance()/2] = true;

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length ; j++) {
                if(space[i][j] == false){
                    System.out.print(" . ");
                }else {
                    System.out.print(" ⦿ ");
                    int waitTime = (int) (Math.random()*333);
                    TimeUnit.MILLISECONDS.sleep(waitTime);
                }
            }
            System.out.println();
        }


        System.out.println("(the distance between two dots represent 1 meter) ");
        System.out.println("");
        System.out.println("Initial Conditions: ");
        System.out.println("Launch Angle: " + angle + " degrees");
        System.out.println("Launch Velocity: "  + launchVelocity + " m/s");

        System.out.println("");
        System.out.println("Flight Data (Truncated to int): ");
        System.out.println("Max vertical height: " + bullet.getMaxHeight() + " m");
        System.out.println("Range: " + bullet.getMaxDistance() + " m");
        System.out.println("Time of flight: " + bullet.getFlightTime() + " s");




    }


}
