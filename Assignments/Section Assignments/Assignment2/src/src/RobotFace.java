import javax.swing.*;
import java.awt.*;

public class RobotFace {
    public static void main(String[] args) {

        JFrame frame = new JFrame("RobotFace");
        frame.setSize(600,600);
        frame.setLocation(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }
}

class Panel extends JPanel {
    public void paintComponent(Graphics g) {

        final int HEAD_WIDTH = 300;
        final int HEAD_HEIGHT = 400;
        final int EYE_RADIUS = 20;
        final int MOUTH_WIDTH = 150;
        final int MOUTH_HEIGHT = 50;

        // Calculate top-left corner of the rectangle
        int headX = (getWidth() - HEAD_WIDTH) / 2;
        int headY = (getHeight() - HEAD_HEIGHT) /2;

        // Fill gray rectangle
        g.setColor(Color.GRAY);
        g.fillRect(headX, headY, HEAD_WIDTH, HEAD_HEIGHT);

        // Draw rectangle with black outlines
        g.setColor(Color.BLACK);
        g.drawRect(headX, headY, HEAD_WIDTH, HEAD_HEIGHT);


        // Calculate centers for the eyes
        int leftEyeCenterX = headX + (HEAD_WIDTH / 4);
        int rightEyeCenterX = headX + (3 * HEAD_WIDTH / 4);
        int eyeCenterY = headY + (HEAD_HEIGHT / 4);

        // Calculate top-left corner of the eyes
        int leftEyeX = leftEyeCenterX - EYE_RADIUS;
        int leftEyeY = eyeCenterY - EYE_RADIUS;
        int rightEyeX = rightEyeCenterX - EYE_RADIUS;
        int rightEyeY = eyeCenterY - EYE_RADIUS;

        // Draw black outline for the eyes
        g.setColor(Color.YELLOW);
        g.fillOval(leftEyeX, leftEyeY, 2 * EYE_RADIUS, 2 * EYE_RADIUS);
        g.fillOval(rightEyeX, rightEyeY, 2 * EYE_RADIUS, 2 * EYE_RADIUS);

        // Calculate center for the mouth
        int mouthX = headX + (HEAD_WIDTH / 4);
        int mouthY = headY + (3 * HEAD_HEIGHT / 4);

        g.setColor(Color.WHITE);
        g.fillRect(mouthX, mouthY, MOUTH_WIDTH, MOUTH_HEIGHT);

    }
}
