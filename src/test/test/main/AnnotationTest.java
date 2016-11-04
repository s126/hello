package test.main;

import java.lang.annotation.Annotation;

public class AnnotationTest implements Annotation{

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}

}
