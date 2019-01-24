package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OompaLoompaSong {
    private int lines;

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public OompaLoompaSong(int lines){
        this.lines = lines;
    }

    public ArrayList<String> getSongFromFile(){
        ArrayList<String> song = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("OompaLoompaSong.txt"))) {
            while(scanner.hasNextLine()){
                song.add(scanner.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found brat");
        }
        return song;
    }

    public String sing(){
        int randomNumber = (int)(Math.random()*getSongFromFile().size());
        return getSongFromFile().get(randomNumber);
    }
	
}
