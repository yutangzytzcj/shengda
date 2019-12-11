package mode;
public class User {
	private int id;
	private String username;								//用户名
	private String password;								//密码
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String username) {				//设置用户名
		this.username=username;
	}
	public void setPassWord(String password) {				//设置密码
		this.password=password;
	}
	public String getUserName() {							//获取用户名
		return this.username;
	}
	public String getPassWord() {							//获取密码
		return this.password;
	}
}
