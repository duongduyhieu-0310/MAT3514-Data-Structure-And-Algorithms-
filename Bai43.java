// cho số nguyên dương n thu được dãy A1,A2,...,An
// sắp xếp dãy trên theo chiều tăng dần 
// Dùng thuật toán sắp xếp chọn  

import java.util.Scanner;

public class Bai43 {

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

        // Sử dụng thuật toán sắp xếp lựa chọn để sắp xếp dãy số
        selectionSort(a);

        // In ra màn hình dãy số đã sắp xếp
        System.out.println("Dãy số đã sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }

    // Thuật toán sắp xếp lựa chọn
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Hoán đổi phần tử tại minIndex và i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
