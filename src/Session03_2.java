import java.util.ArrayList;
import java.util.Scanner;

public class Session03_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soLuong = 0; //biến đếm số lượng học viên nhập vào
        double tongDiem = 0;
        double max = 0;
        double min = 0;

        //sử dụng vùng lặp while để nhập lựa chọn
        while (true) {
            System.out.println("***************MENU NHẬP ĐIỂM***************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int select = sc.nextInt();

            //Nếu lựa chọn là 1:
            if (select == 1) {
                // tiếp tục sử dụng vòng lặp while để nhập điểm đến khi muốn dừng thì nhập -1
                while (true) {
                    System.out.print("Nhập điểm học viên (0-10), -1 để kết thúc: ");
                    double score = sc.nextDouble();
                    //Nếu người dùng nhập -1 thì kết thúc chương trình của lựa chọn 1
                    if (score == -1) {
                        break;
                    }
                    //Nếu nhập sai định dạng điểm thì hiển thị thong báo
                    if (score < 0 || score > 10) {
                        System.out.println("Điểm không hợp lệ. Nhập lại.");
                        continue;
                    }

                    // Xếp loại ngay sau mỗi lần nhập điểm
                    if (score < 5) {
                        System.out.println("Học lực: Yếu");
                    } else if (score < 7) {
                        System.out.println("Học lực: Trung Bình");
                    } else if (score < 8) {
                        System.out.println("Học lực: Khá");
                    } else if (score < 9) {
                        System.out.println("Học lực: Giỏi");
                    } else {
                        System.out.println("Học lực: Xuất sắc");
                    }

                    // Cập nhật thống kê
                    soLuong++;
                    tongDiem += score;

                    if (soLuong == 1) {
                        max = min = score;
                    } else {
                        if (score > max) max = score;
                        if (score < min) min = score;
                    }
                }
                //Nếu lựa chọn là 2:
            } else if (select == 2) {   //Thống kê
                if (soLuong == 0) {
                    System.out.println("Chưa có dữ liệu.");
                } else {   //Hiển thị Thống kê nếu có dữ liệu
                    double trungBinh = tongDiem / soLuong;
                    //In ra kết quả thống kê
                    System.out.println("Số học viên: " + soLuong);
                    System.out.printf("Điểm trung bình: %.2f%n", trungBinh);
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                }

                //nếu lựa chọn là 3 thì kết thúc chương trình
            } else if (select == 3) {
                System.out.println("Kết thúc chương trình.");
                System.exit(0);
            } else {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
            System.out.println(); // tạo dòng trống
        }
    }
}