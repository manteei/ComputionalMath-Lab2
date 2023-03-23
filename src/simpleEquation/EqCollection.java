package simpleEquation;

public class EqCollection {
    public double f1(double x) {
        return  Math.pow(x, 3) - 20 * x - 2;
    }
    public double f2(double x) {
        return  Math.pow(x, 4) - 2 * x - 13450;
    }
    public double f3(double x) {
        return  Math.pow(x, 5) + Math.pow(x, 3) + 12 * x - 1000;
    }

    public static void printF1(){
        System.out.println("1) x^3 - 20x = 2");
    }
    public static void printF2(){
        System.out.println("2) x^4 - 2x = 13450");
    }
    public static void printF3(){
        System.out.println("3) x^5 + x^3 + 12x = 1000");
    }
    public double f(double x, int n){
        if (n == 1){
            return f1(x);
        }else if (n==2) {
            return f2(x);
        }else {
            return f3(x);
        }
    }
    public static void printEqCollection(){
        System.out.println("------------------------------------------------------------------------------");
        printF1();
        printF2();
        printF3();
    }

}
