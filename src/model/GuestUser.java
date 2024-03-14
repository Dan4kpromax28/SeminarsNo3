package model;

//import java.time.LocalDateTime;

public class GuestUser {
    private long generatedid;

    private static long counter = 0;

    public long getGeneratedid() {
        return generatedid;
    }

    public void setGeneratedid() {
        this.generatedid = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "generatedid = " + generatedid +
                '}';
    }

    public void test() {
    //    LocalDateTime l = LocalDateTime.now();
    }
}
