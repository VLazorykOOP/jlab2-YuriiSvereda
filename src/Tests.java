import java.sql.SQLOutput;

public class Tests {
    static void task1(){
        Triangle instant = new Triangle(15, 25, 20);
        System.out.println(instant.getType());
        System.out.println(instant.getHa());
        try{
            instant.setAngleA(90);
            instant.setAngleA(72);
            instant.setAngleA(54);
        }catch(Exception ex){
            System.out.println(ex.getCause());
        }
        System.out.println(instant.calculateArea());
        System.out.println(instant.calculatePerimetr());
    }
}
