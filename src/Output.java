public class Output {
    public void printEquationResult(double chordResult, double tangentResult){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("��������� ������� ��������� ������� ����: " + chordResult);
        System.out.println("��������� ������� ��������� ������� �����������: " + tangentResult);
        System.out.println("������� ����� ��������: ");
        double value =  Math.abs(chordResult-tangentResult);
        System.out.format("%.15f",value);
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------");
    }
    public void printEqSystemResult(double[] result){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("��������� ������� ������� ��������� ������� �������: ");
        System.out.println("X = " + result[0]);
        System.out.println("Y = " + result[1]);
        System.out.println("------------------------------------------------------------------------------");
    }

}
