package com.s126.action;

import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	
	/* �г����е� emp ��Ա */
	public String listAll() {
		// ����һϵ�е����ݿ�������õ���Ӧ�Ľ����
		System.out.println("�����кܶ࣬��ѯ�����⡣��ȴ���");
		return "listAll";
	}
	
	
	public int id;
	public String name;
	
	/* ɾ��ĳһ����Ա */
	public String delete() {
		// ��ȡҪ����˵���ر�ţ�Ȼ�����һϵ�е����ݿ������
		System.out.println("�ҵĺ����ǣ�" + id);
		System.err.println("�����Ѿ�ɾ���ˡ���Ȼ��ƭ��ġ�");
		return "delete";
	}
	
	public String add(){
		System.out.println("�������");
		return "add";
	}
	
	public String update(){
		System.out.println("��������");
		return "update";
	}
	
	public String killbill () {
		System.out.println("�������ɳ��ܶ�ɱ�֣���ȴ������������");
		return "listAll";
	}
}
