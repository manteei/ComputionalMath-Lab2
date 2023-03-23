package eqSystem;


public class FirstEqFirstSystem implements EquationFromSystem {


    @Override
    public double getEquation(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y, 2) - 4;
    }

    @Override
    public double getDerivativeX(double x, double y) {
        return 2 * x;
    }

    @Override
    public double getDerivativeY(double x, double y) {
        return 2 * y;
    }

}