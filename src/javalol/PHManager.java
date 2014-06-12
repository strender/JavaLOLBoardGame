package javalol;

public class PHManager {
	Player one;
	Player two;
	
	
	Block[] block_name = {
		//땅 이름, 챔피언이면 false값, 그냥 챔피언값, 스킬1,2,3,4 배우는데 필요한돈, 평타뎀지, 스킬1,2,3,4 뎀지
			new Block("시작점", true),
			new Block("알리스타", false, 25, 15, 25, 35, 45, 10, 20, 30, 30, 50),
			new Block("가렌", false,  25, 15, 25, 35, 45, 10, 20, 30, 40, 50),
			new Block("자크", false,  25, 15, 25, 35, 45, 10, 20, 30, 40, 50),
			new Block("찬스카드", true),
			new Block("하이머딩거", false, 25, 15, 25, 35, 45, 10, 20, 30, 40, 50),
			new Block("다리우스", false, 25, 15, 25, 35, 45, 10, 20, 30, 40, 50),
			new Block("케이틀린", false, 50, 20, 30, 40, 50, 15, 25, 35, 45, 55),
			new Block("찬스카드", true),
			new Block("라이즈", false, 50, 20, 30, 40, 50, 15, 25, 35, 45, 55),
			new Block("트페", false, 50, 20, 30, 40, 50, 15, 25, 35, 45, 55),
			new Block("찬스카드", true),
			new Block("블라디미르", false, 50, 20, 30, 40, 50, 15, 25, 35, 45, 55),
			new Block("찬스카드", true),
			new Block("그레이브즈", false, 50, 20, 30, 40, 50, 15, 25, 35, 45, 55),
			new Block("루시안", false, 75, 25, 35, 45, 55, 20, 37, 50, 62, 69),
			new Block("찬스카드", true),
			new Block("카직스", false, 75, 25, 35, 45, 55, 20, 37, 50, 62, 69),
			new Block("레넥톤", false, 75, 25, 35, 45, 55, 20, 37, 50, 62, 69),
			new Block("찬스카드", true),
			new Block("리산드라", false, 75, 25, 35, 45, 55, 20, 37, 50, 62, 69),
			new Block("니달리", false, 75, 25, 35, 45, 55, 20, 37, 50, 62, 69),
			new Block("벨코즈", false, 90, 35, 45, 55, 65, 27, 40, 58, 70, 79),
			new Block("아리", false, 90, 35, 45, 55, 65, 27, 40, 58, 70, 79),
			new Block("찬스카드", true),
			new Block("브랜드", false, 90, 35, 45, 55, 65, 27, 40, 58, 70, 79),
			new Block("애니", false, 90, 35, 45, 55, 65, 27, 40, 58, 70, 79),
			new Block("신드라", false, 90, 35, 45, 55, 65, 27, 40, 58, 70, 79),
			new Block("찬스카드", true),
			new Block("카타리나", false, 110, 40, 50, 60, 70, 35, 45, 60, 78, 90),
			new Block("문도박사", false, 110, 40, 50, 60, 70, 35, 45, 60, 78, 90),
			new Block("드레이븐", false, 110, 40, 50, 60, 70, 35, 45, 60, 78, 90)
	};
	
	ChanceCard[] cc = {
			new ChanceCard("용을 처치하였습니다! \n돈 50원을 획득합니다!"),
			new ChanceCard("바론을 처치하였습니다! \n돈 100원과 공격력 +20 효과를 봅니다!"),
			new ChanceCard("스펠 회복을 사용하였습니다! \n체력이 증가합니다!"),
			new ChanceCard("체력 포션을 사용하였습니다! \n체력이 증가합니다!"),
			new ChanceCard("스펠 점화를 사용하였습니다! \n체력이 감소합니다!"),
			new ChanceCard("마나 포션을 사용하셨습니다! \n 아쉽지만 보드게임에서는 쓸모가 없죠ㅎㅎ")
			//new ChanceCard(""),
			
	};
	
	public PHManager(Player a, Player b){
		one = a;
		two = b;
	}
	
	
}
