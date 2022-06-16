package abstractClass;

public class ChildClass extends myClass implements MyInterface{
	ChildClass(){
		super();
		System.out.println("child class called");
	}
	@Override
	public void introduce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void hi() {
		System.out.println("zz");
	}

	@Override
	public void testF() {
		// TODO Auto-generated method stub
		
	}

}
