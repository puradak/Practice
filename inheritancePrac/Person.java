package inheritancePrac;

public class Person implements InterfaceA{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	
	public void sayHi() {
		System.out.println(this.name + " : hi");
	}
}
