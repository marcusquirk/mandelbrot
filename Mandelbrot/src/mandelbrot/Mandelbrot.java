package mandelbrot;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author marcus
 */
public class Mandelbrot extends JFrame{

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final String TITLE = "Mandelbrot";
    
    public Mandelbrot() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Mandelbrot");
        
        Container container = this.getContentPane();
        
        SimpleBitmap panel = new SimpleBitmap();
        container.add(panel);
        
        this.setVisible(true);
    } // Mandelbrot()
    
    
    public static void main(String[] args) {
        Mandelbrot mandelbrot = new Mandelbrot();
    } // main()
    
} // Mandelbrot
