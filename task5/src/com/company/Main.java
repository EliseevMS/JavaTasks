package com.company;
import com.company.BoundingBox;
import com.company.Circle;
import com.company.Annotation;

public class Main {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
    }

    private static void test1() {
        BoundingBox box = new BoundingBox(new Point(0,10), new Point(100,0));
        Circle circle = new Circle(new Point(100, 100), 50);
        Annotation annotatedBox = new Annotation(box, "box");
        Annotation annotatedCircle = new Annotation(circle, "circle");
        Annotation[] annotations = new Annotation[]{annotatedBox, annotatedCircle};
        Annotation a = Annotation.findByPoint(annotations,110,90); // circle
        if (a != null) {
            System.out.println(a.getLabel());
            System.out.println(a.getFigure().getDescription());
        } else {
            System.out.println("Not found annotation by point");
        }
    }

    private static void test2() {
        BoundingBox box = new BoundingBox(new Point(0,10), new Point(100,0));
        Circle circle = new Circle(new Point(100, 100), 50);
        System.out.println(box.getDescription());
        System.out.println("Move it");
        box.move(5,10);
        System.out.println(box.getDescription());

        System.out.println();

        System.out.println(circle.getDescription());
        System.out.println("Move it");
        circle.move(5,10);
        System.out.println(circle.getDescription());
    }
}
