package spring;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class LeaveController {

	private List<Leave> leaveList;

	@Resource(name = "leaveList")
	public void setLeaveList(List<Leave> leaves) {
		this.leaveList = leaves;
	}

	@RequestMapping(value = "/blob", method = RequestMethod.GET, produces = "application/json")
	public List<Leave> returnMessage(){
		return leaveList;
		
	}
}
