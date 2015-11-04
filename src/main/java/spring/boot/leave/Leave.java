package spring.boot.leave;

import java.util.Date;

public class Leave {
    private Date startDate;
	private Date endDate;
	private String type;

	public Leave(Date startDate, Date endDate, String type) {
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
   
}

