import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ProgramHierarchy {

    public static final int width = 640;
    public static final int height = 480;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(width , height);
        frame.setTitle("Target");
        frame.setLocation(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new PanelProgram());
        frame.setVisible(true);
    }
}

class PanelProgram extends JComponent {
    final static int RECTANGLE_WIDTH = 150;
    final static int RECTANGLE_HEIGHT = 50;

    public void paintComponent(Graphics g) {

        int rectangleX = (getWidth() - RECTANGLE_WIDTH) / 2;
        int rectangleY = (getHeight() - RECTANGLE_HEIGHT) / 2;

        // variable to have x and y coordinates for top rectangle
        int topRectangleX = rectangleX;
        int topRectangleY = rectangleY - RECTANGLE_HEIGHT;

        // Draw top rectangle
        g.drawRect(topRectangleX, topRectangleY, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

        // variable to have x and y coordinates for bottom middle rectangle
        int bottomMiddleRectangleX = rectangleX;
        int bottomMiddleRectangleY = rectangleY + RECTANGLE_HEIGHT;

        // Draw bottom middle rectangle
        g.drawRect(bottomMiddleRectangleX, bottomMiddleRectangleY, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

        // variable to have x and y coordinates for bottom left rectangle
        int bottomLeftRectangleX = rectangleX - RECTANGLE_WIDTH - 30;
        int bottomLeftRectangleY = rectangleY + RECTANGLE_HEIGHT;

        // Draw bottom left rectangle
        g.drawRect(bottomLeftRectangleX, bottomLeftRectangleY, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

        // variable to have x and y coordinates for bottom left rectangle
        int bottomRightRectangleX = rectangleX + (RECTANGLE_WIDTH) + 30;
        int bottomRightRectangleY = rectangleY + RECTANGLE_HEIGHT;

        // Draw bottom left rectangle
        g.drawRect(bottomRightRectangleX, bottomRightRectangleY, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);


        // *** Calculate center points of rectangles where lines should start and end***
        int topRectangleLineX = topRectangleX + (RECTANGLE_WIDTH / 2);
        int topRectangleLineY = topRectangleY + RECTANGLE_HEIGHT;

        int bottomLeftRectangleLineX = bottomLeftRectangleX + (RECTANGLE_WIDTH / 2);
        int bottomMiddleRectangleLineX = bottomMiddleRectangleX + (RECTANGLE_WIDTH / 2);
        int bottomRightRectangleLineX = bottomRightRectangleX + (RECTANGLE_WIDTH / 2);

       g.drawLine(topRectangleLineX, topRectangleLineY, bottomLeftRectangleLineX, bottomLeftRectangleY);
       g.drawLine(topRectangleLineX, topRectangleLineY, bottomMiddleRectangleLineX, bottomMiddleRectangleY);
       g.drawLine(topRectangleLineX, topRectangleLineY, bottomRightRectangleLineX, bottomRightRectangleY);


       // FontMetrics for calculating width of the text
       FontMetrics fm = g.getFontMetrics();

       drawString(g, fm, "Program", topRectangleX, topRectangleY);
       drawString(g, fm, "GraphicsProgram", bottomLeftRectangleX, bottomRightRectangleY);
       drawString(g, fm, "ConsoleProgram", bottomMiddleRectangleX, bottomMiddleRectangleY);
       drawString(g, fm, "DialogProgram", bottomRightRectangleX, bottomRightRectangleY);

    }

    public static void drawString(Graphics g, FontMetrics fm, String stringName, int rectangleX, int rectangleY) {
        int textWidth =  fm.stringWidth(stringName);
        int textX = rectangleX + (RECTANGLE_WIDTH - textWidth) / 2;
        int textY = rectangleY + RECTANGLE_HEIGHT / 2;
        g.drawString(stringName, textX, textY);
    }
}
