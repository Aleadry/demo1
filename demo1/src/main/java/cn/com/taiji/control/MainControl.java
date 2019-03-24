package cn.com.taiji.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.taiji.po.Hello;
import cn.com.taiji.po.HelloWorld;


public class MainControl {
	
	
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("cn.com.taiji.po");
		context.refresh();
		System.out.println("Bean的个数"+context.getBeanDefinitionCount());
		String[] names=context.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
			System.out.println(context.containsBeanDefinition(name));
		};
		System.out.println();
		context.close();
		ControlType con=new ControlType();
		HelloWorld hello=con.helloWorld();
		System.out.println(hello.toString());
		
	}
}
