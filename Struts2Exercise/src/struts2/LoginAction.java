package struts2;

public class LoginAction {
	private String userName;
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	} 
	public String execute(){
		if(getUserName().equals("Wangjg") && getUserPassword().equals("Wangjg")){
			System.out.println("Login success!");
			return "success";
		}
		else{
			System.out.println("Login fail!");
			return "error";
		}
	}
}
