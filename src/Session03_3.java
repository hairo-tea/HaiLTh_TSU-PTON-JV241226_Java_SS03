import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Session03_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soLuong = 0; //biến đếm số lượng nhân viên nhập vào
        double tongLuong = 0;
        double maxLuong = 0;
        double minLuong = 0;
        double tongTienThuong = 0;
        //Tạo formatter cho kiểu tiền:
        NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

        //sử dụng vùng lặp while để nhập lựa chọn
        while (true) {
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int select = sc.nextInt();

            //Nếu lựa chọn là 1:
            if (select == 1) {
                // tiếp tục sử dụng vòng lặp while để nhập lương đến khi muốn dừng thì nhập -1
                while (true) {
                    System.out.print("Nhập lương nhân viên (từ 0 đến 500 triệu), -1 để kết thúc: ");
                    double luong = sc.nextDouble();
                    //Nếu người dùng nhập -1 thì kết thúc chương trình của lựa chọn 1
                    if (luong == -1) {
                        break;
                    }
                    //Nếu nhập sai định dạng lương thì hiển thị thong báo
                    if (luong < 0 || luong > 500_000_000) {
                        System.out.println("Lương phải có giá trị từ 0 đến 500 triệu. Nhập lại.");
                        continue;
                    }

                    //  Nhập hợp lệ, phân loại lương nhân viên
                    if (luong < 5_000_000) {
                        System.out.println("Thu nhập thấp");
                    } else if (luong < 15_000_000) {
                        System.out.println("Thu nhập trung bình");
                    } else if (luong < 50_000_000) {
                        System.out.println("Thu nhập khá");
                    } else {
                        System.out.println("Thu nhập cao");
                    }

                    //cập nhật thống kê
                    tongLuong += luong;
                    soLuong++;
                    //Tìm lương thấp nhất và cao nhất
                    if (soLuong == 1) {
                        maxLuong = minLuong = luong;
                    } else {
                        if (luong > maxLuong) maxLuong = luong;
                        if (luong < minLuong) minLuong = luong;
                    }
                    //Tính tổng số tiền thưởng cho nhân viên
                    double thuong = 0;
                    if (luong < 5_000_000) {
                        thuong = luong * 0.05;
                    } else if (luong < 15_000_000) {
                        thuong = luong * 0.1;
                    } else if (luong < 50_000_000) {
                        thuong = luong * 0.15;
                    } else if (luong < 100_000_000) {
                        thuong = luong * 0.2;
                    } else {
                        thuong = luong * 0.25;
                    }
                    tongTienThuong += thuong;
                }
                //Nếu lựa chọn là 2:
            } else if (select == 2) {
                //Thống kê
                if (soLuong == 0) {
                    System.out.println("Chưa có dữ liệu.");
                } else {   //Hiển thị Thống kê nếu có dữ liệu
                    double trungBinh = tongLuong / soLuong; //Tính lương trung bình

                    //In ra kết quả thống kê
                    System.out.println("--- Thống kê ---");
                    System.out.println("Số nhân viên: " + soLuong);
                    System.out.println("Tổng lương: " + currencyFormat.format(tongLuong) + " VND");
                    System.out.println("Lương trung bình: " + currencyFormat.format(trungBinh) + " VND");
                    System.out.println("Lương cao nhất: " + currencyFormat.format(maxLuong) + " VND");
                    System.out.println("Lương thấp nhất: " + currencyFormat.format(minLuong) + " VND");
                }
            } else if (select == 3) { //Hiển thị tổng số tiền thưởng cho nhân viên
                if (soLuong == 0) {
                    System.out.println("Chưa có dữ liệu.");
                } else {
                    System.out.printf("Tổng tiền thưởng:" + currencyFormat.format(tongTienThuong) + " VND");
                }
            } else if (select == 4) { //nếu lựa chọn là 4 thì kết thúc chương trình
                System.out.println("Kết thúc chương trình.");
                System.exit(0);
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
            System.out.println(); // tạo dòng trống
        }
    }
}
