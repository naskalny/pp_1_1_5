package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();
        userDao.saveUser("Ренат", "Отебулатов", (byte) 27);
        userDao.saveUser("Ахмед", "Гагиев", (byte) 26);
        userDao.saveUser("Владислав", "Поздняков", (byte) 33);
        userDao.saveUser("Александр", "Аникеев", (byte) 24);

        List<User> userList = userDao.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        userDao.cleanUsersTable();

        userDao.dropUsersTable();
    }
}
