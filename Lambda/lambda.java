package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface		//@FunctionalInterface란 단 한개의 추상 메서드를 가지는 인터페이스
interface MyFunction {
	void run();  			// public abstract가 생략됨
}


@FunctionalInterface		//abstract메서드만 1개가 유지되면 함수형 인터페이스라고 할 수 있다.
interface MyFunction2 {
	void run();  			//얘가 abstract 메서드
	static void run2() {
		System.out.println("this is run2");
	}
	default void run3() {};
}

/*
 * 함수형 인터페이스를 사용하는 이유는 람다식이 함수형 인터페이스로만 접근이 되기 때문 
 * 함수형 인터페이스에는 "추상메서드"가 한개만 있으면 된다. static메서드나 default메서드는 상관없음
 * 람다식은 "익명객체"이다.
 */

public class lambda {
	
	public static void main(String[] args) {
		
		//예시상황1
		// 익명클래스로 run()을 구현
		MyFunction f1 = new MyFunction() {  
			public void run() {   // public을 반드시 붙여야 함
				System.out.println("익명클래스로 구현");
			}
		};
		
		//람다식으로 바꿀때는 [접근제어자][반환타입][메서드이름]생략
		//return 생략
		//{}안이 한줄일 경우에는 {} 생략가능
		
		// 람다식으로 MyFunction의 run()을 구현
		MyFunction f2 = ()-> System.out.println("람다식으로 구현");
		
		f1.run();
		f2.run();	//함수형 인터페이스이기때문에 run이라는 메서드 이름을 사용할 수 있다.
		
		
		
		//예시상황2
		List<String> list = new ArrayList<>();
		list.add("qwer");
		list.add("asdf");
		list.add("zxcv");
		
		//익명 클래스로 구현
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		//람다식으로 구현
		Collections.sort(list, (s1,s2) -> s1.length()-s2.length());
		
		//Comparator 정의에 들어가보면 @FunctionalInterface 어노테이션 있다. 즉 얘도 함수형 인터페이스이다.
	}
}
