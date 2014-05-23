package javalol;

import javax.swing.JOptionPane;

public class Player {
	public String Name;
	public int position = 1;
	public int PlayerNum;
	public int money;
	public int health;
	public boolean disconnect = false;
	public int turns = 0;
	
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
		if(position+dice < 33){
			position += dice;
		} else{
			position = position + dice - 32;
		}
	}
	
	public void drawPlayer(){
		
	}	
}
