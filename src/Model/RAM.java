package Model;

import java.io.Serializable;

public class RAM implements Serializable{
    private String code;
    private String type;
    private String bus;
    private String brand;
    private int quantity;
    private String productionMonthYear;
    private boolean active;


    public RAM() {
    }

    public RAM(String code, String type , String bus, String brand, int quantity,  String productionMonthYear,boolean active) {
        this.active = active;
        this.brand = brand;
        this.bus = bus;
        this.code = code;
        this.productionMonthYear = productionMonthYear;
        this.quantity = quantity;
        this.type = type;
    }

   

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductionMonthYear() {
        return productionMonthYear;
    }

    public void setProductionMonthYear(String productionMonthYear) {
        this.productionMonthYear = productionMonthYear;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
     


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\t").append(code);
        sb.append("\t ").append(type);
        sb.append("\t ").append(bus);
        sb.append("\t ").append(brand);
        sb.append("\t ").append(quantity);
        sb.append("\t ").append(productionMonthYear);
        sb.append("\t ").append(active);
        
        return sb.toString();
    }


    



}
