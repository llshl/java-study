package Lambda;

import java.util.Arrays;
import java.util.List;

public class Stream {
	//stream은 collection을 중간 가공과정을 거치고 최종 결과로 반환하는것
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		System.out.println("-------Using Lambda Functions--------");
		//Using Lambda function to call system.out.println()
		myList.stream().map(s -> s.toUpperCase())					//map은 요소들을 특정조건으로 변환
				.forEach(s -> System.out.println(s));				//forEach는 반복문

		
		System.out.println("-------Using Method Reference--------");
		 //Using Method reference to call system.out.println()
		myList.stream().map(String::toUpperCase)					//더블콜론::을 사용하는방법.
				.forEach(System.out::println);						//[타겟레퍼런스::메소드명]
	}

}
