package day0531;

// 부모님, 아이, 강아지랑 소풍을 가요.
// 각각의 역할이 있을 것임

abstract class Living {
	int x, y;  // 위치(좌표) 값
	
	abstract void move (int x, int y);
	// 부모님, 아이, 강아지 3명 각각의 위치를 나타내고싶어서 추상화로 선언
	// 내가 원하는 곳으로 입력을 하고 싶으면 상속을 받아서 편하게 쓰면 되기 때문에 추상화 선언
	
	void stop() {
		System.out.println("도착했어요 !");
	}
}


class Parent extends Living { // abstract
	// 만약 지금 Parent 클래스를 사용하고 싶지 않으면 여기에도 abstract를 입력하면된다
	// 그렇다면 이 클래스를 사용하려면 또 누군가가 Parent 클래스를 상속을 받아서 구현을 하면된다.
	
	void move (int x, int y) { // 추상메서드 구현 (=오버라이딩)
		System.out.printf("Parent의 위치 : %d, %d%n", x, y);
	}
	
	void drive() { // 운전을 나타내는 메서드 생성
		System.out.println("운전을 해요 !");
	}
	
}


class Child extends Living {
	
	void move (int x, int y) {
		System.out.printf("Child의 위치 : %d, %d%n", x, y);
	}
	
	void play() { // 노는 것을 나타내는 메서드 생성
		System.out.println("놀아요 !");
	}
	
	void cry() { // 우는 것을 나타내는 메서드 생성
		System.out.println("울어요 ~");
	}
}


class Dog1 extends Living {
	
	void move (int x, int y) {
		System.out.printf("강아지의 위치 : %d, %d%n", x, y);
	}
	
	void sleep() {
		System.out.println("강아지는 자요 ~");
	}
}


public class PicnicMain {

	public static void main(String[] args) {
		
		// 객체배열을 통해 화면에 표시
		// 객체배열 : 참조변수를 묶은 것
		// 부모, 아이, 강아지의 값을 나타내야하기 때문에 3
		// 객채배열은 부모 클래스를 기준
		Living[] group = new Living[3];
		
		// Object[] group = new Object[3]; -> Object는 부모의 부모이기 때문에 가능하지만 객체로는 사용이 불가능함
		// Object는 최고 조상이므로 다형성이 가능하지만 (객체생성은 가능, 객체 사용은 불가능),
		// move()나 stop()메서드를 가지고 있지는 않기 때문에 메서드를 호출할 수 없음.

		group[0] = new Parent();
		group[1] = new Child();
		group[2] = new Dog1();
		
		// Living[] group = {new Parent(), new Child(), new Dog1()};
		// 이렇게 표현이 가능함, 바로 위의 코드와 같은 코드
		
		// 결과값 나타내기 (for문 사용)
		for (int i=0; i<group.length; i++) {
			group[i].move(100, 200);
			group[i].stop();
		}
		
	}

}
