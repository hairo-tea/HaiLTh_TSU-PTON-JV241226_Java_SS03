import java.util.ArrayList;
import java.util.Scanner;

public class Session03_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntStudents = 0; // khai báo biến đếm sinh viên
        int totalScore = 0; //khai báo biến tính tổng điểm
        float minScore = Float.MAX_VALUE;
        float maxScore = Float.MIN_VALUE;
        do {
            //In menu
            System.out.println("***************MENU NHẬP ĐIỂM***************");
            System.out.println("1.  Nhập điểm học viên");
            System.out.println("2.  Hiển thị thống kê");
            System.out.println("3.  Thoát");
            System.out.print(" Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: //Nhập điểm học viên:
                    do {
                        System.out.print("Nhập điểm: ");
                        float score = Float.parseFloat(sc.nextLine());
                        if (score == -1) {
                            break;
                        } else if (score < 0 || score > 10) {
                            System.err.println("Điểm không hợp lệ. Nhập lại.");
                        } else {
                            cntStudents++;
                            totalScore += score;
                            //Tìm điểm cao nhất và thấp nhất
                            if (score < minScore) {
                                minScore = score;
                            }
                            if (score > maxScore) {
                                maxScore = score;
                            }
                            // xếp loại học lực
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

                        }
                    } while (true);
                    break;
                case 2: // Hiển thị thống kê
                    if (cntStudents == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("Số học viên đã nhập: " + cntStudents);
                        System.out.println("Điểm trung bình: " + totalScore / cntStudents);
                        System.out.println("Điểm cao nhất: " + maxScore);
                        System.out.println("Điểm thấp nhất : " + minScore);
                    }
                    break;
                case 3:
                    System.exit(0);
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.err.println("Có lỗi xảy ra. Vui lòng nhập 1-3! ");
            }
        } while (true);
    }
}