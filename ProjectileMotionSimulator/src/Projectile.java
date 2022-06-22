public class Projectile {
    private double launchAngle;
    private double launchVelocity;
    private double g;

    public Projectile(double launchAngle, double launchVelocity, double g){
        this.launchAngle = launchAngle;
        this.launchVelocity = launchVelocity;
        this.g = g;
    }


    public int getPositionX(double time){
        double velocityX = Math.cos(launchAngle) * launchVelocity;
        return (int) ( velocityX * time + 0.5);
    }

    public int getMaxHeight(){
        double velocityY = Math.sin(launchAngle) * launchVelocity;
        int maxHeight = (int)( Math.pow(velocityY, 2) / (2 * g) + 0.5);
        return maxHeight;
    }

    public int getMaxDistance(){
        return (int)((Math.pow(launchVelocity, 2) * Math.sin(2 * launchAngle))/g);
    }

    public int getFlightTime(){
        return (int) ((int) this.getMaxDistance()/ (Math.cos(launchAngle) * launchVelocity) +  0.5) ;
    }

    public int getPositionY(double time){
        double velocityY = Math.sin(launchAngle) * launchVelocity;
        return (int) (velocityY * time - 0.5*g*Math.pow(time, 2) + 0.5);


    }

}
