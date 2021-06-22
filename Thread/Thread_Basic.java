package Thread;

public class Thread_Basic {
	public static void main(String[] args) {
		/* 쓰레드 구현은 두가지 방법이 있다 
		 * 1. Runnable 인터페이스를 구현 후 Thread 생성자에 넣어주기
		 * 2. Thread 클래스 직접 상속하기
		 * */
		//Runnable 구현 후 Thread생성자로 넣어주기 방법
		Runnable task = new Task();
		Thread t1 = new Thread(task);
		t1.start();
		
		//쓰레드 직접 상속하여 구현
		T2 t2 = new T2();
		t2.run();
	}
}

//인터페이스 구현 - 자바에서 다중 상속은 안되기에 
//인터페이스를 구현하는 방법이 조금 더 유연한 프로그래밍이 가능하다
class Task implements Runnable{
	
	int num = 0;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("t1: "+num++);
		}
	}
}

//쓰레드를 직접 상속받는 클래스 사용
class T2 extends Thread{
	
	int num = 0;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("t2: "+num++);
		}
	}
}
