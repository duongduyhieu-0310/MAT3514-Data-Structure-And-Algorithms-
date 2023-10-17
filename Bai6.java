// cho số nguyên dương n  thu được dãy A1,A2,...,An và một số nguyên dương k với điều kiện k<=n 
// sắp xếp dãy trên theo chiều tăng dần 
// in ra số nhỏ thứ k trong dãy 

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số nguyên dương");
            return;
        }

        // Nhập vào số nguyên dương k với điều kiện k <= n
        System.out.print("Nhập số nguyên dương k (k <= n): ");
        int k = scanner.nextInt();

        if (k >= n) {
            System.out.println("k phải là số nguyên dương nhỏ hơn n");
            return;
        }

        // Khai báo và khởi tạo mảng arr có kích thước n
        int[] arr = new int[n];

        // Nhập dãy số nguyên a từ bàn phím
        System.out.println("Nhập dãy số nguyên " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sử dụng thuật toán sắp xếp chèn
        insertionSort(arr);

        // In ra mảng sau khi đã sắp xếp
        System.out.println("Mảng sau khi đã sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // In ra số nhỏ thứ k trong dãy
        if (k > 0 && k <= n) {
            System.out.println("\nSố nhỏ thứ " + k + " trong dãy: " + arr[k - 1]);
        } else {
            System.out.println("\nKhông có số nhỏ thứ " + k + " trong dãy.");
        }

        scanner.close();
    }

    // Thuật toán insertionSort.
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử lớn hơn key về phía sau
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
