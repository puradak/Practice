package _12_assignment;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame; 

public class myFrame {
	// 생성자만 호출해도 바로 GUI 창이 열리게 구성했습니다.
	public myFrame() {
		// 새로운 JFrame frame을 만듭니다. 타이틀을 "Rectangle Moving"으로 합니다.
		JFrame frame = new JFrame("Rectangle Moving");
		// 사이즈를 가로*세로 400*400으로 설정합니다. 
		frame.setSize(400,400);
		// 레이아웃을 absolute로 변경합니다.
		frame.setLayout(null);
		// GUI창 종료 시 프로그램이 같이 종료되도록 설정합니다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// GUI창 frame을 출력합니다. 
		frame.setVisible(true);
		// frame에 마우스 리스너를 등록합니다. 마우스 어댑터를 이용합니다.
		// 추상클래스 마우스 어댑터를 익명클래스로 작성합니다. 
		frame.addMouseListener(new MouseAdapter() {
			// 익명클래스의 멤버로 Graphics g를 선언하며, frame.getGraphics()로 초기화합니다.
			private Graphics g = frame.getGraphics();
			// 마우스 어댑터 클래스의 mousePressed 메서드를 오버라이딩하여 정의합니다.
			public void mousePressed(MouseEvent e) {
				// 이 메서드는 frame 위에 올려진 그림을 지우는 역할입니다.
				frame.paint(g);
				// g를 이용해 사각형을 그립니다. 마우스 커서 팁이 사각형의 중심이 되도록 설정했습니다.
				g.drawRect(e.getX()-10, e.getY()-10, 20, 20);
			}
		});
	}
}
