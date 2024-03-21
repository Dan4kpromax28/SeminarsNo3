package model;

//import java.time.LocalDateTime;

import service.impl.GuestUserServiceImpl;

public class GuestUser {
    private long userID;

    private static long counter = 0;

    public GuestUserServiceImpl service = new GuestUserServiceImpl();

    public long getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = counter;
        counter++;
    }

    public GuestUser(){
        setUserID();
    }

    @Override
    public String toString() {
        return
                "" + userID;
    }

    public void test() {
    //    LocalDateTime l = LocalDateTime.now();
    }
}
