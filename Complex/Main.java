package com.company;

public class Main {
    public static void main(String[] args) {
        Complex z1 = new Complex(1, 2);
        Complex z2 = new Complex(2, -3);
        System.out.println(z1);
        System.out.println(z2);
        Complex z3 = z1.add(z2);
        System.out.println("z1 + z2 = " + z3);
        Complex z4 = z1.subtract(z2);
        System.out.println("z1 - z2 = " + z4);
        Complex z5 = z1.multiply(z2);
        System.out.println("z1 * z2 = " + z5);
        Complex z6 = z1.divide(z2);
        System.out.println("z1 / z2 = " + z6);
        Complex z7 = z1.divide(new Complex(0, 0));
        System.out.println(z7);
        Complex z8 = z1.conjugate();
        System.out.println("conjugate z1 = " + z8);
        Complex z9 = z1.neg();
        System.out.println("z1.neg() = " + z9);
        Complex z10 = z1.pow(2);
        System.out.println("z1.pow(2) = " + z10);
        Complex z11 = z1.sqrt();
        System.out.println("z1.sqrt() = " + z11);


    }

    public static double abs(double d) {
        return Math.abs(d);
    }

    public static boolean equals(Complex z1, Complex z2) {
        return z1.getReal() == z2.getReal() && z1.getImag() == z2.getImag();
    }
}

class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public boolean checkReal() {
        return this.real != 0;
    }

    public boolean checkImag() {
        return this.imag != 0;
    }

    public Complex copy() {
        return new Complex(this.real, this.imag);
    }

    public Complex add(Complex z) {
        return new Complex(this.real + z.getReal(), this.imag + z.getImag());
    }

    public Complex subtract(Complex z) {
        return new Complex(this.real - z.getReal(), this.imag - z.getImag());
    }

    public Complex multiply(Complex z) {
        double newReal = (this.real * z.getReal()) - (this.imag * z.getImag());
        double newImag = (this.imag * z.getReal()) + (this.real * z.getImag());
        return new Complex(newReal, newImag);
    }

    public Complex divide(Complex z) {
        double newReal = (this.real * z.getReal() + this.imag * z.getImag()) / (z.getReal() * z.getReal() + z.getImag() * z.getImag());
        double newImag = (this.imag * z.getReal() - this.real * z.getImag()) / (z.getReal() * z.getReal() + z.getImag() * z.getImag());
        if (Double.isNaN(newReal) || Double.isNaN(newImag)) {
            System.out.println("divide bu zero:/ no changes");
            return copy();
        }
        return new Complex(newReal, newImag);
    }

    public Complex conjugate() {
        return new Complex(this.real, -this.imag);
    }

    public Complex neg() {
        return new Complex(-this.real, -this.imag);
    }

    public Complex pow(double n) {
        double newReal = Math.pow(this.real, n);
        double newImag = Math.pow(this.imag, n);
        return new Complex(newReal, newImag);
    }

    public Complex sqrt() {
        double newReal = Math.sqrt(this.real);
        double newImag = Math.sqrt(this.imag);
        return new Complex(newReal, newImag);
    }

    @Override
    public String toString() {
        if (this.imag == 0) {
            return "" + (int) this.real;
        } else if (this.real == 0) {
            return "" + (int) this.imag + "i";
        } else {
            return this.imag >= 0 ? "" + this.real + " + " + this.imag + "i" : "" + this.real + " " + this.imag + "i";
        }
    }
}