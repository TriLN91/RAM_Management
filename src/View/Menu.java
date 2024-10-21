package View;

import Controller.RAMManagementSystem;
import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    
    

    public static void display(int order, String x){
        if(order == 1){
            System.out.println("");
            System.out.println("=====================================================================");
            System.out.println("------------------------Ram Management System------------------------");
            System.out.println("1. Add an RAM Item.                                                  ");
            System.out.println("2. Search RAM Item.                                                  ");
            System.out.println("3. Update RAM Item Information.                                      ");
            System.out.println("4. Delete RAM Item.                                                  ");
            System.out.println("5. Show All RAM Items.                                               ");
            System.out.println("6. Save to File.                                             ");
            System.out.println("7. Exist.                                                            ");
            System.out.print("Your choice: ");

            
            
        }
        if(order == 2){
            System.out.println("Enter [1] to return Menu.");
            System.out.println("Enter [2] to continue "+ x +". ");
            System.out.print("Your choice: ");

        }
    }

    

    public static void displayMenu(){
    
    RAMManagementSystem ramMS = new RAMManagementSystem();
    
    int choice;
    boolean checkAction = true;
    do { 
        display(1, "");
        choice = sc.nextInt();
        sc.nextLine(); 
        System.out.println("");

        switch (choice) {
            case 1:
                do {
                    ramMS.addRAMItem(); // Thực hiện thêm RAM item
                    display(2, "add another RAM item."); // Hỏi người dùng có muốn tiếp tục không
                    String respond = sc.nextLine().trim();
                    if ("1".equals(respond)) {
                        break; // Trở về menu chính
                    }
                } while (true); // Tiếp tục lặp nếu người dùng chọn tiếp tục thêm item
                break;

            case 2:
                do {
                    ramMS.searchRAMItem(); // Thực hiện tìm kiếm RAM
                    display(2, "search for another RAM item."); // Hỏi người dùng có muốn tiếp tục không
                    String respond = sc.nextLine().trim();
                    if ("1".equals(respond)) {
                        break; // Trở về menu chính
                    }
                } while (true); // Tiếp tục lặp nếu người dùng chọn tiếp tục tìm kiếm
                break;

            case 3:
                do {
                    ramMS.updateRAMItem(); // Thực hiện cập nhật RAM
                    display(2, "update another RAM item."); // Hỏi người dùng có muốn tiếp tục không
                    String respond = sc.nextLine().trim();
                    if ("1".equals(respond)) {
                        break; // Trở về menu chính
                    }
                } while (true); // Tiếp tục lặp nếu người dùng chọn tiếp tục cập nhật
                break;

            case 4:
                do {
                    ramMS.deleteRAMItem(); // Thực hiện xóa RAM
                    display(2, "delete another RAM item."); // Hỏi người dùng có muốn tiếp tục không
                    String respond = sc.nextLine().trim();
                    if ("1".equals(respond)) {
                        break; // Trở về menu chính
                    }
                } while (true); // Tiếp tục lặp nếu người dùng chọn tiếp tục xóa
                break;
            case 5:
                ramMS.showAllItems();
                break;

            case 6:
                ramMS.saveToFile();
                ramMS.loadFromFile();
                break;

            case 7:
                
                checkAction = false;
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }

        
        // if (choice > 7 && choice < 1) {
        //     checkAction = false;
        //     ramMS.saveToFile();
        // }

    } while (checkAction);
    
    // Lưu dữ liệu trước khi thoát chương trình
    ramMS.saveToFile();
    System.out.println("Exiting program. Data saved.");
}
}
