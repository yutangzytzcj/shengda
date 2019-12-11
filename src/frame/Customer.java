package frame;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.Conn;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
public class Customer extends JInternalFrame {
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField personTxt;
	private JTextField addressTxt;
	private JFormattedTextField phoneTxt;
	/**
	 * Create the frame.
	 */
	public Customer() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 320, 246);
		setVisible(true);
		JLabel id = new JLabel("\u7F16\u53F7:");
		
		JLabel khname = new JLabel("\u5BA2\u6237\u540D\u79F0:");
		
		JLabel contacts = new JLabel("\u8054\u7CFB\u4EBA:");
		
		JLabel address = new JLabel("\u5730\u5740:");
		
		JLabel telephone = new JLabel("\u7535\u8BDD:");
		
		JButton addBut = new JButton("\u6DFB\u52A0");
		addBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKehu();
			}
		});
		addBut.setIcon(new ImageIcon(Customer.class.getResource("/res/icon/add.png")));
		
		JButton resetBut = new JButton("\u91CD\u7F6E");
		resetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBut.setIcon(new ImageIcon(Customer.class.getResource("/res/icon/reset.png")));
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		personTxt = new JTextField();
		personTxt.setColumns(10);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		
		phoneTxt = new JFormattedTextField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(khname)
						.addComponent(id)
						.addComponent(telephone)
						.addComponent(address))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addBut)
							.addGap(18)
							.addComponent(resetBut))
						.addComponent(addressTxt)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(contacts)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(personTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(phoneTxt)
						.addComponent(nameTxt))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(id)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(contacts)
						.addComponent(personTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(khname)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(address)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telephone)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBut)
						.addComponent(resetBut))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	//重置信息
	protected void reset() {
		idTxt.setText("");
		nameTxt.setText("");
		personTxt.setText("");
		addressTxt.setText("");
		phoneTxt.setText("");
	}
	//添加客户
	protected void addKehu() {
		if(idTxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "编号不能为空!");
			return;
		}
		if(nameTxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "姓名不能为空!");
			return;
		}
		if(personTxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "联系人不能为空!");
			return;
		}
		if(addressTxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "地址不能为空!");
			return;
		}
		if(phoneTxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "电话不能为空!");
			return;
		}
		if(phoneTxt.getText().length()!=11) {
			JOptionPane.showMessageDialog(null, "电话号必须是11位!");
			return;
		}
		int i=new Conn().insertKehu(idTxt.getText().trim(), nameTxt.getText().trim(), 
				personTxt.getText().trim(), addressTxt.getText().trim(), phoneTxt.getText().trim());
		if(i==1) {
			JOptionPane.showMessageDialog(null, "添加成功!");
			idTxt.setText("");
			nameTxt.setText("");
			personTxt.setText("");
			addressTxt.setText("");
			phoneTxt.setText("");
			return;
		}
	}
}
