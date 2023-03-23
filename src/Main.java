import eqSystem.EqSystem;
import simpleEquation.EqCollection;
import simpleEquation.Equation;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        boolean isSystem = input.chooseType();
        if (isSystem){
            EqSystem.printAllSystems();
        }else {
            EqCollection.printEqCollection();
        }
        int num = input.getNumber(isSystem);
        double[] aprox = input.getApproximation();
        double eps = input.getEpsilon();
        if (isSystem) {
            EqSystem.choseSystem(num);
            output.printEqSystemResult(EqSystem.SystemCalculator(aprox, eps));
        }else {
            Equation equation = new Equation(num,aprox);
            output.printEquationResult(equation.methodChord( eps), equation.methodTangent(eps));
        }
    }
}
