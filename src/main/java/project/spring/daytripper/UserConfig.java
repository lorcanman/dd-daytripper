package project.spring.daytripper;

import static project.spring.daytripper.UserAuthentication.ADMIN;
import static project.spring.daytripper.UserAuthentication.TEAMLEADER;
import static project.spring.daytripper.UserAuthentication.TEAMMEMBER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean(name = "users")
    public UserList users() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User("Shannen", TEAMMEMBER, "ssmyth@deloitte.co.uk", "Shannen", 5));
        return new UserList(users);
    }
}
