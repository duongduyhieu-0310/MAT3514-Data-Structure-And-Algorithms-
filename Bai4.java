import java.lang.Math;

class Sphere {
    private double radius; // Bán kính của hình cầu
    private double x; // Tọa độ x của tâm
    private double y; // Tọa độ y của tâm
    private double z; // Tọa độ z của tâm

    public Sphere(double radius, double x, double y, double z) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Tính diện tích xung quanh hình cầu
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    // Tính thể tích của hình cầu
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Kiểm tra xem hai hình cầu có bao nhau hay không
    public boolean isIntersecting(Sphere other) {
        // Tính khoảng cách giữa hai tâm hình cầu
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) +
                                    Math.pow(this.y - other.y, 2) +
                                    Math.pow(this.z - other.z, 2));
        // Hai hình cầu bao nhau nếu khoảng cách giữa tâm các hình cầu nhỏ hơn tổng bán kính của chúng
        return distance <= (this.radius + other.radius);
    }
}

public class Bai4 {
    public static void main(String[] args) {
        // Tạo hai hình cầu
        Sphere sphere1 = new Sphere(5.0, 0.0, 0.0, 0.0);
        Sphere sphere2 = new Sphere(3.0, 8.0, 0.0, 0.0);

        // Tính diện tích xung quanh và thể tích của hình cầu 1
        double surfaceArea1 = sphere1.getSurfaceArea();
        double volume1 = sphere1.getVolume();

        // Tính diện tích xung quanh và thể tích của hình cầu 2
        double surfaceArea2 = sphere2.getSurfaceArea();
        double volume2 = sphere2.getVolume();

        // Kiểm tra xem hai hình cầu có bao nhau hay không
        boolean isIntersecting = sphere1.isIntersecting(sphere2);

        // In kết quả
        System.out.println("Diện tích xung quanh hình cầu 1: " + surfaceArea1);
        System.out.println("Thể tích của hình cầu 1: " + volume1);
        System.out.println("Diện tích xung quanh hình cầu 2: " + surfaceArea2);
        System.out.println("Thể tích của hình cầu 2: " + volume2);
        System.out.println("Hai hình cầu có bao nhau không? " + isIntersecting);
    }
}
