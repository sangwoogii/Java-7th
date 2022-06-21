package day0531;

// 영화 예메 금액의 총 합계를 계산하고자 함.
// 모든 영화의 정가는 10,000원이며, 기본 할인율은 10%이다.
// 또한 장르별로 추가로 할인가능하며 할인 금액은 아래와 같다.
// 1. 액션 : 1,000원 할인
// 2. 공포 : 800원 할인
// 3. 코미디 : 1,500원 할인

// 총 3장의 영화를 다음과 같이 예매하였을 때 총 예메 금액을 표시하시오.
// 1. 범죄도시 (액션)
// 2. 여고괴담 (공포)
// 3. 극한직업 (코미디)

// - 클래스 이름 : ActionMovie, HorroMovie, ComedyMovie
//   추가로 필요한 클래스의 이름은 본인이 선택하여 작성하시오.

abstract class Movie {
	String name;			// 영화 이름
	int price = 10000;		// 정가가 10000원이기 때문에
	double discount = 0.1d;	// 기본할인율 10%
	
	Movie () {} // 기본생성자

	Movie(String name) {
		this.name = name;
	}
	
	abstract double discountedPrice();
	// 추가 할인에 대한 추상메서드
	// 각 영화별로 추가할인이 다르기 때문에 부모 클래스에서 추상화(미완성 설계도)를 선언한 다음
	// 각각의 영화 클래스에서 몸통을 만들어 코드를 작성하면 됨
}


class ActionMovie extends Movie {
	
	ActionMovie(String name) {
		super (name);
	}
	
	double discountedPrice() {
		return price * (1-discount) - 1000;
		// 기본값에서 10%를 빼고 1000원을 뺀 금액
	}
	
	public void print() {
		System.out.println("예매 영화 : " + name);
	}
}


class HorroMovie extends Movie {
	
	HorroMovie(String name) {
		super (name);
	}
	
	double discountedPrice() {
		return price * (1-discount) - 800;
		// 기본값에서 10%를 빼고 800원을 뺸 금액
	}
	
	public void print() {
		System.out.println("예매 영화 : " + name);
	}
}


class ComedyMovie extends Movie {
	
	ComedyMovie(String name) {
		super (name);
	}
	
	double discountedPrice() {
		return price * (1-discount) - 1500;
		// 기본값에서 10%를 빼고 1500원을 뺀 금액
	}
	
	public void print() {
		System.out.println("예매 영화 : " + name);
	}
}


public class MovieDiscountMain {

	public static void main(String[] args) {
// 		1.
		ActionMovie am = new ActionMovie("범죄도시");
		HorroMovie hm = new HorroMovie("여고괴담");
		ComedyMovie cm = new ComedyMovie("극한직업");
		
		am.print();
		hm.print();
		cm.print();
		
		
		int sum = 0;
		
		sum += am.discountedPrice();
		sum += hm.discountedPrice();
		sum += cm.discountedPrice();
		
		// 2. 배열
		
//		Movie[] movie = {new ActionMovie("범죄도시"), new HorroMovie("여고괴담"), new ComedyMovie("극한직업")};
//	
//		int sum = 0;
//		for (int i=0; i<movie.length; i++) {
//			sum += movie[i].discountedPrice();
//		}
		
		// 향상 for문
//		for (Movie m : movie) {
//			sum += m.discountedPrice();
//		}
		
		System.out.println("총 예메 금액 : " + sum + "원입니다.");
		
	}
}
