package javalol;

import javax.swing.JOptionPane;

public class Player {
	public String Name;
	public int position = 0;
	public int PlayerNum;
	public boolean disconnect = false;
	public int turns = 0;
	
	public void setName(){
		String s = JOptionPane.showInputDialog("Player1 이름 입력:");
		this.Name = s;
	}
	
	public Player(String name, int num){
		Name = name;
		PlayerNum = num;
	}
	
	public void Move(){
		
	}
	
	public void drawPlayer(){
		
	}	
}
