package ball.model;

import java.util.ArrayList;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(350,200,Bouncing.UP,Ball.DEFAULT_RADIUS,Elastic.SHRINK)
        };
    }

    private static Ball bouncingElasticBall(int centerX , int centerY, int direction, int defaultRadius, int growthDirection) {
        ArrayList<Behaviour> behaviour = new ArrayList<>();
        behaviour.add(new Bouncing(direction));
        behaviour.add(new Elastic(growthDirection));

        return new Ball(centerX,centerY,defaultRadius,behaviour);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        ArrayList<Behaviour> behaviour = new ArrayList<>();
        behaviour.add(new Bouncing(direction));
        return new Ball(centerX,centerY,behaviour);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        ArrayList<Behaviour> behaviour = new ArrayList<>();
        behaviour.add(new Elastic(direction));
        return new Ball(centerX,centerY,radius, behaviour);
    }
}
