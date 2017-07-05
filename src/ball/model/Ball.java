package ball.model;

import java.awt.*;
import java.util.ArrayList;

public class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;
    protected ArrayList<Behaviour> behaviours = new ArrayList<>();

    protected Ball(int x, int y, int radius,ArrayList<Behaviour> behaviours) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = behaviours;
    }

    protected Ball(int x, int y,ArrayList<Behaviour> behaviours) {

        this(x, y,DEFAULT_RADIUS,behaviours);
    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

    public void update(){
        for (Behaviour behaviour : behaviours) {
            behaviour.applyBehaviour(this);
        }
    }
}
