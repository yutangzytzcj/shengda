package frame;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

import dao.Conn;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.security.acl.Group;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
public class EmployeeAdd extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField birthDate;
	private ButtonGroup group;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	/**
	 * Create the frame.
	 */
	public EmployeeAdd() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		setClosable(true);
		setEnabled(false);
		setRootPaneCheckingEnabled(false);
		setIconifiable(true);
		setVisible(true);
		setTitle("\u804C\u5DE5\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 331, 234);
		setLocation(300, 100);
		JLabel label = new JLabel("\u59D3\u540D:");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u6027\u522B:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("\u51FA\u751F\u65E5\u671F:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("\u804C\u4F4D:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("\u85AA\u6C34:");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		birthDate = new JFormattedTextField();
		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");
		birthDate= new JFormattedTextField(myfmt.getDateInstance());
		JButton button = new JButton("\u6DFB\u52A0");
		button.setIcon(new ImageIcon(EmployeeAdd.class.getResource("/res/icon/add.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！");
					return;
				}
				if(birthDate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "出生日期请使用\"2007-05-10\"格式!");
					return;
				}
				if(textField_3.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "职位不能为空！");
					return;
				}
				if(textField_4.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "薪水不能为空！");
					return;
				}
				String sex="男";
				if(!radioButton.isSelected()){
					sex="女";}
				int i=new Conn().insertEmployeeInfo(textField_1.getText().trim(),sex.trim(),Date.valueOf(birthDate.getText().trim()), textField_3.getText().trim(), Double.valueOf(textField_4.getText().trim()));
				if(i==1){
					JOptionPane.showMessageDialog(null, "添加成功！");
					doDefaultCloseAction();
				}
			}
		});
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(EmployeeAdd.class.getResource("/res/icon/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				birthDate.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		
		radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		
		radioButton_1 = new JRadioButton("\u5973");
		group=new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(44)
							.addComponent(textField_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_5)
								.addComponent(label_4)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(birthDate)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(radioButton)
									.addGap(18)
									.addComponent(radioButton_1))
								.addComponent(textField_4)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(18)
									.addComponent(button_1)))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(birthDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(radioButton_1)
								.addComponent(radioButton))
							.addGap(27)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
