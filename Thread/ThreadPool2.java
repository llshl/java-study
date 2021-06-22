package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {

	public static void main(String[] args) {
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(1);
		
		/* corePoolSize = 100	(쓰레드 풀이 기본적으로 몇개의 쓰레드를 풀에 가지고 있을지
		 * maximumPoolSize = 100(이 값을 넘어가면 RejectedExecutionException 발생)
		 * keepAliveTime = 10	(idle 쓰레드의 keep alive time)
		 * TimeUnit.SECONDS		(keepAliveTime의 시간 단위)
		 * workQueue = bq		(corePoolSize를  넘어서는 쓰레드들을 큐잉 처리하기 위한 큐 선언)
		 * */
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,100,10,TimeUnit.SECONDS, bq);
		
		Runnable task = new Task2();
		for(int i=0;i<100;i++) {
			threadPoolExecutor.execute(task);
		}
		System.out.println("쓰레드 콜 종료"); 
	}

}

class Task2 implements Runnable{
	
	int num = 0;
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+", num = "+num++);
		}
	}
}
