package s126.hello.misc;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DateConverter;

@SuppressWarnings("rawtypes")
public class MyDateConverter extends DateConverter {

	// 实现我们自定义的转换
	// 实际上我们需要继承 StrutsTypeConverter，然后覆写里面的方法。DateConverter 是 struts 默认的日期转换器。
	// 自己的日期转换，请自行完成。
	@Override
	public Object convertValue(Map<String, Object> arg0, Object arg1, Member arg2, String arg3, Object arg4, Class arg5) {
		System.out.println(">>> MyDateConverter.");
		String[] values = (String[]) arg4;
		return super.convertValue(arg0, arg1, arg2, arg3, values[0], Date.class);
	}
	
}
