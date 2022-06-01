import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**This problem was asked by Airbnb.

 Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

 For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

 Follow-up: Can you do this in O(N) time and constant space?**/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  lines = br.readLine();
        String[] strs = lines.trim().split(" ");

        ArrayList<Integer> inputArray = new ArrayList<>();
        for (String str : strs) {
            inputArray.add(Integer.parseInt(str));
        }
        int max = maxSumOfNonAdjacentElements(inputArray);
        System.out.println(max);
    }

    private static int maxSumOfNonAdjacentElements(ArrayList<Integer> inputArray) {
       if(inputArray.size()==2)
           return Math.max(inputArray.get(0),inputArray.get(1));
       int maxNotIncluding = Math.max(0,inputArray.get(0));
       int maxIncludingElement = Math.max(inputArray.get(0),inputArray.get(1));
       for(int i =2 ; i< inputArray.size();i++){
           int previousMax = maxIncludingElement;
           maxIncludingElement=Math.max(maxIncludingElement,maxNotIncluding+inputArray.get(i));
           maxNotIncluding = previousMax;
       }
       return Math.max(maxNotIncluding,maxIncludingElement);
    }
}