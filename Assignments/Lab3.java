package Assignments;
import java.util.*;

class shape{

    double Base,Height,Area;
    static double setArea(double Base, double Height){
       return (Base*Height)/2;
    }

    double Side;
    static double setArea(double Side){
        return Side * Side;
    }

    float Radius;
    static float PI = 3.14f;
    static float setArea(float Radius){
        return PI *Radius*Radius;
    }
}

class Triangle extends shape{
    void getInputs(){
        System.out.println("Triangle");
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter the Base: ");
        Base = SC.nextDouble();
        System.out.print("Enter the Height: ");
        Height = SC.nextDouble();
    }
    
}

class Square extends shape{

    void getInputs(){
        System.out.println("Square");
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter the Side : ");
        Side = SC.nextDouble();
    }
    
}

class Circle extends shape{

    void getInputs(){
        System.out.println("Circle");
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter the Radius : ");
        Radius = SC.nextFloat();
    }
    
}


public class Lab3{
    public static void main(String[] args) {
        Triangle T = new Triangle();
        T.getInputs();
        T.Area = shape.setArea(T.Base,T.Height);
        
        Square S = new Square();
        S.getInputs();
        S.Area = shape.setArea(S.Side);
        
        Circle C = new Circle();
        C.getInputs();
        C.Area = shape.setArea(C.Radius);
        double roundoff = Math.floor(C.Area * 100)/100;


        System.out.println("Area of Triangle is : "+T.Area);
        System.out.println("Area of Square is : "+S.Area);
        System.out.println("Area of Circle is : "+ roundoff);

    }
}