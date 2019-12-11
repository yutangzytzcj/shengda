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
public class Gongyingshang extends JInternalFrame{
	private JLabel id;
	private JLabel name;
	private JLabel person;
	private JLabel address;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField persontxt;
	private JTextField addresstxt;
	private JButton add;
	private JButton reset;
	public Gongyingshang() {
		super("供应商信息添加");
		setVisible(true);
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setClosable(true);
		setIconifiable(true);
		setRootPaneCheckingEnabled(false);
		Container container=getContentPane();
		container.setLayout(null);
		setBounds(100, 100, 300, 170);
		id=new JLabel("厂商编号:");
		id.setBounds(10, 10, 70, 20);
		name=new JLabel("厂商名称:");
		name.setBounds(10, 40, 70, 20);
		person=new JLabel("联系人:");
		person.setBounds(160, 10, 50, 20);
		address=new JLabel("地址:");
		address.setBounds(10, 70, 70, 20);

		idtxt=new JTextField();
		idtxt.setBounds(80, 10, 70, 20);

		nametxt=new JTextField();
		nametxt.setBounds(80, 40, 210, 20);
		persontxt=new JTextField();
		persontxt.setBounds(220, 10, 70, 20);
		addresstxt=new JTextField();
		addresstxt.setBounds(80, 70, 210, 20);
		add=new JButton("添加");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPerformed();
			}
		});
		add.setBounds(80, 100, 70, 20);
		reset=new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPerformed();
			}
		});
		reset.setBounds(170, 100, 70, 20);
		container.add(id);
		container.add(idtxt);
		container.add(person);
		container.add(persontxt);
		container.add(name);
		container.add(nametxt);
		container.add(address);
		container.add(addresstxt);
		container.add(add);
		container.add(reset);
	}
	//添加数据
	private void addPerformed() {
		if(idtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "厂商编号不能为空!");
			return;
		}
		if(persontxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "联系人不能为空!");
			return;
		}
		if(nametxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "厂商各称不能为空!");
			return;
		}
		if(addresstxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "地址不能为空!");
			return;
		}
		int i=new Conn().insertGongyingshang(idtxt.getText().trim(), nametxt.getText().trim(),
				persontxt.getText().trim(), addresstxt.getText().trim());
		if(i==1) {
			JOptionPane.showMessageDialog(null, "添加成功!");
			resetPerformed();
			return;
		}
	}
	//重置表单
	private void resetPerformed() {
		idtxt.setText("");
		persontxt.setText("");
		nametxt.setText("");
		addresstxt.setText("");
	}
}