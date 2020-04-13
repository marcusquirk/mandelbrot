package mandelbrot;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

class SimpleBitmap extends JPanel implements ActionListener {

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private BufferedImage image;
    private Random rng = new Random();

    public SimpleBitmap() {
        Timer timer = new Timer(300, this);
        timer.start();
        
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

        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                if (Math.abs(i-j) < 10) {
                    raster.setPixel(i, j, yellow);
                } // if
                else if ((int)((double) i / j) == 2){
                    raster.setPixel(i, j, random);
                }
                else if (rng.nextInt(8)<rng.nextInt(4)){
                    raster.setPixel(i, j, random2);
                }
                else if (Math.abs((w-i)-(30+j)) < 5) {
                    raster.setPixel(i, j, random);
                } // if
                else {
                    raster.setPixel(i, j, black);
                }
            } // for
        } // for
        
        g2d.drawImage(image, scale, this);
        
    } // paintComponent( Graphics )
    
    @Override
    public void actionPerformed(ActionEvent e){
        this.repaint();
    }
    
} // simpleBitmap
