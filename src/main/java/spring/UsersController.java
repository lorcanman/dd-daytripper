package spring;

import java.util.Collection;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UsersController {

	private UserDao userDao;
	
	  public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

    private UserList users;

    @Resource(name = "users")
    public void setUserList(UserList users) {
        this.users = users;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
	  public String newUser(Model model, @Valid User user, BindingResult result) {
		  if(result.hasErrors()) {
			  return "user";
		  }
		  try (ClassPathXmlApplicationContext context =
			        new ClassPathXmlApplicationContext("classpath:/spring/dtApplicationContext.xml")) {
			  
			  userDao = context.getBean(UserDao.class);
			  User newUser = new User(user.getId(), user.getLevelOfAuthentication(),
					  user.getEmail(), user.getPassword(), user.getDaysOff());
			  System.out.println(newUser);
			  System.out.println(userDao);
			  userDao.create(newUser);
			  model.addAttribute("users", userDao.allUsers());
			  
		  return "hello-world";
		  }

	  }
}
