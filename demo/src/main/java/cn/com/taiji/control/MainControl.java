package cn.com.taiji.control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.po.HelloWorld;

public class MainControl {

	public static void main(String args[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:META-INF/application-context.xml");
		int count=context.getBeanDefinitionCount();
		System.out.println("Bean的个数"+count);
		String[] names=context.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
			System.out.println(context.containsBeanDefinition(name));
		};
	}
	public void start() {
		System.out.println("1111111111");
	}
}