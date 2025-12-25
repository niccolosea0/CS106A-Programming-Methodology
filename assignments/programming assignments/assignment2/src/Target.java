import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Target  {
    public static final int width = 640;
    public static final int height = 480;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(width , height);
        frame.setTitle("Target");
        frame.setLocation(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new PanelTarget());
        frame.setVisible(true);
    }
}

class PanelTarget extends JComponent {

    final double OUTER_RED_CIRCLE_RADIUS = 96;
    final double WHITE_CIRCLE_RADIUS = 62.4;
    final double INNER_RED_CIRCLE_RADIUS = 28.8;

    public void paintComponent(Graphics g) {

        // Calculate center position
        int circleX = (getWidth() / 2);
        int circleY = (getHeight() / 2);

        // Calculate start position for outer circle
        int outerCircleStartX = (int) (circleX - OUTER_RED_CIRCLE_RADIUS);
        int outerCircleStartY = (int) (circleY - OUTER_RED_CIRCLE_RADIUS);

        // Draw outer circle
        g.setColor(Color.RED);
        g.fillOval(outerCircleStartX, outerCircleStartY, (int) (2 * OUTER_RED_CIRCLE_RADIUS), (int) (2 * OUTER_RED_CIRCLE_RADIUS));

        // Calculate outer start position for white circle
        int whiteCircleStartX = (int) (circleX - WHITE_CIRCLE_RADIUS);
        int whiteCircleStartY = (int) (circleY - WHITE_CIRCLE_RADIUS);

        // Draw white circle
        g.setColor(Color.WHITE);
        g.fillOval(whiteCircleStartX, whiteCircleStartY, (int) (2 * WHITE_CIRCLE_RADIUS),  (int) (2 * WHITE_CIRCLE_RADIUS));

        // Calculate start position for inner circle
        int innerCircleStartX = (int) (circleX - INNER_RED_CIRCLE_RADIUS);
        int innerCircleStartY = (int) (circleY - INNER_RED_CIRCLE_RADIUS);

        // Draw inner circle
        g.setColor(Color.RED);
        g.fillOval(innerCircleStartX, innerCircleStartY, (int) (2 * INNER_RED_CIRCLE_RADIUS), (int) (2 * INNER_RED_CIRCLE_RADIUS));
    }

}
