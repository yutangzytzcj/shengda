/**
 * 商品信息管理
 */
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
import frame.UserEdit.tableListener;
import mode.ShangPinInfo;
public class ShangPin extends JInternalFrame{
	private JLabel id;
	private JLabel name;
	private JLabel colour;
	private JLabel type;
	private JLabel guige;
	private JLabel number;
	private JLabel max;
	private JLabel min;
	private JLabel price;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField colourtxt;
	private JTextField typetxt;
	private JTextField guigetxt;
	private JTextField numbertxt;
	private JTextField maxtxt;
	private JTextField mintxt;
	private JTextField pricetxt;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton reset;
	private JScrollPane js;
	private DefaultTableModel shangpinMode;
	private JTable shangpinTable;
	private String [] columns= {"商品编码","品名","颜色","类型","规格","库存数量","最高库存","最低数量","参考价格"};
	private Object [][] shangpins;
	private List shangpinlist;
	public ShangPin() {
		setTitle("商品信息管理");
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setBounds(100, 100, 581, 339);		
		Container container=getContentPane();
		container.setLayout(null);
		id=new JLabel("商品编码:");
		id.setBounds(20, 179, 70, 20);
		idtxt=new JTextField();
		
		idtxt.setBounds(87, 179, 70, 20);
		name=new JLabel("\u54C1    \u540D:");
		name.setBounds(186, 179, 70, 20);
		nametxt=new JTextField();
		nametxt.setBounds(249, 179, 70, 20);
		colour=new JLabel("\u989C    \u8272:");
		colour.setBounds(357, 179, 70, 20);
		colourtxt=new JTextField();
		colourtxt.setBounds(418, 179, 70, 20);
		type=new JLabel("\u7C7B    \u578B:");
		type.setBounds(20, 209, 70, 20);
		typetxt=new JTextField();
		typetxt.setBounds(87, 209, 70, 20);
		guige=new JLabel("\u89C4    \u683C:");
		guige.setBounds(186, 209, 70, 20);
		guigetxt=new JTextField();
		guigetxt.setBounds(249, 209, 70, 20);
		number=new JLabel("\u5E93    \u5B58:");
		number.setBounds(357, 209, 70, 20);
		numbertxt=new JTextField();
		numbertxt.setBounds(418, 209, 70, 20);
		max=new JLabel("最高库存:");
		max.setBounds(20, 239, 70, 20);
		maxtxt=new JTextField();
		maxtxt.setBounds(87, 239, 70, 20);
		min=new JLabel("最低库存:");
		min.setBounds(186, 239, 70, 20);
		mintxt=new JTextField();
		mintxt.setBounds(249, 239, 70, 20);
		price=new JLabel("参考价格:");
		price.setBounds(357, 239, 70, 20);
		pricetxt=new JTextField();
		pricetxt.setBounds(418, 239, 70, 20);
		add=new JButton("添加");
		add.addActionListener(new InsertListener());
		add.setBounds(87, 269, 70, 20);
		edit=new JButton("修改");
		edit.addActionListener(new saveListener());
		edit.setBounds(169, 269, 70, 20);
		delete=new JButton("删除");
		delete.addActionListener(new deleteListener());
		delete.setBounds(249, 269, 70, 20);
		reset=new JButton("重置");
		reset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		reset.setBounds(332, 269, 70, 20);
		js=new JScrollPane();
		container.add(id);
		container.add(idtxt);
		container.add(name);
		container.add(nametxt);
		container.add(colour);
		container.add(colourtxt);
		container.add(type);
		container.add(typetxt);
		container.add(guige);
		container.add(guigetxt);
		container.add(number);
		container.add(numbertxt);
		container.add(max);
		container.add(maxtxt);
		container.add(min);
		container.add(mintxt);
		container.add(price);
		container.add(pricetxt);
		container.add(add);
		container.add(edit);
		container.add(delete);
		container.add(reset);
		container.add(js);
		js.setLocation(10, 10);
		js.setSize(557,159);
		shangpins=getShangPin(new Conn().selectShangPin());
		shangpinMode=new DefaultTableModel(shangpins,columns);
		shangpinTable=new JTable(shangpinMode);
		shangpinTable.addMouseListener(new tableListener());
		js.setViewportView(shangpinTable);
	}
	//获取表格数据
	private Object[][] getShangPin(List list){
		Object[][] shangpins=new Object[list.size()][columns.length];
		for(int i=0;i<list.size();i++) {
			ShangPinInfo shangpin=(ShangPinInfo)list.get(i);
			shangpins[i][0]=shangpin.getId();
			shangpins[i][1]=shangpin.getName();
			shangpins[i][2]=shangpin.getColour();
			shangpins[i][3]=shangpin.getType();
			shangpins[i][4]=shangpin.getGuige();
			shangpins[i][5]=shangpin.getNumber();
			shangpins[i][6]=shangpin.getMaxnumber();
			shangpins[i][7]=shangpin.getMinnumber();
			shangpins[i][8]=shangpin.getPrice();
		}
		return shangpins;
	}
	//表格事件
	class tableListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int selRow = shangpinTable.getSelectedRow();
			idtxt.setText(shangpinTable.getValueAt(selRow,0).toString());
			nametxt.setText(shangpinTable.getValueAt(selRow,1).toString());
			colourtxt.setText(shangpinTable.getValueAt(selRow,2).toString());
			typetxt.setText(shangpinTable.getValueAt(selRow,3).toString());
			guigetxt.setText(shangpinTable.getValueAt(selRow,4).toString());
			numbertxt.setText(shangpinTable.getValueAt(selRow,5).toString());
			maxtxt.setText(shangpinTable.getValueAt(selRow,6).toString());
			mintxt.setText(shangpinTable.getValueAt(selRow,7).toString());
			pricetxt.setText(shangpinTable.getValueAt(selRow,8).toString());
		}
	}
	//添加
	class InsertListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			isEmpty();
			float price;
			if(Float.valueOf(pricetxt.getText().trim()).equals("")) {
				price=0.0f;
			}else {
				price=Float.valueOf(pricetxt.getText().trim());
			}			
			int i=new Conn().insertShangPin(idtxt.getText().trim(), nametxt.getText().trim(), colourtxt.getText().trim(),
			typetxt.getText().trim(), guigetxt.getText().trim(), Integer.valueOf(maxtxt.getText().trim()), Integer.valueOf(mintxt.getText().trim()),price);
			if(i==1) {
				JOptionPane.showMessageDialog(null, "添加成功!");
				shangpins=getShangPin(new Conn().selectShangPin());
				shangpinMode.setDataVector(shangpins, columns);
				shangpinTable.setModel(shangpinMode);
				reset();
				return;
			}
		}
	}
	//判空
	private void isEmpty() {
		if(idtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "商品编码不能为空!");
			return;
		}
		if(nametxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "品名不能为空!");
			return;
		}
		if(colourtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "颜色不能为空!");
			return;
		}
		if(typetxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "类型不能为空!");
			return;
		}
		if(guigetxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "规格不能为空!");
			return;
		}
		if(maxtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "最高库存不能为空!");
			return;
		}
		if(mintxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "最低库存不能为空!");
			return;
		}
	}
	//保存
	class saveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			isEmpty();
			int i=new Conn().updateShangPin(idtxt.getText().trim(),nametxt.getText().trim(), colourtxt.getText().trim(), typetxt.getText().trim(), guigetxt.getText().trim(),
			Integer.valueOf(maxtxt.getText().trim()), Integer.valueOf(mintxt.getText().trim()),Float.valueOf(pricetxt.getText().trim()));
			if(i==1) {
				JOptionPane.showMessageDialog(null, "保存成功!");
				shangpins=getShangPin(new Conn().selectShangPin());
				shangpinMode.setDataVector(shangpins, columns);
				shangpinTable.setModel(shangpinMode);
				reset();
				return;
			}
		}
	}
	//删除
		class deleteListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(idtxt.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "请选择要删除的行!");
					return;
				}
				int i=new Conn().deleteShangPin(idtxt.getText().trim());
				if(i==1) {
					JOptionPane.showMessageDialog(null, "删除成功!");
					shangpins=getShangPin(new Conn().selectShangPin());
					shangpinMode.setDataVector(shangpins, columns);
					shangpinTable.setModel(shangpinMode);
					reset();
					return;
				}
			}
		}
	//重置
	private void reset() {
		idtxt.setText("");
		nametxt.setText("");
		colourtxt.setText("");
		typetxt.setText("");
		guigetxt.setText("");
		numbertxt.setText("");
		maxtxt.setText("");
		mintxt.setText("");
		pricetxt.setText("");
	}
}