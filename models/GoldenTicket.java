package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GoldenTicket {
    private static Random random = new Random();

    private String code;
    private Date raffled;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public GoldenTicket(String code, String raffled) throws Exception {
        this.code = code;
        this.raffled = dateFormat.parse(raffled);
    }

    public GoldenTicket() {
        this.code = GoldenTicket.codeCreator();
        this.raffled = null;
    }

    public GoldenTicket(String code, Date raffled){
        this.code = code;
        this.raffled = raffled;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRaffled() {
        return raffled;
    }

    public void setRaffled(String raffled) throws Exception {
        this.raffled = dateFormat.parse(raffled);
    }

    public boolean isRaffled() {
        return (raffled != null);
    }

    public static String codeCreator() {
        String generatingList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        int randomChar;
        String code = "";
        while (code.length() < 6) {
            randomChar = random.nextInt(generatingList.length() - 1);
            code += (generatingList.charAt(randomChar));
        }
        return code;
    }

    @Override
    public String toString() {
        if (this.isRaffled()) {
            return ("The code of prize: " + this.code + ", the raffled date is: " + dateFormat.format(this.raffled));
        } else {
            return ("The code of prize: " + this.code);
        }
    }
}