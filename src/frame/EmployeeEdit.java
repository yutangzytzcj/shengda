package frame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import dao.Conn;
import mode.Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
public class EmployeeEdit extends JInternalFrame{
	private String [] header= {"编号","姓名","性别","出生日期","职位","薪水"};
	private List <Employee>emplist;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField jobTxt;
	private JTextField salaryTxt;
	private JFormattedTextField dataTxt;
	private ButtonGroup group;
	private JRadioButton boy;
	private JRadioButton girl;
	private DefaultTableModel tableModel;
	public EmployeeEdit() {
		super("\u804C\u5DE5\u4FE1\u606F\u4FEE\u6539\u4E0E\u5220\u9664");
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setIconifiable(true);
		setSize(434, 303);
		setLocation(220, 100);
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		scrollPane = new JScrollPane();		
		JLabel lblId = new JLabel("\u7F16\u53F7:");
		lblId.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("\u59D3\u540D:");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u65E5\u671F:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u804C\u4F4D:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("\u85AA\u6C34:");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		jobTxt = new JTextField();
		jobTxt.setColumns(10);
		
		salaryTxt = new JTextField();
		salaryTxt.setColumns(10);
		
		JButton save = new JButton("\u4FEE\u6539");
		save.setIcon(new ImageIcon(EmployeeEdit.class.getResource("/res/icon/modify.png")));
		save.addActionListener(new saveaddListener());
		JButton delete = new JButton("\u5220\u9664");
		delete.setIcon(new ImageIcon(EmployeeEdit.class.getResource("/res/icon/delete.png")));
		delete.addActionListener(new deleteListener());
		boy = new JRadioButton("\u7537");
		boy.setSelected(true);
		
		girl = new JRadioButton("\u5973");
		group=new ButtonGroup();
		group.add(boy);
		group.add(girl);
		JLabel label_4 = new JLabel("\u6027\u522B:");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");
		dataTxt= new JFormattedTextField(myfmt.getDateInstance());

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(label)
								.addComponent(label_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(save)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(delete))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jobTxt, Alignment.LEADING)
										.addComponent(nameTxt, Alignment.LEADING)
										.addComponent(idTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_1)
										.addComponent(label_4))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(boy)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(girl))
								.addComponent(dataTxt, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(salaryTxt))))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(boy)
						.addComponent(girl))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(dataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(jobTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(salaryTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(save)
						.addComponent(delete))
					.addGap(126))
		);
		getContentPane().setLayout(groupLayout);		
		Object[][]results=getFileStates(new Conn().selectEmployee());
		tableModel=new DefaultTableModel(results, header);
		table=new JTable(tableModel);
		table.addMouseListener(new tableListener());
		scrollPane.setViewportView(table);
	}
	private Object[][] getFileStates(List emplist){
		Object[][]results=new Object[emplist.size()][header.length];
		for(int i=0;i<emplist.size();i++){
			Employee employee=(Employee)emplist.get(i);
			results[i][0]=employee.getId();
			results[i][1]=employee.getName();
			results[i][2]=employee.getSex();
            results[i][3]=employee.getBirthDate();
            results[i][4]=employee.getJob();
            results[i][5]=employee.getSalary();
		}
		return results;
	}
	//table事件
	class tableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int selRow = table.getSelectedRow();
			idTxt.setText(table.getValueAt(selRow, 0).toString().trim());
			nameTxt.setText(table.getValueAt(selRow, 1).toString().trim());
			if(table.getValueAt(selRow, 2).toString().trim().equals("男"))
				boy.setSelected(true);
			else
				girl.setSelected(true);
			dataTxt.setText(table.getValueAt(selRow, 3).toString().trim());
			jobTxt.setText(table.getValueAt(selRow, 4).toString().trim());
			salaryTxt.setText(table.getValueAt(selRow, 5).toString().trim());
		}
	}
	//修改职员信息
	class saveaddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nameTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "姓名不能为空！");
				return;
			}
			if(dataTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "出生日期请按2017-05-26此种格式输入!");
				return;
			}
			if(jobTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "职位不能为空！");
				return;
			}
			if(salaryTxt.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "薪水不能为空！");
				return;
			}
			String sex="男";
			if(!boy.isSelected()){
				sex="女";}
			
			int i=new Conn().updateEmployee(Integer.parseInt(idTxt.getText().trim()),nameTxt.getText().trim(),
			sex,Date.valueOf(dataTxt.getText().trim()),jobTxt.getText().trim(),Double.valueOf(salaryTxt.getText().trim()));
			if(i==1) {
				JOptionPane.showMessageDialog(null, "更新成功!");
				Object[][]results=getFileStates(new Conn().selectEmployee());
				idTxt.setText("");
				nameTxt.setText("");
				dataTxt.setText("");
				jobTxt.setText("");
				salaryTxt.setText("");
				tableModel.setDataVector(results, header);
				table.setModel(tableModel);
			}
		}
	}
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i=0;
			if(idTxt.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请选择要删除的行!");
				return;
			}
			i=new Conn().deleteEmployee(Integer.parseInt(idTxt.getText()));
			if(i==1) {
				JOptionPane.showMessageDialog(null, "删除成功!");
				Object[][]results=getFileStates(new Conn().selectEmployee());
				idTxt.setText("");
				nameTxt.setText("");
				dataTxt.setText("");
				jobTxt.setText("");
				salaryTxt.setText("");
				tableModel.setDataVector(results, header);
				table.setModel(tableModel);
			}
		}
	}
}