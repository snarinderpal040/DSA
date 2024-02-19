package leetcode;

public class MergeAlternativily {
	public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        
        StringBuilder word = new StringBuilder();

        while(i < word1.length() && j < word2.length()){
            word.append(word1.charAt(i));
            word.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i < word1.length()) {
        	word.append(word1.charAt(i));
        	i++;
        }
        while(j < word2.length()) {
        	word.append(word2.charAt(j));
        	j++;
        }
        
        return word.toString();
    }

	public static void main(String[] args) {
		System.out.println(mergeAlternately("", "pqrst"));
	}

}
