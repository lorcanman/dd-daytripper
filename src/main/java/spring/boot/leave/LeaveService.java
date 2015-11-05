package spring.boot.leave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/leaves")
public class LeaveService {
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<Leave> allLeaves() {
        return schedule;
    }
//
//    @RequestMapping(value="/destination/{destination}", method = RequestMethod.GET, produces="application/json")
//    public List<Leave> bookLeave(@PathVariable("destination") String destination) {
//        return schedule;
//    }

    @RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public List<Leave> createLeave(@RequestBody Leave leave) {
        schedule.add(leave);
        return schedule;
    }
    
    @Resource(name="schedule")
    public void setSchedule(List<Leave> schedule) {
    		this.schedule = schedule;
    }
    private List<Leave> schedule;
}
