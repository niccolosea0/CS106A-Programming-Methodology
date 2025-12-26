/* File: Target.java */
/* This file draws target object */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class Target extends GraphicsProgram {

    // Circle Radiuses
    private final double OUTER_RADIUS = 96;
    private final double MIDDLE_RADIUS = 62.4; 
    private final double INNER_RADIUS =  28.8;

    public void run() {

        double cx = getWidth() / 2;
        double cy = getHeight() / 2;

        draw_circle(cx - OUTER_RADIUS, cy - OUTER_RADIUS, OUTER_RADIUS, Color.RED);
        draw_circle(cx - MIDDLE_RADIUS, cy - MIDDLE_RADIUS, MIDDLE_RADIUS, Color.WHITE);
        draw_circle(cx - INNER_RADIUS, cy - INNER_RADIUS, INNER_RADIUS, Color.RED);
    }

    public void draw_circle(double x, double y, double radius, Color color) {

        GOval circle = new GOval(x, y, 2 * radius, 2 * radius);
        circle.setFilled(true);
        circle.setColor(color);
        add(circle);
    }
}
