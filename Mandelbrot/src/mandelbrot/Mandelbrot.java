package mandelbrot;

import java.awt.Color;

/**
 * A class that determines if a point is likely to be in the Mandelbrot set.
 *
 * @author marcus
 */
public class Mandelbrot {

    private Complex c;
    private double uMin;
    private double uMax;
    private double vMin;
    private double vMax;

    public Mandelbrot(double uMin, double uMax, double vMin, double vMax) {
        this.uMin = uMin;
        this.uMax = uMax;
        this.vMin = vMin;
        this.vMax = vMax;
    } // Mandelbrot()

    public int check(int x, int y, int xMin, int xMax, int yMin, int yMax,
            double c1, double c2) {
        c = this.mapping(x, y, xMin, xMax, yMin, yMax);
        Complex z = new Complex(0+c1, 0+c2);
        int loopCounter = 0;
        Boolean continueLooping = true;
        while (continueLooping) {
            z = z.multiply(z);
            z = z.add(c);
            loopCounter++;
            if (loopCounter == 100 | z.magnitude() > 2) {
                continueLooping = false;
            } // if
        } // while
        //    System.out.println(c + " " + loopCounter + " " + z.magnitude());
        return loopCounter;
    } // check( int, int )

    public Complex mapping(int x, int y, int xMin, int xMax, int yMin, int yMax) {
        //    System.out.println(x + ", " + y);
        double u = (double) uMin + ((double) (uMax - uMin) * ((double) (x - xMin) / (xMax - xMin)));
        double v = (double) vMin + ((double) (vMax - vMin) * ((double) (y - yMin) / (yMax - yMin)));
        return new Complex(u, v);
    }

    public static void main(String[] args) {
        MandelbrotFrame mandelbrotFrame = new MandelbrotFrame();

    } // main()
}
