package Hash;

public class HashTest {

	public static void main(String[] args) {
		
		//ũ�� 3�� �ؽ����̺� ����
		HashTable ht = new HashTable(3);
		
		ht.put("Lee", "lee is pretty");
		ht.put("Kim", "kim is smart");
		ht.put("Hee", "hee is an angel");
		ht.put("Choi", "choi is cute");
		
		//�����ϴ� ������ �˻�
		System.out.println(ht.get("Lee"));
		System.out.println(ht.get("Kim"));
		System.out.println(ht.get("Hee"));
		System.out.println(ht.get("Choi"));

		//�������� �ʴ� ������ �˻�
		System.out.println(ht.get("Kang"));
		
		//���� ������ �����
		ht.put("Choi", "choi is sexy");
		System.out.println(ht.get("Choi"));
	}
}
