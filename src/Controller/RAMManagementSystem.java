package Controller;

import Model.RAM;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import utilites.Validation;

public class RAMManagementSystem {
    private final Map<String, RAM> ramItems = new HashMap<>();
    private static final String FILE_NAME = "RAMModules.dat";
    public static Scanner sc = new Scanner(System.in);

    public RAMManagementSystem() {
        
        loadFromFile();
    }

    public void addRAMItem(){

        String code = Validation.validCode(ramItems);
        String type = code.split("_")[0].substring(3);
        String bus = Validation.validBus();
        String brand = Validation.validBrand();
        int quantity = Validation.validQuantity();
        String productMonthYear = Validation.validProductMonthYear();
        boolean active = true;
        
        RAM newRam = new RAM(code, type, bus, brand, quantity, productMonthYear, active);
        ramItems.put(code, newRam);   
        System.out.println("RAM item added successfully.");
    }

    public void searchRAMItem(){

        int choice;
        boolean validInput = true;

        System.out.println("1. Search by Type.");
        System.out.println("2. Search by Bus.");
        System.out.println("3. Search by Brand.");
        choice = Validation.getInt("Enter your choice: ", 1, 3);
        switch(choice){
            case 1:{
                    String type = replayInput("type");
                    List<RAM> result = new ArrayList<>();
                    for (RAM ram : ramItems.values()) {
                        if (ram.getType().equalsIgnoreCase(type)) {
                            result.add(ram);
                        }
                    }
                    if(result.size() != 0){
                        displaySearch("type", result);

                    }else {
                        System.out.println("No products available");
                        System.out.println("Do you want to search next time?");
                        System.out.print("Yes/No :  ");
                        String choiceYN = sc.nextLine().trim();
                        if("yes".equalsIgnoreCase(choiceYN)){
                            searchRAMItem();
                        }
                    }
                }
                break;
            case 2:{
                    String bus = replayInput("bus");
                    List<RAM> result = new ArrayList<>();
                    for (RAM ram : ramItems.values()) {
                        if (ram.getBus().equalsIgnoreCase(bus)) {
                            result.add(ram);
                        }
                    }
                    if(result.size() != 0){
                        displaySearch("bus", result);

                    }else {
                        System.out.println("No products available");
                        System.out.println("Do you want to search next time?");
                        System.out.print("Yes/No :  ");
                        String choiceYN = sc.nextLine().trim();
                        if("yes".equalsIgnoreCase(choiceYN)){
                            searchRAMItem();
                        }
                    }

                }
                break;
            case 3:{
                    String brand = replayInput("brand");
                    List<RAM> result = new ArrayList<>();
                    for (RAM ram : ramItems.values()) {
                        if (ram.getBrand().equalsIgnoreCase(brand)) {
                            result.add(ram);
                        }
                    }
                    if(result.size() != 0){
                        displaySearch("brand", result);

                    }else {
                        System.out.println("No products available");
                        System.out.println("Do you want to search next time?");
                        System.out.print("Yes/No :  ");
                        String choiceYN = sc.nextLine().trim();
                        if("yes".equalsIgnoreCase(choiceYN)){
                            searchRAMItem();
                        }
                    }


                }
                break;
            default:
            searchRAMItem();

        }


        
    }

    public String replayInput(String order){
        String input;
        boolean validInput = false;
        do{
            System.out.print("Enter " + order +": " );
            input = sc.nextLine().trim();
            
            if(input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again");
                continue;
            }
            validInput = true;
        }while(!validInput);

        return input;
        
    }

