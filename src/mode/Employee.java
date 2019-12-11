/**
 * 职工信息类
 */
package mode;

import java.sql.Date;

public class Employee {
	private int id;										//id
	private String name;								//姓名
	private String sex;									//性别
	private Date birthdate;								//出生日期
	private String job;									//职位
	private double salary;								//薪水
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
