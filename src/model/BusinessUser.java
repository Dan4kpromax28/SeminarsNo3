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
        if(nameAndSurnameORTitle != null && nameAndSurnameORTitle.matches("[A-Za-z0-9%&+@=.,!]{3,50}"))
            super.nameAndSurnameORTitle = nameAndSurnameORTitle;
        else
            super.nameAndSurnameORTitle = "----------";
    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {

    }


}
