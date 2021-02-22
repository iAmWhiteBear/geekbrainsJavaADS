package HW5;

public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2, -3)); //0.125
        System.out.println(pow(3,5)); //243
    }

    private static double pow(double base, double pow) {
        if (isNegativePow(pow)) return 1 / calculate(base, -pow);
        return calculate(base, pow);

    }

    private static boolean isNegativePow(double pow) {
        return pow < 0;
    }

    private static double calculate(double base, double pow) {
        if (base == 1 || pow == 1) return base;
        if (pow == 0) return 1;
        return base * calculate(base, pow - 1);
    }
}
