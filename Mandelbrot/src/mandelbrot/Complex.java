package mandelbrot;

/**
 *
 * @author marcus
 */
public class Complex {
    
    public double real;
    public double imaginary;
    
    /**
     * The class models a complex number.
     * 
     * @param real The real part of the complex number.
     * @param imaginary The imaginary part of the complex number.
     */
    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public Complex add(Complex c){
        return new Complex(this.real+c.real, this.imaginary+c.imaginary);
    } // add(Complex)
    
    public Complex subtract(Complex c){
        return new Complex(this.real-c.real, this.imaginary-c.imaginary);
    } // subtract(Complex)
    
    public Complex multiply(Complex that){
        return new Complex(
        this.real*that.real -  this.imaginary*that.imaginary, 
                this.real*that.imaginary + this.imaginary*that.real);
    } // multiply(Complex)
    
    public double magnitude(){
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary);
    } // magnitude()
    
    @Override
    public String toString(){
        if (imaginary == 0){
            return Double.toString(real);
        }
        else{
        return real + " + " + imaginary + "i";
        }
    }
    
    public static void main(String[] args){
        Complex c = new Complex(3,2);
        System.out.println(c);
        System.out.println(c.multiply(new Complex(3,-2)));
        System.out.println(c.magnitude());
    } // main()
}
