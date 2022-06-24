public class Projectile {


    /*
    Projectile object:
    imagine a rock is launched at an angle from a flat surface. It eventually falls back to the ground,
    but it goes a certain distance forward. During flight there is negligible friction.
    This object basically simulates its flight and provides all sorts of useful information.

    All calculations are done with simple 2D kinematic equations I learned from AP Physics 1. fun fun

     */


    //very straightforward fields
    private double launchAngle;
    private double launchVelocity;
    private double g; //gravitational downward acceleration


    //constructors
    public Projectile(double launchAngle, double launchVelocity, double g){
        this.launchAngle = launchAngle;
        this.launchVelocity = launchVelocity;
        this.g = g;
    }

    public Projectile(){
        launchAngle = 45;
        launchVelocity = 1;
        g = 9.8;
    }

    public int getPositionX(double time){  //horizontal position as a function of time
        double velocityX = Math.cos(launchAngle) * launchVelocity;
        return (int) Math.floor(velocityX * time + 0.5);
    }

    public int getMaxHeight(){ //get how high it will go
        double velocityY = Math.sin(launchAngle) * launchVelocity;
        int maxHeight = (int) Math.floor(( Math.pow(velocityY, 2) / (2 * g) + 0.5));
        return maxHeight;
    }

    public int getMaxDistance(){ //get how far it travels
        return (int) Math.floor((Math.pow(launchVelocity, 2) * Math.sin(2 * launchAngle))/g);
    }

    public int getFlightTime(){ //get the total flight time
        return (int) Math.floor (this.getMaxDistance()/ (Math.cos(launchAngle) * launchVelocity) +  0.5) ;
    }

    public int getPositionY(double time){ //vertical position as a function of time
        double velocityY = Math.sin(launchAngle) * launchVelocity;
        return (int) Math.floor(velocityY * time - 0.5*g*Math.pow(time, 2) + 0.5);


    }

}
