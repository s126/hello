package s126.hello.bean;

import hibernate.helloworld.Author;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("unchecked")
public class AuthorTest {

	public static void main(String[] args) throws Exception {
		String mappingClass = "hibernate.helloworld.Author";
		Class<Author> c = (Class<Author>) Class.forName(mappingClass);

		Annotation as = c.getAnnotation(Entity.class);
		if (as != null) {
			System.out.println(c.getName() + " 是一个实体类");
		}

		for (Field f : c.getDeclaredFields()) {
			
			Id id = f.getAnnotation(Id.class);
			if (id != null) {
				System.out.println(f.getName() + " 是一个主键");
			}

			Column col = f.getAnnotation(Column.class);
			if (col != null) {
				System.out.println(f.getName() + " 对应的数据库中的字段名为:" + col.name());
				System.out.println(f.getName() + " 对应的数据库中的字段长度为:"
						+ col.length());
			}
		}

	}

}
