package s126.hello.service;

import java.util.List;

import s126.hello.bean.Emp;
import s126.hello.dao.EmpDao;

public class EmpService {

	private EmpDao empDao = new EmpDao();
	
//	public List<Emp> getAll() {
//		String sql = "select empno, ename, job, sal from Emp";
//		return empDao.query(Emp.class, sql);
//	}
//	
//	public List<Emp> getSome(String input) {
//		String cond = "%" + input + "%";
//		String sql = "select empno, ename, job, sal from Emp where upper(ename) like upper(?) or upper(job) like upper(?)";
//		return empDao.query(Emp.class, sql, cond, cond);
//	}
//
//	public boolean add(Emp emp) {
//		return empDao.execute(
//				"insert into emp (ename,job,sal) values (?, ?, ?)",
//				emp.getEname(), emp.getJob(), emp.getSal());
//	}
//
//	public boolean delete(int empno) {
//		String sql = "delete from Emp where empno=?";
//		return empDao.execute(sql, empno);
//	}
//
//	public List<Emp> getBySalRange(int min, int max) {
//		String sql = "select empno, ename, job, sal from Emp where sal>=? and sal<=?";
//		return empDao.query(Emp.class, sql, min, max);
//	}
//
//
	public List<String> getJobs() {
		return empDao.getJobs();
	}
	
	/**获取所有员工信息
	 * @return 数据库中所有的Emp对象集合
	 * */
	public List<Emp> getAll(){
		return empDao.getAll();
	}

	/**筛选；like搜索
	 * @return 符合条件的Emp对象集合
	 * */
	public List<Emp> getSome(String input){
		return empDao.getSome(input);
	}
	
	
	/**添加员工
	 * @return 是否成功 boolean
	 * */
	public boolean addEmp(Emp emp){
		return empDao.addEmp(emp);
	}
	
	
	/**删除员工
	 * @return 是否成功 boolean
	 * */
	public boolean deleteEmp(int empno){
		return empDao.deleteEmp(empno);
	}
	
	/**根据工资范围筛选
	 * @return 符合调剂按的Emp对象集合
	 * */
	public List<Emp> getBySalRange(int min, int max) {
		return empDao.getBySalRange(min, max);
	}
}
