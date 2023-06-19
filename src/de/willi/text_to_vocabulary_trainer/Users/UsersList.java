package de.willi.text_to_vocabulary_trainer.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    static List<User> list = new ArrayList<>();

    public static void addToList(User user){
        list.add(user);
    }

    public static boolean verifyUser(String name, String password){
        for(User u: list){
            if (u.getName().equals(name))
                if(u.getPassword().equals(password)){
                    return true;
                }
        }
        return false;
    }
}
