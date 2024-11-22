package jdbc;

import jdbc.model.User;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args)  {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Name1", "LastName1", (byte) 33);
        userService.saveUser("Name2", "LastName2", (byte) 25);
        userService.saveUser("Name3", "LastName3", (byte) 31);
        userService.removeUserById(1);
        List<User> users = userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}


