package day0531;

abstract class Animal {
	String kind;
	
	void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	abstract void sound();
	// 개와 고양이가 우는게 둘다 있어야하지만 각각 써놓을 필요 없이
	// 추상메서드로 만들어 개와 고양이에게 값을 직접 구현받으면된다 ?
	// 추상메서드를 생성했으니 클래스도 추상클래스가 되도록 abstract를 입력.
}


class Dog extends Animal { 
	Dog () { // 생성자에 작성
		this.kind = "포유류";
	}
	
	void sound() {
		// 부모클래스에서 추상메서드의 몸통을 구현함
		// 메서드이름을 그대로 들고 오기 때문에 오버라이딩이라고 할 수 있다.
		// Animal (부모) 클래스에서 추상화때문에 객체를
		// 생성할 수 없기 때문에 도움을 주는 것이라고 생각할 수 있다.
		System.out.println("멍멍");
	}
}


class Cat extends Animal { 
	Cat () { // 생성자에 작성
		this.kind = "포유류";
	}
	
	void sound() {
		// 부모클래스에서 추상메서드의 몸통을 구현함
		// 메서드이름을 그대로 들고 오기 때문에 오버라이딩이라고 할 수 있다.
		System.out.println("야옹");
	}
}


public class AnimalMain {

	public static void main(String[] args) {
		
		// sound() 메서드 호출
		
		// 1. 가장 일반적인 방법
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		
		System.out.println("---------------");
		
		// 2. 부모타입의 참조변수를 이용하여
		//	  자식의 sound() 메서드 호출하는 방법
		// 	  자식은 부모타입으로 자동형변환이 가능
		Animal animal = null;
		
		// Animal animal = new Dog();  ->  다형성 (Animal과 Dog가 다른 타입)
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		
		System.out.println("---------------");
		
		// 3. 메서드를 생성하여 호출하는 방법 (main 영역 밖에서 입력해야함)
		animalSound(new Dog());
		animalSound(new Cat());
	}
	
	// 객체생성없이 사용, 메인을 호출할때만 사용할 것이기 때문에
	// Animal animal = new Dog();
	// Animal animal = new Cat(); 과 같은 의미
	public static void animalSound(Animal animal) {
		// 매개변수를 Animal타입 animal로 설정 
		animal.sound();
	}

}
