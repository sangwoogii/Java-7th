package day0531;

class Product {  // 슈퍼
	int price;
	int bonus;
	
	Product() {} // 기본 생성자
	
	Product(int price) { // 매개변수가 1개 있는 생성자
		this.price = price;
		bonus = (int)(price / 10.0);
	}
}

class Tv extends Product {
	Tv(){
		super(100); // 부모의 생성자 호출
	}
	
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer(){ // 부모의 생성자 호출
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio(){ // 부모의 생성자 호출
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
}

class Buyer { // 손님
	int money = 1000; // 손님이 가지고 있는 현금
	int bonus = 0; // 적립금
	Product[] cart = new Product[10]; // 10칸짜리 장바구니를 담는 배열 선언 (2번째문제)
	int i = 0;
	
	void buy(Product p) { // 메서드
		if (money < p.price) {
			System.out.println("잔액 부족 !");
			return;
		}
		// if문 다음 else if가 와도 되지만 조건을 만족하면 return값을 준다는 return이 있기 때문에
		// else if를 따로 쓰지 않아도된다. return밑에 쓰는 money부터는 조건을 만족하지 않았을때
		// 실행되는 코드들이다.
		
		money -= p.price; // 손님이 가진 돈에서 제품 금액을 빼는 코드
		bonus += p.bonus; // 적립금 추가하는 코드
		cart[i++] = p;
		System.out.println(p + "를 구입하였습니다.");
		System.out.println("현재 잔액 : " + p.price + "원");
		System.out.println("보너스 포인트 : " + p.bonus + "점");
	}
	
	// 지금 밑에 주석 : 오버로딩
		// 하나하나 써도 되지만 저 클래스들을 상속한 부모의 클래스를 매개변수로 쓰게되면
		// 저렇게 하나하나 다 안써도된다.
//		void buy (Tv t) {
//			
//		}
	//	
//		void buy (Computer c) {
//			
//		}
	
	
	// 구매한 물품(합계)에 대한 요약 정보를 표시하는 메서드
	void summary() {
		int sum = 0;
		String itemList = "";
		
		// 구매한 물건의 총 합계를 표시, 물건의 목록을 표시하는 식
		for (int i=0; i<cart.length; i++) {
			// 배열이 비어있으면 반복문을 종료한다는 if문 코드 (의미)
			if (cart[i] == null) {
				break;
			}
			// 여기부턴 if문의 조건이 만족하지 않았을때 실행되는 코드
			sum += cart[i].price;
			itemList += cart[i] + ", ";
			// cart의 i번째의 값을 더해가야함
			// i가 cart.length까지 이기 때문에
			
			// 마지막 쉼표 없애기 -> 삼항연산자 사용
			itemList += (i == 0) ? "" + cart[i] : ", " + cart[i];
			
		}
		
		System.out.println("총 금액 : " + sum);
		System.out.println("구입한 물건 : " + itemList);
	}

}


public class Array {

	public static void main(String[] args) {
		
		Buyer b = new Buyer(); // 1명의 고객 객체 생성
		
//		Product p = new Tv();
//		b.buy(p);
		b.buy(new Tv()); // 위의 주석과 같은 의미
		System.out.println();
		
		b.buy(new Computer());
		System.out.println();
		
		b.buy(new Audio());
		System.out.println();
		
		b.summary();
	}

}
