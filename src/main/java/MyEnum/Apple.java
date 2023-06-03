package MyEnum;

public enum Apple {FUJI, PIPPIN, GRANNY_SMITH}

enum Orange {NAVEL, TEMPLE}

class test {
    public static void main(String[] args) {

        //System.out.println(Apple.PIPPIN);
        // enumTest(Apple.PIPPIN);

        for (PLANET p : PLANET.values()) {
            System.out.println(p);
        }
        System.out.println(Operation.MINUS.apply(10, 11));
    }

    static void enumTest(Apple apple) {
        System.out.println(apple);
    }


}

enum PLANET {
    EARTH(1000, 6400),
    PLUTO(50, 24);
    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    PLANET(double mass, double radious) {
        this.mass = mass;
        this.radius = radious;
        this.surfaceGravity = mass / Math.pow(radious, 2);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }
}