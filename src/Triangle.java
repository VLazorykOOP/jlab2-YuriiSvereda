public class Triangle {
    private int angleA = 60;
    private int angleB = 60;
    private int angleC = 60;
    private int sideAB = 1;
    private int sideBC = 1;
    private int sideAC = 1;

    public Triangle() {
        /*this.sideAB = 1;
        this.sideBC = 1;
        this.sideAC = 1;
        this.angleA = 60;
        this.angleB = 60;
        this.angleC = 60;*/
    }

    public Triangle(int sideAB, int sideBC, int sideAC) {
        if (sideAB + sideBC > sideAC && sideAB + sideAC > sideBC && sideAC + sideBC > sideAB) {
            this.sideAB = sideAB;
            this.sideBC = sideBC;
            this.sideAC = sideAC;
        }
        /*else {
            this.sideAB = 1;
            this.sideBC = 1;
            this.sideAC = 1;*//*
        }*/
    }


    public int getAngleA() {
        return angleA;
    }

    public int getAngleB() {
        return angleB;
    }

    public int getAngleC() {
        return angleC;
    }

    public void setAngleA(int value){
        if (value <= 180) {
            angleA = value;
        } else {
            throw new IllegalArgumentException("invalid value");
        }
    }

    public void setAngleB(int value) {
        if (value <= 180) {
            angleB = value;
        } else {
            throw new IllegalArgumentException("invalid value");
        }
    }

    public void setAngleC(int value) {
        if (value <= 180) {
            angleC = value;
        } else {
            throw new IllegalArgumentException("invalid value");
        }
    }

    public int getSideAB() {
        return sideAB;
    }

    public int getSideBC() {
        return sideBC;
    }

    public int getSideAC() {
        return sideAC;
    }

    public void setSideAB(int value) {
        sideAB = value;
    }

    public void setSideBC(int value) {
        sideBC = value;
    }

    public void setSideAC(int value) {
        sideAC = value;
    }

    public double calculateArea() {
        double p = (double) (sideAB + sideBC + sideAC) / 2;
        return Math.sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideAC));
    }

    public int calculatePerimetr() {
        return sideAB + sideBC + sideAC;
    }

    public double getHa() {
        return 2 * (calculateArea() / sideBC);
    }

    public double getHb() {
        return 2 * calculateArea() / sideAC;
    }

    public double getHc() {
        return 2 * calculateArea() / sideAB;
    }

    public String getType() {
        String type = "simple";
        if ( angleA == 90 || angleB == 90 || angleC == 90) {
            type = "right-angled";
        } else if (sideAB == sideBC || sideBC == sideAC || sideAB == sideAC) {
            type = "isosceles ";
        } else if (sideAB == sideBC && sideBC == sideAC ) {
            type = "equilateral";
        }
        return type;
    }
}
