package cn.com.taiji.po;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hello {

	@Autowired
	private HelloWorld helloName;
	@Autowired
	private SayHello helloAge;
	int a;
	public HelloWorld getHelloName() {
		return helloName;
	}
	public void setHelloName(HelloWorld helloName) {
		this.helloName = helloName;
	}
	public SayHello getHelloAge() {
		return helloAge;
	}
	public void setHelloAge(SayHello helloAge) {
		this.helloAge = helloAge;
	}
	public Hello() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hello(@Autowired HelloWorld helloName,@Autowired SayHello helloAge,int a) {
		super();
		this.helloName = helloName;
		this.helloAge = helloAge;
		this.a=a;
	}
	
}
