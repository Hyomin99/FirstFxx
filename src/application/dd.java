package application;

public class dd {
	
	static final dd dd = new dd(); 
	private dd() {
		
	}
	
	static dd getInstance() {
		return dd;
	}
	
	private String filepath;
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	

}
