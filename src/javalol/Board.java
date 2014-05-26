package javalol;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Board extends JFrame implements ActionListener{
	//전체  Frame 크기 지정
	private int width = 1200; //프레임의 가로길이
	private int height = 800; //프레임의 세로길이

	boolean finish = false; //게임이 끝났는지 안끝나는지 나타내는 불값. true가 되면 게임이 종료된다
	private int next = 1; //편의상 player를 숫자로 나타낸 것. player1 = 1, player = 2;
	private int dice_num = 0; //주사위 숫자값 저장하는 곳

	//Player 생성
	private Player p1 = new Player(1); //Player1
	private Player p2 = new Player(2); //Player2
	
	//TextArea에 출력되는 메세지
	String p1stat = p1.Name + "\nMoney: " + p1.money + "$\nHP: " + p1.health;
	String p2stat = p2.Name + "\nMoney: " + p2.money + "$\nHP: " + p2.health;
	String message = "여기에 게임 진행상황이 나타날 것입니다.";
	
	//이미지 배치할 좌표 지정해둔 정수형 배열.
	int places[][] = {
		{690, 670}, {610, 670}, {530, 670}, {450, 670}, {370, 670}, {290, 670}, {210, 670}, {130, 670}, {50, 670},//밑 가로줄 
		{50, 590}, {50, 510}, {50, 430}, {50, 350}, {50, 270}, {50, 190}, {50, 110}, {50, 30}, //왼쪽 세로줄 끝
		{130, 30}, {210, 30}, {290, 30}, {370, 30}, {450, 30}, {530, 30}, {610, 30}, {690, 30}, //위 가로줄 끝
		{690, 110}, {690, 190}, {690, 270}, {690, 350}, {690, 430}, {690, 510}, {690, 590} //오른쪽 세로줄 끝
	};
	
	ImageIcon imagetest[] = {
		new ImageIcon("images/white.jpeg"),
		new ImageIcon("images/Alistar.png"),
		new ImageIcon("images/Garen.png"),
		new ImageIcon("images/Zac.png"),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
		new ImageIcon(""),
	};
	
	ImageIcon image0 = new ImageIcon("images/white.jpeg"); //Start Position
	JLabel imageLabel0 = new JLabel(image0);
	ImageIcon image1 = new ImageIcon("images/Alistar.png");
	JLabel imageLabel1 = new JLabel(image1);
	ImageIcon image2 = new ImageIcon("images/Garen.png");
	JLabel imageLabel2 = new JLabel(image2);
	ImageIcon image3 = new ImageIcon("images/Zac.png");
	JLabel imageLabel3 = new JLabel(image3);
	ImageIcon image4 = new ImageIcon("images/white.jpeg"); //Chance Card
	JLabel imageLabel4 = new JLabel(image4);
	ImageIcon image5 = new ImageIcon("images/Heimerdinger.png");
	JLabel imageLabel5 = new JLabel(image5);
	ImageIcon image6 = new ImageIcon("images/Darius.png");
	JLabel imageLabel6 = new JLabel(image6);
	ImageIcon image7 = new ImageIcon("images/Caitlyn.png");
	JLabel imageLabel7 = new JLabel(image7);
	ImageIcon image8 = new ImageIcon("images/white.jpeg"); //Disconnect
	JLabel imageLabel8 = new JLabel(image8);
	//밑 가로줄 끝
	
	ImageIcon image10 = new ImageIcon("images/Ryze.png");
	JLabel imageLabel10 = new JLabel(image10);
	ImageIcon image11 = new ImageIcon("images/TwistedFate.png");
	JLabel imageLabel11 = new JLabel(image11);
	ImageIcon image12 = new ImageIcon("images/white.jpeg"); //Chance Card
	JLabel imageLabel12 = new JLabel(image12);
	ImageIcon image13 = new ImageIcon("images/Vladimir.png");
	JLabel imageLabel13 = new JLabel(image13);
	ImageIcon image14 = new ImageIcon("images/white.jpeg"); //Chance Card
	JLabel imageLabel14 = new JLabel(image14);
	ImageIcon image15 = new ImageIcon("images/Graves.png"); 
	JLabel imageLabel15 = new JLabel(image15);
	ImageIcon image16 = new ImageIcon("images/Lucian.png");
	JLabel imageLabel16 = new JLabel(image16);
	ImageIcon image17 = new ImageIcon("images/white.jpeg"); //Chance Card
	//왼쪽 새로줄 끝
	
	JLabel imageLabel17 = new JLabel(image17);
	ImageIcon image18 = new ImageIcon("images/Khazix.png");
	JLabel imageLabel18 = new JLabel(image18);
	ImageIcon image19 = new ImageIcon("images/Renekton.png");
	JLabel imageLabel19 = new JLabel(image19);
	ImageIcon image20 = new ImageIcon("images/white.jpeg"); //Chance Card
	JLabel imageLabel20 = new JLabel(image20);
	ImageIcon image21 = new ImageIcon("images/Lissandra.png");
	JLabel imageLabel21 = new JLabel(image21);
	ImageIcon image22 = new ImageIcon("images/Nidalee.png");
	JLabel imageLabel22 = new JLabel(image22);
	ImageIcon image23 = new ImageIcon("images/Velkoz.png");
	JLabel imageLabel23 = new JLabel(image23);
	ImageIcon image24 = new ImageIcon("images/Ahri.png");
	JLabel imageLabel24 = new JLabel(image24);
	ImageIcon image25 = new ImageIcon("images/white.jpeg"); //Chance Card
	//위 가로줄 끝
	
	JLabel imageLabel25 = new JLabel(image25);
	ImageIcon image26 = new ImageIcon("images/Brand.png");
	JLabel imageLabel26 = new JLabel(image26);
	ImageIcon image27 = new ImageIcon("images/Annie.png");
	JLabel imageLabel27 = new JLabel(image27);
	ImageIcon image28 = new ImageIcon("images/Syndra.png");
	JLabel imageLabel28 = new JLabel(image28);
	ImageIcon image29 = new ImageIcon("images/white.jpg"); //Chance Card
	JLabel imageLabel29 = new JLabel(image29);
	ImageIcon image30 = new ImageIcon("images/Katarina.png");
	JLabel imageLabel30 = new JLabel(image30);
	ImageIcon image31 = new ImageIcon("images/DrMundo.png");
	JLabel imageLabel31 = new JLabel(image31);
	ImageIcon image32 = new ImageIcon("images/Draven.png");
	JLabel imageLabel32 = new JLabel(image32);
	
	ImageIcon image33 = new ImageIcon("images/test.png");
	JLabel imageLabel33 = new JLabel(image33);
	
	ImageIcon[] image = {image1, image2};
	
	Graphics g;
	JButton dice, okbtn, yesbtn, nobtn;
	JTextArea p1status, p2status, text, d1, d2;
	Border border = BorderFactory.createLineBorder(Color.black);
	
	//Constructor method
	public Board(){
		setTitle("LOLBoardGame");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		
		//전반적인 레이아웃 짜는 부분
		for(int i = 0; i < 33; i++){
			for(int j = 0; j < 2; j++){
			}
		}
		
		createImage(imageLabel1, 690, 670);
		createImage(imageLabel2, 610, 670);
		createImage(imageLabel3, 530, 670);
		createImage(imageLabel4, 450, 670);
		createImage(imageLabel5, 370, 670);
		createImage(imageLabel6, 290, 670);
		createImage(imageLabel7, 210, 670);
		createImage(imageLabel8, 130, 670);
		//createImage(imageLabel9, 50, 670);
		createImage(imageLabel10, 50, 590);
		createImage(imageLabel11, 50, 510);
		createImage(imageLabel12, 50, 430);
		createImage(imageLabel13, 50, 350);
		createImage(imageLabel14, 50, 270);
		createImage(imageLabel15, 50, 190);
		createImage(imageLabel16, 50, 110);
		createImage(imageLabel17, 50, 30);
		createImage(imageLabel18, 130, 30);
		createImage(imageLabel19, 210, 30);
		createImage(imageLabel20, 290, 30);
		createImage(imageLabel21, 370, 30);
		createImage(imageLabel22, 450, 30);
		createImage(imageLabel23, 530, 30);
		createImage(imageLabel24, 610, 30);
		createImage(imageLabel25, 690, 30);
		createImage(imageLabel26, 690, 110);
		createImage(imageLabel27, 690, 190);
		createImage(imageLabel28, 690, 270);
		createImage(imageLabel29, 690, 350);
		createImage(imageLabel30, 690, 430);
		createImage(imageLabel31, 690, 510);
		createImage(imageLabel32, 690, 590);
		
		imageLabel33.setLocation(400, 400);
		imageLabel33.setSize(20, 20);
		add(imageLabel33);
		
		//버튼 부착
		dice = new JButton("ROLL_DICE");
		dice.setLocation(900, 500);
		dice.setSize(100, 30);
		add(dice);
		
		okbtn = new JButton("OK");
		okbtn.setLocation(1000, 500);
		okbtn.setSize(100, 30);
		add(okbtn);
		
		yesbtn = new JButton("YES");
		yesbtn.setLocation(900, 540);
		yesbtn.setSize(100, 30);
		add(yesbtn);
		
		nobtn = new JButton("NO");
		nobtn.setLocation(1000, 540);
		nobtn.setSize(100, 30);
		add(nobtn);
		
		dice.addActionListener(this);
		okbtn.addActionListener(this);
		yesbtn.addActionListener(this);
		nobtn.addActionListener(this);
		
		//TextArea
		p1status = new JTextArea();
		p1status.setText(p1stat);
		p1status.setBounds(870, 140, 125, 100);
		p1status.setBorder(border);
		p1status.setBackground(Color.YELLOW);
		p1status.setEditable(false);
		add(p1status);
		
		p2status = new JTextArea();
		p2status.setText(p2stat);
		p2status.setBounds(995, 140, 125, 100);
		p2status.setBorder(border);
		p2status.setBackground(Color.cyan);
		p2status.setEditable(false);
		add(p2status);
		
		text = new JTextArea();
		text.setText(message);
		text.setBounds(870, 240, 250, 250);
		text.setBorder(border);
		text.setEditable(false);
		add(text);
		
		//레이아웃 다짠 후에 패널 부착!
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		
		while(!finish){
			resetMessage();
			if(next == 1){
				text.append(p1.Name + "'s Turn! Roll the Dice! \n");
				text.append(dice_num + "!\n");
				p1.Move(dice_num);
				text.append(p1.alertLocation());
				break;
				//next = 2;
			}else{
				text.append(p2.Name + "'s Turn! Roll the Dice! \n");
			}
		}
	}//END of constructor
	
	
	//이미지 붙이는데 코드 줄이기 위한 메서드
	public void createImage(JLabel label, int xLocation, int yLocation){
		label.setLocation(xLocation, yLocation);
		label.setSize(80, 80);
		add(label);
	}
	
	//text창 초기화하기
	public void resetMessage(){
		text.setText("");
	}
	
	public int rollDice(){
		int total_dice = 0;
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		total_dice = dice1 + dice2;
		//g.fill3DRect(300, 300, 100, 100, true);
		//g.fill3DRect(300, 400, 100, 100, true);
		return total_dice;
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "ROLL_DICE"){
			dice_num = rollDice();
			text.append("" + dice_num + "!\n");
		} else if(e.getActionCommand() == "OK"){
			System.out.println("Ok");
		} else if(e.getActionCommand() == "YES"){
			System.out.println("Yes");
		} else{ 
			System.out.println("NO");
		}//END of if..else
		
	}
}