import java.util.ArrayList;

public class Planet {

    private int orbitTime;
    private String designation;
    private ArrayList<Moon> moons;

    Planet(){
        designation = "undefined";
        orbitTime = -1;
        moons = new ArrayList<Moon>();

    }
    Planet(String designation, int orbitTime){
        this.designation = designation;
        this.orbitTime = orbitTime;
        this.moons = new ArrayList<Moon>();

    }

    public ArrayList<Moon> getMoons() {
        return moons;
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public void addMoon(Moon newMoon){
        moons.add(newMoon);
    }

    @Override
    public boolean equals(Object o) {

        //instead of comparing the address of the planet, it compares their designation and orbit time;
        if(o instanceof Planet){
            return(this.designation.equals(((Planet) o).getDesignation())&&
                    this.orbitTime == ((Planet) o).getOrbitTime());

        }
        return false;
    }


    public String toString() {
        return (this.designation + " OT: " + orbitTime);
    }


}
