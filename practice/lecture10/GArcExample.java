import acm.program.*;
import acm.graphics.*;

public class GArcExample extends GraphicsProgram {


    public void run() {

        double cx = getWidth() / 2;
        double cy = getHeight() / 2;

        double d = getHeight() * 0.8;   // Diameter of the circle

        // Create GArc object
        GArc a1 = new GArc(d, d, 0, 90);
       
        /* Add GArc object in center */
        // add(a1, cx - d / 2, cy - d / 2);

        GArc a2 = new GArc(d, d, 45, 270);
        // add(a2, cx - d / 2, cy - d / 2);

        GArc a3 = new GArc(d, d, -90, 90);
        // add(a3, cx - d / 2, cy - d / 2);

        GArc a4 = new GArc(d, d, 0, -180);
        // add(a4, cx - d / 2, cy - d / 2);


        // Colored arc (filled)
        GArc a5 = new GArc(0, 0, getWidth(), getHeight(), 0, 235);
        a5.setFilled(true);
        add(a5);


    }

}
