package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyMultiThread implements Runnable{
	public static long sum;	//static
	private int start;
	private int end;
	
	public MyMultiThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		long temp = 0;
		for(int i=start;i<=end;i++) {
			temp += i;
		}
		sum += temp;
	}
}

public class MulitThreadTest {
	public static final int THREAD_COUNT = 4;
	
	public static void singleThreadTest() {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i=0;i<2000000000;i++) {
			sum += i;
		}
		System.out.println("[���� ������ ���]�����հ�: "+sum);
		long end = System.currentTimeMillis();
		System.out.println("[���� ������ ���]����ð�: "+(end-start)/1000.0+"��");
	}
	
	
	public static void mulitThreadTest() throws InterruptedException {
		Thread[] threads = new Thread[THREAD_COUNT];
		int target = 2000000000;
		long start = System.currentTimeMillis();
		
		for(int i=0;i<threads.length;i++) {
			//Runnable�������̽��� Thread�� ���ڷ� �Ѱ������
			threads[i] = new Thread(new MyMultiThread(i*(target/THREAD_COUNT), (i+1)*(target/THREAD_COUNT)-1));
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++) {
			threads[i].join();	//��� �����尡 ����Ǳ� ��ٸ�
		}
		long end = System.currentTimeMillis();
		System.out.println("[��Ƽ ������ ���]�����հ�: "+MyMultiThread.sum);
		System.out.println("[��Ƽ ������ ���]����ð�: "+(end-start)/1000.0+"��");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		singleThreadTest();
		System.out.println("");
		mulitThreadTest();
	}

}