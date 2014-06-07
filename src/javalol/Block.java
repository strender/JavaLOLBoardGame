package javalol;

public class Block{
	String location_name;
	boolean is_special;
	int[] price = new int[5];
	int[] damage = new int[5];
	int x_position, y_position;
	int owned = 0;
	//0 == no one, 1 == player1, 2 == player2
	
	public Block(String s, boolean b){
		location_name = s;
		is_special = b;
	}
	
	
	public Block(String s, boolean b, int p1, int p2, int p3, int p4, int p5, int d1, int d2, int d3, int d4, int d5){
		location_name = s;
		is_special = b;
		price[0] = p1; price[1] = p2; price[2] = p3; price[3] = p4; price[4] = p5;
		damage[0] = d1; damage[1] = d2; damage[2] = d3; damage[3] = d4; damage[4] = d5;
	}
}
