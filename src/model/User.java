package model;

import service.PostService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User extends GuestUser implements PostService {
    //variables

    private String username;
    //TODO pasword enkodesana, piemeram , ar md5
    private String password;
    protected String nameAndSurnameORTitle;



    //get and set functions


    public String getUsername() {
        return username;
    }

    public String getNameAndSurnameORTitle() {
        return nameAndSurnameORTitle;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername() {
        this.username = nameAndSurnameORTitle+ "_" + getUserID();
    }

    public void setPassword(String password) {
        //TODO ievietot encodesanu

        if(password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,40}$")) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                this.password = new String(md.digest());
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        else
            this.password = "-----------";
    }

    public abstract void setNameAndSurnameORTitle(String nameAndSurnameORTitle);
    // kas notiek ar abstractu funkcija, lai precizet ka tas strada ar registreto user un neregistreto usert


    public User(){
        super(); //GuestUser()
        setPassword("123456789");
    }

    public User(String password){
        super();
        setPassword(password);
    }

    @Override
    public String toString() {
        return super.toString() + ":";
    }

    // TODO login()
    // TODO folowpage()
}
