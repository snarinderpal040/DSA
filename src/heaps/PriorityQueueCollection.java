package heaps;

import java.util.PriorityQueue;

class Student implements Comparable<Student>{
	
	public int rollNo;
	public String name;
	
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	@Override
	public int compareTo(Student that) {
		return this.rollNo - that.rollNo;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
	
}

public class PriorityQueueCollection {
	
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>();
		pq.add(new Student(1, "Aviraj"));
		pq.add(new Student(5, "Narinder"));
		pq.add(new Student(3, "Harman"));
		pq.add(new Student(9, "Pargat"));
		pq.add(new Student(2, "Aradhna"));
		pq.add(new Student(2, "Aradhna"));
		
		while(!pq.isEmpty()) 
			System.out.println(pq.remove());
	}

}
