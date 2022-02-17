public class Moon {
    private String designation;
    private Planet planet;
    private int orbitTime;
    private boolean atmosphere;

    public Moon(Planet planet, int orbitTime, String designation, boolean atmosphere){
        this.planet = planet;
        this.orbitTime = orbitTime;
        this.designation = designation;
        this.atmosphere = atmosphere;
    }

    public boolean isAtmosphere() {
        return atmosphere;
    }

    public String getDesignation() {
        return designation;
    }

    public int getOrbitTime() {
        return orbitTime;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setOrbitTime(int orbitTime) {
        this.orbitTime = orbitTime;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAtmosphere(boolean atmosphere) {
        this.atmosphere = atmosphere;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public boolean equals(Object o) {


      if (o instanceof Moon){
          return(this.designation.equals(((Moon) o).getDesignation()));
      }
        return false;
  }

    @Override
    public String toString() {
        return "Moon{" +
                "designation='" + designation + '\'' +
                ", planet=" + planet +
                ", orbitTime=" + orbitTime +
                ", atmosphere=" + atmosphere +
                '}';
    }
}
