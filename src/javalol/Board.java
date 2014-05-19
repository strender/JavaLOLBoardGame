package javalol;

import java.awt.*;
import javax.swing.*;

public class Board extends JFrame{
	private int width = 1200;
	private int height = 800;
	
	//Constructor method
	public Board(){
		setTitle("LOLBoardGame");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		
		//전반적인 레이아웃 짜는 부분
		ImageIcon image1 = new ImageIcon("images/brand.png");
		JLabel imageLabel1 = new JLabel(image1);
		imageLabel1.setLocation(10, 10);
		imageLabel1.setSize(100, 100);
		add(imageLabel1);
		
		ImageIcon image2 = new ImageIcon("images/Ahri.png");
		JLabel imageLabel2 = new JLabel(image2);
		imageLabel2.setLocation(110, 10);
		imageLabel2.setSize(100, 100);
		add(imageLabel2);
		
		ImageIcon image3 = new ImageIcon("images/Khazix.png");
		JLabel imageLabel3 = new JLabel(image3);
		imageLabel3.setLocation(10, 110);
		imageLabel3.setSize(100, 100);
		add(imageLabel3);
		
		
		//버튼 테스트해보았습니다
		JButton btn1 = new JButton("주사위굴리기");
		btn1.setLocation(6, 600);
		btn1.setSize(120, 30);
		add(btn1);
		
		//레이아웃 다짠 후에 패널 부착!
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		
		
	}
	
}
