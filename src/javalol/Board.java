package javalol;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Board extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1015459599455368218L;
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
		{50, 590}, {50, 510}, {50, 430}, {50, 350}, {50, 270}, {50, 190}, {50, 110}, {50, 30}, //왼쪽 세로줄
		{130, 30}, {210, 30}, {290, 30}, {370, 30}, {450, 30}, {530, 30}, {610, 30}, {690, 30}, //위 가로줄
		{690, 110}, {690, 190}, {690, 270}, {690, 350}, {690, 430}, {690, 510}, {690, 590} //오른쪽 세로줄
	};
	
	//이미지를 저장해둔 배열.
	ImageIcon[] image = {
		//밑 가로줄(0~8)
		new ImageIcon("images/white.jpeg"), //Start Position
		new ImageIcon("images/Alistar.png"),
		new ImageIcon("images/Garen.png"),
		new ImageIcon("images/Zac.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		new ImageIcon("images/Heimerdinger.png"),
		new ImageIcon("images/Darius.png"),
		new ImageIcon("images/Caitlyn.png"),
		new ImageIcon("images/white.jpeg"), //Disconnect
		//왼쪽 세로줄(9~16)
		new ImageIcon("images/Ryze.png"),
		new ImageIcon("images/TwistedFate.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		new ImageIcon("images/Vladimir.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		new ImageIcon("images/Graves.png"),
		new ImageIcon("images/Lucian.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		//위 가로줄(19~24)
		new ImageIcon("images/Khazix.png"),
		new ImageIcon("images/Renekton.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		new ImageIcon("images/Lissandra.png"),
		new ImageIcon("images/Nidalee.png"),
		new ImageIcon("images/Velkoz.png"),
		new ImageIcon("images/Ahri.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		//오른쪽 세로줄(25~31)
		new ImageIcon("images/Brand.png"),
		new ImageIcon("images/Annie.png"),
		new ImageIcon("images/Syndra.png"),
		new ImageIcon("images/white.jpeg"), //Chance Card
		new ImageIcon("images/Katarina.png"),
		new ImageIcon("images/DrMundo.png"),
		new ImageIcon("images/Draven.png"),
	};
	
	//이미지를 감싸줄 레이블을 저장해둔 배열.
	JLabel[] imageLabel = { 
			new JLabel(image[0]), new JLabel(image[1]), new JLabel(image[2]), new JLabel(image[3]),
			new JLabel(image[4]), new JLabel(image[5]), new JLabel(image[6]), new JLabel(image[7]),
			new JLabel(image[8]), new JLabel(image[9]), new JLabel(image[10]), new JLabel(image[11]),
			new JLabel(image[12]), new JLabel(image[13]), new JLabel(image[14]), new JLabel(image[15]),
			new JLabel(image[16]), new JLabel(image[17]), new JLabel(image[18]), new JLabel(image[19]),
			new JLabel(image[20]), new JLabel(image[21]), new JLabel(image[22]), new JLabel(image[23]),
			new JLabel(image[24]), new JLabel(image[25]), new JLabel(image[26]), new JLabel(image[27]),
			new JLabel(image[28]), new JLabel(image[29]), new JLabel(image[30]), new JLabel(image[31])
	};
	
	ImageIcon image33 = new ImageIcon("images/test.png");
	JLabel imageLabel33 = new JLabel(image33);
	
	JButton dice, okbtn, yesbtn, nobtn;
	JTextArea p1status, p2status, text, d1, d2;
	Border border = BorderFactory.createLineBorder(Color.black);
	ButtonListener buttonListener;
	
	//Constructor method
	public Board(){
		setTitle("LOLBoardGame");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		
		//전반적인 레이아웃 짜는 부분
		for(int i = 0; i < 32; i++){
			createImage(imageLabel[i], places[i][0], places[i][1]);
		}
		
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