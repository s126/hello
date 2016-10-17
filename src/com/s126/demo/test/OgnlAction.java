package com.s126.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.s126.demo.bean.Computer;
import com.s126.demo.bean.Student;

public class OgnlAction implements SessionAware {
	
	private Student xiaoyueyue;
	private String myname = "shuaige";
	private List<String> haha = new ArrayList<String>();
	
	private Map<String, Object> global_session = null;
	
	public String testOGNL () {
		
		xiaoyueyue = new Student("月神", 18);
		
		// 周强的电脑
		Computer comp = new Computer();
		comp.setType("Thinkpad");
		comp.setPrice(9998);
		// 电脑的名字
		List<String> alias = new ArrayList<String>();
		alias.add("小黑");
		alias.add("Mr.Black");
		alias.add("黑先生");
		comp.setAlias(alias);
		
		xiaoyueyue.setComp(comp);
		
		
		
		/**
		 * 想在 action 类中获取request,session等对象的方法有如下几种：
		 */
		// 第一种，从 ServletActionContext提供的静态方法获取。
		// 比如，ServletActionContext.getRequest() 得到的是一个原生的 HttpServletRequest 对象。得到后我们可以按照以前写 servlet 时候的写法处理这个对象。
		// 所以，如果想得到回话对象的话，那么如下代码：
		HttpSession s1 = ServletActionContext.getRequest().getSession();
		s1.setAttribute("flag1", "red");
		
		// struts 提供了另外一种封装，即把 session,request 等当做 Map 对象来处理，达到简化我们操作的目的。
		Map<String, Object> s2 = ActionContext.getContext().getSession();
		s2.put("flag2", "green");
		
		// 通过实现 SessionAware 接口，定义全局的 session 对象。
		global_session.put("flag3", "yellow");
		
		// 除了 session，其他的比如 request,parameters,response等对象可以进行同样的操作。
		((Map<String, Object>) ActionContext.getContext().get("request")).put("flag4", "blue");
		
		System.out.println("testOGNL");
		return "success";
	}
	
	
	
	/**
	 * OGNL，有三个主要的元素：表达式，root，content
	 * 表达式是其中的核心，也是我们着重要掌握的。
	 * @throws OgnlException 
	 */
	
	
	public static void main(String[] args) throws OgnlException {
		Student zhouqiang = new Student("周强", 17);
		
		// 周强的电脑
		Computer comp = new Computer();
		comp.setType("MacBook");
		comp.setPrice(8888);
		// 电脑的名字
		List<String> alias = new ArrayList<String>();
		alias.add("小黑");
		alias.add("Mr. Black");
		alias.add("黑先生");
		comp.setAlias(alias);
		
		
		for(String li: alias) {
			System.out.println(li);
		}
		
		
		zhouqiang.setComp(comp);
		
		
		// 获取周强的名字
		System.out.println(zhouqiang.getName());
		System.out.println(Ognl.getValue("name", zhouqiang));
		
		// 获取周强的电脑型号
		System.out.println(zhouqiang.getComp().getType());
		System.out.println(Ognl.getValue("comp.type", zhouqiang));
		
		// 获取周强的电脑型号的字符串长度
		System.out.println("我的电脑名字长度：" + zhouqiang.getComp().getType().length());
		System.out.println("我的电脑名字长度：" + Ognl.getValue("comp.type.length()", zhouqiang));
		
		// 获取周强的电脑的第二个名字
		System.out.println("我的电脑的名字：" + zhouqiang.getComp().getAlias().get(1)); 
		System.out.println("周强的电脑的第二个名字：" + Ognl.getValue("comp.alias[1]",zhouqiang));
		System.out.println("周强电脑名字的数目：" + Ognl.getValue("comp.alias.size()", zhouqiang));
		
		
		
		String a = "hello World";
		System.out.println(a.charAt(19));
	}



	public Student getXiaoyueyue() {
		return xiaoyueyue;
	}



	public void setXiaoyueyue(Student xiaoyueyue) {
		this.xiaoyueyue = xiaoyueyue;
	}



	public String getMyname() {
		return myname;
	}



	public void setMyname(String myname) {
		this.myname = myname;
	}



	public List<String> getHaha() {
		return haha;
	}



	public void setHaha(List<String> haha) {
		this.haha = haha;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		global_session = session;
	}
	
	
	
	
	

}
