package ball.model;

import ball.ui.BallWorld;
import org.junit.Test;

import static ball.BallTestHarness.*;

public class BouncingTest {
    @Test
    public void shouldGoDown() {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, Bouncing.DOWN);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingBall);
    }

    @Test
    public void shouldGoUpAfterHittingTheBottom() {
        int theBottomEdge = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theBottomEdge, Bouncing.DOWN);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(theBottomEdge), bouncingBall);
    }

    @Test
    public void shouldGoUp() {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, Bouncing.UP);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(100), bouncingBall);
    }

    @Test
    public void shouldGoDownAfterHittingTheTop() {
        int theTopEdge = Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theTopEdge, Bouncing.UP);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(theTopEdge), bouncingBall);
    }
}
