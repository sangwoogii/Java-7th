package day0531;

import java.util.Currency;

/*
 * 	각국 통화 (원화 / 달러 / 유로)의 금액을 출력하고자 한다.
 	- 원화 : 1,500원
 	- 달러 : 100.50달러
 	- 유로 : 260.75유로
 	
 	입력 예시
 	KRW won = new KRW(1500.00);

	모든 화폐를 Curreny 배열에 담고, 반복문을 이용하여 금액을 출력하시오.
	출력예시
 	KRW : 1500.00원
 	USD : 100.50달러
 	EUR : 26.75유로
 * */

abstract class Curreny {
	
	double money; // 각각의 통화의 금액이 다르기 때문에 int보다는 double사용
	
	Curreny() {} // 기본 생성자
	
	Curreny (double money) { // 매개변수 1개를 갖는 생성자
		this.money = money;
	}
	
	abstract void printInfo();
	// 출력하기 위한 추상메서드
	// 각각의 통화가 다르기 때문에 추상메서드 생성
}


class KRW extends Curreny {
	
	KRW() {}
	
	KRW(double money) {
		super (money);
	}
	
	public void printInfo () { // 몸통만들기
		System.out.printf("KRW : %.2f원 %n", money); 
		// 결과물이 소수점이기 때문에 printf 사용
		// %.2f원 -> 소수점 2자리를 나타냄
	}
}


class USD extends Curreny {
	
	USD(double money) {
		super (money);
	}
	
	public void printInfo () {
		System.out.printf("USD : %.2f달러 %n", money);
	}
}

class EUR extends Curreny {
	
	EUR(double money) {
		super (money);
	}
	
	public void printInfo () {
		System.out.printf("EUR : %.2f유로 %n", money);
	}
}


public class CurrenyMain {

	public static void main(String[] args) {
		
		Curreny [] curr = {new KRW(1500.00), new USD(100.50), new EUR(260.75)};
		
//		for (int i=0; i<curr.length; i++) {
//			curr[i].printInfo();
//		}
	
		
		// 향상 for문
//		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//	
//		for (int i : arr) {
//			System.out.println(i);
//		}
		
		for (Curreny c : curr) { // 변수가 와야함
			c.printInfo();
		}

	}

}
