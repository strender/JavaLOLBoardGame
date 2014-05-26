package javalol;

public class Block{
	String location_name;
	boolean is_special;
	int[] price = new int[5];
	int x_position, y_position;
	
	public Block(){
		
	}
	
	public Block(String s, boolean special, int p0, int p1, int p2, int p3, int p4, int x, int y){
		location_name = s;
		is_special = special;
		price[0] = p0;
		price[1] = p1;
		price[2] = p2;
		price[3] = p3;
		price[4] = p4;
		x_position = x;
		y_position = y;
	}
}
