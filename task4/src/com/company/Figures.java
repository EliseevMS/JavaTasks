package com.company;
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
}

abstract class Figure {
    abstract String getDescription();
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
}
