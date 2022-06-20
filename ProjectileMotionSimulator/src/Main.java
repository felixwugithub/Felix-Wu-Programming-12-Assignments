public class Main {

    public static void main(String[] args) {
        double pi = 3.141592653589793;
        double g = 9.8;
        Projectile bullet = new Projectile(pi/2, 100, g);
        System.out.println(bullet.getPositionX(9));
        System.out.println(bullet.getPositionY(1));

    }
}
