import acm.graphics.*;
import acm.program.*;



public class CheckerBoard extends GraphicsProgram {

    // Private constants
    public static final int NROWS = 8;
    public static final int NCOLUMNS = 8;

    public void run() {

        // Calculate size of each piece of board
        double sqSize = (double) getHeight() / NROWS;

        for (int i = 0; i < NROWS ; i++) {  // Iterate over the rows

            double y = i * sqSize; // Calculate position of the next square in vertical (y coordiante)

            for (int j = 0; j < NCOLUMNS ; j++) {  // Iterate over the columns

                double x = j * sqSize; // Calculate position of the next square in horizontal (x coordinate)
                GRect sq = new GRect(x, y, sqSize, sqSize);
                sq.setFilled((i + j) % 2 != 0);
                add(sq);
            }
        }
    }
}
