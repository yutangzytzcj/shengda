package frame;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import dao.Conn;
import frame.CustomerEdit.tableListener;
import mode.User;
public class UserEdit extends JInternalFrame{
	private JLabel username;
	private JLabel pw;
	private JTextField usernametxt;
	private JTextField pwtxt;
	private JButton save;
	private JButton delete;
	private JScrollPane js;
	private DefaultTableModel userTableMode;
	private JTable userTable;
	private String [] columns= {"id","用户名"};
	private Object [][] users;
	private List userlist;
	public UserEdit() {
		setTitle("用户编辑");
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setBounds(100, 100, 291, 189);		
		Container container=getContentPane();
		container.setLayout(null);
		js=new JScrollPane();
		js.setLocation(10, 10);
		js.setSize(267,59);
		username=new JLabel("用户名:");
		username.setBounds(10, 88, 50, 20);
		usernametxt=new JTextField();
		usernametxt.setBounds(55, 88, 70, 20);
		pw=new JLabel("密码:");
		pw.setBounds(139, 88, 50, 20);
		pwtxt=new JTextField();
		pwtxt.setBounds(171, 88, 106, 20);
		save=new JButton("保存");
		save.addActionListener(new saveListener());
		save.setBounds(55, 118, 62, 20);
		delete=new JButton("删除");
		delete.addActionListener(new deleteListener());
		delete.setBounds(127, 118, 62, 20);
		container.add(js);
		container.add(usernametxt);
		container.add(username);
		container.add(pw);
		container.add(pwtxt);
		container.add(save);
		container.add(delete);
		users=getUser(new Conn().selectUser());
		userTableMode=new DefaultTableModel(users, columns);
		userTable=new JTable(userTableMode);
		userTable.addMouseListener(new tableListener());
		js.setViewportView(userTable);
		
	}
	//获取用户数据
	private Object[][] getUser(List userlist){
		Object[][] users=new Object[userlist.size()][columns.length];
		for(int i=0;i<userlist.size();i++) {
			User user=(User)userlist.get(i);
			users[i][0]=user.getId();
			users[i][1]=user.getUserName();
		}
		return users;
	}
	//表格事件
	class tableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int selRow = userTable.getSelectedRow();
			usernametxt.setText(userTable.getValueAt(selRow, 1).toString());
		}
	}
	//保存
	class saveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(usernametxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "用户名不能为空!");
				return;
			}
			if(pwtxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "密码不能为空!");
				return;
			}
			int i=new Conn().updateUser(Integer.parseInt(userTable.getValueAt(userTable.getSelectedRow(), 0).toString()), 
					usernametxt.getText().trim(), pwtxt.getText().trim());
			if(i==1) {
				JOptionPane.showMessageDialog(null, "保存成功!");
				reset();
				return;
			}
		}
	}
	//删除
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(userTable.getSelectedRow()==0) {
				JOptionPane.showMessageDialog(null, "请选择要删除的行!");
				return;
			}
			int i=new Conn().deleteUser(Integer.parseInt(userTable.getValueAt(userTable.getSelectedRow(), 0).toString()));
			if(i==1) {
				JOptionPane.showMessageDialog(null, "删除成功!");
				users=getUser(new Conn().selectUser());
				userTableMode.setDataVector(users, columns);
				userTable.setModel(userTableMode);
				reset();
				return;
			}
		}
	}
	//重置
	private void reset() {
		usernametxt.setText("");
		pwtxt.setText("");
	}
}