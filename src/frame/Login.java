/**
 * ��¼����
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
	private JLabel userLabel;										//�û���
	private JLabel passwordLabel;									//����
	private JTextField userText;									//�û����ı���
	private JPasswordField passwordText;							//�����
	private JButton login;											//��¼��ť
	private JButton reset;											//���ð�ť
	public Login(String title) {									
		super(title);												//���ô����ڲ�����
		titleLabel=new JLabel("����������Ϣ����ϵͳ");						//��ǩ���
		titleLabel.setFont(new Font("����", Font.BOLD, 22));
		titleLabel.setBounds(50, 30, 220, 30);
		userLabel=new JLabel("�û���:");
		userLabel.setBounds(50, 70, 50, 20);
		passwordLabel=new JLabel("��    ��:");
		passwordLabel.setBounds(50, 100, 50, 20);
		userText=new JTextField();									//�ı������
		userText.setBounds(110, 70, 130, 20);
		passwordText=new JPasswordField();
		passwordText.setBounds(110, 100, 130, 20);
		login=new JButton("��¼");									//��ť���
		login.setBounds(110, 130, 60, 20);
	
		reset=new JButton("����");
		reset.setBounds(180, 130, 60, 20);

		JPanel jpanel=new LoginJpanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);										//���ñ������
		jpanel.setLayout(null);										//ȡ�����ֹ�����
		
		jpanel.add(titleLabel);										//������
		jpanel.add(userLabel);
		jpanel.add(passwordLabel);
		jpanel.add(userText);
		jpanel.add(passwordText);
		jpanel.add(login);
		jpanel.add(reset);

		login.addActionListener(new ActionListener() {			   //��¼�¼�
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
		passwordText.addKeyListener(new KeyAdapter() {				//�س��¼�
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					enterCheck();
				}
			}
		});
		reset.addActionListener(new ActionListener() {				//�����¼�
			public void actionPerformed(ActionEvent e) {
				userText.setText("");								//����ı�������
				passwordText.setText("");
			}
		});
		setLocationRelativeTo(null);								//���ô��������ʾ		
	}
	public boolean isEmpty(String str) {							//�ж��ַ����Ƿ�Ϊ��
		if(str==null || "".equals(str.trim()))
			return true;											//���Ϊ��,����true.
		else 
			return false;											//�����Ϊ��,����false.
	}
	//��¼��֤
	public void loginCheck() {
		String name=userText.getText();					            //����û���������
		String password=new String(passwordText.getPassword());
		if(isEmpty(name)) {								            //����û���Ϊ��,������ʾ��
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		}
		if(isEmpty(password)) {							            //��������Ϊ��,������ʾ��
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		}
		Connection conn=new Conn().getConnection();		           //�������ݿ�����
		try {
			String sql="select * from user where name=? "
					+ "and password=?";		     
			PreparedStatement st=conn.prepareStatement(sql);//����PreparedStatement����
			st.setString(1, name);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();			     //ִ�в�ѯ���
			if(rs.next()) {								 //�û�����������ȷ
				MainFrame fr=new MainFrame();			 //����������
				setVisible(false);						 //���ص�¼����
			}
			else {
				JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			try {
				conn.close();							//�ر����ݿ�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	//����������»س���ʱ���õ�¼��֤����
	public void enterCheck() {
		loginCheck();
	}
	public static void main(String[] args) {
		Login fr=new Login("��¼");
		fr.setVisible(true);							//���ô���ɼ�
		fr.setResizable(false);							//ȡ����󻯴���
		fr.setSize(300, 200);							//���ô����С
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);		//���ô���رշ�ʽ
	}
}
