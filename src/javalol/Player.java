package javalol;

import javax.swing.JOptionPane;

public class Player {
	public String Name;
	public int position = 0;
	public int PlayerNum;
	public int money;
	public int health;
	public boolean disconnect = false;
	public int turns = 0;
	
	
	public int placement[][] = {
			
	};
	
	public void setName(){
		String s = JOptionPane.showInputDialog("Player" + PlayerNum + " 이름 입력:");
		this.Name = s;
	}
	
	public Player(int num){
		PlayerNum = num;
		setName();
		money = 475;
		health = 550;
	}
	
	public void Move(int dice){
		if(position+dice < 32){
			position += dice;
		} else{
			position = position + dice - 32;
			money += 200;
		}
	}
	
	public int getLocation(){
		return position;
	}
	
	public String alertLocation(){
		String s = Name + "이" + position + "을 밟았습니다!";
		return s;
	}
	
	public void drawPlayer(){
		
	}	
}
