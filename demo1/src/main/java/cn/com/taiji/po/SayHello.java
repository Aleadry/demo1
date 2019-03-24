package cn.com.taiji.po;

import org.springframework.stereotype.Component;

@Component
public class SayHello {
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SayHello [age=" + age + "]";
	}
	
}
