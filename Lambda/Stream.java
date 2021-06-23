package Lambda;

import java.util.Arrays;
import java.util.List;

public class Stream {
	//stream�� collection�� �߰� ���������� ��ġ�� ���� ����� ��ȯ�ϴ°�
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		System.out.println("-------Using Lambda Functions--------");
		//Using Lambda function to call system.out.println()
		myList.stream().map(s -> s.toUpperCase())					//map�� ��ҵ��� Ư���������� ��ȯ
				.forEach(s -> System.out.println(s));				//forEach�� �ݺ���

		
		System.out.println("-------Using Method Reference--------");
		 //Using Method reference to call system.out.println()
		myList.stream().map(String::toUpperCase)					//�����ݷ�::�� ����ϴ¹��.
				.forEach(System.out::println);						//[Ÿ�ٷ��۷���::�޼ҵ��]
	}

}