    public void displaySearch(String order, List<RAM> list){
        switch(order){
            case "type":{
                System.out.println("");
                System.out.printf("%-15s %-15s %-18s %-10s\n", "Code", "Type", "ProductDateTime", "Quantity");
                
                for (RAM ram : list) {
                    System.out.printf("%-15s %-15s %-18s %-10d\n", ram.getCode(), ram.getType(), ram.getProductionMonthYear(), ram.getQuantity());
                    System.out.println("");
                }
                System.out.println("Do you want to search next time?");
                System.out.print("Yes/No :  ");
                String choice = sc.nextLine().trim();
                if("yes".equalsIgnoreCase(choice)){
                    searchRAMItem();
                }
                
            } break;
            case "bus":{
                System.out.println("");
                System.out.printf("%-15s %-15s %-18s %-10s\n", "Code", "Bus", "ProductDateTime", "Quantity");
                
                for (RAM ram : list) {
                    System.out.printf("%-15s %-15s %-18s %-10d\n", ram.getCode(), ram.getBus(), ram.getProductionMonthYear(), ram.getQuantity());
                    System.out.println("");
                }
                System.out.println("Do you want to search next time?");
                System.out.println("Yes/No :  ");
                String choice = sc.nextLine().trim();
                if("yes".equalsIgnoreCase(choice)){
                    searchRAMItem();
                }
                
            } break;
            case "brand":{
                System.out.println("");
                System.out.printf("%-15s %-15s %-18s %-10s\n", "Code", "Brand", "ProductDateTime", "Quantity");
                
                for (RAM ram : list) {
                    System.out.printf("%-15s %-15s %-18s %-10d\n", ram.getCode(), ram.getBrand(), ram.getProductionMonthYear(), ram.getQuantity());
                    System.out.println("");
                }
                System.out.println("Do you want to search next time?");
                System.out.println("Yes/No :  ");
                String choice = sc.nextLine().trim();
                if("yes".equalsIgnoreCase(choice)){
                    searchRAMItem();
                }
                
            } break;
        }

    }

    public void updateRAMItem(){
        String code;
        code = Validation.validCodeUpdate( ramItems);
        RAM ram = ramItems.get(code);
        System.out.println(ram);
        
        System.out.print("Enter new Type: ");
        String newType = sc.nextLine().trim().toUpperCase();
        if(!newType.isEmpty()){
            ram.setType(newType);
            String[] olderRAM = ram.getCode().split("_");
            ram.setCode("RAM"+ newType + "_" + olderRAM[1]);
        }

        System.out.print("Enter new bus: ");
        String newBus = sc.nextLine().trim();
        if(!newBus.isEmpty()){
            ram.setBus(newBus);
        }

        System.out.print("Enter new brand: ");
        String newBrand = sc.nextLine().trim();
        if(!newBrand.isEmpty()){
            ram.setBrand(newBrand);
        }

        System.out.print("Enter new quantity: ");
        String newQuantity = sc.nextLine().trim();
        if(!newQuantity.isEmpty()){
            try {
                int value = Integer.parseInt(newQuantity);
                ram.setQuantity(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value entered!");
            }
        }

        System.out.print("Enter new datetime of product: ");
        String newPMY = sc.nextLine().trim();
        if(!newPMY.isEmpty()){
            String pattern = "(0[1-9]|1[0-2])-(\\d{4})";
            if(newPMY.matches(pattern)){
                ram.setProductionMonthYear(newPMY);
            }
        }

        // System.out.println("Update active: ");
        // String newActive = sc.nextLine().trim().toLowerCase();
        // if(!newActive.isEmpty()){
        //     if("true".equalsIgnoreCase(newActive)){
        //         ram.setActive(true);
        //     }
        //     if("false".equalsIgnoreCase(newActive)){
        //         ram.setActive(false);
        //     }
        // }


        System.out.println("Update successfully!");
    }

    public void deleteRAMItem(){
        
        String code;
        code = Validation.validCodeUpdate(ramItems);
        RAM ram = ramItems.get(code);
        System.out.println("This is RAM of information: ");
        System.out.println(ram);
        System.out.println("Do you want to delete this RAM?");
        System.out.println("Yes/No :  ");
        String choice = sc.nextLine().trim();
        if("yes".equalsIgnoreCase(choice)){
            ram.setActive(false);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Deleted failed");
        }

    }

    public void showAllItems(){

        System.out.println("");
        System.out.printf("%-15s %-10s %-10s %-15s %-18s %-10s %-10s\n", "Code", "Type", "Bus", "Brand", "ProductDate", "Quantity", "Active");
        
        for(RAM ram : ramItems.values()){
            if(ram.isActive()){
                System.out.printf("%-15s %-10s %-10s %-15s %-18s %-10s %-10s\n", ram.getCode(), ram.getType(), ram.getBus(), ram.getBrand(), ram.getProductionMonthYear(), ram.getQuantity(), ram.isActive());
            }
            
        }
    }

    

    public void loadFromFile(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\Model\\RAMModules.dat" ))) {
            
            ramItems.putAll((Map<String, RAM> ) ois.readObject());

            System.out.println("RAM items have been loaded from " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME + ". A new file will be created when saving.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading RAM items from file: " + e.getMessage());
        }
    }


    public void saveToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\Model\\RAMModules.dat"))) 
        {
            oos.writeObject(ramItems);
            System.out.println("RAM items have been successfully saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving RAM items to file: " + e.getMessage());
        }
    }

    
}
