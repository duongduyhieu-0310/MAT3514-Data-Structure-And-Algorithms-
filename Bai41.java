// cho số nguyên dương n thu được dãy A1,A2,...,An
// sắp xếp dãy trên theo chiều tăng dần 
// Dùng thuật toán sắp xếp nổi bọt 

import java.util.Scanner;

public class Bai41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số dương n từ bàn phím
        System.out.print("Nhập số dương n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n phải là số dương.");
            return;
        }

        // Khai báo và khởi tạo mảng a có kích thước n
        int[] a = new int[n];

        // Nhập dãy số nguyên a từ bàn phím
        System.out.println("Nhập dãy số nguyên a:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Sử dụng thuật toán sắp xếp nổi bọt để sắp xếp dãy số
        bubbleSort(a);

        // In ra màn hình dãy số đã sắp xếp
        System.out.println("Dãy số đã sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }

    // Thuật toán sắp xếp nổi bọt
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Hoán đổi arr[i] và arr[i+1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
