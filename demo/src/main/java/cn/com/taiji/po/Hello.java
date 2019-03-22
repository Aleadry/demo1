package cn.com.taiji.po;

import org.springframework.beans.factory.annotation.Autowired;

public class Hello {

	private HelloWorld helloName;
	private SayHello helloAge;
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
	public Hello(HelloWorld helloName, SayHello helloAge) {
		super();
		this.helloName = helloName;
		this.helloAge = helloAge;
	}
	
}
