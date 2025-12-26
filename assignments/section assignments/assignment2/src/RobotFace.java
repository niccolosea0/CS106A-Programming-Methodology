/* File: RobotFace.java */
/* This program draws robot face */


import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {

    private static final int HEAD_WIDTH = 250;
    private static final int HEAD_HEIGHT = 350;
    private static final int EYE_RADIUS = 25;
    private static final int MOUTH_WIDTH = 120;
    private static final int MOUTH_HEIGHT = 50;

    public void run() {
        add_face(getWidth() / 2, getHeight() / 2);
    }

    public void add_face(double cx, double cy) {
        add_head(cx, cy);
        add_eyes(cx - HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4);
        add_eyes(cx + HEAD_WIDTH / 4, cy - HEAD_HEIGHT / 4);
        add_mouth(cx, cy + HEAD_HEIGHT / 4);
    }

    public void add_head(double cx, double cy) {
        double x = cx - HEAD_WIDTH / 2;
        double y = cy - HEAD_HEIGHT / 2;

        GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
        head.setFilled(true);
        head.setFillColor(Color.GRAY);
        add(head);
    }

    public void add_eyes(double cx, double cy) {
        double x = cx - EYE_RADIUS;
        double y = cy - EYE_RADIUS;

        GOval eye = new GOval(x, y, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
        eye.setFilled(true);
        eye.setColor(Color.YELLOW);
        add(eye);
    }

    public void add_mouth(double cx, double cy) {
        double x = cx - MOUTH_WIDTH / 2;
        double y = cy - MOUTH_HEIGHT / 2;

        GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
        mouth.setFilled(true);
        mouth.setColor(Color.WHITE);
        add(mouth);
    }

}
