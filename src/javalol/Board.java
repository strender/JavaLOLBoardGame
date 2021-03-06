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
	String message = "Game Start! \n";
	
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
		new ImageIcon("images/Start.jpeg"), //Start Position
		new ImageIcon("images/Alistar.png"),
		new ImageIcon("images/Garen.png"),
		new ImageIcon("images/Zac.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		new ImageIcon("images/Heimerdinger.png"),
		new ImageIcon("images/Darius.png"),
		new ImageIcon("images/Caitlyn.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Disconnect
		//왼쪽 세로줄(9~16)
		new ImageIcon("images/Ryze.png"),
		new ImageIcon("images/TwistedFate.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		new ImageIcon("images/Vladimir.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		new ImageIcon("images/Graves.png"),
		new ImageIcon("images/Lucian.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		//위 가로줄(19~24)
		new ImageIcon("images/Khazix.png"),
		new ImageIcon("images/Renekton.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		new ImageIcon("images/Lissandra.png"),
		new ImageIcon("images/Nidalee.png"),
		new ImageIcon("images/Velkoz.png"),
		new ImageIcon("images/Ahri.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
		//오른쪽 세로줄(25~31)
		new ImageIcon("images/Brand.png"),
		new ImageIcon("images/Annie.png"),
		new ImageIcon("images/Syndra.png"),
		new ImageIcon("images/Chancecard.jpeg"), //Chance Card
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
	
	ImageIcon p1token = new ImageIcon("images/p1token.jpg");
	JLabel p1tokenLabel = new JLabel(p1token);
	ImageIcon p2token = new ImageIcon("images/p2token.jpg");
	JLabel p2tokenLabel = new JLabel(p2token);
	
	JButton dice, okbtn, yesbtn, nobtn;
	JTextArea p1status, p2status, text, d1, d2;
	Border border = BorderFactory.createLineBorder(Color.black);
	ButtonListener buttonListener;
	
	PHManager phm = new PHManager(p1, p2);
	
	//Constructor method
	public Board(){
		setTitle("LOLBoardGame");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		//전반적인 레이아웃 짜는 부분
		p1tokenLabel.setLocation(places[0][0] + 10, places[0][1] + 10);
		p1tokenLabel.setSize(20, 20);
		add(p1tokenLabel);
		
		p2tokenLabel.setLocation(places[0][0] + 50, places[0][1] + 50);
		p2tokenLabel.setSize(20, 20);
		add(p2tokenLabel);
		
		drawBoard();
		
		//버튼 부착
		dice = new JButton("ROLL_DICE");
		dice.setLocation(900, 500);
		dice.setSize(100, 30);
		add(dice);
		
		okbtn = new JButton("BUY");
		okbtn.setLocation(1000, 500);
		okbtn.setSize(100, 30);
		add(okbtn);
		
		nobtn = new JButton("END TURN");
		nobtn.setLocation(900, 540);
		nobtn.setSize(200, 30);
		add(nobtn);
		
		dice.addActionListener(this);
		okbtn.addActionListener(this);
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
	
	}//END of constructor
	
	
	
	//이미지 붙이는데 코드 줄이기 위한 메서드
	public void createImage(JLabel label, int xLocation, int yLocation){
		label.setLocation(xLocation, yLocation);
		label.setSize(80, 80);
		add(label);
	}
	
	//말을 움직이는데 필요한 메서드
	public void redrawToken(JLabel token, Player p){
		p.Move(dice_num);
		if(p.PlayerNum == 1){
			token.setLocation(places[p.getPosition()][0] + 10, places[p.getPosition()][1] + 10);
		} else{
			token.setLocation(places[p.getPosition()][0] + 50, places[p.getPosition()][1] + 50);
		}
	}
	
	//보드판을 그리는 부분. 이미지 부분
	public void drawBoard(){
		for(int i = 0; i < 32; i++){
			createImage(imageLabel[i], places[i][0], places[i][1]);
		}
	}
	
	//text창 초기화하기
	public void resetMessage(){
		text.setText("");
	}
	
	
	//턴이 끝난 후 돈과 체력을 갱신해주는 메서드
	public void refreshStat(){ 
		p1status.setText(p1.Name + "\nMoney: " + p1.money + "$\nHP: " + p1.health);
		p2status.setText(p2.Name + "\nMoney: " + p2.money + "$\nHP: " + p2.health);
	}
	
	//주사위 돌리는 메서드
	public int rollDice(){
		int total_dice = 0;
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		total_dice = dice1 + dice2;
		dice_num = total_dice;
		return total_dice;
	}
	
	
	//상대방 챔피언을 밟았을 때 데미지를 얼마나 받는지, 혹은 따의 주인이 없는지 체크해주는 것
	public int damageCheck(int num, int location){
		int total = 0;
		if(phm.block_name[location].owned == 0){
			return 0;
		} else{
			if(phm.block_name[location].owned != num){
				for(int i = 0; i < 5; i++){
					if(phm.block_name[location].damage[i] >0){
						total += phm.block_name[location].damage[i];
					}
				}
				if(num == 1){
					p1.health -= total;
				}else{
					p2.health -= total;
				}
				text.append(total + " 만큼 공격을 받았습니다! \n");//END of for
			} else{
				for(int i = 0; i < 5; i++){
					if(phm.block_name[location].damage[i] < 0){
						total += phm.block_name[location].damage[i];
					}
					if(num == 1){
						p1.health -= phm.block_name[location].damage[i];
					}else{
						p2.health -= phm.block_name[location].damage[i];
					}
				}//END of for
				if(total < 0){
					text.append(total + "만큼 회복하였습니다! \n");
				}
				
			}
		}
		if(p1.health <= 0 || p2.health <= 0){
			text.append("GAME END \n");
			okbtn.setEnabled(false);
			dice.setEnabled(false);
			nobtn.setEnabled(false);
			if(p1.health > p2.health){
				text.append("Player 1 " + p1.Name + " Win! \n");
				return 1;
			}else{
				text.append("Player 2 " + p2.Name + " Win! \n");
				return 1;
			}
		}
		return 0;
	}//END of damageCheck

	
	//땅을 구매할 때 필요한 메서드
	public void Buy(int num, int location){
		if(phm.block_name[location].owned != num){
			if(num == 1){
				if(p1.money - (phm.block_name[location].price[0] + p1.turns*20) > 0){
					p1.money -= (phm.block_name[location].price[0] + p1.turns*20);
					phm.block_name[location].owned = num;
					text.append("구매완료!");
				} else{
					text.append("구매하기엔 돈이 부족합니다");
				}
			} else{
				if(p2.money - (phm.block_name[location].price[0] + p2.turns*20)> 0){
					p2.money -= (phm.block_name[location].price[0] + p2.turns*20);
					phm.block_name[location].owned = num;
					text.append("구매완료!");
				} else{
					text.append("구매하기엔 돈이 부족합니다");
				}
				
			}
		}
	}
	
	
	//찬스카드 땅을 밟았을 때 실행되는 메서드
	public void chancechance(int num){
		text.append("Chance Card! \n");
		int rnum = (int) (Math.random()*5 + 1);
		text.append(phm.cc[rnum].chance);
		switch (rnum) {
		case 0:
			if(num == 1){
				p1.money += 50;
			}else{
				p2.money += 50;
			}
			break;
		case 1:
			if(num == 1){
				p1.money += 100;
			}else{
				p2.money += 100;
			}
			break;
		case 2:
			if(num == 1){
				p1.health += 150;
			}else{
				p2.health += 150;
			}
			break;
		case 3:
			if(num == 1){
				p1.health += 100;
			}else{
				p2.health += 100;
			}
			break;
		case 4:
			if(num == 1){
				p2.health -= 120;
			}else{
				p1.health -= 120;
			}
			break;
		case 5:
			break;
		}
		refreshStat();
	}
	
	
	//플레이어의 위치를 리턴하는 메서드
	public int getPosition(int num){
		int result;
		if(num == 1){
			result = p1.getPosition();
		} else{
			result = p2.getPosition();
		}
		return result;
	}
	
	
	@Override
	//버튼이벤트 내용
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//주사위 굴리기 버튼
		if(e.getActionCommand() == "ROLL_DICE"){
			dice.setEnabled(false);
			nobtn.setEnabled(true);
			//Player 1
			if(next == 1){
				dice_num = rollDice();
				text.append("" + dice_num + "!\n");
				redrawToken(p1tokenLabel, p1);
				//text.append(p1.alertLocation());
				if(phm.block_name[p1.getPosition()].is_special){
					chancechance(next);
					okbtn.setEnabled(false);
				} else{
					okbtn.setEnabled(true);
					if(damageCheck(next, getPosition(next)) == 0){
						refreshStat();
						text.append(phm.block_name[p1.getPosition()].location_name + "을 구매하시겠습니까?(BUY) \n(" + (phm.block_name[p1.getPosition()].price[0]+p1.turns*20)+ "$)\n");
					} else{
						refreshStat();
					}					
				}
			//Player 2	
			} else{
				dice_num = rollDice();
				text.append("" + dice_num + "!\n");
				redrawToken(p2tokenLabel, p2);
				//text.append(p2.alertLocation());
				if(phm.block_name[p2.getPosition()].is_special){
					chancechance(next);
					okbtn.setEnabled(false);
				} else{
					okbtn.setEnabled(true);
					if(damageCheck(next, getPosition(next)) == 0){
						refreshStat();
						text.append(phm.block_name[p2.getPosition()].location_name + "을 구매하시겠습니까?(BUY)\n(" + (phm.block_name[p2.getPosition()].price[0]+p2.turns*20) +"$)\n");
					} else{
						refreshStat();
					}
				}
			}
		//BUY버튼	
		} else if(e.getActionCommand() == "BUY"){
			Buy(next, getPosition(next));
			okbtn.setEnabled(false);
			refreshStat();
		// NEXT TURN 버튼	
		} else{
			resetMessage();
			if(next == 1){
				next = 2;
				text.append(p2.Name + " 의 차례입니다! \n");
			} else{
				next = 1;
				text.append(p1.Name + " 의 차례입니다!");
			}
			dice.setEnabled(true);
			okbtn.setEnabled(false);
			nobtn.setEnabled(false);
			text.append("주사위를 던지세요! \n");
		}//END of if..else
		
	}//END of ActionEventListener
}