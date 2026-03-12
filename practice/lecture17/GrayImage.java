import acm.program.*;
import acm.graphics.*;

public class GrayImage extends GraphicsProgram {

    public void run() {

        GImage image = new GImage("samurai.jpg");
        GImage grayImage = createGrayImage(image);

        image.scale(0.5);
        add(image, (getWidth() / 2) - 200, 50);

        grayImage.scale(0.5);
        add(grayImage, (getWidth() / 2) + 200, 50);
    }

    // Creates a grayscale version of original image
    private GImage createGrayImage(GImage image) {

        // Gets copy of pixel array from image
        int[][] array = image.getPixelArray();

        int height = array.length;  // number of rows in grid
        int width = array[0].length;    // number of columns in grid

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = array[i][j];

                int r = GImage.getRed(pixel);
                int g = GImage.getGreen(pixel);
                int b = GImage.getBlue(pixel);

                int xx = computeLuminocity(r, g, b);
                array[i][j] = GImage.createRGBPixel(xx, xx, xx);
            }
        }

        return new GImage(array);

    }

    private int computeLuminocity(int r, int g, int b) {
        return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
    }
}
