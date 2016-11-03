package s126.hello.bean;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

import test.main.Cat;


@Cat("asd")
public class Account {
//	GenerationType
//	@Id
//	@GenericGenerator
//	@GeneratedValue(strategy=GenerationType.AUTO,generator=)
//	@SequenceGenerator(name="aa",sequenceName=)
	private Integer accid;
	private String username;
	private String password;
	private Integer acctype; // 1, 学生； 2, 老师； 3, 校长
	private Date lastLogin; // 上次登录时间
	private Date birthday; // 生日
	private String email;
	private String phone;
	private Integer sex;

	@Override
	public String toString() {
		return "Account [accid=" + accid + ", username=" + username
				+ ", password=" + password + ", acctype=" + acctype
				+ ", lastLogin=" + lastLogin + ", birthday=" + birthday
				+ ", email=" + email + ", phone=" + phone + ", sex=" + sex
				+ "]";
	}



	public Integer getAccid() {
		return accid;
	}



	public void setAccid(Integer accid) {
		this.accid = accid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getAcctype() {
		return acctype;
	}



	public void setAcctype(Integer acctype) {
		this.acctype = acctype;
	}



	public Date getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Integer getSex() {
		return sex;
	}



	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
