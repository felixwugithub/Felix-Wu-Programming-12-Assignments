import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double g = 9.8;
        double launchAngle = 0;
        double angle = 0;
        double launchVelocity = 0;
        final double PI = 3.1415926;

        System.out.println("Welcome to Felix's simple 2D projectile motion simulator.");

        System.out.println("Please enter the initial conditions of the projectile.");

        System.out.println();
        System.out.println("launch angle (degrees): ");
        angle = Double.parseDouble(input.nextLine());
        launchAngle = angle/180 * PI;
        System.out.println("launch velocity (m/s): ");
        launchVelocity = input.nextDouble();
        System.out.println("Downward acceleration due to gravity (m/s^2): ");
        g = input.nextDouble();

        Projectile bullet = new Projectile(launchAngle, launchVelocity, g);
        boolean[][] space = new boolean [bullet.getMaxHeight() + 5][bullet.getMaxDistance() + 5];

        double time = 0;
        while((bullet.getPositionY(time) < bullet.getMaxHeight()+3 && (bullet.getPositionY(time) >= 0))){
            int x = bullet.getPositionX(time);
            int y = bullet.getMaxHeight()+4 - bullet.getPositionY(time);
            space[y][x] = true;
            time = time + 0.5;

        }

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length ; j++) {
                if(space[i][j] == false){
                    System.out.print(" . ");
                }else{

                    System.out.print(" ■ ");
                }
            }
            System.out.println();
        }

        System.out.println("Initial Conditions: ");
        System.out.println("Launch Angle: " + angle + " degrees");
        System.out.println("Launch Velocity: "  + launchVelocity + " m/s");
        System.out.println("Gravity: " + g + "m/s^2 down");
        System.out.println("Max vertical height: " + bullet.getMaxHeight() + " m");
        System.out.println("Range: " + bullet.getMaxDistance() + " m");
        System.out.println("Time of flight: " + bullet.getFlightTime() + " s");




    }


}
