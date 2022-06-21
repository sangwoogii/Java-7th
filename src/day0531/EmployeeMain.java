package day0531;

class Employee {
	String name;	// 이름
	int age;		// 나이
	String addr;	// 주소
	String dept;	// 부서
	int comm;		// 월급
	
	Employee() {}
	
	Employee(String name, int age, String addr, String dept) {
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.dept = dept;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + addr);
		System.out.println("부서 : " + dept);
	}
	void setComm(int comm) {}
	void setSalary(int time) {}
	// e1의 자료형이 Employee이기 때문에 Employee에
	// setcomm과 setSalary가 들어가 있어야한다
}

class Regular extends Employee {
	
	Regular(){}
	
	Regular(String name, int age, String addr, String dept) {
		super (name, age, addr, dept);
	}
	
	public void setComm(int comm) {
		this.comm = comm;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.println("정규직");
		System.out.println("급여 : " + comm + "만원");
	}
}

class Temporary extends Employee {
	
	int time;			// 일한시간
	int sal = 10000;	// 시간당 보수
	
	Temporary(){}
	
	Temporary(String name, int age, String addr, String dept) {
		super (name, age, addr, dept);
		sal = 10000; // 왜 써?
	}
	
	public void setSalary(int time) {
		this.time = time;
		this.comm = time * sal;
		System.out.println(comm);
	}
	
	public void printInfo() {
		super.printInfo();  // 부모꺼를 가져오기 !!!!!! 이거 틀림
		System.out.println("비정규직");
		System.out.println("일한시간 : " + time + "시간");
		System.out.println("급여 : " + comm + "만원");
	}
}

public class EmployeeMain {

	public static void main(String[] args) {
			Employee e1 = new Regular("김그린", 35, "울산", "인사부");
			e1.setComm(5000000);
			e1.printInfo();
	
			System.out.println();
			
			Employee e2 = new Temporary("이자바", 22, "서울", "개발부");
			e2.setSalary(120);
			e2.printInfo();
		

	}

}
