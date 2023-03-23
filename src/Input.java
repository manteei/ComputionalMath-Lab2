import java.util.Scanner;

public class Input {
    public boolean chooseType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Решение СНАУ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Для выбора введите соответствующую цифру:\n• Решение нелинейного уравнения (1)\n• Решение системы нелинейных уравнений (2)");
        String str = scanner.nextLine();
        System.out.println("------------------------------------------------------------------------------");

        while(!str.trim().equalsIgnoreCase("1")) {
            if (str.trim().equalsIgnoreCase("2")) {
                System.out.println("Вы выбрали решение системы нелинейных уравнений");
                return true;
            }

            System.out.println("Ошибка! введите 1 или 2 в зависимости от кого, что хотите решить.");
            str = scanner.nextLine();
        }

        System.out.println("Вы выбрали решение нелинейного уравнения ");
        return false;
    }

    public int getNumber(boolean flag){
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        if (flag){
            System.out.println("Введите номер системы нелинейных уравнений");
        }else {
            System.out.println("Введите номер нелинейного уравнения");
        }

        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 6 && num > 0) {
                    return num;
                }
                System.out.println("Ошибка! Номер должен задаваться числом от 0 и до 5");
            } catch (NumberFormatException var8) {
                System.out.println("Ошибка! Номер должен задаваться числом");
            }
        }

    }

    public double getEpsilon() {
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите точность приближения");
        double eps;
        String s;
        while (true) {
            s = scanner.nextLine();
            try {
                eps = Double.parseDouble(s);
                if (eps > 0.0D && eps <= 1.0D) {
                    break;
                }
                System.out.println("Ошибка! Точность должна задаваться числом больше 0 и меньше 1");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Точность должна задаваться числом");
            }
        }
        return eps;
    }



    public static double[] getApproximation() {
        System.out.println("------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        double[] results = new double[2];
        System.out.println("Выберите первое приближение:");
        System.out.println("Левая граница:");

        while (true) {
            String s = scanner.nextLine();
            try {
                results[0] = Double.parseDouble(s);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Ошибка!Граница должна задаваться числом");
            }
        }
        System.out.println("Правая граница:");
        while (true) {
            String s = scanner.nextLine();
            try {
                results[1] = Double.parseDouble(s);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Ошибка!Граница должна задаваться числом");
            }
        }
        return results;
    }
}
