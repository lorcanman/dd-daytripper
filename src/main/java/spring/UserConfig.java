package spring;

import static spring.UserAuthentication.ADMIN;
import static spring.UserAuthentication.TEAMLEADER;
import static spring.UserAuthentication.TEAMMEMBER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean(name = "users")
    public UserList users() {
        List<User> users = new ArrayList<>();   
        System.out.println("UserList Constructed.");
        users.add(new User());
        System.out.println(users.get(0).getId() + " in UserList.");
        users.add(new User("Shannen", "TEAMMEMBER", "ssmyth@deloitte.co.uk", "Shannen's password", 5));
        System.out.println(users.get(1).getId() + " in UserList.");
//        for(int i=0; i<users.size(); i++){
//        System.out.println(users.get(i).getId());
//        }
        return new UserList(users);
    }
}
