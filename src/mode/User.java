package mode;
public class User {
	private int id;
	private String username;								//�û���
	private String password;								//����
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String username) {				//�����û���
		this.username=username;
	}
	public void setPassWord(String password) {				//��������
		this.password=password;
	}
	public String getUserName() {							//��ȡ�û���
		return this.username;
	}
	public String getPassWord() {							//��ȡ����
		return this.password;
	}
}
