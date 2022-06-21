package day0531;

// 비행기, 차 클래스 생성
// 두 개의 공통적인 특징을 클래스명으로

// 비행기와 차의 공통점을 이용하여 클래스를 생성
// Car와 Plane의 공통점을 Vehicle에 입력

// Vehicle 클래스는 추상메서드를 가지고 있으므로 추상클래스가 됨
abstract class Vehicle { // 추상메서드가 있는 클래스에도 abstract를 적어주어야함
	int speed; // 속도
	
	public void setSpeed(int speed) { // 속도를 보여주는 메서드
		this.speed = speed;
		System.out.println("속도를 " + speed + "으로 설정하였습니다.");
	}
	
	
	// 추상메서드
	// 추상메서드가 아니게 되려면 {} 중괄호가 없어야한다.
	abstract void show(); 
}


class Car extends Vehicle { // Vehicle을 상속받는 클래스 생성
	// 자동차만 가지는 특성
	int num;		// 차량 번호
	double gas;		// 연료량
	
	Car(int num, double gas) { // 2개의 매개변수를 가지는 생성자
		this.num = num;
		this.gas = gas;
		
		System.out.println("차량 번호 : " + num + ", 연료량 : " + gas + "인 자동차를 생성함");
	}
	
	// 몸통 구현
	void show() {
		System.out.println("차량 번호 : " + num);
		System.out.println("연료량 : " + gas);
		System.out.println("속도 : " + speed);
	}
}


class Plane extends Vehicle { // Vehicle을 상속받는 클래스 생성
	// 비행기만 가지는 특성
	int flight; // 비행기 번호를 나타냄
	
	Plane(int flight) { // 1개의 매개변수를 가지는 생성자
		this.flight = flight;
		
		System.out.println("비행기 번호 : " + flight + "인 비행기를 생성함");
	}
	
	// 몸통 구현
	void show() {
		System.out.println("비행기 번호 : " + flight);
		System.out.println("속도 : " + speed);
	}
}


		// 부모 클래스 (Vehicle)가 추상메서드, 추상클래스가 되었으면
		// 자식 클래스 (Car, Plane)에도 abstract를 따로 적지 않고
		// 자식 클래스에서 정상적으로 실행되도록 구현해주면 된다
		// 단, 각각의 자식클래스가 가지고 사용할 수 있는 필드와
		// 부모가 가지고 있는 필드를 맞게 작성하여야한다.



public class AbstMain {

	public static void main(String[] args) {
		// 배열을 사용하여 값을 저장
		// Car와 Plane만 넣을 것이기 때문에 2로 설정
		Vehicle[] vc = new Vehicle[2]; 
		
		vc[0] = new Car(1234, 30.6);
		vc[0].setSpeed(80);
		
		System.out.println();
		
		vc[1] = new Plane(111);
		vc[1].setSpeed(700);
		
		System.out.println();
		vc[0].show();
		
		System.out.println();
		vc[1].show();

	}

}
