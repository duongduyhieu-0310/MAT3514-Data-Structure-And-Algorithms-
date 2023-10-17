import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Định nghĩa lớp ComplexNumber để biểu diễn số phức và thực hiện các phép toán liên quan
class ComplexNumber {
    private double real;
    private double imaginary;

    // Constructor để khởi tạo số phức
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Phương thức để in số phức
    public void print() {
        System.out.println(real + " + " + imaginary + "i");
    }

    // Phương thức để thực hiện phép cộng hai số phức
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Phương thức để thực hiện phép nhân hai số phức
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Phương thức static để cộng nhiều số phức lại với nhau
    public static ComplexNumber addMultiple(List<ComplexNumber> complexNumbers) {
        ComplexNumber result = new ComplexNumber(0, 0);
        for (ComplexNumber num : complexNumbers) {
            result = result.add(num);
        }
        return result;
    }

    // Phương thức static để nhân nhiều số phức lại với nhau
    public static ComplexNumber multiplyMultiple(List<ComplexNumber> complexNumbers) {
        ComplexNumber result = new ComplexNumber(1, 0);
        for (ComplexNumber num : complexNumbers) {
            result = result.multiply(num);
        }
        return result;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập và in số phức thứ nhất
        System.out.println("Nhập số phức thứ nhất:");
        System.out.print("Phần thực: ");
        double real1 = scanner.nextDouble();
        System.out.print("Phần ảo: ");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber complex1 = new ComplexNumber(real1, imaginary1);
        System.out.print("Số phức thứ nhất: ");
        complex1.print();

        // Nhập và in số phức thứ hai
        System.out.println("\nNhập số phức thứ hai:");
        System.out.print("Phần thực: ");
        double real2 = scanner.nextDouble();
        System.out.print("Phần ảo: ");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber complex2 = new ComplexNumber(real2, imaginary2);
        System.out.print("Số phức thứ hai: ");
        complex2.print();

        // Cộng và nhân hai số phức
        ComplexNumber sum = complex1.add(complex2);
        ComplexNumber product = complex1.multiply(complex2);

        System.out.println("\nTổng của hai số phức: ");
        sum.print();
        System.out.println("Tích của hai số phức: ");
        product.print();

        // Nhập và in nhiều số phức
        System.out.print("\nNhập số lượng số phức muốn tính tổng và tích: ");
        int n = scanner.nextInt();
        List<ComplexNumber> complexNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập số phức thứ " + (i + 1) + ":");
            System.out.print("Phần thực: ");
            double real = scanner.nextDouble();
            System.out.print("Phần ảo: ");
            double imaginary = scanner.nextDouble();
            ComplexNumber complexNumber = new ComplexNumber(real, imaginary);
            complexNumbers.add(complexNumber);
        }

        // Tính tổng và tích của nhiều số phức
        ComplexNumber sumMultiple = ComplexNumber.addMultiple(complexNumbers);
        ComplexNumber productMultiple = ComplexNumber.multiplyMultiple(complexNumbers);

        System.out.println("\nTổng của các số phức nhập vào: ");
        sumMultiple.print();
        System.out.println("Tích của các số phức nhập vào: ");
        productMultiple.print();
    }
}
