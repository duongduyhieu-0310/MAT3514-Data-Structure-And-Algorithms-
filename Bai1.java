import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập và in ra kiểu dữ liệu int
        System.out.print("Nhập một số nguyên (int): ");
        int intValue = scanner.nextInt();
        System.out.println("Giá trị kiểu int bạn vừa nhập: " + intValue);

        // Nhập và in ra kiểu dữ liệu double
        System.out.print("Nhập một số thực (double): ");
        double doubleValue = scanner.nextDouble();
        System.out.println("Giá trị kiểu double bạn vừa nhập: " + doubleValue);

        // Nhập và in ra kiểu dữ liệu char
        System.out.print("Nhập một ký tự (char): ");
        char charValue = scanner.next().charAt(0);
        System.out.println("Giá trị kiểu char bạn vừa nhập: " + charValue);

        // Nhập và in ra kiểu dữ liệu boolean
        System.out.print("Nhập một giá trị boolean (true hoặc false): ");
        boolean booleanValue = scanner.nextBoolean();
        System.out.println("Giá trị kiểu boolean bạn vừa nhập: " + booleanValue);

        // Nhập và in ra kiểu dữ liệu String
        System.out.print("Nhập một chuỗi (String): ");
        String stringValue = scanner.next();
        System.out.println("Giá trị kiểu String bạn vừa nhập: " + stringValue);

        scanner.close();
    }
}
    

