package mandelbrot;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author marcus
 */
public class MandelbrotFrame extends JFrame{

    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private static final String TITLE = "Mandelbrot";
    
    public MandelbrotFrame() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Mandelbrot");
        
        Container container = this.getContentPane();
        
        SimpleBitmap panel = new SimpleBitmap();
        container.add(panel);
        
        this.setVisible(true);
    } // MandelbrotFrame()

    
} // MandelbrotFrame
