public class Triangle {
    private int angleA;
    private int angleB;
    private int angleC;
    private int sideAB;
    private int sideBC;
    private int sideAC;

    public int getAngleA(){
        return angleA;
    }
    public int getAngleB(){
        return angleB;
    }
    public int getAngleC(){
        return angleC;
    }
//    public void setAngleA(int value)throws Exception{
//        if(value <= 178){
//            if(180 - angleB+angleC==value){
//                angleA=value;
//            }
//            else{
//                throw new Exception("invalid value");
//            }
//        }
//    }

    public void setAngleA(int value) throws Exception{
        if(value <= 180) {
            angleA = value;
        }
        else{
            throw new Exception("invalid value");
        }
    }
    public void setAngleB(int value) throws Exception{
        if(value <= 180) {
            angleB = value;
        }
        else{
            throw new Exception("invalid value");
        }
    }
    public void setAngleC(int value) throws Exception{
        if(value <= 180) {
            angleC = value;
        }
        else{
            throw new Exception("invalid value");
        }
    }
    public int getSideAB(){
        return sideAB;
    }
    public int getSideBC(){
        return sideBC;
    }
    public int getSideAC(){
        return sideAC;
    }
    public void setSideAB(int value){
        sideAB=value;
    }
    public void setSideBC(int value){
        sideBC=value;
    }
    public void setSideAC(int value){
        sideAC=value;
    }

    public double calculateArea (){
        double p = (sideAB+sideBC+sideAC)/2;
        return Math.pow(p*(p-sideAB)*(p-sideBC)*(p-sideAC), 1/2);
    }
    public int calculatePerimetr(){
        return sideAB+sideBC+sideAC;
    }

    public double getHa(){
        return 2*calculateArea()/sideBC;
    }
    public double getHb(){
        return 2*calculateArea()/sideAC;
    }
    public double getHc(){
        return 2*calculateArea()/sideAB;
    }

    public String getType(){
        String type="simple";
        if(sideAB==sideBC && sideBC==sideAC){
            type="equilateral ";
        } else if (sideAB==sideBC || sideBC==sideAC || sideAB==sideAC) {
            type="isosceles ";
        } else if (angleA==90||angleB==90||angleC==90) {
            type="right-angled";
        }
        return type;
    }
}
