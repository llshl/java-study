package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        // ExecutorService �������̽� ������ü Executors �����޼��带 ���� �ִ� ������ ������ 2�� ������ Ǯ ���� 
        ExecutorService executorService = Executors.newFixedThreadPool(2);
         
        for(int i = 0; i < 10; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //�����忡�� ��ų �۾� ����
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();//������ Ǯ ������ ���
                    String threadName = Thread.currentThread().getName();//������ Ǯ�� �ִ� �ش� ������ �̸� ���
                    System.out.println("[�� ������ ����:" + poolSize + "] �۾� ������ �̸�: "+threadName);
                     
                    //�Ϻη� ���� �߻� ��Ŵ
                    int value = Integer.parseInt("����");
                }
            };
            //������Ǯ���� �۾� ó�� ��û
            executorService.execute(runnable);
            //executorService.submit(runnable);
            //�ܼ� ��� �ð��� �ֱ� ���� ���ν����� 0.01�� sleep�� �ɾ��.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
             
        }
        //������Ǯ ����
        executorService.shutdown();
    }
}