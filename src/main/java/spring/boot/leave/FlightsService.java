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
public class FlightsService {
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<Leave> allLeaves() {
        return schedule;
    }
//    @RequestMapping(value="/origin/{origin}", method = RequestMethod.GET, produces="application/json")
//    public List<Leave> flightsByOrigin(@PathVariable("origin") String origin) {
//        List<Leave> results = new ArrayList<Leave>();
//        for(Leave f : schedule) {
//            if(f.getOrigin().equals(origin)) {
//                results.add(f);
//            }
//        }
//        return results;
//    }
    @RequestMapping(value="/destination/{destination}", method = RequestMethod.GET, produces="application/json")
    public List<Leave> bookLeave(@PathVariable("destination") String destination) {
        return schedule;
    }
//    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces="application/json")
//    public ResponseEntity<Leave> deleteFlight(@PathVariable("id") int id) {
//        Leave found;
//        if((found = removeFlight(id)) != null) {
//           return new ResponseEntity<Leave>(found,HttpStatus.OK);
//        }
//        return new ResponseEntity<Leave>(HttpStatus.NOT_FOUND);
//    }
//    @RequestMapping(value="/{id}", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
//    public Leave updateFlight(@PathVariable("id") int id, @RequestBody Leave flight) {
//        removeFlight(id);
//        schedule.add(flight);
//        return flight;
//    }
//    private Leave removeFlight(int id) {
//        Iterator<Leave> iter = schedule.iterator();
//        while(iter.hasNext()) {
//            Leave f = iter.next();
//            if(f.getNumber() == id) {
//                iter.remove();
//                return f;
//            }
//        }
//        return null;
//    }
    @Resource(name="schedule")
    public void setSchedule(List<Leave> schedule) {
    		this.schedule = schedule;
    }
    private List<Leave> schedule;
}
