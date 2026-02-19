package lecture11;

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class ClickForFace extends GraphicsProgram {

    public void init() {
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {
        GFace face = new GFace(FACE_WIDTH, FACE_HEIGHT);
        add(face, e.getX(), e.getY());
    }

    private static final int FACE_WIDTH = 50;
    private static final int FACE_HEIGHT = 100;
}
