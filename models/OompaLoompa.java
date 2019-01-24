package models;

public class OompaLoompa extends Being {
    private int height;
    private String favouriteFood;

    public OompaLoompa(int code, String name, int height, String favouriteFood) {
        super(code, name);
        this.height = height;
        this.favouriteFood = favouriteFood;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String toString() {
        return  "height: " + height +
                ", favouriteFood: " + favouriteFood + '\'' +
                ", code: " + code +
                ", name: '" + name;
    }
}
