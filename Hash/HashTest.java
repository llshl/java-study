package Hash;

public class HashTest {

	public static void main(String[] args) {
		
		//크기 3의 해쉬테이블 생성
		HashTable ht = new HashTable(3);
		
		ht.put("Lee", "lee is pretty");
		ht.put("Kim", "kim is smart");
		ht.put("Hee", "hee is an angel");
		ht.put("Choi", "choi is cute");
		
		//존재하는 데이터 검색
		System.out.println(ht.get("Lee"));
		System.out.println(ht.get("Kim"));
		System.out.println(ht.get("Hee"));
		System.out.println(ht.get("Choi"));

		//존재하지 않는 데이터 검색
		System.out.println(ht.get("Kang"));
		
		//기존 데이터 덮어쓰기
		ht.put("Choi", "choi is sexy");
		System.out.println(ht.get("Choi"));
	}
}
