package com.company;


import java.lang.Math;
import com.company.Moveable;

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX (int xNew) {
        x = xNew;
    }

    public void setY (int yNew) {
        y = yNew;
    }
}

abstract class Figure implements Moveable {
    abstract String getDescription();
    abstract boolean containsPoint(Point point);
}

class BoundingBox extends Figure {
    private Point leftBottomPoint;
    private Point rightTopPoint;

    BoundingBox(Point leftBottomPoint, Point rightTopPoint) {
        this.leftBottomPoint = leftBottomPoint;
        this.rightTopPoint = rightTopPoint;
    }

    @Override
    public String getDescription() {
        return "Box: (" + leftBottomPoint.getX() + ", " + leftBottomPoint.getY() + ") - (" + rightTopPoint.getX() + ", " + rightTopPoint.getY() + ")";
    }

    @Override
    boolean containsPoint(Point point) {
        return point.getX() >= leftBottomPoint.getX() && point.getX() <= rightTopPoint.getX()
                && point.getY() >= rightTopPoint.getY() && point.getY() <= leftBottomPoint.getY();
    }

    @Override
    public void move(int dx, int dy) {
        leftBottomPoint.setX(leftBottomPoint.getX() + dx);
        leftBottomPoint.setY(leftBottomPoint.getY() + dy);
        rightTopPoint.setX(rightTopPoint.getX() + dx);
        rightTopPoint.setY(rightTopPoint.getY() + dy);
    }
}

class Circle extends Figure {
    private Point center;
    private int radius;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String getDescription() {
        return "Circle: (" + center.getX() + ", " + center.getY() + "), R = " + radius;
    }

    @Override
    boolean containsPoint(Point point) {
        return Math.pow(point.getX()-center.getX(),2)+Math.pow(point.getY()-center.getY(),2) <= radius*radius;
    }

    @Override
    public void move(int dx, int dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }
}