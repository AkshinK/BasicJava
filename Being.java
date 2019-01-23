package models;

public abstract class Being {
    protected int code;
    protected String name;

    public Being(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Being() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
