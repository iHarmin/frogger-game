package GameLogic;
import java.awt.*;
public class Car {
    private Point currentPosition;
    private Color bodyColour;
    private int movementSpeed;
    private int xSize;
    private int ySize;
    private boolean moveLeft;

    public Car(Point currentPosition, Color bodyColour, int movementSpeed, int xSize, int ySize, boolean moveLeft) {
        this.currentPosition = currentPosition;
        this.bodyColour = bodyColour;
        this.movementSpeed = movementSpeed;
        this.xSize = xSize;
        this.ySize = ySize;
        this.moveLeft = true;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Color getBodyColour() {
        return bodyColour;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void move() {
        if(moveLeft) {
            currentPosition.x -= movementSpeed;
        } else {
            currentPosition.x += movementSpeed;
        }
    }

    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x, currentPosition.y,xSize,ySize);
    }

}
