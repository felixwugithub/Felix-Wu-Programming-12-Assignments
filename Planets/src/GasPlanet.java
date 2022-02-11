import java.awt.*;

public class GasPlanet extends Planet {
    private boolean hasRings;
    private Color color;

    public GasPlanet(String designation, int orbitTime, boolean hasRings, Color color){
        super(designation, orbitTime);
        this.hasRings = hasRings;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Color getColor() {
        return color;
    }

    public boolean HasRings() {
        return hasRings;
    }

    public String toString() {

        return
                super.toString() +
                "-> isAlso: GasPlanet{" +
                "hasRings=" + hasRings +
                ", color='" + color + '\'' +
                '}';

    }
}
