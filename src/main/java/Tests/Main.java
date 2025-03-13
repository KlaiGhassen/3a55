package Tests;

import Models.User;
import Services.UserService;
import Utils.MyDb;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            //  userService.insert(new User(21, "amin", "kaaboura"));
            System.out.println(userService.findAll());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
