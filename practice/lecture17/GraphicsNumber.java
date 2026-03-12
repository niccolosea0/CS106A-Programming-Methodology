import acm.program.*;
import acm.graphics.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.*;

public class GraphicsNumber extends GraphicsProgram {

    private List<GLabel> labels = new ArrayList<>();
    private static final double START_X = 50;
    private static final double START_Y = 50;


    public void run() {
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {

        GLabel lab = new GLabel("#" + labels.size());
        lab.setFont("Arial-19");

        // Move all existing labels down one row
        double dy = lab.getHeight();
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).move(0, dy);
        }

        add(lab, START_X, START_Y);
        labels.add(lab);

    }
}
