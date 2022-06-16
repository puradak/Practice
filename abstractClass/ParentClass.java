package abstractClass;

public class ParentClass{
	public int number = 10;
	public ParentClass() {
		System.out.println("parent Class called");
	}
	
	public void introduce() {
		System.out.println("Hi, I'm object of Parent Class");
	}
	
	protected void test() {
		System.out.println("hi");
	}
}
