package project.spring.daytripper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserList users;

    @Resource(name = "users")
    public void setUserList(UserList users) {
        this.users = users;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<User> viewAll() {
        return users.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public User addOrUpdate(@RequestBody User user) {
        users.replace(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getById(@PathVariable("id") String id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        users.delete(id);
    }
}
