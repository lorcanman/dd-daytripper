package spring.boot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.*;

import spring.boot.leave.Leave;

@Configuration
public class SpringBootServicesForJSConfig {
	@Bean(name="schedule")
	public List<Leave> buildSchedule() {
		List<Leave> leaves = new ArrayList<Leave>();
		leaves.add(new Leave(new Date(),new Date(), "Standard"));
		leaves.add(new Leave(new Date(),new Date(), "Standard"));
		leaves.add(new Leave(new Date(),new Date(), "Standard"));
		leaves.add(new Leave(new Date(),new Date(), "Public"));
        return leaves;
	}
	
}
