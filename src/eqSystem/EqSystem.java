package eqSystem;

import java.util.Arrays;

public class EqSystem {
    public static EquationFromSystem eq1;
    public static EquationFromSystem eq2;

    public static void choseSystem(int n) {
        if (n==1) {
             eq1 = new FirstEqFirstSystem();
             eq2 = new SecondEqFirstSystem();
        }else {
             eq1 = new FirstEqSecondSystem();
             eq2 = new SecondEqSecondSystem();
        }
    }


    public static double[][] df(double[] vector) {
        double[][] df = new double[2][2];
        df[0][0] = eq1.getDerivativeX(vector[0], vector[1]);
        df[0][1] = eq1.getDerivativeY(vector[0], vector[1]);
        df[1][0] = eq2.getDerivativeX(vector[0], vector[1]);
        df[1][1] = eq2.getDerivativeY(vector[0], vector[1]);
        return df;
    }

    public static double[] F(double[] vector) {
        double[] f = new double[2];
        f[0] = -eq1.getEquation(vector[0], vector[1]);
        f[1] = -eq2.getEquation(vector[0], vector[1]);
        return f;
    }

    public static  double[] SystemCalculator(double[] results, double eps) {
        double[] lastResults = {results[0] + 2 * eps, results[1] + 2 * eps};
        double[][] jacobian;
        double[] f;
        double[] deltas;
        while (isEps(results[0], lastResults[0], eps) || isEps(results[1], lastResults[1], eps)) {
            lastResults = Arrays.copyOf(results, results.length);
            jacobian = df(lastResults);
            f = F(lastResults);
            deltas = getUnknownColumn(jacobian, f);
            results[0] = results[0] + deltas[0];
            results[1] = results[1] + deltas[1];
        }
        return results;
    }

    public static double[][] methodGausse(double[][] matrix, double[] results) {
        double[][] fullMatrix = createFullMatrix(matrix, results);
        double[][] copyMatrix = copyMatrix(fullMatrix);
        for (int k = 0; k < copyMatrix.length - 1; k++) {
            if (copyMatrix[0][0] == 0) continue;
            for (int i = k + 1; i < copyMatrix.length; i++) {
                if (copyMatrix[i][k] == 0) continue;
                double specialEl = copyMatrix[i][k];
                for (int j = 0; j < copyMatrix.length + 1; j++) {
                    copyMatrix[i][j] -= (double) Math.round(copyMatrix[k][j] * (specialEl / copyMatrix[k][k]) * 1000) / 1000;
                }
            }
        }
        return copyMatrix;
    }

    public static double[] getUnknownColumn(double[][] jacobi, double[] results) {
        double[][] triangle = methodGausse(jacobi, results);
        double[] unknowns = getNullColumn(results.length);
        for (int i = triangle.length - 1; i >= 0; i--) {
            double elementsSum = 0;
            double b = triangle[i][triangle.length];
            if (!isnNullRow(triangle[i]) && triangle[i][i] != 0) {
                for (int j = 0; j < triangle.length; j++) {
                    if (j != i) elementsSum += unknowns[j] * triangle[i][j];
                }
                unknowns[i] = (b - elementsSum) / triangle[i][i];
            }
        }
        return unknowns;

    }

    private static double[][] createFullMatrix(double[][] matrix, double[] result) {
        double[][] fullMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                fullMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            fullMatrix[i][matrix.length] = result[i];
        }
        return fullMatrix;
    }

    private static double[][] copyMatrix(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length + 1; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    private static double[] getNullColumn(int size) {
        double[] column = new double[size];
        Arrays.stream(column)
                .forEach(el -> el = 0);
        return column;
    }

    public static boolean isnNullRow(double[] row) {
        return Arrays.stream(row)
                .allMatch(el -> el == 0);
    }

    public static void printAllSystems(){
        System.out.println("1) x^2 + y^2 = 4");
        System.out.println("   y = 3 * x^2");
        System.out.println("2) x^3 + 4y = 0 ");
        System.out.println("   x^2 + y^2 = 12");
    }
    private static boolean isEps(double current, double previous, double eps){
        return Math.abs(current - previous) > eps;

    }
}