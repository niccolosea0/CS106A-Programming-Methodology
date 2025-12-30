// File: BouncingBall.java
// This program graphically simulates a bouncing ball

import acm.program.*;
import acm.graphics.*;


public class BouncingBall extends GraphicsProgram {

    // Size (diameter) of the ball
    private static final int DIAM_BALL = 30;

    // Amount of Y Velocity is increased each cycle as a result of gravity
    private static final double GRAVITY = 3;

    // Animation delay or pause between ball moves
    private static final int DELAY = 50;

    // Initial X and Y coordinates of ball
    private static final double X_START = DIAM_BALL / 2;
    private static final double Y_START = 100;

    // X Velocity
    private static final double X_VEL = 5;

    // Amount of Y Velocity is reduced when it bounced
    private static final double BOUNCE_REDUCED = 0.9;

    // Starting X and Y Velocities
    private double xVel = X_VEL;
    private double yVel = 0.0;

    // Private instance variable
    private GOval ball;

    public void run() {
        
        // 1. Show created ball on the screen
        setup();

        while (ball.getX() < getWidth()) {  // 2. Loop while ball is not out of window
                
                moveBall(); // 3. Move the ball
                checkForCollision(); // 4. Check if ball exceeded window height
                pause(DELAY); // 5. Add delay to see how

        } // 6. Repeat steps 3,4,5
    }


    // Create and place ball
    public void setup() {
        ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
        ball.setFilled(true);
        add(ball);
    }

    // Update and move ball
    public void moveBall() {
        // Update Y Velocity by increasing it value with gravity on each cycle
        yVel += GRAVITY;

        // Move the ball with xVel and yVel coordinates
        ball.move(xVel, yVel);

    }
    
    // Determine if collision with floor, update velocities and locations as appropiate
    public void checkForCollision() {

        if (ball.getY() > (getHeight() - DIAM_BALL)) {
            yVel = -yVel * BOUNCE_REDUCED;

            // Calculate difference between ball and floor,
            // It is used, to get the ball on the floor after it exceeds it far.
            double diff = ball.getY() - (getHeight() - DIAM_BALL);

            ball.move(0, -2 * diff);
        }

    }

}
