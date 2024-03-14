package model;

import java.util.ArrayList;

public class PrivateUser extends User{
    //variables
    //get and set
    // constructors
    //to string
    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<User> followers = new ArrayList<User>();

    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    @Override
    public void setNameAndSurnameORTitle(String nameAndSurnameORTitle) {
        if (nameAndSurnameORTitle != null && nameAndSurnameORTitle.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+ [A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēīļšāžčņ]+")){
            super.nameAndSurnameORTitle = nameAndSurnameORTitle;
        }else
            super.nameAndSurnameORTitle = "________";
    }

    public PrivateUser(){
        super();//User()
        setNameAndSurnameORTitle("Janis Bērziņš");
        setUsername();
    }

    public PrivateUser(String name, String surname, String password){
        super(password);
        setNameAndSurnameORTitle(name+" "+surname);
        setUsername();
    }

    public String toString(){
        return super.toString()+super.nameAndSurnameORTitle + "(" + super.getUsername()+ ")";
    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {
        if(type == null && msg == null){
            throw new Exception("Problem with input parameter");
        }
        Post newPost = new Post(msg);
        if(type.equals(PostType.privatePost)) privatePosts.add(newPost);
        else if (type.equals(PostType.publicPost)) publicPosts.add(newPost);

    }
    public void followPrivateUser(User user) throws Exception {
        if(user != null){
            for (User tempUser : followers){
                if (tempUser.getUsername().equals(user.getUsername())){
                    throw new Exception("This user is already follower");
                }
            }
            followers.add(user);
        }else throw new Exception("Problems with input parameter");
    }
}
