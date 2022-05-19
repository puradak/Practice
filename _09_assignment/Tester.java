package _09_assignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tester implements Serializable{
	private static final long serialVersionUID = -6555617001086707012L;

	public static void main(String[] args) {
		int count = 0;
		Scanner input = new Scanner(System.in);
		SimpleDateFormat type = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("문장들을 입력하세요.");
		try {
			FileOutputStream out = new FileOutputStream("sentences.txt");
			String str="";
			while(true) {
				count ++;
				System.out.print(count + ". ");
				str = input.nextLine();
				out.write((type.format(new Date())+"\t"+ str +"\n").getBytes());
				if(str.toLowerCase().equals("exit")) break;
			}
			out.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		  
		input.close();
	}

}
