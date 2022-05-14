package _22_05_14_;

import java.util.Scanner;

public class BRN_TESTER {
	public static void main(String args[]) {
		BigRealNumber f = new BigRealNumber();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("정수를 입력 : ");
			f.factorial(input.nextInt());
			f.print();	
		}
	}
}
