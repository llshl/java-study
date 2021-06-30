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
		System.out.println("[단일 쓰레드 사용]연산합계: "+sum);
		long end = System.currentTimeMillis();
		System.out.println("[단일 쓰레드 사용]연산시간: "+(end-start)/1000.0+"초");
	}
	
	
	public static void mulitThreadTest() throws InterruptedException {
		Thread[] threads = new Thread[THREAD_COUNT];
		int target = 2000000000;
		long start = System.currentTimeMillis();
		
		for(int i=0;i<threads.length;i++) {
			//Runnable인터페이스를 Thread의 인자로 넘겨줘야함
			threads[i] = new Thread(new MyMultiThread(i*(target/THREAD_COUNT), (i+1)*(target/THREAD_COUNT)-1));
			threads[i].start();
		}
		for(int i=0;i<threads.length;i++) {
			threads[i].join();	//모든 쓰레드가 종료되길 기다림
		}
		long end = System.currentTimeMillis();
		System.out.println("[멀티 쓰레드 사용]연산합계: "+MyMultiThread.sum);
		System.out.println("[멀티 쓰레드 사용]연산시간: "+(end-start)/1000.0+"초");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		singleThreadTest();
		System.out.println("");
		mulitThreadTest();
	}

}