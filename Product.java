package models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Product {
    private String description;
    private long barcode;
    private String serialNumber;
    private GoldenTicket prizeTicket;

    public Product(String description, long barcode, String serialNumber) {
        this.description = description;
        this.barcode = barcode;
        this.serialNumber = serialNumber;
        this.prizeTicket = null;
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public GoldenTicket getPrizeTicket() {
        return prizeTicket;
    }

    public void setPrizeTicket(GoldenTicket prizeTicket) {
        this.prizeTicket = prizeTicket;
    }

    public static void registerProduct(Product product) {
        ArrayList<Product> registeredProducts = new ArrayList<>();
        registeredProducts.add(product);
    }

    @Override
    public String toString() {
        if (prizeTicket != null) {
            return "Description: " + description + ", barcode: " + barcode + ", serial number: "
                    + serialNumber + ", prize ticket num.: " + prizeTicket.getCode();
        } else {
            return ("Description: " + description + ", barcode: " + barcode + ", serial number: "
                    + serialNumber + " and the product doesn't have prize ticket");
        }
    }
}
