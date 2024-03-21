package model;

import java.util.ArrayList;

public class BusinessUser extends User{


    private ArrayList<Page> listOfPages = new ArrayList<Page>();
    private String PVNNo;//example


    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    public String getPVNNo() {
        return PVNNo;
    }

    public void setPVNNo(String PVNNo) {
        if(PVNNo != null && PVNNo.matches("[A-Z]{2}[0-9]{11}")){
            this.PVNNo = PVNNo;
        }else
            this.PVNNo ="________";

    }

    @Override
    public void setNameAndSurnameORTitle(String nameAndSurnameORTitle) {
        if(nameAndSurnameORTitle != null && nameAndSurnameORTitle.matches("[A-Za-z0-9%&+@=.,! ]{3,50}"))
            super.nameAndSurnameORTitle = nameAndSurnameORTitle;
        else
            super.nameAndSurnameORTitle = "----------";
    }

    public BusinessUser() {
        super();
        setNameAndSurnameORTitle("AutoServis");
        setUsername();
        setPVNNo("LV40003245752");
    }

    public BusinessUser(String title, String password, String PVNNo){
        super(password);
        setNameAndSurnameORTitle(title);
        setUsername();
        setPVNNo(PVNNo);
    }

    @Override
    public String toString() {
        return super.toString()+ ":" + PVNNo;
    }

    public void createPage(String title, String description) throws Exception {
        if (title == null || description == null) throw new Exception("Problem");
        for (Page tempP : listOfPages){
            if(tempP.getTitle().equals(title)){
                throw new Exception("This title already exist");
            }
        }
        Page newPage = new Page(title,description);
        listOfPages.add(newPage);
    }

    @Override
    public Post publishPost(PostType type, String msg) throws Exception {
        Post newPost = new Post();//Parbaudit parametrus
        return newPost;
    }

    public void publishPostInPage(String pageTitle, String msg) throws Exception {
        //parbaudes
            for (Page tempP : listOfPages){
                if(tempP.getTitle().equals(pageTitle)){
                    Post newPost = publishPost(PostType.publicPost,msg);
                    tempP.getPostsInPage().add(newPost);
                    return;
                }
            }
            throw new Exception("Page not found");
    }


}
