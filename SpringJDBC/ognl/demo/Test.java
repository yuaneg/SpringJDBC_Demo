package demo;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Test {
	public static void main(String[] args) {
		OgnlContext context=new OgnlContext();
		Person person=new Person();
		Person person2=new Person();
		person2.setName("123213");
		person.setName("yuanenguang");
		context.put("Person", person);
		context.put("Person2", person2);
		context.setRoot(person);
		
		try {
			Object obj=	Ognl.getValue("Person2.name.length()",context);
			
			System.out.println(obj);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		
	}
	
}
