package model;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<User> followers= new ArrayList<User>();
    private ArrayList<Post> postsInPage = new ArrayList<Post>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.length() > 5 && 50 > title.length()){
            this.title = title;
        }else
            this.title = "New title";

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null && description.length() > 5 && description.length() < 500) {
            this.description = description;
        }else
            this.description = "_________";

    }

    public ArrayList<User> getFollowers() {
        return followers;
    }



    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }

    public Page() {
        setTitle("Autoserviss Ventspili");
        setDescription("Autoserviss Ventspioli - jaunakas aktualitates");
    }
    public Page(String title, String description){
            setTitle(title);
            setDescription(description);
        }

    public String toString(){
        return title+"(" + description + ") -> "+ followers.size();
    }
}
