package spring;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserList {

    private final Map<String, User> users = new TreeMap<>();

    public UserList() {
    }

    public UserList(List<User> users) {
        for (User user : users) {
            this.users.put(user.getId(), user);
        }
    }

    public Collection<User> list() {
        return users.values();
    }

    public void replace(User user) {
        users.put(user.getId(), user);
    }

    public User get(String id) {
        return users.get(id);
    }

    public void delete(String id) {
        users.remove(id);
    }
}
