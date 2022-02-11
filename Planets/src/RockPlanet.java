public class RockPlanet extends Planet{

    private boolean habitable;

    public RockPlanet(String designation, int orbitTime, boolean habitable){
        super(designation, orbitTime);
        this.habitable = habitable;
    }

    public void setHabitable(boolean habitable) {
        this.habitable = habitable;

    }

    public boolean isHabitable(){
        return habitable;
    }


    public String toString() {
        return(
                super.toString()+
                "-> isAlso: RockPlanet{" +
                "habitable=" + habitable +
                '}')
                ;
    }
}
