/**
 * ���ݿ����
 */
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mode.Employee;
import mode.Gongyingshang;
import mode.Kehu;
import mode.ShangPinInfo;
import mode.User;
public class Conn {
	private Connection connection=null;
	private Statement stmt;
	private PreparedStatement statement;
	private ResultSet res;
	private List list;
	//�������ݿ�����
	public Connection getConnection() {									
		String url="jdbc:mysql://localhost:3306/db_jxc?useSSL=false";
		String user="root";
		String password="123456";
		try {			
			Class.forName("com.mysql.jdbc.Driver");						//�������ݿ�����
			connection=DriverManager.getConnection(url,user,password);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	//����û�
	public int insertUser(String username,String password) {
		int i=0;
		try {
			String sql="insert into user(name,password) values(?,?)";
			statement=new Conn().getConnection().prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			i=statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//�û���ѯ
	public List selectUser() {
		String sql="select * from user";
		try {
			stmt=new Conn().getConnection().createStatement();
			res=stmt.executeQuery(sql);
			list=new ArrayList();
			while(res.next()) {
				User user=new User();
				user.setId(res.getInt("id"));
				user.setUserName(res.getString("name"));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//�û�����
	public int updateUser(int id,String name,String password) {
		int i=0;
		try {
			String sql="update user set name='"+name+"',password='"+password+"' where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//�û�ɾ��
	public int deleteUser(int id) {
		int i=0;
		try {
			String sql="delete from user where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ְ����Ϣ���
	public int insertEmployeeInfo(String name,String sex,Date birthdate,String job,double salary) {
		int i=0;
		try {
			String sql="insert into employee(name,sex,birthDate,job,salary)"
					+ "values(?,?,?,?,?)";
			statement=new Conn().getConnection().prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, sex);
			statement.setDate(3, birthdate);
			statement.setString(4, job);
			statement.setDouble(5, salary);
			i=statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ְ����Ϣ��ѯ
	public List selectEmployee() {
		String sql="select * from employee";
		try {
			stmt=new Conn().getConnection().createStatement();
			res=stmt.executeQuery(sql);
			list=new ArrayList();
			while(res.next()) {
				Employee employee=new Employee();				
				employee.setId(res.getInt("id"));
				employee.setName(res.getString("name"));
				employee.setSex(res.getString("sex"));
				employee.setBirthdate(res.getDate("birthDate"));
				employee.setJob(res.getString("job"));
				employee.setSalary(res.getDouble("salary"));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//ְ����Ϣ����
	public int updateEmployee(int id,String name,String sex,Date birthdate,String job,double salary) {
		int i=0;
		try {
			String sql="update employee set name='"+name+"',sex='"+sex+"',birthdate='"+birthdate+"',job='"+job+"',salary='"+salary+"' where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ְ����Ϣɾ��
	public int deleteEmployee(int id) {
		int i=0;
		String sql="delete from employee where id='"+id+"'";
		try {
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	//��ӿͻ���Ϣ
	public int insertKehu(String id,String name,String person,String address,String phone) {
		int i=0;
		try {
			String sql="insert into customer values(?,?,?,?,?)";
			statement=new Conn().getConnection().prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, person);
			statement.setString(4, address);
			statement.setString(5, phone);
			i=statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ�ͻ���Ϣ
	public List selectKehu() {
		try {
			String sql="select * from customer";
			stmt=new Conn().getConnection().createStatement();
			res=stmt.executeQuery(sql);
			list=new ArrayList();
			while(res.next()) {
				Kehu kehu=new Kehu();
				kehu.setId(res.getString("id"));
				kehu.setName(res.getString("khname"));
				kehu.setPerson(res.getString("Contacts"));
				kehu.setAddress(res.getString("address"));
				kehu.setPhone(res.getString("Telephone"));
				list.add(kehu);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//���¿ͻ���Ϣ
	public int updateKehu(String id,String name,String person,String address,String phone) {
		int i=0;
		try {
			String sql="update customer set khname='"+name+"',Contacts='"+person+"',"
					+ "address='"+address+"',Telephone='"+phone+"' where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ɾ���ͻ���Ϣ
	public int deleteKehu(String id) {
		int i=0;
		try {
			String sql="delete from customer where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//��ӹ�Ӧ����Ϣ
	public int insertGongyingshang(String id,String name,String person,String address) {
		int i=0;
		try {
			String sql="insert into supplier values(?,?,?,?)";
			statement=new Conn().getConnection().prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, person);
			statement.setString(4, address);
			i=statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ��Ӧ����Ϣ
	public List selectGongyingshang() {
		try {
			String sql="select * from supplier";
			stmt=new Conn().getConnection().createStatement();
			res=stmt.executeQuery(sql);
			list=new ArrayList();
			while(res.next()) {
				Gongyingshang gys=new Gongyingshang();
				gys.setId(res.getString("id"));
				gys.setName(res.getString("cxname"));
				gys.setPerson(res.getString("Contact"));
				gys.setAddress(res.getString("address"));
				list.add(gys);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//���¹�Ӧ����Ϣ
	public int updateGongyingshang(String id,String name,String person,String addres) {
		int i=0;
		try {
			String sql="update supplier set cxname='"+name+"',Contact='"+person+"',address='"+addres+"' where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ɾ����Ӧ����Ϣ
	public int deleteGongyingshang(String id) {
		int i=0;
		try {
			String sql="delete from supplier where id='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//�����Ʒ��Ϣ
	public int insertShangPin(String id,String name,String colour,String type,String guige,
			int maxnumber,int minnumber,float price) {
		int i=0;
		try {
			String sql="insert into shangpin(spId,spName,colour,type,guiGe,maxNumber,minNumber,price) values(?,?,?,?,?,?,?,?)";
			statement=new Conn().getConnection().prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, name);
			statement.setString(3, colour);
			statement.setString(4, type);
			statement.setString(5, guige);
			statement.setInt(6, maxnumber);
			statement.setInt(7, minnumber);
			statement.setFloat(8, price);
			i=statement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ��Ʒ��Ϣ
	public List selectShangPin() {
		try {
			String sql="select * from shangpin";
			stmt=new Conn().getConnection().createStatement();
			res=stmt.executeQuery(sql);
			list=new ArrayList();
			while(res.next()) {
				ShangPinInfo shangpin=new ShangPinInfo();
				shangpin.setId(res.getString("spId"));
				shangpin.setName(res.getString("spName"));
				shangpin.setColour(res.getString("colour"));
				shangpin.setType(res.getString("type"));
				shangpin.setGuige(res.getString("guiGe"));
				shangpin.setNumber(res.getInt("number"));
				shangpin.setMaxnumber(res.getInt("maxNumber"));
				shangpin.setMinnumber(res.getInt("minNumber"));
				shangpin.setPrice(res.getFloat("price"));
				list.add(shangpin);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//������Ʒ��Ϣ
	public int updateShangPin(String id,String name,String colour,String type,String guige,
			int max,int min,float price) {
		int i=0;
		try {
			String sql="update shangpin set spName='"+name+"',spName='"+name+"',colour='"+colour+"',type='"+type+"'"
					+ ",guiGe='"+guige+"',maxNumber='"+max+"',minNumber='"+min+"',price='"+price+"' where spId='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//ɾ����Ʒ��Ϣ
	public int deleteShangPin(String id) {
		int i=0;
		try {
			String sql="delete from shangpin where spId='"+id+"'";
			stmt=new Conn().getConnection().createStatement();
			i=stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
