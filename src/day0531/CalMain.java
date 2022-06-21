package day0531;

import java.util.Scanner;

abstract class Calculator {
	int num1;
	int num2;
	
	abstract int add (int num1, int num2);
	abstract int minus (int num1, int num2);
	abstract int mul (int num1, int num2);
	abstract int div (int num1, int num2);
	
}


class Cal extends Calculator {

	@Override
	int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	@Override
	int minus(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 - num2;
	}

	@Override
	int mul(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	int div(int num1, int num2) {
		
		if (num2 == 0) {
			return 0;
		} else {
			return num1 / num2;	
		}
	}
}



public class CalMain {

	public static void main(String[] args) {
		
		// 1. 클래스 이름 : Calculator.java
		// 2. 추상 메서드 : 매개변수 2개인 add(더하기), minus(빼기), mul(곱하기), div(나누기) 생성
		// 3. Calculator를 상속받는 cal.java 생성하여 계산
		// 4. CalMain.java를 생성하여 사용자에게서 두 수를 입력받아 cal.java를 통해 계산하여 그 결과를 출력하시오.
		// 5. 출력예시
		//		5 + 3 = 8
		//		5 - 3 = 2
		//		5 * 3 = 15
		//		5 / 3 = 1
		// 나눗셈에서 나누는 수에 0이 입력될 때 오류가 발생하지 않도록 설정하시오.
		
		Cal c = new Cal();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 : ");
		int n1 = s.nextInt();
		
		System.out.print("두번째 숫자 : ");
		int n2 = s.nextInt();
		
		
		System.out.printf("%d + %d = %d%n", n1, n2, c.add(n1, n2));
		System.out.printf("%d - %d = %d%n", n1, n2, c.minus(n1, n2));
		System.out.printf("%d * %d = %d%n", n1, n2, c.mul(n1, n2));
		System.out.printf("%d / %d = %d%n", n1, n2, c.div(n1, n2));
		

		s.close();
	}

}
