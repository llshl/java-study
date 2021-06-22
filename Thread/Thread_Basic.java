package Thread;

public class Thread_Basic {
	public static void main(String[] args) {
		/* ������ ������ �ΰ��� ����� �ִ� 
		 * 1. Runnable �������̽��� ���� �� Thread �����ڿ� �־��ֱ�
		 * 2. Thread Ŭ���� ���� ����ϱ�
		 * */
		//Runnable ���� �� Thread�����ڷ� �־��ֱ� ���
		Runnable task = new Task();
		Thread t1 = new Thread(task);
		t1.start();
		
		//������ ���� ����Ͽ� ����
		T2 t2 = new T2();
		t2.run();
	}
}

//�������̽� ���� - �ڹٿ��� ���� ����� �ȵǱ⿡ 
//�������̽��� �����ϴ� ����� ���� �� ������ ���α׷����� �����ϴ�
class Task implements Runnable{
	
	int num = 0;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("t1: "+num++);
		}
	}
}

//�����带 ���� ��ӹ޴� Ŭ���� ���
class T2 extends Thread{
	
	int num = 0;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("t2: "+num++);
		}
	}
}
