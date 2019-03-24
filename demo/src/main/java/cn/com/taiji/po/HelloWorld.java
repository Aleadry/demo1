package cn.com.taiji.po;

public class HelloWorld {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + name + "]";
	}
	public void start() {
		System.out.println("1111111111");
	}
	
	public void destory() {
		System.out.println("2222222222");
	}
}
