package s126.hello.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jboss.logging.Logger;

import s126.hello.bean.Account;
import s126.hello.dao.BaseDao;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivsInterceptor extends AbstractInterceptor {
	private static Logger log = Logger.getLogger(PrivsInterceptor.class);
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try{
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			Account acc = (Account) session.getAttribute("account");
			
			log.info("acc="+acc);
			log.info("acc == null:"+acc==null);
			// 没有登录，返回登录页面
			if(acc == null) {
				return "index";
			}
			// TODO ?AccType为空时异常结束
			int acctype = acc.getAcctype();
			String namespace = invocation.getProxy().getNamespace();
			String method = invocation.getProxy().getMethod();
			
			if (namespace.equalsIgnoreCase("/emp")) {
				
				// 没有权限，返回相关页面，比如登录页面。仅是一个示例。
				if(acctype != 2 && (method.equalsIgnoreCase("delete") || method.equalsIgnoreCase("update"))) {
					session.invalidate();
					return "index";
				}
				
			} else if (namespace.equalsIgnoreCase("/items")) {
				// my judge
			}
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return invocation.invoke();
	}

}
