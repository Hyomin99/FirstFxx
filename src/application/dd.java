package application;

public class dd {
	
	static final dd dd = new dd(); 
	private dd() {
		
	}
	
	static dd getInstance() {
		return dd;
	}
	
	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	

}
