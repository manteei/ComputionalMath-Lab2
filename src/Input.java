import java.util.Scanner;

public class Input {
    public boolean chooseType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("������� ����");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("��� ������ ������� ��������������� �����:\n� ������� ����������� ��������� (1)\n� ������� ������� ���������� ��������� (2)");
        String str = scanner.nextLine();
        System.out.println("------------------------------------------------------------------------------");

        while(!str.trim().equalsIgnoreCase("1")) {
            if (str.trim().equalsIgnoreCase("2")) {
                System.out.println("�� ������� ������� ������� ���������� ���������");
                return true;
            }

            System.out.println("������! ������� 1 ��� 2 � ����������� �� ����, ��� ������ ������.");
            str = scanner.nextLine();
        }

        System.out.println("�� ������� ������� ����������� ��������� ");
        return false;
    }

    public int getNumber(boolean flag){
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        if (flag){
            System.out.println("������� ����� ������� ���������� ���������");
        }else {
            System.out.println("������� ����� ����������� ���������");
        }

        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 6 && num > 0) {
                    return num;
                }
                System.out.println("������! ����� ������ ���������� ������ �� 0 � �� 5");
            } catch (NumberFormatException var8) {
                System.out.println("������! ����� ������ ���������� ������");
            }
        }

    }

    public double getEpsilon() {
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �������� �����������");
        double eps;
        String s;
        while (true) {
            s = scanner.nextLine();
            try {
                eps = Double.parseDouble(s);
                if (eps > 0.0D && eps <= 1.0D) {
                    break;
                }
                System.out.println("������! �������� ������ ���������� ������ ������ 0 � ������ 1");
            } catch (NumberFormatException e) {
                System.out.println("������! �������� ������ ���������� ������");
            }
        }
        return eps;
    }



    public static double[] getApproximation() {
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        double[] results = new double[2];
        System.out.println("�������� ������ �����������:");
        System.out.println("����� �������:");

        while (true) {
            String s = scanner.nextLine();
            try {
                results[0] = Double.parseDouble(s);
                break;
            }catch (NumberFormatException e) {
                System.out.println("������!������� ������ ���������� ������");
            }
        }
        System.out.println("������ �������:");
        while (true) {
            String s = scanner.nextLine();
            try {
                results[1] = Double.parseDouble(s);
                break;
            }catch (NumberFormatException e) {
                System.out.println("������!������� ������ ���������� ������");
            }
        }
        return results;
    }
}
