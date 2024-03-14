package model;

public abstract class User extends GuestUser{
    //variables

    private String username;
    //TODO pasword enkodesana, piemeram , ar md5
    private String password;
    private String nameAndSurnameORTitle;



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

    public void setUsername(String username) {
        this.username = nameAndSurnameORTitle+ "_" + getUserID();
    }

    public void setPassword(String password) {
        //TODO ievietot encodesanu
        if(password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,40}$"))
            this.password = (password);
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
