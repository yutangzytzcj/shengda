/**
 * ��Ʒ��Ϣ����
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
	private String [] columns= {"��Ʒ����","Ʒ��","��ɫ","����","���","�������","��߿��","�������","�ο��۸�"};
	private Object [][] shangpins;
	private List shangpinlist;
	public ShangPin() {
		setTitle("��Ʒ��Ϣ����");
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setBounds(100, 100, 581, 339);		
		Container container=getContentPane();
		container.setLayout(null);
		id=new JLabel("��Ʒ����:");
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
		max=new JLabel("��߿��:");
		max.setBounds(20, 239, 70, 20);
		maxtxt=new JTextField();
		maxtxt.setBounds(87, 239, 70, 20);
		min=new JLabel("��Ϳ��:");
		min.setBounds(186, 239, 70, 20);
		mintxt=new JTextField();
		mintxt.setBounds(249, 239, 70, 20);
		price=new JLabel("�ο��۸�:");
		price.setBounds(357, 239, 70, 20);
		pricetxt=new JTextField();
		pricetxt.setBounds(418, 239, 70, 20);
		add=new JButton("���");
		add.addActionListener(new InsertListener());
		add.setBounds(87, 269, 70, 20);
		edit=new JButton("�޸�");
		edit.addActionListener(new saveListener());
		edit.setBounds(169, 269, 70, 20);
		delete=new JButton("ɾ��");
		delete.addActionListener(new deleteListener());
		delete.setBounds(249, 269, 70, 20);
		reset=new JButton("����");
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
	//��ȡ�������
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
	//����¼�
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
	//���
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
				JOptionPane.showMessageDialog(null, "��ӳɹ�!");
				shangpins=getShangPin(new Conn().selectShangPin());
				shangpinMode.setDataVector(shangpins, columns);
				shangpinTable.setModel(shangpinMode);
				reset();
				return;
			}
		}
	}
	//�п�
	private void isEmpty() {
		if(idtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "��Ʒ���벻��Ϊ��!");
			return;
		}
		if(nametxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "Ʒ������Ϊ��!");
			return;
		}
		if(colourtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "��ɫ����Ϊ��!");
			return;
		}
		if(typetxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "���Ͳ���Ϊ��!");
			return;
		}
		if(guigetxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "�����Ϊ��!");
			return;
		}
		if(maxtxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "��߿�治��Ϊ��!");
			return;
		}
		if(mintxt.getText().length()==0) {
			JOptionPane.showMessageDialog(null, "��Ϳ�治��Ϊ��!");
			return;
		}
	}
	//����
	class saveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			isEmpty();
			int i=new Conn().updateShangPin(idtxt.getText().trim(),nametxt.getText().trim(), colourtxt.getText().trim(), typetxt.getText().trim(), guigetxt.getText().trim(),
			Integer.valueOf(maxtxt.getText().trim()), Integer.valueOf(mintxt.getText().trim()),Float.valueOf(pricetxt.getText().trim()));
			if(i==1) {
				JOptionPane.showMessageDialog(null, "����ɹ�!");
				shangpins=getShangPin(new Conn().selectShangPin());
				shangpinMode.setDataVector(shangpins, columns);
				shangpinTable.setModel(shangpinMode);
				reset();
				return;
			}
		}
	}
	//ɾ��
		class deleteListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(idtxt.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������!");
					return;
				}
				int i=new Conn().deleteShangPin(idtxt.getText().trim());
				if(i==1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
					shangpins=getShangPin(new Conn().selectShangPin());
					shangpinMode.setDataVector(shangpins, columns);
					shangpinTable.setModel(shangpinMode);
					reset();
					return;
				}
			}
		}
	//����
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