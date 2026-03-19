public class ArmstrongNumber {

    public boolean isArmstrong(int n) {
        int original = n;
        int digits = 0;
        int temp = n;

        while (temp > 0) {
            temp /= 10;
            digits++;
        }

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }
}
