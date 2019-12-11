package frame;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import dao.Conn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
public class UserAdd extends JInternalFrame{
	private JLabel user;
	private JLabel pw;
	private JTextField usertxt;
	private JTextField pwtxt;
	private JButton add;
	private JButton reset;
	public UserAdd() {
	super("�û����");
	setVisible(true);
	setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
	setClosable(true);
	setIconifiable(true);
	setRootPaneCheckingEnabled(false);
	Container container=getContentPane();
	container.setLayout(null);
	setBounds(100, 100, 250, 154);
	user=new JLabel("�û���:");
	user.setBounds(23, 24, 49, 20);
	pw=new JLabel("����:");
	pw.setBounds(23, 54, 49, 20);
	usertxt=new JTextField();
	usertxt.setBounds(95, 24, 123, 20);
	pwtxt=new JTextField();
	pwtxt.setBounds(95, 54, 123, 20);
	add=new JButton("���");
	add.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			addPerformed();
		}
	});
	add.setBounds(95, 84, 60, 25);
	reset=new JButton("����");
	reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			resetPerformed();
		}
	});
	reset.setBounds(157, 84, 60, 25);
	container.add(user);
	container.add(usertxt);
	container.add(pw);
	container.add(pwtxt);
	container.add(add);
	container.add(reset);
	}	
	//���
	private void addPerformed() {
		if(usertxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��!");
			return;
		}
		if(pwtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
			return;
		}
		int i=new Conn().insertUser(usertxt.getText().trim(), pwtxt.getText().trim());
		if(i==1) {
			JOptionPane.showMessageDialog(null, "��ӳɹ�!");
			resetPerformed();
			return;
		}
	}
	//����
	private void resetPerformed() {
		usertxt.setText("");
		pwtxt.setText("");
	}
}