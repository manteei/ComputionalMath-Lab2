package simpleEquation;

public class Equation {
    EqCollection eqCollection = new EqCollection();
    int n;
    double a;
    double b;
    public Equation(int n, double[] aprox){
        this.n = n;
        this.a = aprox[0];
        this.b = aprox[1];
    }
    public double methodChord(double eps) {
        double newResult = 0;
        double tmp;
        do{
            tmp = newResult;
            newResult = b - f(b) * (a - b) / (f(a) - f(b));
            a = b;
            b = newResult;
        } while(isEps(newResult, tmp, eps));
        return newResult;
    }

    public double methodTangent(double eps){
        double newResult = b;
        double df;
        double h = 0.00001;
        double tmp;
        df= (f(newResult + h) - f(newResult)) / h;
        do{
            tmp = newResult;
            newResult = newResult - f(newResult) / df;
        } while(isEps(newResult, tmp, eps));
        return newResult;
    }

    private boolean isEps(double current, double previous, double eps){
        return Math.abs(current - previous) > eps;

    }
    public double f (double x){
       return eqCollection.f(x, n);
    }

}
