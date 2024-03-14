package model;
import java.time.LocalDateTime;
public class Post {
    private String msg;
    //
    private LocalDateTime dateTime;
    private int countOfLikes = 0;

    public String getMsg() {
        return msg;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void setMsg(String msg) {
        if(msg != null && msg.length() > 5 && msg.length() < 300){
            this.msg = msg;
        }else
            this.msg="________";
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }
//TODO glabajam lietotajus, kuri ir piespiedusi laiku
    public void incrementCountOfLikes() {
        this.countOfLikes++;
    }


    public Post(){
        setMsg("Test msg");
        setDateTime();
    }
    public Post(String msg){
        setMsg(msg);
        setDateTime();
    }

    public String toString(){
        return msg + "(" + dateTime + ") likes [" + countOfLikes + "]";
    }
}
