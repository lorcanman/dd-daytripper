package spring;

import java.util.List;

public interface UserDao {

    void create(User user);

	List<User> allUsers();

}