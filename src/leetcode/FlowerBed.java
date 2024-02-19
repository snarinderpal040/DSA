package leetcode;

public class FlowerBed {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n == 0) {
			return true;
		}
		if(flowerbed.length == 1 && n == 1) {
			if(flowerbed[0] == 0) {
				return true;
			}else {
				return false;
			}
		}
		
		if(flowerbed[0] == 0 && flowerbed[1] == 0) {
			n--;
			flowerbed[0] = 1;
		}
		
		for(int i = 1; i < flowerbed.length - 1; i++) {
			if(flowerbed[i] == 0) {
				if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
					n--;
					flowerbed[i] = 1;
				}
			}
		}
		
		if(flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
			flowerbed[flowerbed.length - 1] = 1;
			n--;
		}
		
		return n <= 0; 
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {1,0,0,0,1,0,0,0,0};
		System.out.println(canPlaceFlowers(flowerbed, 3));
		
	}

}
