package slindingWindow2Pointer;

public class LL03_MaxNoOfConsecutiveOnes {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int maxLength = maxOnesWithKReplacements(nums,k);
        System.out.println("Max Length: "+maxLength);
    }
    //First Approach:
    private static int maxOnesWithKReplacements(int[] nums, int k) {
        int maxLength = 0;
        int leftIndex=0,rightIndex=0;
        int noOfZeros = 0;
        while (rightIndex<nums.length && leftIndex<=rightIndex){
             if(nums[rightIndex]==0){
                noOfZeros++;
            }
            if(noOfZeros<=k){
                maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
            }else{
                while(noOfZeros>k)
                    if(nums[leftIndex++]==0) noOfZeros--;
            }
            rightIndex++;
        }
        return maxLength;
    }
}
