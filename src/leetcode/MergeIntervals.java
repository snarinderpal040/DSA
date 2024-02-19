package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
				
		List<List<Integer>> list = new ArrayList<>();
		
		
		int start = 0;
		int end = intervals.length - 1;
		
		while(start < end) {
			List<Integer> curr = new ArrayList<>();
			if(intervals[start][1] >= intervals[start + 1][0]) {
				curr.add(intervals[start][0]);
				curr.add(intervals[start + 1][1]);
				list.add(curr);
				start = start+2;
			}else {
				curr.add(intervals[start][0]);
				curr.add(intervals[start][1]);
				list.add(curr);
				start = start + 1;
				
				if(start == end) {
					List<Integer> last = new ArrayList<>();
					last.add(intervals[start][0]);
					last.add(intervals[start][1]);
					
					list.add(last);
				}
			}
			
			
		}
		int[][] arr = new int[list.size()][2];
		
		for(int i = 0; i < list.size(); i++) {
			arr[i][0] = list.get(i).get(0);
			arr[i][1] = list.get(i).get(1);
		}
		
		return arr;
    }

	
	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		int[][] merge = merge(intervals);
		
		for(int i = 0 ; i < merge.length; i++) {
			System.out.println(merge[i][0] + " " + merge[i][1]);
		}
	}
}
