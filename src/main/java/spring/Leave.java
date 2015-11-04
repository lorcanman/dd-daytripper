package spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leave {

	private Date startDate, endDate;
	private String type;
	
	
	public Leave(){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			this.startDate = formatter.parse("2015/11/16");
			this.endDate = formatter.parse("2015/11/19");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.type = "Standard";
	}
	
	public Leave(Date startDate, Date endDate, String type) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
