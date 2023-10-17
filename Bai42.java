// cho số nguyên dương n thu được dãy A1,A2,...,An
// sắp xếp dãy trên theo chiều tăng dần 
// Dùng thuật toán sắp xếp chèn  

import java.util.Scanner;

public class Bai42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n từ bàn phím
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số nguyên dương.");
            return;
        }

        // Khai báo và khởi tạo mảng a có kích thước n
        int[] a = new int[n];

        // Nhập dãy số nguyên a từ bàn phím
        System.out.println("Nhập dãy số nguyên a:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Sử dụng thuật toán sắp xếp chèn để sắp xếp dãy số
        insertionSort(a);

        // In ra màn hình dãy số đã sắp xếp
        System.out.println("Dãy số đã sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }

    // Thuật toán sắp xếp chèn
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
