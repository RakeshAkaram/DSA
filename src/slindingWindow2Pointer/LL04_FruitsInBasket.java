package slindingWindow2Pointer;

import java.util.HashMap;
import java.util.Map;

public class LL04_FruitsInBasket {
    public static void main(String[] args) {
        int nums[] = {3,3,3,1,2,1,1,2,3,3,4};
        int k=2;
        int maxNoOFFruits =  maxNoOfFruitsForKBaskets(nums,k);
        System.out.println("Max No of Fruits: "+maxNoOFFruits);
    }
    //First Approach
    private static int maxNoOfFruitsForKBaskets(int[] nums, int k) {
        int leftIndex=0,rightIndex=0;
        int maxLength=0;
        Map<Integer,Integer> fruitCountMap = new HashMap<>();
        while (rightIndex<nums.length){
            int currentValue = nums[rightIndex];
            if(fruitCountMap.get(currentValue)!=null){
                int count = fruitCountMap.get(currentValue);
                fruitCountMap.put(currentValue,count+1);
            }else{
                fruitCountMap.put(currentValue,1);
            }
            if(fruitCountMap.size()<=k){
                maxLength=Math.max(maxLength,rightIndex-leftIndex+1);
            }else{
                while (fruitCountMap.size()>k){
                    int leftFruit = nums[leftIndex];
                    int fruitsPresent = fruitCountMap.get(leftFruit);
                    if(fruitsPresent==1){
                        fruitCountMap.remove(leftFruit);
                    }else{
                        fruitCountMap.put(leftFruit,fruitsPresent-1);
                    }
                    leftIndex++;
                }
            }
            rightIndex++;
        }
        return maxLength;
    }
}
