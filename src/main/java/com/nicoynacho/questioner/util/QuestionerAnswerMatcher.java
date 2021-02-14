package com.nicoynacho.questioner.util;

import java.util.Arrays;

/**
 * This class utilizes a Levenshtein Distance algorithm to compare the answer strings
 * 
 * from wikipedia:
 * 
 * the Levenshtein distance is a string metric for measuring the difference between two sequences. 
 * Informally, the Levenshtein distance between two words is the minimum number of single-character 
 * edits (insertions, deletions or substitutions) required to change one word into the other.
 */
public class QuestionerAnswerMatcher {
	
	public static boolean doAnswersMatch(String ogA, String inA) {
		  int[][] dp = new int[ogA.length() + 1][inA.length() + 1];

		    for (int i = 0; i <= ogA.length(); i++) {
		        for (int j = 0; j <= inA.length(); j++) {
		            if (i == 0) {
		                dp[i][j] = j;
		            }
		            else if (j == 0) {
		                dp[i][j] = i;
		            }
		            else {
		                dp[i][j] = min(dp[i - 1][j - 1] 
		                 + costOfSubstitution(ogA.charAt(i - 1), inA.charAt(j - 1)), 
		                  dp[i - 1][j] + 1, 
		                  dp[i][j - 1] + 1);
		            }
		        }
		    }

		    int distance = dp[ogA.length()][inA.length()];
		    
		    //if the distance is bigger than half of the input string's length, we discard the result 
		    if (distance >= ogA.length() / 2)
		    	return false;
		    
		    return true;
	}
	
    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    
    private static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }

}
