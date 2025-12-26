/* File: Pyramid.java */
/* This program draws pyramid consisting of bricks in horizontal row */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

    private static final int BRICK_WIDTH = 35;
    private static final int BRICK_HEIGHT = 15;
    private static final int BRICK_IN_BASE = 14;


    public void run() {


        double cx = getWidth() / 2;
        int y = getHeight(); 
        int bricks_in_row = BRICK_IN_BASE; // Variable that will change after each row

        for (int i = 0; i < BRICK_IN_BASE; i++) { // Loop for rows
            double row_length_center = bricks_in_row * BRICK_WIDTH / 2.; // Calculate each row length center for positioning

            double startX = (cx - row_length_center); // start coordiante for first brick in row

            for (int j = 0; j < bricks_in_row; j++) {
                int height = (i + 1) * BRICK_HEIGHT; // Variable for shifting height  

                GRect rect = new GRect(startX + j * BRICK_WIDTH, y - height, BRICK_WIDTH, BRICK_HEIGHT);
                add(rect);
            }
            bricks_in_row--; // Decrease because we are shifting height up
        }
    }
}
