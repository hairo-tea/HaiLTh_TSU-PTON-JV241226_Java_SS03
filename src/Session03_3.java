import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Session03_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countStaff = 0; //khởi tạo biến đếm số  nhân viên nhập vào
        float totalSalary = 0; // Khởi tạo biến đếm tổng lương
        float maxSalary = Float.MIN_VALUE;
        float minSalary = Float.MAX_VALUE;
        float bonus = 0; // biến đếm thưởng
        float totalBonus = 0; //biến lưu tổng thưởng

        do {
            //in menu để người dùng nhập lựa chọn
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1.Nhập lương nhân viên");
            System.out.println("2.CHiển thị thống kê");
            System.out.println("3.Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: //Nhập lương nhân viên
                    do {
                        System.out.print("Nhập lương: ");
                        float salary = Float.parseFloat(sc.nextLine());
                        if (salary == -1) {
                            System.out.println("Kết thúc quá trình nhập");
                            break;
                        } else if (salary < 0 || salary > 500_000_000) {
                            System.err.println("Lương không hợp lệ. Vui lòng nhập lại!");
                        } else {
                            //lưu lương
                            countStaff++;
                            totalSalary += salary;
                            totalBonus += bonus;

                            //tính thưởng
                            if (salary < 5_000_000) {
                                bonus = salary * 0.05F;
                            } else if (salary < 15_000_000) {
                                bonus = salary * 0.1F;
                            } else if (salary < 50_000_000) {
                                bonus = salary * 0.15F;
                            } else if (salary < 100_000_000) {
                                bonus = salary * 0.2F;
                            } else {
                                bonus = salary * 0.25F;
                            }

                            //Tìm lương cao nhất và lương thấp nhất
                            if (salary > maxSalary) {
                                maxSalary = salary;
                            }
                            if (salary < minSalary) {
                                minSalary = salary;
                            }

                            //Xếp loại
                            if (salary < 5_000_000) {
                                System.out.println("Thu nhập thấp");
                            } else if (salary < 15_000_000) {
                                System.out.println("Thu nhập trung bình ");
                            } else if (salary < 50_000_000) {
                                System.out.println("Thu nhập khá ");
                            } else {
                                System.out.println("Thu nhập cao ");
                            }
                        }
                    } while (true);
                    break;
                case 2: //Hiển thị thống kê
                    if (countStaff == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("----Thống kê----");
                        System.out.println("Số nhân viên: " + countStaff);
                        System.out.printf("Tổng lương: %,5.0f VND%n ", totalSalary);
                        System.out.printf("Lương trung bình: %,5.0f VND%n ", totalSalary / countStaff);
                        System.out.printf("Lương cao nhất: %,10.0f VND%n ", maxSalary);
                        System.out.printf("Lương thấp nhất: %,10.0f VND%n ", minSalary);
                    }
                    break;
                case 3: //Tính tổng tiền thưởng cho nhân viên
                    System.out.println("---Tính tổng số tiền thưởng cho nhân viên---");
                    System.out.printf("Tổng tiền thưởng nhân viên: %,5.0f VND%n", totalBonus);
                    break;
                case 4: //Thoát chương trình
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-4 !");
            }
        } while (true);
    }
}
