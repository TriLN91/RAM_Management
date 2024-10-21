package utilites;

import Model.RAM;
import java.util.Map;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max){
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an integer number in range: " + min + " to " + max);
            }
        }
        return n;
    }
    public static boolean existCode(String code, Map<String, RAM>ram){
        return ram.containsKey(code);
    }

    public static String validCode(Map<String, RAM> ram){
        String code;
        boolean validInput = false;
        do { 
            System.out.print("Enter code: ");
            code = sc.nextLine().trim();
            if(code.isEmpty()){
                System.out.println("Input cannot be empty. Please try again");
                continue;
            }

            String pattern = "RAM[A-Z0-9]+_\\d+";
            if(!code.matches(pattern)){
                System.out.println("Code is wrong format (RAM[x]_[y])!");
                
                continue;
            }

            if(existCode(code,ram)){
                System.out.println("Product ID already in the system");
                continue;
            }

            validInput = true;

        } while (!validInput);
        return code;
    }

    public static String validCodeUpdate( Map<String, RAM> ram){
        String code;
        boolean validInput = false;
        do { 
            System.out.print("Enter code: ");
            code = sc.nextLine().trim();
            if(code.isEmpty()){
                System.out.println("Input cannot be empty. Please try again");
                continue;
            }

            String pattern = "RAM[A-Z0-9]+_\\d+";
            if(!code.matches(pattern)){
                System.out.println("Code is wrong format (RAM[x]_[y])!");
                continue;
            }

            if(!existCode(code,ram)){
                System.out.println("Product is not in the system");
                continue;
            }

            validInput = true;

        } while (!validInput);
        return code;



    }

    
    public static String validBus(){
        
        String bus;
        boolean validInput = false;

        do{
            System.out.print("Enter Bus: ");
            bus = sc.nextLine().trim();

            if(bus.isEmpty()){
                System.out.println(" Input cannot be empty. Please try again. ");
                continue;

            }
            try {
                int valueCheck = Integer.parseInt(bus);
                if(valueCheck <=0 ){
                    System.out.println("The bus must be bigger than 0.");
                }else {
                    validInput = true; 
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a bus of number.");
            }

        }while (!validInput) ;
        
        return bus ;

    }

    public static String validBrand(){
        String brand;
        boolean validInput = false;
        do { 
            System.out.print("Enter Brand: ");
            brand = sc.nextLine().trim();
            if (brand.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            validInput = true;
        } while (!validInput);
        return brand;

    }

    public static int validQuantity(){
        String quantity;
        int valueFinal = 0;
        boolean validInput = false;

        do { 
            System.out.print("Enter quantity: ");
            quantity = sc.nextLine().trim();

            if(quantity.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
                continue;

            }

            try {
                valueFinal = Integer.parseInt(quantity);
                if (valueFinal <= 0) {
                    System.out.println("The value must be greater than 0.");
                    
                } else {
                    validInput = true;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter quantity of number.");
            }
        } while (!validInput); 

        return valueFinal;
    }

    public static String validProductMonthYear(){
        String productMonthYear;
        boolean validInput = false;

        do{
            System.out.print("Enter datetime of product (Month-Year): ");
            productMonthYear = sc.nextLine().trim();

            if(productMonthYear.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }

            String pattern = "(0[1-9]|1[0-2])-(\\d{4})";
            if(!productMonthYear.matches(pattern)){
                System.out.println("Datetime of product must be format (MM-YYYY) !");
                continue;
            }

            validInput = true;

        }while(!validInput);

        return productMonthYear;
    }


}
