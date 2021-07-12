package Hash;

import java.util.LinkedList;

public class HashTable {
	class Node{
		String key;
		String value;
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		String getValue() {
			return value;
		}
		
		void setValue(String value) {
			this.value = value;
		}
	}
	
	//각 배열 칸에 링크드리스트를 넣음으로서 collision이 발생할 시 뒤에 이어나간다.
	LinkedList<Node>[] data;
	
	//해시테이블을 생성하는 순간 생성자를 통해서 배열 크기 초기화
	HashTable(int size){
		this.data = new LinkedList[size];
	}
	
	//키를 해쉬코드로 변환하는 메소드
	int getHashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
	
	//해쉬코드를 배열의 인덱스로 변환하는 메소드
	int convertHashCodeToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	//배열의 인덱스에 노드가 여러개 있다면 key를 통해 알맞은 value를 찾는 메소드
	Node searchKey(LinkedList<Node> list , String key) {
		//리스트에 아무것도 없으면 null 반환
		if(list == null) {
			 return null;
		}
		
		//리스트에 있는 노드중에 찾는 key를 가진 노드가 있다면 반환
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		
		//리스트에 노드가 없다면 null 반환
		return null;
	}
	
	//key-value를 저장하는 메소드
	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int index = convertHashCodeToIndex(hashcode);
		
		//배열의 해당 인덱스에 들어가있던 리스트 가져온다
		LinkedList<Node> list = data[index];
		
		//배열의 해당 인덱스 번지에 아직 리스트가 없다면
		if(list == null) {
			//리스트 만들고 해당 인덱스에 넣는다
			list = new LinkedList<Node>();
			data[index] = list;
		}
		
		//가져온 리스트에 지금 넣고자하는 key가 먼저 들어가있는지 확인
		Node node = searchKey(list, key);
		
		//노드가 없다면 처음 들어가는 key라는 의미
		if(node == null) {
			list.addLast(new Node(key, value));
		}
		else {
			//이미 해당 key로 들어가있는 노드가 있다면 지금 넣는 key로 덮어쓰기
			node.value = value;
		}
	}
	
	//key를 통해 value 가져오는 메소드
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertHashCodeToIndex(hashcode);
		LinkedList<Node> list = data[index];
		
		//해당 인덱스에 있는 list에서 key를 통해 value를 찾는다
		Node node = searchKey(list, key);
		
		//해당 key값의 node가 없으면 Not Found반환, 있으면 value 반환
		return node == null ? "Not Found" : node.value;
	}
}