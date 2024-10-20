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
            System.out.println("6. Store Data to Files .                                             ");
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
        String tail,temp;
        boolean checkAction = true;
        do { 
            display(1, "");
            choice = sc.nextInt();
            tail = sc.nextLine().trim();
            
            switch (choice) {
                case 1:{
                    boolean checkRespond = true;
                    do { 
                        ramMS.addRAMItem();
                        display(2, "add Item other");
                        String respond = sc.nextLine().trim();
                        if ("2".equalsIgnoreCase(respond)) {
                            continue;
                        }
                        checkRespond = false;
                        
                    } while (checkRespond);
                    displayMenu();
                    

                }
                    break;

                case 2:{
                    // boolean checkRespond = true;
                    // do { 
                    //     ramMS.searchRAMItem();
                    //     display(2, "add Item other");
                    //     String respond = sc.nextLine().trim();
                    //     if ("yes".equalsIgnoreCase(respond)) {
                    //         continue;
                    //     }
                    //     checkRespond = false;
                        
                    // } while (checkRespond);
                    ramMS.searchRAMItem();
                    displayMenu();
                    
                }
                    break;

                case 3:{
                    boolean checkRespond = true;
                    do { 
                        ramMS.updateRAMItem();
                        display(2, "update Item information other");
                        String respond = sc.nextLine().trim();
                        if ("yes".equalsIgnoreCase(respond)) {
                            continue;
                        }
                        checkRespond = false;
                        
                    } while (checkRespond);
                    displayMenu();

                }
                    break;

                case 4:{
                    boolean checkRespond = true;
                    do { 
                        ramMS.deleteRAMItem();
                        display(2, "delete Item other");
                        String respond = sc.nextLine().trim();
                        if ("yes".equalsIgnoreCase(respond)) {
                            continue;
                        }
                        checkRespond = false;
                        
                    } while (checkRespond);
                    displayMenu();
                    
                }
                    break;

                case 5:{
                    ramMS.showAllItems();
                    displayMenu();

                }
                    break;

                case 6:{
                    ramMS.saveToFile();
                    displayMenu();
                    
                }
                    break;

                
                default:
                    throw new AssertionError();
            }
            if(choice >=6 && choice <=1 ){
                ramMS.saveToFile();
                checkAction = false;
            }
        } while (checkAction);
    }
}
