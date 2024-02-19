package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
	
	//Sorted on end time basis already
	public static void selectActivities(int[] start, int[] end) {
		int maxActivities = 0;
		List<Integer> list = new ArrayList<>();
		
		maxActivities = 1;
		list.add(0);
		int lastEnd = end[0];
		
		for(int i = 1; i < start.length; i++) {
			if(lastEnd <= start[i]) {
				list.add(i);
				maxActivities++;
				lastEnd = end[i];
			}
		}
		
		System.out.println("Max Activities are : " + maxActivities);
		list.stream().forEach(n -> System.out.print("A" + n + " "));
	}
	
	//Not sorted on end time basis
	public static void maxActivities(int[] start, int[] end) {
		int max = 0;
		List<Integer> list = new ArrayList<>();
		int[][] activities = new int[start.length][3];
		
		for(int i = 0; i < start.length; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
		
		max = 1;
		list.add(activities[0][0]);
		int lastEnd = activities[0][2];
		
		for(int i = 1; i < start.length; i++) {
			if(lastEnd <= activities[i][1]) {
				max++;
				list.add(activities[i][0]);
				lastEnd = activities[i][2];
			}
		}
		
		System.out.println("Max activities : " + max);
		list.stream().forEach(n -> System.out.print("A" + n + " "));
	}
	
	
	public static void main(String[] args) {
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};
		
		System.out.println("*************** Sorted *******************");
		selectActivities(start, end);
		System.out.println();
		
		
		System.out.println("*************** Not Sorted *******************");
		maxActivities(start, end);
	}

}
