package hibernate.helloworld;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table
public class Author {
	
	@Id
	@GeneratedValue
	private int aid;
	
	@Column
	private String name;
	private Date birth;

	@Transient
	private String luanqibazao;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getLuanqibazao() {
		return luanqibazao;
	}
	public void setLuanqibazao(String luanqibazao) {
		this.luanqibazao = luanqibazao;
	}

}
