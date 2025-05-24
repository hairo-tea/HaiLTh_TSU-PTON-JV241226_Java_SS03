import java.util.Scanner;

public class Session03_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.println("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        float price = Float.parseFloat(sc.nextLine());
        System.out.println("Số lượng mua: ");
        float quantity = Float.parseFloat(sc.nextLine());
        System.out.println("Khách hàng có thẻ thành viên hay không?(true/false): ");
        boolean isMember = Boolean.parseBoolean(sc.nextLine());

        //thực hiện tính:
        float amount = price * quantity;
        float memberDiscount = isMember ? (0.1F * amount) : 0;
        float vat = 0.08F * amount;
        float totalAmount = amount - memberDiscount + vat;

        //output
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm : " + productName);
        System.out.println("Số lượng: " + quantity);
        System.out.printf("Đơn giá: %,10.2f VND %n", price);
        System.out.printf("Thành tiền: %,10.2f VND %n", amount);
        System.out.printf("Giảm giá thành viên (10%%): %,10.2f VND %n", memberDiscount);
        System.out.printf("Tiền VAT (8%%): %,10.2f VND %n", vat);
        System.out.printf("Tổng thanh toán: %,10.2f VND %n", totalAmount);

        sc.close();
    }
}
