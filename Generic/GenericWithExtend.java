package Generic;

abstract class Info{
    public abstract int getLevel();
}
class EmployeeInfo extends Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{
    public T info;
    Person(T info){ this.info = info; }
}

public class GenericWithExtend {

	public static void main(String[] args) {
		Person p1 = new Person(new EmployeeInfo(1));
        Person<String> p2 = new Person<String>("∫Œ¿Â");
	}

}
