/**
 * 登录窗体
 */
package frame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Jpanel.LoginJpanel;
import dao.Conn;
public class Login extends JFrame{
	private JLabel titleLabel;										
	private JLabel userLabel;										//用户名
	private JLabel passwordLabel;									//密码
	private JTextField userText;									//用户名文本框
	private JPasswordField passwordText;							//密码框
	private JButton login;											//登录按钮
	private JButton reset;											//重置按钮
	public Login(String title) {									
		super(title);												//设置窗体内部标题
		titleLabel=new JLabel("金玉满堂信息管理系统");						//标签组件
		titleLabel.setFont(new Font("宋体", Font.BOLD, 22));
		titleLabel.setBounds(50, 30, 220, 30);
		userLabel=new JLabel("用户名:");
		userLabel.setBounds(50, 70, 50, 20);
		passwordLabel=new JLabel("密    码:");
		passwordLabel.setBounds(50, 100, 50, 20);
		userText=new JTextField();									//文本框组件
		userText.setBounds(110, 70, 130, 20);
		passwordText=new JPasswordField();
		passwordText.setBounds(110, 100, 130, 20);
		login=new JButton("登录");									//按钮组件
		login.setBounds(110, 130, 60, 20);
	
		reset=new JButton("重置");
		reset.setBounds(180, 130, 60, 20);

		JPanel jpanel=new LoginJpanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);										//设置背景面板
		jpanel.setLayout(null);										//取消布局管理器
		
		jpanel.add(titleLabel);										//添加组件
		jpanel.add(userLabel);
		jpanel.add(passwordLabel);
		jpanel.add(userText);
		jpanel.add(passwordText);
		jpanel.add(login);
		jpanel.add(reset);

		login.addActionListener(new ActionListener() {			   //登录事件
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
		passwordText.addKeyListener(new KeyAdapter() {				//回车事件
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					enterCheck();
				}
			}
		});
		reset.addActionListener(new ActionListener() {				//重置事件
			public void actionPerformed(ActionEvent e) {
				userText.setText("");								//清空文本框内容
				passwordText.setText("");
			}
		});
		setLocationRelativeTo(null);								//设置窗体居中显示		
	}
	public boolean isEmpty(String str) {							//判断字符串是否为空
		if(str==null || "".equals(str.trim()))
			return true;											//如果为空,返回true.
		else 
			return false;											//如果不为空,返回false.
	}
	//登录验证
	public void loginCheck() {
		String name=userText.getText();					            //获得用户名、密码
		String password=new String(passwordText.getPassword());
		if(isEmpty(name)) {								            //如果用户名为空,给出提示。
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(isEmpty(password)) {							            //如果密码框为空,给出提示。
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		Connection conn=new Conn().getConnection();		           //建立数据库连接
		try {
			String sql="select * from user where name=? "
					+ "and password=?";		     
			PreparedStatement st=conn.prepareStatement(sql);//创建PreparedStatement对象
			st.setString(1, name);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();			     //执行查询语句
			if(rs.next()) {								 //用户名和密码正确
				MainFrame fr=new MainFrame();			 //启动主窗体
				setVisible(false);						 //隐藏登录窗体
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			try {
				conn.close();							//关闭数据库
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	//当在密码框按下回车键时调用登录验证方法
	public void enterCheck() {
		loginCheck();
	}
	public static void main(String[] args) {
		Login fr=new Login("登录");
		fr.setVisible(true);							//设置窗体可见
		fr.setResizable(false);							//取消最大化窗体
		fr.setSize(300, 200);							//设置窗体大小
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);		//设置窗体关闭方式
	}
}
