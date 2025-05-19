import java.util.Scanner;

public class Session03_1 {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);

        System.out.println("Tên khách hàng: ");
        String name = sc.nextLine();

        System.out.println("Tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.println("Giá sản phẩm: ");
        double price = sc.nextInt();

        System.out.println("Số lượng mua: ");
        double quantity = sc.nextInt();

        // Tính toán
        double thanhtien = price * quantity;
        double giamgia = 0;

        //Nếu là thành viên giảm 10%
        System.out.println("Khách có thẻ thành viên hay không [ t (true)/ f (false)]: ");
        String member = sc.next();
        if (member.equals("t")) {
            giamgia = 0.1 * thanhtien;
        }
        double tiensaugiamgia = thanhtien - giamgia;
        double VAT = 0.08 * thanhtien;
        double tongtienthanhtoan = tiensaugiamgia + VAT;

        //output
        System.out.printf("Khách hàng: %s%n " +
                        "Sản phẩm:%s%n " +
                        "Giá: %.0f%n " +
                        "Số lượng:%f%n " +
                        "Thành tiền:%.0f%n " +
                        "Giảm giá:%.0f%n " +
                        "Tiền VAT:%.0f%n " +
                        "Tổng thanh toán:%.0f%n ",
                name, product, price, quantity, thanhtien, giamgia, VAT, tongtienthanhtoan);
        sc.close();
    }
}
