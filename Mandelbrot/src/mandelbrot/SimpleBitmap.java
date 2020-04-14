package mandelbrot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;
import javax.swing.JPanel;

class SimpleBitmap extends JPanel {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private BufferedImage image;
    private Random rng = new Random();

    public SimpleBitmap() {
        
        int w = WIDTH;
        int h = HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } // SimpleBitmap()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale((double) w / WIDTH, (double) h / HEIGHT);
        WritableRaster raster = this.image.getRaster();

        int[] black = {0, 0, 0};
        int[] yellow = {255, 255, 0};
        int[] random = {rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)};
        int[] random2 = {rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)};

        Mandelbrot mandelbrot = new Mandelbrot(-1.3, -1.1, -0.4, -0.2);
        
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                double mandelbrotValue = mandelbrot.check(i, j, 1, w, 1, h);
 //               System.out.println(mandelbrotValue);
                raster.setPixel(i, j, yellow);
                if (mandelbrotValue < 10){
                    raster.setPixel(i,j,black);
//                } else if (mandelbrotValue < 25 && mandelbrotValue>20){
//                    raster.setPixel(i,j, random);
                } else if (mandelbrotValue < 35){
                    raster.setPixel(i,j, new int[]{0,10*(int)(mandelbrotValue-10),
                        5*(int)(mandelbrotValue-10)});
                }
            } // for
        } // for
        
        g2d.drawImage(image, scale, this);
        
    } // paintComponent( Graphics )
    
} // simpleBitmap
