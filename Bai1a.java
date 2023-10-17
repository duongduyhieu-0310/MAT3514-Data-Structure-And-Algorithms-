// Bài 1 phần a ta sẽ nhập n số nguyên dương sau đó tạo mảng n phần tử và đánh giá tốc độ số lần đổi chỗ và số lần so sánh .
// a) Với dãy số nguyên có kích thước nhỏ được nhập từ bàn phím.
// chú ý vì dãy số nhập tay ta có kích thức nhỏ lên tốc độ chjay gần như bằng 0 ta khó có thể so sánh được tốc độ chạy mỗi thuật toán sắp xếp . 
// ta tập chung vào số lần đổi chỗ và số lần so sánh giữa các phần tử .

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Bai1a {

    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của dãy số: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Nhập các phần tử của dãy số:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("Đánh giá thuật toán sắp xếp với dãy số nguyên có " + size + " phần tử:");

        evaluateSortingAlgorithm("Sắp xếp nổi bọt", array.clone());
        evaluateSortingAlgorithm("Sắp xếp chọn", array.clone());
        evaluateSortingAlgorithm("Sắp xếp chèn", array.clone());
        evaluateSortingAlgorithm("Sắp xếp trộn (Merge Sort)", array.clone());
        evaluateSortingAlgorithm("Sắp xếp nhanh (Quick Sort)", array.clone());
    }

    // Đánh giá hiệu suất của thuật toán sắp xếp và in kết quả ra màn hình
    public static void evaluateSortingAlgorithm(String algorithmName, int[] array) {
        System.out.println("Đánh giá hiệu suất của thuật toán " + algorithmName);

        int[] originalArray = array.clone();

        long startTime = System.nanoTime();

        int[] result;
        if (algorithmName.equals("Sắp xếp nổi bọt")) {
            result = bubbleSort(array);
        } else if (algorithmName.equals("Sắp xếp chọn")) {
            result = selectionSort(array);
        } else if (algorithmName.equals("Sắp xếp chèn")) {
            result = insertionSort(array);
        } else if (algorithmName.equals("Sắp xếp trộn (Merge Sort)")) {
            result = mergeSort(array);
        } else if (algorithmName.equals("Sắp xếp nhanh (Quick Sort)")) {
            result = quickSort(array);
        } else {
            result = new int[]{0, 0}; // Trường hợp không hợp lệ
        }

        long endTime = System.nanoTime();
        long executionTimeNano = endTime - startTime;
        long executionTimeMillis = TimeUnit.NANOSECONDS.toMillis(executionTimeNano);

        int comparisons = result[0];
        int swaps = result[1];

        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
        System.out.println("Thời gian thực thi: " + executionTimeMillis + " ms");
    }

    // Các thuật toán sắp xếp (sử dụng dữ liệu số nguyên)

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            // Nếu không có sự hoán đổi nào trong vòng lặp này, dãy đã sắp xếp
            if (!swapped) {
                break;
            }
        }
        return new int[]{comparisons, swaps};
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Hoán đổi arr[i] và arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            swaps++;
        }
        return new int[]{comparisons, swaps};
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j = j - 1;
                swaps++;
            }
            arr[j + 1] = key;
        }
        return new int[]{comparisons, swaps};
    }

    public static int[] mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static int[] mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            int[] leftResult = mergeSortHelper(arr, left, mid);
            int[] rightResult = mergeSortHelper(arr, mid + 1, right);
            int[] mergeResult = merge(arr, left, mid, right);
            return new int[]{
                    leftResult[0] + rightResult[0] + mergeResult[0],
                    leftResult[1] + rightResult[1] + mergeResult[1]
            };
        } else {
            return new int[]{0, 0};
        }
    }

    private static int[] merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        int comparisons = 0;
        int swaps = 0;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            swaps++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            swaps++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            swaps++;
        }

        return new int[]{comparisons, swaps};
    }

    public static int[] quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1);
    }

    private static int[] quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int[] partitionResult = partition(arr, low, high);
            int pi = partitionResult[0];
            int comparisons = partitionResult[1];
            int swaps = partitionResult[2];
            int[] leftResult = quickSortHelper(arr, low, pi - 1);
            int[] rightResult = quickSortHelper(arr, pi + 1, high);
            return new int[]{
                    leftResult[0] + rightResult[0] + comparisons,
                    leftResult[1] + rightResult[1] + swaps
            };
        } else {
            return new int[]{0, 0};
        }
    }

    private static int[] partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int comparisons = 0;
        int swaps = 0;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
            }
        }
        // Hoán đổi arr[i+1] và arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        swaps++;

        return new int[]{i + 1, comparisons, swaps};
    }
}
