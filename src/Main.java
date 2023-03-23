import eqSystem.EqSystem;
import simpleEquation.EqCollection;
import simpleEquation.Equation;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        boolean isSystem = input.chooseType();
        if (isSystem){
            System.out.println("");
        }else {
            EqCollection.printEqCollection();
        }
        int num = input.getNumber(isSystem);
        double[] aprox = input.getApproximation();
        double eps = input.getEpsilon();
        Equation equation = new Equation(num,aprox);
        if (isSystem) {
            aprox = new double[]{1, 2};
            output.printEqSystemResult(EqSystem.newtoneMethodSystemRunner(aprox));
        }else {
            output.printEquationResult(equation.methodChord( eps), equation.methodTangent(eps));
        }
    }
}
