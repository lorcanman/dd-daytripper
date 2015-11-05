package spring;

import static spring.UserAuthentication.ADMIN;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

	private String id, email, password;
	private String levelOfAuthentication;
	private int daysOff;
	private Boolean isOnHoliday;
	
	public User() {
		setId("Prometheus");
		setLevelOfAuthentication("ADMIN");
		setEmail("default@test.com");
		setPassword("password");
		setDaysOff(8);
		setIsOnHoliday(false);
	}
	
	public User(String id, String levelOfAuthentication, String email, String password, int daysOff){
		this.id = id;
		this.setLevelOfAuthentication(levelOfAuthentication);
		this.setEmail(email);
		this.setPassword(password);
		this.setDaysOff(daysOff);
		this.setIsOnHoliday(false);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevelOfAuthentication() {
		return levelOfAuthentication;
	}

	public void setLevelOfAuthentication(String levelOfAuthentication) {
		this.levelOfAuthentication = levelOfAuthentication;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}

	public Boolean getIsOnHoliday() {
		return isOnHoliday;
	}

	public void setIsOnHoliday(Boolean isOnHoliday) {
		this.isOnHoliday = isOnHoliday;
	}
}
