package spring.boot.leave.test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import spring.boot.leave.Leave;
import spring.boot.leave.LeaveService;

public class LeaveServiceTest {

	private LeaveService target;
	private Leave leave;
	private List<Leave> leaveList;
	
	@Before
	public void setUp() {
		leaveList = new ArrayList<Leave>();
		leave = mock(Leave.class);
		
		target = new LeaveService();
		target.setSchedule(leaveList);
	}
	
	@Test
	public void shouldAddLeaveToListOfLeaves() throws Exception {	
		List<Leave> returnedList = target.createLeave(leave);
		
		assertTrue(leaveList.size() == 1);
		assertTrue(leaveList.contains(leave));
		assertEquals(leaveList, returnedList);
    }
	
}
