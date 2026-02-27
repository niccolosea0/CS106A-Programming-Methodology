/*
* File: Breakout.java
* -------------------
* This file will eventually implement the game of Breakout.
*/
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 700;
    
    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 60;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static final int NTURNS = 3;

    public void run() {
        /* You fill this in, along with any subsidiary methods */
        setup();
        play();
    }

    public void setup() {
        setupBricks();
        createPaddle();
        addMouseListeners();
    }

    public void play() {
        createBall();
        initializeVelocity();
        moveBall();
    }

    // Method to create bricks
    private void setupBricks() {
        double startX = (WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH +
                    (NBRICKS_PER_ROW - 1) * BRICK_SEP)) / 2; 

        for (int i = 0; i < NBRICK_ROWS; i++) {
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                brick = new GRect(startX + (j * (BRICK_WIDTH + BRICK_SEP)), (i * (BRICK_HEIGHT + BRICK_SEP)) + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                giveBrickColor(brick, i);
                add(brick);
            }
        }
    }

    // Method to give bricks color
    private void giveBrickColor(GRect brick, int row) {
        switch (row) {
    
            case 0:
            case 1:
                brick.setColor(Color.RED);
                break;
    
            case 2:
            case 3:
                brick.setColor(Color.ORANGE);
                break;
    
            case 4:
            case 5:
                brick.setColor(Color.YELLOW);
                break;
    
            case 6:
            case 7:
                brick.setColor(Color.GREEN);
                break;
    
            case 8:
            case 9:
                brick.setColor(Color.CYAN);
    
    break;
        }
    }

    // Method to create a paddle
    private void createPaddle() {

        paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle, (WIDTH - PADDLE_WIDTH) / 2, (HEIGHT -  PADDLE_Y_OFFSET - PADDLE_HEIGHT));
    }

    // Locate paddle when mouse is pressed, ensure paddle is selected
    public void mousePressed(MouseEvent e) {

        paddleLast = new GPoint(e.getX(), e.getY());
        GObject obj = getElementAt(paddleLast);

        if (obj == paddle) {
            paddle = (GRect) obj;
        }
    }

    // Method that dragges paddles
    public void mouseDragged(MouseEvent e) {

        if (paddle != null) {
            paddle.move(e.getX() - paddleLast.getX(), 0);

            // left boundary
            if (paddle.getX() <= 0) {
                paddle.setLocation(0, paddle.getY());
            } 

            // right boundaty
            else if (paddle.getX() >= WIDTH - PADDLE_WIDTH) {
                paddle.setLocation(WIDTH - PADDLE_WIDTH, paddle.getY());
            }

            // Update last positions
            paddleLast = new GPoint(e.getX(), e.getY());
        }
    }

    // Method that creates a ball
    private void createBall() {
        double diameter = 2 * BALL_RADIUS;
        ball = new GOval(
            WIDTH / 2 - BALL_RADIUS,
            HEIGHT / 2 - BALL_RADIUS,
            diameter,
            diameter
        );
        ball.setFilled(true);
        add(ball);
    }

    // Method to initialize velocities
    private void initializeVelocity() {
        // Vertical velocity will be differnet in games
        vx = rgen.nextDouble(1.0, 3.0);
        vy = 3;
        if (rgen.nextBoolean(0.5)) 
            vx = -vx;
    }

    // Method where ball actually moves
    private void moveBall() {
        GObject collider = getCollidingObject();

        while (true) {
            ball.move(vx, vy);
            checkWallCollisions();
            dealWithCollide();
            pause(6);

        }
    }

    // Method to check if ball hit walls
    private void checkWallCollisions() {
        // left wall or right wall
        if ((ball.getX() <= 0) || (ball.getX() + (2 * BALL_RADIUS)) >= WIDTH) {
            vx = -vx;
        }

        // top wall or bottom wall
        if ((ball.getY() <= 0) || (ball.getY() + (2 * BALL_RADIUS)) >= HEIGHT) {
            vy = -vy;
        }
    }

    // Method to get Colliding Object
    private GObject getCollidingObject() {

        double x = ball.getX();
        double y = ball.getY();
        double diameter = (2 * BALL_RADIUS);

        // object on top left
        GObject collider = getElementAt(x, y);

        if (collider == null) {
            // get object on top right
            collider = getElementAt(x + diameter, y);
        }

        if (collider == null) {
            // get object on bottom left
            collider = getElementAt(x, y + diameter);
        }

        if (collider == null) {
            // get object on bottom right
            collider = getElementAt(x + diameter, y + diameter);
        }

        return collider;
    }

    private void dealWithCollide() {

        GObject collider = getCollidingObject();
        
        if (collider == paddle) {
            vy = -vy;
        } else if (collider != null) {
            remove(collider);
            vy = -vy;
        }
    }



    // Private instance variables
    private GRect brick;
    private GRect paddle;
    private GPoint paddleLast;
    private GOval ball;
    private double vx, vy;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private int hearts = 5;

    // Adding main method to determine main class
    public static void main(String[] args) {
        new Breakout().start(args);
    }
}
