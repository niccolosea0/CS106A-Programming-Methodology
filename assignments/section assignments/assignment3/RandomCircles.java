/*
    Write a GraphicsProgram that draws a set of ten circles with different sizes, positions,
    and colors. Each circle should have a randomly chosen color, a randomly chosen radius
    between 5 and 50 pixels, and a randomly chosen position on the canvas, subject to the
    condition that the entire circle must fit inside the canvas without extending past the edge.
    The following sample run shows one possible outcome:
*/



import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class RandomCircles extends GraphicsProgram {

    
    /* Circles need to have
     *
     * 1. Randomly chosen COLOR
     * 2. Randomly chosen RADIUS between 5 and 50 pixels
     * 3. Randomly chosen POSITIONS on the canvas
     *
     * 4. Entire circle MUST FIT INSIDE THE CANVAS
     */

    //  Number of circles to be displayed
    private static final int CIRCLES_NUM = 10;

    // GOval object
    private GOval circle;

    public void run() {

        // Get canvas width and height
        int canvasWidth = getWidth();
        int canvasHeight = getHeight();

        // Loop 10 times and print circles
        for (int i = 0; i < CIRCLES_NUM; i++) {
            addCircle(canvasWidth, canvasHeight);
        }

    }


    private void addCircle(int cw, int ch) {

        // Get random radius
        int radius = rgen.nextInt(5, 50);

        // Get x and y coordinates
        int x = getRandomX(cw, radius);
        int y = getRandomY(ch, radius);

        // Get random color
        Color randomColor = rgen.nextColor();

        // Create circle object
        circle = new GOval(x, y, 2 * radius, 2 * radius);
        circle.setFilled(true);
        circle.setColor(randomColor);
        add(circle);

    }


    // Get random X coordinate 
    private int getRandomX(int cw, int radius) {

        int randomX = rgen.nextInt(0, cw);

        int diameter = 2 * radius;

        // Check if circle exceeds canvas width
        if ((randomX + diameter) > cw) {
            randomX = cw - diameter;
        }

        return randomX;

    }

    // Get random Y coordinate
    private int getRandomY(int ch, int radius) {
        
        int randomY = rgen.nextInt(0, ch);
        int diameter = 2 * radius;

        // Check if circle exceeds canvas height
        if ((randomY + diameter) > ch) {
            randomY = ch - diameter;
        }

        return randomY;

    }

    private RandomGenerator rgen = RandomGenerator.getInstance();
}

