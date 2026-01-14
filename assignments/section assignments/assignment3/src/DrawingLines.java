/* File: DrawingLines.java
 * This program allows users to draw lines on canvas
*/


import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class DrawingLines extends GraphicsProgram {

    // Start coordinates
    private int lineStartX = 0;
    private int lineStartY = 0;

    // End coordinates, that will change overtime
    private int lineEndX = 0;
    private int lineEndY = 0;

    // Declare Gline reference variable
    private GLine line;

    public void run() {

        // Mouse Listener, that will listen for mouse events 
        addMouseListeners();

    }

    // When mouse pressed, one small dot will be placed, which indicates line's start position
    public void mousePressed(MouseEvent e) {

        // Initialize line start coordinates
        lineStartX = e.getX();
        lineStartY = e.getY();

        // Create new line with start coordinates 
        line = new GLine(lineStartX, lineStartY, lineStartX, lineStartY);
        add(line);
    }

    // When mouse is dragged, this function is called
    public void mouseDragged(MouseEvent e) {


       // Initialize line end coordinates
       lineEndX = e.getX();
       lineEndY = e.getY();
       
       // Update line's end points
       line.setEndPoint(lineEndX, lineEndY);
    }

    
    /* If we want to delete line after releasing mouse, uncomment below lines */
    /* public void mouseReleased(MouseEvent e) {
        remove(line);
    }
    */
}
