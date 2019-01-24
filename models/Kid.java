package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Kid extends Being {
    private Date birthday;
    private ArrayList<Product> purchasedProducts;
    private String placeOfBirth;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Kid(int code, String name, String birthday, String placeOfBirth) throws Exception{
        super(code, name);
        this.birthday = dateFormat.parse(birthday);
        this.placeOfBirth = placeOfBirth;
        purchasedProducts = new ArrayList<>();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void addProduct(Product product){
        this.purchasedProducts.add(product);
    }

    @Override
    public String toString() {
        return ("Name: " + name + " Code: " + code +" Birthday: " + dateFormat.format(birthday) + " Birth Place: " + placeOfBirth);
    }
}
