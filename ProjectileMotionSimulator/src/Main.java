import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {


    public static double G = 9.8;           //acceleration due to gravity downwards
    public static double launchAngleRadians = 0;   //angle between velocity vector and ground (radians)
    public static double launchAngleDegrees = 0;   //same thing but in degrees for user input cuz the average person doesn't know how radians work
    public static double launchVelocity = 0;       //in meters per second
    public static final double PI = 3.1415926;     //for unit conversions between degrees and radians
    public static int selection;                   //for user input when choosing the planet
    public static boolean[][] grid;                //for displaying trajectory in 2D
    public static Projectile bullet = new Projectile(); //Projectile object

    public static void main(String[] args) throws InterruptedException { //main method that does everything
        getUserInput();
        simulate2D();
        printGrid(grid);
        printData();

    }


    public static void getUserInput(){      //initial conditions of the projectile and the gravity of the planet
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to Felix's simple 2D projectile motion simulator.");
        System.out.println("Please enter the initial conditions of the projectile.");
        System.out.println();
        System.out.println("launch angle (degrees 0 ~ 90): ");
        launchAngleDegrees = Double.parseDouble(input.nextLine());
        launchAngleRadians = launchAngleDegrees/180 * PI;
        System.out.println("launch velocity (m/s) [I recommend keeping this below 30]: ");
        launchVelocity = input.nextDouble();
        System.out.println("Choose gravity");
        input.nextLine();
        System.out.println("Earth[1]   " +
                "Moon[2]   " +
                "Mercury[3]   " +
                "Venus[4]   " +
                "Mars[5]   " +
                "Jupiter[6]   " +
                "Saturn[7]   " +
                "Uranus[8]   " +
                "Neptune[9]   " +
                "Pluto[10]   ");
        selection = Integer.parseInt(input.nextLine());
        double[] g = new double[10];
        g[0] = 9.807;
        g[1] = 1.62;
        g[2] = 3.7;
        g[3] = 8.87;
        g[4] = 3.721;
        g[5] = 24.79;
        g[6] = 10.44;
        g[7] = 8.87;
        g[8] = 1.15;
        g[9] = 0.62;
        G = g[selection - 1];

    }

    public static void simulate2D(){ //simulates the trajectory and stores the x & y position of the projectile in a 2D array that simulates a 2D space

        Projectile bullet = new Projectile(launchAngleRadians, launchVelocity, G);
        grid = new boolean [bullet.getMaxHeight() + 5][bullet.getMaxDistance() + 5];

        double time = 0;


        while((bullet.getPositionY(time) < bullet.getMaxHeight()+3 && (bullet.getPositionY(time) >= 0))){
            /* my approach to this is very dumb. Basically I obtain the x and y coordinates of the projectile
            for 250 ms intervals, and map its x & y to an actual element in a 2d array.
             */
            int x = bullet.getPositionX(time);
            int y = bullet.getMaxHeight()+4 - bullet.getPositionY(time);
            grid[y][x] = true;
            time = time + 0.25;
        }

        grid[bullet.getMaxHeight()+4][bullet.getMaxDistance()] = true;
        grid[4][bullet.getMaxDistance()/2] = true;

    }


    public static void printGrid(boolean[][] space) throws InterruptedException { //prints out the 2D array (very cool parabola)
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length ; j++) {
                if(space[i][j] == false){
                    //some random wait times to make the program look more sophisticated than it actually is
                    System.out.print(" . ");
                }else {
                    System.out.print(" ⦿ ");
                    int waitTime = (int) (Math.random()*333);
                    TimeUnit.MILLISECONDS.sleep(waitTime);
                }
            }
            System.out.println();
        }
    }

    public static void printData(){         //stats for nerds
        System.out.println("(the distance between two dots represent 1 meter) ");
        System.out.println("");
        System.out.println("Initial Conditions: ");
        System.out.println("Acceleration downward due to gravity: " + G);
        System.out.println("Launch Angle: " + launchAngleDegrees + " degrees");
        System.out.println("Launch Velocity: "  + launchVelocity + " m/s");

        System.out.println("");
        System.out.println("Flight Data (Truncated to int): ");
        System.out.println("Max vertical height: " + bullet.getMaxHeight() + " m");
        System.out.println("Range: " + bullet.getMaxDistance() + " m");
        System.out.println("Time of flight: " + bullet.getFlightTime() + " s");

    }





}
