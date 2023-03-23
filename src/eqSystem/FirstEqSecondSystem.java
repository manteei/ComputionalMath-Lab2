package eqSystem;


public class FirstEqSecondSystem implements EquationFromSystem {


    @Override
    public double getEquation(double x, double y) {
        return Math.pow(x, 3) + 4*y;
    }

    @Override
    public double getDerivativeX(double x, double y) {
        return 3*Math.pow(x, 2);
    }

    @Override
    public double getDerivativeY(double x, double y) {
        return 4;
    }

}