import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Pyramid {
        public static int width = 640;
        public static int height = 480;
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setSize(width, height);
        f.setLocation(500, 250);
        f.setTitle("Pyramid");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setContentPane(new Panel());
        f.setVisible(true);
    }
}

class Panel extends JComponent {

    public void paintComponent(Graphics g) {

        final int BRICK_WIDTH = 30;
        final int BRICK_HEIGHT = 15;
        final int BRICK_IN_BASE = 14; // 14 bricks in base

        int panelCenterWidth = getWidth() / 2; // Center width of the panel
        int brickY = (getHeight() - BRICK_HEIGHT); // Bottom center height

        int bricks_in_row = BRICK_IN_BASE; // Variable to determine how many bricks do we have in each row

        for (int column = 0; column < BRICK_IN_BASE; column++) { // Loop for printing height of the pyramid

            int rowWidth = bricks_in_row * BRICK_WIDTH; // Calculating row width for positioning the pyramid

            for (int row = 0; row < bricks_in_row; row++) { // For loop for printing rows
                int startX = (panelCenterWidth) - (rowWidth / 2); // Very left position of the first brick
                g.drawRect(startX + (row * BRICK_WIDTH), brickY - (column * BRICK_HEIGHT), BRICK_WIDTH, BRICK_HEIGHT);
            }

            bricks_in_row--; // Decrease value of the bricks_in_row for printing another row up
        }

    }
}
