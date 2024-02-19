package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplUsingHashMap {
	
	public static class Edge{
		int src;
		int dest;
		int weight;
		
		public Edge(int src, int dest, int weight){
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
	}
	
	
	public static void main(String[] args) {
		/*
		        (5)
		     0------- 1
		             / \
		        (1) /   \ (3)
		           /     \
		          2-------3
		          |  (1)
		      (2) |
		          |
		          4
		 */
		
		Map<Integer, List<Edge>> graph = new HashMap<>();
		
		List<Edge> list0 = new ArrayList<>();
		List<Edge> list1 = new ArrayList<>();
		List<Edge> list2 = new ArrayList<>();
		List<Edge> list3 = new ArrayList<>();
		List<Edge> list4 = new ArrayList<>();
	
		list0.add(new Edge(0, 1, 5));
		
		list1.add(new Edge(1, 0, 5));
		list1.add(new Edge(1, 2, 1));
		list1.add(new Edge(1, 3, 3));
		
		list2.add(new Edge(2, 1, 1));
		list2.add(new Edge(2, 3, 1));
		list2.add(new Edge(2, 4, 2));
		
		list3.add(new Edge(3, 1, 3));
		list3.add(new Edge(3, 2, 1));
		
		list4.add(new Edge(4, 2, 2));
		
		graph.put(0, list0);
		graph.put(1, list1);
		graph.put(2, list2);
		graph.put(3, list3);
		graph.put(4, list4);
		
		//2's neighbours
		
		List<Edge> list = graph.get(2);
		list.stream().forEach(n -> System.out.println(n.dest));
		
	}

}
