package frame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import dao.Conn;
import frame.CustomerEdit.tableListener;
import mode.Gongyingshang;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Color;
public class GongyingshangEdit extends JInternalFrame {
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField personTxt;
	private JTextField addressTxt;
	private List gysList;
	private JTable gysTable;
	private DefaultTableModel gysTableMode;
	private String [] header= {"编号","厂商名称","联系人","地址"};
	/**
	 * Create the frame.
	 */
	public GongyingshangEdit() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4F9B\u5E94\u5546\u4FE1\u606F\u4FEE\u6539\u4E0E\u5220\u9664");
		setBounds(100, 100, 443, 283);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7F16 \u53F7:");
		
		JLabel label_1 = new JLabel("\u5382\u5546\u540D\u79F0:");
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u4EBA:");
		
		JLabel label_3 = new JLabel("\u5730\u5740:");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		personTxt = new JTextField();
		personTxt.setColumns(10);
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		
		JButton saveBut = new JButton("\u4FEE\u6539");
		saveBut.addActionListener(new saveListener());
		saveBut.setIcon(new ImageIcon(GongyingshangEdit.class.getResource("/res/icon/modify.png")));
		
		JButton deleteBut = new JButton("\u5220\u9664");
		deleteBut.addActionListener(new deleteListener());
		deleteBut.setIcon(new ImageIcon(GongyingshangEdit.class.getResource("/res/icon/delete.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(saveBut)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(deleteBut))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(personTxt, 0, 0, Short.MAX_VALUE)
												.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_3)
												.addComponent(label_1))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
												.addComponent(addressTxt, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(personTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveBut)
						.addComponent(deleteBut))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		Object [][] gys=getGongyingshang(new Conn().selectGongyingshang());
		gysTableMode=new DefaultTableModel(gys, header);
		gysTable=new JTable(gysTableMode);
		gysTable.addMouseListener(new tableListener());
		scrollPane.setViewportView(gysTable);
	}
	//获取供应商信息
	public Object[][] getGongyingshang(List gysList){
		Object [][] gongyingshangs=new Object [gysList.size()][header.length];
		for(int i=0;i<gysList.size();i++) {
			Gongyingshang gys=(Gongyingshang)gysList.get(i);
			gongyingshangs[i][0]=gys.getId();
			gongyingshangs[i][1]=gys.getName();
			gongyingshangs[i][2]=gys.getPerson();
			gongyingshangs[i][3]=gys.getAddress();
		}
		return gongyingshangs;
	}
	//table事件
	class tableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int selRow = gysTable.getSelectedRow();
			idTxt.setText(gysTable.getValueAt(selRow, 0).toString().trim());
			nameTxt.setText(gysTable.getValueAt(selRow, 1).toString().trim());
			personTxt.setText(gysTable.getValueAt(selRow, 2).toString().trim());
			addressTxt.setText(gysTable.getValueAt(selRow, 3).toString().trim());
		}
	}
	//保存事件
	class saveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nameTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "厂商名称不能为空！");
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
			int i=new Conn().updateGongyingshang(idTxt.getText().trim(),nameTxt.getText().trim(), personTxt.getText().trim(), 
					addressTxt.getText().trim());
			if(i==1) {
				JOptionPane.showMessageDialog(null, "保存成功！");
				Object [][] gys=getGongyingshang(new Conn().selectGongyingshang());
				gysTableMode.setDataVector(gys, header);
				gysTable.setModel(gysTableMode);
				reset();
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
			int i=new Conn().deleteGongyingshang(idTxt.getText().trim());
			if(i==1) {
				JOptionPane.showMessageDialog(null, "删除成功!");
				Object [][] gys=getGongyingshang(new Conn().selectGongyingshang());
				gysTableMode.setDataVector(gys, header);
				gysTable.setModel(gysTableMode);
				reset();
			}
		}
	}
	//重置事件
	private void reset() {
		idTxt.setText("");
		nameTxt.setText("");
		personTxt.setText("");
		addressTxt.setText("");
	}
}
