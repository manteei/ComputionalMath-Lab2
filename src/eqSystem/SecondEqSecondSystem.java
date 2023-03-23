package eqSystem;


public class SecondEqSecondSystem implements EquationFromSystem {

    @Override
    public double getEquation(double x, double y) {
        return y - 3 * Math.pow(x, 2);
    }

    @Override
    public double getDerivativeX(double x, double y) {
        return 2*x;
    }

    @Override
    public double getDerivativeY(double x, double y) {
        return 2*y;
    }

}