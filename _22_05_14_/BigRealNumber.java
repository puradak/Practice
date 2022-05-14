package _22_05_14_;

public class BigRealNumber {
	private double fraction;
	private int power;
	
	public BigRealNumber() {
		fraction = 1.0;
		this.power = 0;
	}
	
	public void factorial(int number) {
		for(int i=1; i<=number; i++) {
			this.fraction *= getInfo(i,"f");
			this.power += (int)getInfo(i,"p");
			if(this.fraction >= 10) {
				this.fraction /= 10;
				this.power ++;
			}
		}
		return;
	}
	
	private double getInfo(int number, String type) {
		double fraction = number;
		double power = 0;
		while(fraction > 10) {
			fraction/=10;
			power ++;
		}
		if(type.equals("f")) return fraction;
		else return power;
	}
	
	public void print() {
		System.out.println(this.fraction+"E"+this.power);
	}
}
