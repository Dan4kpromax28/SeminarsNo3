package service;

import model.BusinessUser;
import model.GuestUser;
import model.PostType;
import model.PrivateUser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
    private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();
    public static void main(String[] args) {
        GuestUser u1 = new GuestUser();
        GuestUser u2 = new GuestUser();
        PrivateUser u3 = new PrivateUser();
        GuestUser u4 = new GuestUser();
        BusinessUser u5 = new BusinessUser();
        PrivateUser u6 = new PrivateUser("Daniels", "Balika", "123456Ks");
        BusinessUser u7 = new BusinessUser("SIA Hesburger", "123456He", "LV12121121212");

        allUsers.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));

        for (GuestUser tempU : allUsers){
            System.out.println(tempU);
        }

        try {
            u6.publishPost(PostType.privatePost, "Man nekas nepatik!");
            u6.publishPost(PostType.publicPost, "Man viss patik");
            u6.publishPost(PostType.publicPost, "Zel, ka sodien nav piektdiena");

            u6.followPrivateUser(u3);
            u6.followPrivateUser(u7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(u6.getPrivatePosts());
        System.out.println(u6.getPublicPosts());
        System.out.println(u6.getFollowers());

    }
}
