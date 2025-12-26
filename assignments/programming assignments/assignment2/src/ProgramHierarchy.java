/* File: ProgramHierarchy.java */
/* This program draws program acm program hierarchy */
/* We are using GRect, GLine, GLabel classes */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {


    // Rectangles width and height
    private static final int BRICK_WIDTH = 150;
    private static final int BRICK_HEIGHT = 60;

    public void run() {
        
     // Canvas middle points
      double cx = getWidth() / 2;
      double cy = getHeight() / 2;
      add_hierarchy(cx, cy);

    }

    public void add_hierarchy(double cx, double cy) {
        // Add Rectangles
        add_brick(cx - BRICK_WIDTH / 2, cy - BRICK_HEIGHT); //  top rectangle
        add_brick(cx - BRICK_WIDTH / 2, cy + BRICK_HEIGHT); // bottom-middle rectangle
        add_brick(cx - (2 * BRICK_WIDTH), cy + BRICK_HEIGHT); // bottom-left rectangle
        add_brick(cx + BRICK_WIDTH, cy + BRICK_HEIGHT); // bottom-right rectangle

        // Add lines
        add_line(cx, cy, cx, cy + BRICK_HEIGHT); // top-to-bottom middle line
        add_line(cx, cy, cx - (1.5 * BRICK_WIDTH), cy + BRICK_HEIGHT); // top-to-bottomleft line
        add_line(cx, cy, cx + (1.5 * BRICK_WIDTH), cy + BRICK_HEIGHT); // top-to-bottomleft line

        // Add labels
        // top label
        GLabel program = new GLabel("Program");
        program.setFont("Sansserif-16"); 
        double programX = cx - program.getWidth() / 2.;
        double programY = cy - (BRICK_HEIGHT / 2) + (program.getAscent() / 2.);
        add(program, programX, programY);

        // bottom-middle label
        GLabel console_program = new GLabel("ConsoleProgram");
        console_program.setFont("Sansserif-16"); 
        double consoleX = cx - console_program.getWidth() / 2.; 
        double bottomY = cy + (1.5 * BRICK_HEIGHT) + console_program.getAscent() / 2.; 
        add(console_program, consoleX, bottomY);

        // bottom-left label
        GLabel graphics_program = new GLabel("GraphicsProgram");
        graphics_program.setFont("Sansserif-16"); 
        double graphicsX = cx - (1.5 * BRICK_WIDTH) - graphics_program.getWidth() / 2.;
        double graphicsY = cy + (1.5 * BRICK_HEIGHT) + console_program.getAscent() / 2.; 
        add(graphics_program, graphicsX, graphicsY);

        // bottom-right label
        GLabel dialog_program = new GLabel("DialogProgram");
        dialog_program.setFont("Sansserif-16"); 
        double dialogX = cx + (1.5 * BRICK_WIDTH) - dialog_program.getWidth() / 2.;
        double dialogY = cy + (1.5 * BRICK_HEIGHT) + console_program.getAscent() / 2.; 
        add(dialog_program, dialogX, dialogY);
    }

    public void add_brick(double x, double y) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        add(brick);
    }

    public void add_line(double startX, double startY, double endX, double endY) {
       GLine line = new GLine(startX, startY, endX, endY);
       add(line);
    }

}
