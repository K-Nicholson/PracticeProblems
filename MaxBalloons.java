/*
Maximum Number of Balloons
Task:
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0

Constraints:
1 <= text.length <= 104
text consists of lower case English letters only.
*/


package LeetCode;
import java.util.*;


public class MaxBalloons {
    public static void main(String args[]){
        String[] tests = new String[] {"nlaebolko","loonbalxballpoon","leetcode"};
        int[] expected = new int[] {1,2,0};

        for( int i=0;i<tests.length;i++){
            if (maxNumberOfBalloons(tests[i])==expected[i]){
                System.out.println(i + " Pass");
            }
            else{
                System.out.println(i + " Fail");
            }
        }


    }
    public static int maxNumberOfBalloons(String text) {
        //make text iterable
        char[] charArr = text.toCharArray();
        HashMap map  = new HashMap();
        
        //add letters to hashmap
        for(char c: charArr){
            //only add letters contained in "balloon"
            if( c=='b'|| c =='a'|| c=='l' || c=='o'|| c=='n'){
                if(map.containsKey(c)){
                map.put(c,((int)map.get(c)+1));
                }
                else{
                    map.put(c,1);
                }
            }
        }
        
        //can only spell "balloon" with double "l" and double "o"
        if(map.containsKey('l') && map.containsKey('o')){
            map.put('l',(int)map.get('l')/2);
            map.put('o',(int)map.get('o')/2);
        }
        
        //checks if you can spell "balloon" at least once
        boolean containsAll = false;
        for(Object c: map.keySet()){
            if(map.containsKey('b')
              && map.containsKey('a')
              && map.containsKey('l')
              && map.containsKey('o')
              && map.containsKey('n')){
                containsAll = true;
              }
        }
        
        //if can't spell balloon, return 0
        if (!containsAll){
            return 0;
        }
        //if can spell word find min times you can spell balloon
        else{
            int min = Integer.MAX_VALUE;
            for(Object c: map.keySet()){
                if((int)map.get(c)< min){
                    min = (int)map.get(c);
                }
            }
            return min;  
        }

    }
}
