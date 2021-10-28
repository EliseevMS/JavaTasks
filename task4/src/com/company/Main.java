package com.company;
import com.company.BoundingBox;
import com.company.Circle;
import com.company.Annotation;
public class Main {

    public static void main(String[] args) {
        BoundingBox box = new BoundingBox(new Point(0, 10), new Point(100, 0));
        Circle circle = new Circle(new Point(100, 100), 50);
        Annotation annotatedBox = new Annotation(box, "box");
        Annotation annotatedCircle = new Annotation(circle, "circle");
        Annotation[] annotations = new Annotation[]{annotatedBox, annotatedCircle};
        for (Annotation annotation : annotations) {
            System.out.println(annotation.getLabel());
            System.out.println(annotation.getFigure().getDescription());
            System.out.println();
        }
    }
}