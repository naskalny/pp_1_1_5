package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("John", "Dope", (byte) 7);
        userDaoJDBC.saveUser("Oleg", "Tinkoff", (byte) 43);
        userDaoJDBC.saveUser("Michael", "Jackson", (byte) 12);
        userDaoJDBC.saveUser("Elisabet", "Olsen", (byte) 27);

        try {
            List<User> userList = userDaoJDBC.getAllUsers();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();

    }
}
