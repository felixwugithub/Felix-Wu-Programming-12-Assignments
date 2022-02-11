public class Main {
    public static void main(String[] args) {
        //Tests for all functionalities;


        Planet p1 = new Planet();

        System.out.println();

        Moon m1 = new Moon(p1, 30, "Luna", false);
        System.out.println(m1.getDesignation());
        System.out.println(m1.getOrbitTime());
        System.out.println(m1.getPlanet());

        p1.setDesignation("Earth");
        p1.setOrbitTime(365);
        p1.addMoon(m1);
        System.out.println(p1.getDesignation());
        System.out.println(p1.getMoons());
        System.out.println(p1.getOrbitTime());

        Planet p2 = new RockPlanet("Mecury", 111, true);
        System.out.println("Rock Planet Info:");
        ((RockPlanet) p2).setHabitable(false);
        System.out.println(p2.getDesignation());
        System.out.println(p2.getOrbitTime());
        System.out.println(p2.getMoons());
        System.out.println(((RockPlanet)p2).isHabitable());


    }
}