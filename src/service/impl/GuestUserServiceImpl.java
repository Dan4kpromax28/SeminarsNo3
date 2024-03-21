package service.impl;

import model.*;
import service.IGuestUserService;
import service.MainService;

import java.util.ArrayList;

public class GuestUserServiceImpl implements IGuestUserService {
    @Override
    public ArrayList<User> findUsers(String nameOrSurname) throws Exception { // nameOrSurname to -> nameOrSurnameOrTitle
        if (nameOrSurname == null || nameOrSurname.length() < 2){
            throw new Exception("Problem");
        }
        ArrayList<User> foundUsers = new ArrayList<User>();
        for(GuestUser tempU : MainService.allUsers){
            if (tempU instanceof PrivateUser || tempU instanceof BusinessUser){

                User user = (User)tempU;
                if(user.getNameAndSurnameORTitle().toLowerCase().contains(nameOrSurname.toLowerCase())){
                    foundUsers.add(user);
                }
            }
        }
        return foundUsers;
    }

    @Override
    public ArrayList<Page> findPages(String titleOrDescription) throws Exception {
        if (titleOrDescription == null || titleOrDescription.length() < 2) {
            throw new Exception("There is problem with input");
        }
        ArrayList<Page> newPages = new ArrayList<Page>();
        for (GuestUser tempU : MainService.allUsers) {
            if (tempU instanceof BusinessUser) {
                BusinessUser newBusinesUser = (BusinessUser) tempU;
                for (Page tempB : newBusinesUser.getListOfPages()) {
                    if (tempB.getTitle().toLowerCase().contains(titleOrDescription)) {
                        newPages.add(tempB);
                    }
                }
            }
        }
        return newPages;
    }
    public ArrayList<Post> findInfoINPublicPosts(String msg) throws Exception {
        if(msg == null || msg.length() < 5) throw new Exception("Error in input");
        ArrayList<Post> newPosts = new ArrayList<Post>();
        for (GuestUser tempU : MainService.allUsers){
            if(tempU instanceof PrivateUser){
                PrivateUser user = (PrivateUser) tempU;
                for (Post tempP : user.getPublicPosts()){
                    if(tempP.getMsg().toLowerCase().contains(msg.toLowerCase())){
                        newPosts.add(tempP);
                    }
                }
            }
            else if(tempU instanceof BusinessUser){
                BusinessUser user = (BusinessUser) tempU;
                for (Page tempP : user.getListOfPages()){
                    for(Post tempPost : tempP.getPostsInPage()){
                        if (tempP.getDescription().toLowerCase().contains(msg.toLowerCase())){
                            newPosts.add(tempPost);
                        }
                    }
                }
            }
        }
        return newPosts;
    }

}
