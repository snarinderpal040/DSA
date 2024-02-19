package maps;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class HashMapImpl {
	
	static class HashMap<K,V> {
		private int n;//size of ll
		private int N;//number of buckets
		private LinkedList<Node>[] buckets;
		
		@SuppressWarnings("unchecked")
		public HashMap() {
			n = 0;
			N = 4;
			buckets = new LinkedList[N];
			for(int i = 0; i < buckets.length; i++) {
				buckets[i] = new LinkedList<>();
			}
		}
		
		private class Node{
			K key;
			V value;
			
			Node(K key, V value){
				this.key = key;
				this.value = value;
			}
		}
		
		
		public void put(K key, V value) {
			int bi = hashFunction(key);
			int di = searchInLinkedList(key, bi);
			
			if(di == -1) {
				buckets[bi].add(new Node(key, value));
				n++;
			}else {
				Node node = buckets[bi].get(di);
				node.value = value;
			}
			
			double lambda = (double) n / N;
			if(lambda > 2.0) {
				rehash();
			}
			
		}

		@SuppressWarnings("unchecked")
		private void rehash() {
			System.out.println("Rehasing...");
			LinkedList<Node> oldBuckets[] = buckets;
			this.n = 0;
			this.N = N * 2;
			buckets = new LinkedList[N];

			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<>();
			}

			for (int i = 0; i < oldBuckets.length; i++) {
				LinkedList<Node> ll = oldBuckets[i];
				for (int j = 0; j < ll.size(); j++) {
					Node node = ll.get(j);
					put(node.key, node.value);
				}
			}
		}

		private int searchInLinkedList(K key, int bi) {
			LinkedList<Node> ll = buckets[bi];
			for(int i = 0; i < ll.size(); i++) {
				Node node = ll.get(i);
				if(node.key == key) {
					return i;
				}
				
			}
			return -1;
		}

		private int hashFunction(K key) {
			int hashCode = key.hashCode();
			int abs = Math.abs(hashCode);
			return abs % N;
		}
		
		public boolean containsKey(K key) {
			int bi = hashFunction(key);
			int di = searchInLinkedList(key, bi);
			if(di == -1) {
				return false;
			}
			return true;
		}
		
		public V get(K key) {
			int bi = hashFunction(key);
			int di = searchInLinkedList(key, bi);
			
			if(di == -1) {
				return null;
			}
			return buckets[bi].get(di).value;
		}
		
		public V remove(K key) {
			int bi = hashFunction(key);
			int di = searchInLinkedList(key, bi);

			if (di == -1) {
				return null;
			} else {
				V value = buckets[bi].get(di).value;
				buckets[bi].remove(di);
				n--;
				return value;
			}
		}
		
		public Set<K> keySet() {
			Set<K> set = new HashSet<>();
			for (int i = 0; i < buckets.length; i++) {
				LinkedList<Node> linkedList = buckets[i];

				for (int j = 0; j < linkedList.size(); j++) {
					set.add(linkedList.get(j).key);
				}
			}
			return set;
		}
		
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("India", 150);
		map.put("China", 140);
		map.put("United States", 60);
		map.put("Canada", 30);
		map.put("Japan", 70);
		map.put("Russia", 80);
		map.put("Pakistan", 101);
		map.put("Australia", 45);
		map.put("New Zealand", 8);
		
		Integer integer = map.get("Russia");
		System.out.println(integer);
		
		System.out.println(map.n);
		
		Set<String> keySet = map.keySet();

		for (String i : keySet) {
			System.out.println(i + " -> " + map.get(i));
		}
		
	}

}
