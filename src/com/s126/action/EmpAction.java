package com.s126.action;

import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	
	/* 列出所有的 emp 成员 */
	public String listAll() {
		// 进行一系列的数据库操作，得到相应的结果。
		System.out.println("数据有很多，查询出问题。请等待。");
		return "listAll";
	}
	
	
	public int id;
	public String name;
	
	/* 删除某一个成员 */
	public String delete() {
		// 获取要身材人的相关编号，然后进行一系列的数据库操作。
		System.out.println("我的号码是：" + id);
		System.err.println("我们已经删除了。虽然是骗你的。");
		return "delete";
	}
	
	public String add(){
		System.out.println("添加数据");
		return "add";
	}
	
	public String update(){
		System.out.println("更新数据");
		return "update";
	}
	
	public String killbill () {
		System.out.println("我正在派出很多杀手，请等待他们完成任务。");
		return "listAll";
	}
}
