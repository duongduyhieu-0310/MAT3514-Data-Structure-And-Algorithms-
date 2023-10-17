//Bài tập 2. Từ bài tập 1 nhưng với dữ liệu tổng quát để có thể sắp xếp mọi dãy đối tượng T có giao diện Comparable<T>.

import java.util.*;

public class Bai2<T extends Comparable<T>> {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};

        for (int size : sizes) {
            System.out.println("Đánh giá thuật toán sắp xếp với dãy số nguyên có " + size + " phần tử:");

            // Sinh dãy số ngẫu nhiên
            Integer[] randomArray = generateRandomArray(size);

            // Đánh giá hiệu suất các thuật toán và lấy kết quả
            PerformanceResult bubbleSortResult = evaluateSortingAlgorithm("Sắp xếp nổi bọt", randomArray.clone());
            PerformanceResult selectionSortResult = evaluateSortingAlgorithm("Sắp xếp chọn", randomArray.clone());
            PerformanceResult insertionSortResult = evaluateSortingAlgorithm("Sắp xếp chèn", randomArray.clone());
            PerformanceResult mergeSortResult = evaluateSortingAlgorithm("Sắp xếp trộn (Merge Sort)", randomArray.clone());
            PerformanceResult quickSortResult = evaluateSortingAlgorithm("Sắp xếp nhanh (Quick Sort)", randomArray.clone());

            // In kết quả
            System.out.println("Sắp xếp nổi bọt:");
            printPerformanceResult(bubbleSortResult);

            System.out.println("Sắp xếp chọn:");
            printPerformanceResult(selectionSortResult);

            System.out.println("Sắp xếp chèn:");
            printPerformanceResult(insertionSortResult);

            System.out.println("Sắp xếp trộn (Merge Sort):");
            printPerformanceResult(mergeSortResult);

            System.out.println("Sắp xếp nhanh (Quick Sort):");
            printPerformanceResult(quickSortResult);

            System.out.println();
        }
    }

    // Sinh dãy số ngẫu nhiên trong khoảng [1, 10^6]
    public static Integer[] generateRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000) + 1;
        }
        return array;
    }

    // Đánh giá hiệu suất của thuật toán sắp xếp và trả về kết quả
    public static PerformanceResult evaluateSortingAlgorithm(String algorithmName, Integer[] array) {
        Integer[] originalArray = array.clone();

        int comparisons = 0;
        int swaps = 0;

        long startTime = System.nanoTime();

        if (algorithmName.equals("Sắp xếp nổi bọt")) {
            bubbleSort(array, comparisons, swaps);
        } else if (algorithmName.equals("Sắp xếp chọn")) {
            selectionSort(array, comparisons, swaps);
        } else if (algorithmName.equals("Sắp xếp chèn")) {
            insertionSort(array, comparisons, swaps);
        } else if (algorithmName.equals("Sắp xếp trộn (Merge Sort)")) {
            mergeSort(array, comparisons, swaps);
        } else if (algorithmName.equals("Sắp xếp nhanh (Quick Sort)")) {
            quickSort(array, comparisons, swaps);
        }

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        return new PerformanceResult(comparisons, swaps, executionTime);
    }

    // Các thuật toán sắp xếp (sử dụng dữ liệu tổng quát)
    public static <T extends Comparable<T>> void bubbleSort(T[] arr, int comparisons, int swaps) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Hoán đổi arr[j] và arr[j+1]
                    T temp = arr[j];
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
    }
    
    public static <T extends Comparable<T>> void selectionSort(T[] arr, int comparisons, int swaps) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                swaps++;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr, int comparisons, int swaps) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                comparisons++;
                arr[j + 1] = arr[j];
                j = j - 1;
                swaps++;
            }
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int comparisons, int swaps) {
        int n = arr.length;
        if (n > 1) {
            int mid = n / 2;
            T[] leftArray = Arrays.copyOfRange(arr, 0, mid);
            T[] rightArray = Arrays.copyOfRange(arr, mid, n);
            mergeSort(leftArray, comparisons, swaps);
            mergeSort(rightArray, comparisons, swaps);

            int i = 0, j = 0, k = 0;
            while (i < leftArray.length && j < rightArray.length) {
                comparisons++;
                if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                    arr[k++] = leftArray[i++];
                } else {
                    arr[k++] = rightArray[j++];
                }
                swaps++;
            }

            while (i < leftArray.length) {
                arr[k++] = leftArray[i++];
            }

            while (j < rightArray.length) {
                arr[k++] = rightArray[j++];
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int comparisons, int swaps) {
        quickSortHelper(arr, 0, arr.length - 1, comparisons, swaps);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] arr, int low, int high, int comparisons, int swaps) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, comparisons, swaps);
            quickSortHelper(arr, low, partitionIndex - 1, comparisons, swaps);
            quickSortHelper(arr, partitionIndex + 1, high, comparisons, swaps);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high, int comparisons, int swaps) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        swaps++;
        return i + 1;
    }

    // Lớp để lưu trữ kết quả hiệu suất
    public static class PerformanceResult {
        public int comparisons;
        public int swaps;
        public long executionTime;

        public PerformanceResult(int comparisons, int swaps, long executionTime) {
            this.comparisons = comparisons;
            this.swaps = swaps;
            this.executionTime = executionTime;
        }
    }

    // Phương thức in kết quả hiệu suất
    public static void printPerformanceResult(PerformanceResult result) {
        System.out.println("Số lần so sánh: " + result.comparisons);
        System.out.println("Số lần đổi chỗ: " + result.swaps);
        System.out.println("Thời gian thực thi (nanoseconds): " + result.executionTime);
    }
}
