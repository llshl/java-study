package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface		//@FunctionalInterface�� �� �Ѱ��� �߻� �޼��带 ������ �������̽�
interface MyFunction {
	void run();  			// public abstract�� ������
}


@FunctionalInterface		//abstract�޼��常 1���� �����Ǹ� �Լ��� �������̽���� �� �� �ִ�.
interface MyFunction2 {
	void run();  			//�갡 abstract �޼���
	static void run2() {
		System.out.println("this is run2");
	}
	default void run3() {};
}

/*
 * �Լ��� �������̽��� ����ϴ� ������ ���ٽ��� �Լ��� �������̽��θ� ������ �Ǳ� ���� 
 * �Լ��� �������̽����� "�߻�޼���"�� �Ѱ��� ������ �ȴ�. static�޼��峪 default�޼���� �������
 * ���ٽ��� "�͸�ü"�̴�.
 */

public class lambda {
	
	public static void main(String[] args) {
		
		//���û�Ȳ1
		// �͸�Ŭ������ run()�� ����
		MyFunction f1 = new MyFunction() {  
			public void run() {   // public�� �ݵ�� �ٿ��� ��
				System.out.println("�͸�Ŭ������ ����");
			}
		};
		
		//���ٽ����� �ٲܶ��� [����������][��ȯŸ��][�޼����̸�]����
		//return ����
		//{}���� ������ ��쿡�� {} ��������
		
		// ���ٽ����� MyFunction�� run()�� ����
		MyFunction f2 = ()-> System.out.println("���ٽ����� ����");
		
		f1.run();
		f2.run();	//�Լ��� �������̽��̱⶧���� run�̶�� �޼��� �̸��� ����� �� �ִ�.
		
		
		
		//���û�Ȳ2
		List<String> list = new ArrayList<>();
		list.add("qwer");
		list.add("asdf");
		list.add("zxcv");
		
		//�͸� Ŭ������ ����
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		//���ٽ����� ����
		Collections.sort(list, (s1,s2) -> s1.length()-s2.length());
		
		//Comparator ���ǿ� ������ @FunctionalInterface ������̼� �ִ�. �� �굵 �Լ��� �������̽��̴�.
	}
}
