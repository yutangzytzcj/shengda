package frame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("\u76DB\u8FBE\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7528\u6237\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/base.png")));
		menuBar.add(menu);
		
		JMenuItem addUser = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAdd userAdd=new UserAdd();
				desktopPane.add(userAdd);
			}
		});
		addUser.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/add.png")));
		menu.add(addUser);
		
		JMenuItem editUser = new JMenuItem("\u7528\u6237\u7F16\u8F91");
		editUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserEdit userEdit=new UserEdit();
				desktopPane.add(userEdit);
			}
		});
		editUser.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/modify.png")));
		menu.add(editUser);
		
		JMenu menu_8 = new JMenu("\u804C\u5DE5\u7BA1\u7406");
		menu_8.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u5458\u5DE5\u57FA\u672C\u4FE1\u606F.png")));
		menuBar.add(menu_8);
		
		JMenuItem zhigongAdd = new JMenuItem("\u804C\u5DE5\u6DFB\u52A0");
		zhigongAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeAdd empAdd=new EmployeeAdd();
				desktopPane.add(empAdd);
			}
		});
		zhigongAdd.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/add.png")));
		menu_8.add(zhigongAdd);
		
		JMenuItem zhigongEdit = new JMenuItem("\u804C\u5DE5\u7EF4\u62A4");
		zhigongEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeEdit empEdit=new EmployeeEdit();
				desktopPane.add(empEdit);
			}
		});
		zhigongEdit.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/modify.png")));
		menu_8.add(zhigongEdit);
		
		JMenu menu_3 = new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u5BA2\u6237\u57FA\u672C\u4FE1\u606F.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5BA2\u6237\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer coustomerAdd=new Customer();
				desktopPane.add(coustomerAdd);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/add.png")));
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5BA2\u6237\u7EF4\u62A4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerEdit customerEdit=new CustomerEdit();
				desktopPane.add(customerEdit);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/modify.png")));
		menu_3.add(menuItem_4);
		
		JMenu menu_7 = new JMenu("\u4F9B\u5E94\u5546\u7BA1\u7406");
		menu_7.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u4F9B\u5E94\u5546\u57FA\u672C\u4FE1\u606F.png")));
		menuBar.add(menu_7);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4F9B\u5E94\u5546\u6DFB\u52A0");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gongyingshang gys=new Gongyingshang();
				desktopPane.add(gys);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/add.png")));
		menu_7.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u4F9B\u5E94\u5546\u7EF4\u62A4");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GongyingshangEdit gysEdit=new GongyingshangEdit();
				desktopPane.add(gysEdit);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/modify.png")));
		menu_7.add(menuItem_8);
		
		JMenu menu_4 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u5546\u54C1\u57FA\u672C\u4FE1\u606F.png")));
		menuBar.add(menu_4);
		
		JMenuItem menuItem = new JMenuItem("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShangPin sp=new ShangPin();
				desktopPane.add(sp);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/edit.png")));
		menu_4.add(menuItem);
		
		JMenu menu_2 = new JMenu("\u5165\u5E93\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u91C7\u8D2D\u5165\u5E93.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5165\u5E93\u5355");
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u91C7\u8D2D\u5165\u5E93.png")));
		menu_2.add(menuItem_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5165\u5E93\u660E\u7EC6");
		menuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u9500\u552E\u7B7E\u5355.png")));
		menu_2.add(menuItem_5);
		
		JMenu menu_6 = new JMenu("\u51FA\u5E93\u7BA1\u7406");
		menu_6.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u9500\u552E\u51FA\u5E93.png")));
		menuBar.add(menu_6);
		
		JMenuItem menuItem_6 = new JMenuItem("\u51FA\u5E93\u5355");
		menuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u9500\u552E\u51FA\u5E93.png")));
		menu_6.add(menuItem_6);
		
		JMenuItem menuItem_9 = new JMenuItem("\u51FA\u5E93\u660E\u7EC6");
		menuItem_9.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/\u9500\u552E\u7B7E\u5355.png")));
		menu_6.add(menuItem_9);
		
		JMenu about = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		about.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/about.png")));
		menuBar.add(about);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about=new About();
				desktopPane.add(about);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/res/icon/me.png")));
		about.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setVisible(true);							                //设置窗体可见
		setResizable(false);							            //取消最大化窗体
		setSize(910, 606);							                //设置窗体大小
		desktopPane=new JDesktopPane();				                //创建桌面面板
		getContentPane().add(desktopPane, BorderLayout.CENTER);		//添加面板到窗体中央
		JLabel imgLabel=new JLabel();
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		URL url=MainFrame.class.getResource("/res/背景.jpg");			//获取图片的url
		Icon icon1=new ImageIcon(url);								//实例化Icon对象
		imgLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/res/\u80CC\u666F.jpg")));
		//设置标签的位置和大小
		imgLabel.setBounds(0, 0, 910,606);
		//把标签放到桌面面板的最底层		
		desktopPane.add(imgLabel, new Integer(Integer.MIN_VALUE));	
		setLocationRelativeTo(null);								//设置窗体居中显示
	}
}
