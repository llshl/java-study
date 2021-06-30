package Static;

class Foo{
	public static String s1 = "i am static";
	public String s2 = "i am instance";
}


public class static_practice {
	public static void main(String[] args) {
		//System.out.println(Foo.s1);
		//System.out.println(Foo.s2);
		
		Foo foo1 = new Foo();
		System.out.println("foo1.s1: "+foo1.s1);
		System.out.println("foo1.s2: "+foo1.s2);
		
		Foo foo2 = new Foo();
		System.out.println("foo2.s1: "+foo2.s1);
		System.out.println("foo2.s2: "+foo2.s2);
		
		System.out.println("====º¯°æ====");
		
		foo2.s1 = "changed s1 (foo2)";
		foo2.s2 = "changed s2 (foo2)";
		
		System.out.println("foo1.s1: "+foo1.s1);
		System.out.println("foo1.s2: "+foo1.s2);
		System.out.println("foo2.s1: "+foo2.s1);
		System.out.println("foo2.s2: "+foo2.s2);
	}
}
