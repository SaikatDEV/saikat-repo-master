package oops_basic;

public class Car {
	
	String name;
	Engine e;
	
	public void start(){
		e= new Engine();
		e.startup();
		System.out.println("car starting");
	}

	public void stop(){
		System.out.println("car stopping");
	}
}
