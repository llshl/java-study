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
	
	//�� �迭 ĭ�� ��ũ�帮��Ʈ�� �������μ� collision�� �߻��� �� �ڿ� �̾����.
	LinkedList<Node>[] data;
	
	//�ؽ����̺��� �����ϴ� ���� �����ڸ� ���ؼ� �迭 ũ�� �ʱ�ȭ
	HashTable(int size){
		this.data = new LinkedList[size];
	}
	
	//Ű�� �ؽ��ڵ�� ��ȯ�ϴ� �޼ҵ�
	int getHashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
	
	//�ؽ��ڵ带 �迭�� �ε����� ��ȯ�ϴ� �޼ҵ�
	int convertHashCodeToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	//�迭�� �ε����� ��尡 ������ �ִٸ� key�� ���� �˸��� value�� ã�� �޼ҵ�
	Node searchKey(LinkedList<Node> list , String key) {
		//����Ʈ�� �ƹ��͵� ������ null ��ȯ
		if(list == null) {
			 return null;
		}
		
		//����Ʈ�� �ִ� ����߿� ã�� key�� ���� ��尡 �ִٸ� ��ȯ
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		
		//����Ʈ�� ��尡 ���ٸ� null ��ȯ
		return null;
	}
	
	//key-value�� �����ϴ� �޼ҵ�
	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int index = convertHashCodeToIndex(hashcode);
		
		//�迭�� �ش� �ε����� ���ִ� ����Ʈ �����´�
		LinkedList<Node> list = data[index];
		
		//�迭�� �ش� �ε��� ������ ���� ����Ʈ�� ���ٸ�
		if(list == null) {
			//����Ʈ ����� �ش� �ε����� �ִ´�
			list = new LinkedList<Node>();
			data[index] = list;
		}
		
		//������ ����Ʈ�� ���� �ְ����ϴ� key�� ���� ���ִ��� Ȯ��
		Node node = searchKey(list, key);
		
		//��尡 ���ٸ� ó�� ���� key��� �ǹ�
		if(node == null) {
			list.addLast(new Node(key, value));
		}
		else {
			//�̹� �ش� key�� ���ִ� ��尡 �ִٸ� ���� �ִ� key�� �����
			node.value = value;
		}
	}
	
	//key�� ���� value �������� �޼ҵ�
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertHashCodeToIndex(hashcode);
		LinkedList<Node> list = data[index];
		
		//�ش� �ε����� �ִ� list���� key�� ���� value�� ã�´�
		Node node = searchKey(list, key);
		
		//�ش� key���� node�� ������ Not Found��ȯ, ������ value ��ȯ
		return node == null ? "Not Found" : node.value;
	}
}