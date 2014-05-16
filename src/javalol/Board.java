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
		ImageIcon image = new ImageIcon("images/brand.png");
		JLabel imageLabel = new JLabel(image);
		imageLabel.setLocation(5, 6);
		imageLabel.setSize(200, 200);
		add(imageLabel);
		
		//버튼 테스트해보았습니다
		JButton btn1 = new JButton("주사위굴리기");
		btn1.setLocation(6, 221);
		btn1.setSize(120, 30);
		add(btn1);
		
		//레이아웃 다짠 후에 패널 부착!
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		
		
	}
	
}
