package lecture11;
import acm.program.*;

public class DrawFace extends GraphicsProgram {
    private static final int FACE_WIDTH = 100;
    private static final int FACE_HEIGHT = 100;

    public void run() {

        GFace face = new GFace(FACE_WIDTH, FACE_HEIGHT);
        add(face, (getHeight() - FACE_WIDTH) / 2, (getWidth() - FACE_HEIGHT) / 2);

    }
}
