package _12_assignment;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame; 

public class myFrame {
	// �����ڸ� ȣ���ص� �ٷ� GUI â�� ������ �����߽��ϴ�.
	public myFrame() {
		// ���ο� JFrame frame�� ����ϴ�. Ÿ��Ʋ�� "Rectangle Moving"���� �մϴ�.
		JFrame frame = new JFrame("Rectangle Moving");
		// ����� ����*���� 400*400���� �����մϴ�. 
		frame.setSize(400,400);
		// ���̾ƿ��� absolute�� �����մϴ�.
		frame.setLayout(null);
		// GUIâ ���� �� ���α׷��� ���� ����ǵ��� �����մϴ�.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// GUIâ frame�� ����մϴ�. 
		frame.setVisible(true);
		// frame�� ���콺 �����ʸ� ����մϴ�. ���콺 ����͸� �̿��մϴ�.
		// �߻�Ŭ���� ���콺 ����͸� �͸�Ŭ������ �ۼ��մϴ�. 
		frame.addMouseListener(new MouseAdapter() {
			// �͸�Ŭ������ ����� Graphics g�� �����ϸ�, frame.getGraphics()�� �ʱ�ȭ�մϴ�.
			private Graphics g = frame.getGraphics();
			// ���콺 ����� Ŭ������ mousePressed �޼��带 �������̵��Ͽ� �����մϴ�.
			public void mousePressed(MouseEvent e) {
				// �� �޼���� frame ���� �÷��� �׸��� ����� �����Դϴ�.
				frame.paint(g);
				// g�� �̿��� �簢���� �׸��ϴ�. ���콺 Ŀ�� ���� �簢���� �߽��� �ǵ��� �����߽��ϴ�.
				g.drawRect(e.getX()-10, e.getY()-10, 20, 20);
			}
		});
	}
}
