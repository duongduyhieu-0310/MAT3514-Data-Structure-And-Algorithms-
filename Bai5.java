// cho số nguyên dương n thu được một dãy A1,A2,..,An phần tử
// Sắp xếp dãy trên theo chiều tăng dần và giảm dần 

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên n từ người dùng
        System.out.print("Nhập số nguyên n: ");
        int n = scanner.nextInt();

        // Tạo mảng với n phần tử
        int[] arr = new int[n];

        // Nhập các phần tử của mảng từ người dùng
        System.out.println("Nhập " + n + " số nguyên:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sắp xếp mảng theo thứ tự tăng dần bằng thuật toán sắp xếp nổi bọt
        bubbleSortAscending(arr);

        // Tạo mảng giảm dần bằng cách đảo ngược mảng đã sắp xếp
        int[] arrDescending = new int[n];
        for (int i = 0; i < n; i++) {
            arrDescending[i] = arr[n - 1 - i];
        }

        // In mảng đã sắp xếp theo thứ tự tăng dần
        System.out.println("Mảng đã sắp xếp tăng dần: ");
        printArray(arr);

        // In mảng đã sắp xếp theo thứ tự giảm dần
        System.out.println("Mảng đã sắp xếp giảm dần: ");
        printArray(arrDescending);

        scanner.close();
    }

    // Hàm sắp xếp nổi bọt theo thứ tự tăng dần
    public static void bubbleSortAscending(int[] arr) {
        int n = arr.length;
        // sử dụng thêm hàm boolean để tối ưu bài code 
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có sự hoán đổi nào trong vòng lặp này, mảng đã sắp xếp
            if (!swapped) {
                break;
            }
        }
    }

    // Hàm in một mảng
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
