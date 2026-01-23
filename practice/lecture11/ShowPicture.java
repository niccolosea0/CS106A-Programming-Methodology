import acm.program.*;
import acm.graphics.*;

public class ShowPicture extends GraphicsProgram {
    public void run() {

        GImage image = new GImage("samurai.jpg");
        image.scale(1.5, 1.5);
        add(image, 0, 0);
    }
}

