package GameLogic;
import java.awt.*;
public class Frog {
    private String name;
    private Point currentPosition;

    public Frog(String name, Point currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public Frog(String name) {
        this.name = name;
        this.currentPosition.x = 0;
        this.currentPosition.y = 0;
    }

    public String getName() {
        return name;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Point move(int xTranslation, int yTranslation) {
        currentPosition.x = currentPosition.x + xTranslation;
        currentPosition.y = currentPosition.y + yTranslation;
        return currentPosition;
    }

    public double distanceFromPoint(Point p) {
        return Math.sqrt(Math.abs(currentPosition.x - p.x) * Math.abs(currentPosition.x - p.x) + Math.abs(currentPosition.y - p.y) * Math.abs(currentPosition.y - p.y));
    }

    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x,currentPosition.y,30,30);
    }

    public String toString() {
        return "The frog named " + name + " is at (" + currentPosition.x + "," + currentPosition.y + ")";
    }
}
