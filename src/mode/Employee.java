/**
 * ְ����Ϣ��
 */
package mode;

import java.sql.Date;

public class Employee {
	private int id;										//id
	private String name;								//����
	private String sex;									//�Ա�
	private Date birthdate;								//��������
	private String job;									//ְλ
	private double salary;								//нˮ
	public void setId(int id) {
		this.id=id;
	} 
	public void setName(String name) {
		this.name=name;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate=birthdate;
	}
	public void setJob(String job) {
		this.job=job;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getSex() {
		return this.sex;
	}
	public Date getBirthDate() {
		return this.birthdate;
	}
	public String getJob() {
		return this.job;
	}
	public double getSalary() {
		return this.salary;
	}
}
