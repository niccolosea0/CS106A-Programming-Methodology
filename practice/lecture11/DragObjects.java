/*
* File: DragObjects.java
* ----------------------
* Example program to show mouse and keyboard interactions.
* This program allows us to move objects on the screen
* by dragging then with the mouse. We can also change the
* color of the last object moved to a random color by typing a key.
*/

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class DragObjects extends GraphicsProgram {

    private GObject gobj; // The object being dragged
    private GPoint last; // The last mouse position
    private RandomGenerator rgen = RandomGenerator.getInstance(); // Variable to get random position

    public void init() {
        GRect grect = new GRect(100, 100, 150, 100);
        grect.setFilled(true);
        add(grect);
        
        GOval oval = new GOval(50, 50, 150, 100);
        oval.setFilled(true);
        add(oval);

        addMouseListeners();
        addKeyListeners();
    }

    // Called on mouse press to record the coordinates of the click
    public void mousePressed(MouseEvent e) {
        last = new GPoint(e.getX(), e.getY());
        gobj = getElementAt(last);
    }

    // Called on mouse drag to reposition the object
    public void mouseDragged(MouseEvent e) {
        gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
        last = new GPoint(e.getPoint());
    }

    // Change the color of last object dragged
    public void keyTyped(KeyEvent e) {
        if (gobj != null) {
            gobj.setColor(rgen.nextColor());
        }
    }
}

