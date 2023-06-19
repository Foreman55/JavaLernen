package de.willi.text_to_vocabulary_trainer.literature.test;

import de.willi.text_to_vocabulary_trainer.Users.User;
import de.willi.text_to_vocabulary_trainer.literature.mysql.Mysql;

public class TestMysqltest {
    public static void main(String[] args) {
        User user = new User("yoyo", "y" ,"i");
        Mysql.insertNewUser(user);
    }
}
