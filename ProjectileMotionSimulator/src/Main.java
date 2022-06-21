public class Main {

    public static void main(String[] args) {
        double pi = 3.141592653589793;
        double g = 9.8;



        Projectile bullet = new Projectile(pi/3, 14, g);
        boolean[][] space = new boolean [bullet.getMaxHeight() + 5][bullet.getMaxDistance() + 5];

        double time = 0;
        while((bullet.getPositionY(time) < bullet.getMaxHeight()+3 && (bullet.getPositionY(time) >= 0))){
            int x = bullet.getPositionX(time);
            int y = bullet.getMaxHeight()+4 - bullet.getPositionY(time);
            System.out.println(x + ", " + y);
            space[y][x] = true;
            time = time + 0.25;

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




    }


}
