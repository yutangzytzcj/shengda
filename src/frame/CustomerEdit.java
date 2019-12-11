/**
 * 客户信息编辑
 */
package frame;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import dao.Conn;
import mode.Kehu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
public class CustomerEdit extends JInternalFrame {
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField personTxt;
	private JTextField addressTxt;
	private JTextField phoneTxt;
	private List kehuList;
	private JTable kehuTable;
	private DefaultTableModel kehuTableMode;
	private String [] header= {"编号","客户名称","联系人","地址","电话"};
	private Object [][] result;
	/**
	 * Create the frame.
	 */
	public CustomerEdit() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u4FEE\u6539\u4E0E\u5220\u9664");
		setBounds(100, 100, 478, 276);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7F16\u53F7:");
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u540D\u79F0:");
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u4EBA:");
		
		JLabel label_3 = new JLabel("\u5730\u5740:");
		
		JLabel label_4 = new JLabel("\u7535\u8BDD:");
		
		JButton saveBut = new JButton("\u4FEE\u6539");
		saveBut.setIcon(new ImageIcon(CustomerEdit.class.getResource("/res/icon/modify.png")));
		saveBut.addActionListener(new saveListener());
		
		JButton deleteBut = new JButton("\u5220\u9664");
		deleteBut.setIcon(new ImageIcon(CustomerEdit.class.getResource("/res/icon/delete.png")));
		deleteBut.addActionListener(new deleteListener());
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		personTxt = new JTextField();
		personTxt.setColumns(10);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(saveBut)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(deleteBut))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(addressTxt, Alignment.LEADING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(personTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
										.addComponent(phoneTxt, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))))
							.addGap(57))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(118))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(personTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveBut)
						.addComponent(deleteBut))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		Object [][] kehu=getKehu(new Conn().selectKehu());
		kehuTableMode=new DefaultTableModel(kehu, header);
		kehuTable=new JTable(kehuTableMode);
		kehuTable.addMouseListener(new tableListener());
		scrollPane.setViewportView(kehuTable);
	}
	//获取客户信息
	public Object [][] getKehu(List kehuList){
		Object [][] kehus=new Object [kehuList.size()][header.length];
		for(int i=0;i<kehuList.size();i++) {
			Kehu kehu=(Kehu)kehuList.get(i);
			kehus[i][0]=kehu.getId();
			kehus[i][1]=kehu.getName();
			kehus[i][2]=kehu.getPerson();
			kehus[i][3]=kehu.getAddress();
			kehus[i][4]=kehu.getPhone();
		}
		return kehus;
	}
	//table事件
	class tableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int selRow = kehuTable.getSelectedRow();
			idTxt.setText(kehuTable.getValueAt(selRow, 0).toString().trim());
			nameTxt.setText(kehuTable.getValueAt(selRow, 1).toString().trim());
			personTxt.setText(kehuTable.getValueAt(selRow, 2).toString().trim());
			addressTxt.setText(kehuTable.getValueAt(selRow, 3).toString().trim());
			phoneTxt.setText(kehuTable.getValueAt(selRow, 4).toString().trim());
		}
	}
	//保存事件
	class saveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nameTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "客户名称不能为空！");
				return;
			}
			if(personTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "联系人不能为空！");
				return;
			}
			if(addressTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "地址不能为空！");
				return;
			}
			if(phoneTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "电话不能为空！");
				return;
			}
			int i=new Conn().updateKehu(idTxt.getText(), nameTxt.getText().trim(),
			personTxt.getText().trim(), addressTxt.getText().trim(), phoneTxt.getText().trim());
			if(i==1) {
				JOptionPane.showMessageDialog(null, "保存成功！");
				Object [][] kehu=getKehu(new Conn().selectKehu());
				kehuTableMode.setDataVector(kehu, header);
				kehuTable.setModel(kehuTableMode);
				idTxt.setText("");
				nameTxt.setText("");
				personTxt.setText("");
				addressTxt.setText("");
				phoneTxt.setText("");
			}
		}
	}
	//删除事件
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(idTxt.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请选择要删除的行!");
				return;
			}
			int i=new Conn().deleteKehu(idTxt.getText().trim());
			if(i==1) {
				JOptionPane.showMessageDialog(null, "删除成功!");
				Object [][] kehu=getKehu(new Conn().selectKehu());
				kehuTableMode.setDataVector(kehu, header);
				kehuTable.setModel(kehuTableMode);
				idTxt.setText("");
				nameTxt.setText("");
				personTxt.setText("");
				addressTxt.setText("");
				phoneTxt.setText("");
			}
		}
	}
}
