package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {

	public static void main(String[] args) {
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(1);
		
		/* corePoolSize = 100	(������ Ǯ�� �⺻������ ��� �����带 Ǯ�� ������ ������
		 * maximumPoolSize = 100(�� ���� �Ѿ�� RejectedExecutionException �߻�)
		 * keepAliveTime = 10	(idle �������� keep alive time)
		 * TimeUnit.SECONDS		(keepAliveTime�� �ð� ����)
		 * workQueue = bq		(corePoolSize��  �Ѿ�� ��������� ť�� ó���ϱ� ���� ť ����)
		 * */
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,100,10,TimeUnit.SECONDS, bq);
		
		Runnable task = new Task2();
		for(int i=0;i<100;i++) {
			threadPoolExecutor.execute(task);
		}
		System.out.println("������ �� ����"); 
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
