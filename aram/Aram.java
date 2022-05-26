package aram;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Aram {

	private static JFrame frmAramToday;
	
	public static void main(String[] args) throws IOException {
		frmAramToday = new JFrame();
		frmAramToday.setTitle("Aram Today");
		frmAramToday.getContentPane().setBackground(Color.WHITE);
		frmAramToday.setBounds(100, 100, 801, 500);
		frmAramToday.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAramToday.getContentPane().setLayout(null);
		
		JLabel date = new JLabel("New label");
		date.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		date.setBounds(12, 10, 410, 36);
		frmAramToday.getContentPane().add(date);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 51, 761, 400);
		frmAramToday.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel date_1 = new JLabel("\uC544\uCE68");
		date_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		date_1.setBounds(0, 0, 40, 24);
		panel.add(date_1);
		
		JLabel date_1_1 = new JLabel("\uC810\uC2EC");
		date_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		date_1_1.setBounds(0, 134, 40, 24);
		panel.add(date_1_1);
		
		JLabel date_1_1_1 = new JLabel("\uC800\uB141");
		date_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		date_1_1_1.setBounds(0, 268, 40, 24);
		panel.add(date_1_1_1);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(0, 24, 761, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel breakfast1 = new JLabel("1");
		breakfast1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		breakfast1.setBounds(12, 10, 737, 20);
		panel_1.add(breakfast1);
		
		JLabel breakfast1_1 = new JLabel("2");
		breakfast1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		breakfast1_1.setBounds(12, 30, 737, 20);
		panel_1.add(breakfast1_1);
		
		JLabel breakfast1_1_1 = new JLabel("3");
		breakfast1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		breakfast1_1_1.setBounds(12, 50, 737, 20);
		panel_1.add(breakfast1_1_1);
		
		JLabel breakfast1_1_1_1 = new JLabel("3");
		breakfast1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		breakfast1_1_1_1.setBounds(12, 70, 737, 20);
		panel_1.add(breakfast1_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(240, 248, 255));
		panel_1_1.setBounds(0, 158, 761, 100);
		panel.add(panel_1_1);
		
		JLabel lunch0;
		lunch0 = new JLabel("");
		lunch0.setBounds(12, 10, 737, 20);
		panel_1_1.add(lunch0);
		
		JLabel lunch1 = new JLabel("");
		lunch1.setBounds(12, 40, 737, 20);
		panel_1_1.add(lunch1);
		
		JLabel lunch2 = new JLabel("");
		lunch2.setBounds(12, 70, 737, 20);
		panel_1_1.add(lunch2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(240, 248, 255));
		panel_1_2.setBounds(0, 290, 761, 100);
		panel.add(panel_1_2);
		
		JLabel dinner1 = new JLabel("");
		dinner1.setBounds(12, 10, 737, 20);
		panel_1_2.add(dinner1);
		
		JLabel dinner2 = new JLabel("");
		dinner2.setBounds(12, 40, 737, 20);
		panel_1_2.add(dinner2);
		
		JLabel dinner3 = new JLabel("");
		dinner3.setBounds(12, 70, 737, 20);
		panel_1_2.add(dinner3);
		
		JLabel[][] label ={ {breakfast1,breakfast1_1,breakfast1_1_1,breakfast1_1_1_1},{lunch0, lunch1, lunch2} ,{ dinner1, dinner2, dinner3}};
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<label[i].length; j++) {
				label[i][j].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			}
		}
		Calendar c = Calendar.getInstance();
		String url = "https://www.gnu.ac.kr/dorm/ad/fm/foodmenu/selectFoodMenuView.do?mi=7278";
		Document html = Jsoup.connect(url).get();
		Elements e1 = html.getElementsByAttributeValue("scope", "row");
		int[] day = {0,7,1,2,3,4,5,6};
		for(int i=0; i<day[c.get(Calendar.DAY_OF_WEEK)]; i++) {
			e1 = e1.next();
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<label[i].length; j++) {
				try{
					if(e1.get(i).getElementsByTag("div").get(j).text().contains("°øÁö")) {
						label[i][j].setText("");
						continue;
					}
					label[i][j].setText(e1.get(i).getElementsByTag("div").get(j).text());
				} catch ( IndexOutOfBoundsException e )
				{
					break;
				}
			}
		}
		
		
		date.setText(new SimpleDateFormat("yyyy").format(new Date())+"³â "+new SimpleDateFormat("MM").format(new Date())+"¿ù "+new SimpleDateFormat("dd").format(new Date())+"ÀÏ "+new SimpleDateFormat("E").format(new Date())+"¿äÀÏÀÇ ½Ä´ÜÇ¥");
		
		JButton btnNewButton = new JButton("\uC2DC\uAC04\uD45C \uBCF4\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timeTable();
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btnNewButton.setFocusable(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setIconTextGap(0);
		btnNewButton.setActionCommand("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setBounds(359, 11, 123, 35);
		frmAramToday.getContentPane().add(btnNewButton);
		frmAramToday.setVisible(true);
	}
	
	public static void timeTable() {
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(60, 34, 200, 70);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("07:30 ~ 09:00");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(33, -2, 134, 27);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\uD14C\uC774\uD06C\uC544\uC6C3");
		lblNewLabel_4.setBounds(68, 30, 72, 15);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("08:30 ~ 09:30");
		lblNewLabel_2_1.setBounds(33, 38, 134, 27);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(240, 248, 255));
		panel_2_1.setBounds(272, 34, 200, 70);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("08:00 ~ 09:00");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(33, 15, 134, 27);
		panel_2_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uD14C\uC774\uD06C\uC544\uC6C3 \uBBF8\uC6B4\uC601");
		lblNewLabel_4_1.setForeground(Color.RED);
		lblNewLabel_4_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(48, 45, 100, 17);
		panel_2_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uC911");
		lblNewLabel.setPreferredSize(new Dimension(24, 20));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 10, 200, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uB9D0 / \uACF5\uD734\uC77C");
		lblNewLabel_1.setPreferredSize(new Dimension(57, 20));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(272, 10, 200, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(240, 248, 255));
		panel_2_2.setBounds(60, 114, 200, 70);
		frame.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("11:30 ~ 13:30");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(33, 21, 134, 27);
		panel_2_2.add(lblNewLabel_2_2_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(240, 248, 255));
		panel_2_1_1.setBounds(272, 114, 200, 70);
		frame.getContentPane().add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("12:00 ~ 13:30");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2_2_1_1.setBounds(33, 21, 134, 27);
		panel_2_1_1.add(lblNewLabel_2_2_1_1);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(new Color(240, 248, 255));
		panel_2_3.setBounds(60, 194, 200, 70);
		frame.getContentPane().add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("17:30 ~ 19:00");
		lblNewLabel_2_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2_2_1_2.setBounds(33, 21, 134, 27);
		panel_2_3.add(lblNewLabel_2_2_1_2);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setBackground(new Color(240, 248, 255));
		panel_2_1_2.setBounds(272, 194, 200, 70);
		frame.getContentPane().add(panel_2_1_2);
		panel_2_1_2.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_3 = new JLabel("17:30 ~ 18:40");
		lblNewLabel_2_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_2_2_1_3.setBounds(33, 21, 134, 27);
		panel_2_1_2.add(lblNewLabel_2_2_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uCE68");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(240, 248, 255));
		lblNewLabel_3.setBounds(5, 34, 50, 70);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uC810\uC2EC");
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_3_1.setBounds(5, 114, 50, 70);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("\uC800\uB141");
		lblNewLabel_3_2.setOpaque(true);
		lblNewLabel_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBackground(new Color(240, 248, 255));
		lblNewLabel_3_2.setBounds(5, 194, 50, 70);
		frame.getContentPane().add(lblNewLabel_3_2);
		frame.setBackground(new Color(255, 255, 255));
		frame.setType(Type.UTILITY);
		frame.setTitle("\uC2DC\uAC04\uD45C");
		frame.setBounds(100, 100, 500, 310);
		 
		frame.setVisible(true);
	}
	
}
