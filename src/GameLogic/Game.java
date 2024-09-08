package GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    private Frog player;
    private ArrayList<Car> cars;

    public Game(String nameOfPlayer, Point startingPosition) {
        this.player = new Frog(nameOfPlayer, startingPosition);
        this.cars = new ArrayList<Car>();

        cars.add(new Car(new Point(100,400), Color.red, 10, 120, 75, false));
        cars.add(new Car(new Point(0,300), Color.orange, 25, 200, 75, false));
        cars.add(new Car(new Point(100,150), Color.yellow, 30, 120, 75, true));
        cars.add(new Car(new Point(0,80), Color.black, 20, 120, 75, true));
    }

    public Frog getPlayer() {
        return player;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void movePlayer(int keys, int stepInPixels) {
        Point currentPosition = player.getCurrentPosition();

        if(keys == KeyEvent.VK_UP) {
            currentPosition.x = currentPosition.x;
            currentPosition.y = currentPosition.y - stepInPixels;
        } else if(keys == KeyEvent.VK_DOWN) {
            currentPosition.x = currentPosition.x;
            currentPosition.y = currentPosition.y + stepInPixels;
        } else if(keys == KeyEvent.VK_LEFT) {
            currentPosition.x = currentPosition.x - stepInPixels;
            currentPosition.y = currentPosition.y;
        } else if(keys == KeyEvent.VK_RIGHT) {
            currentPosition.x = currentPosition.x + stepInPixels;
            currentPosition.y = currentPosition.y;
        }
    }

    public void moveCars(int edge) {
        for(Car c : cars){
            c.move();
            if(c.isMoveLeft()){
                if(c.getCurrentPosition().x < 0){
                    c.getCurrentPosition().x = edge;
                }
            }else {
                if(c.getCurrentPosition().x > edge){
                    c.getCurrentPosition().x = 0;
                }
            }
        }
    }

    public boolean isPlayerHit() {
        Point playerPosition = new Point();
        playerPosition = player.getCurrentPosition();
        for(Car c : cars){
            Rectangle r = c.getCollisionBounds();
            if(r.contains(playerPosition)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPlayerWon() {
        return player.getCurrentPosition().y <= 20;
    }
}
