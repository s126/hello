package hibernate.OneToOne;
/**
 * @author D.O
 * @version 创建时间：2016年11月10日 下午2:45:53
 * 简单说明
 */
public class PersonId {
	private Integer id;
	private String nameCardId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameCardId() {
		return nameCardId;
	}
	public void setNameCardId(String nameCardId) {
		this.nameCardId = nameCardId;
	}
	@Override
	public String toString() {
		return "PersonId [id=" + id + ", nameCardId=" + nameCardId + "]";
	}
	public PersonId() {
		super();
	}
	public PersonId(String nameCardId) {
		super();
		this.nameCardId = nameCardId;
	}
}
