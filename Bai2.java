import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên n
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();

        // Khai báo mảng để lưu dãy n số nguyên
        int[] arr = new int[n];

        // Nhập dãy n số nguyên
        System.out.println("Nhập dãy " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // In ra các số nguyên tố trong dãy
        System.out.print("Các số nguyên tố trong dãy: ");
        for (int num : arr) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // In ra các số nguyên chia hết cho 8 trong dãy( điều kiện tự đặt)
        System.out.print("Các số nguyên chia hết cho 8 trong dãy: ");
        for (int num : arr) {
            if (num % 8 == 0) {
                System.out.print(num + " ");
            }
        }
    }

    // Hàm kiểm tra một số có phải là số nguyên tố không
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
