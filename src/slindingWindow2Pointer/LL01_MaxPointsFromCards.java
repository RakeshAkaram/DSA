package slindingWindow2Pointer;

public class LL01_MaxPointsFromCards {
    public static void main(String[] args) {
        int cards[] = {6,2,3,4,7,2,1,7,1};
        int k=4;
        int maxValue = -1;
        if(k<cards.length)
            maxValue = maximumPointsObtainedFromCards(cards,k);
        System.out.println("Max Value: "+maxValue);
    }

    private static int maximumPointsObtainedFromCards(int[] cards, int k) {
        int rightIndex=cards.length-1;
        int leftIndex=k-1;
        int leftSum=0,rightSum=0;
        for(int i=0;i<k;i++) leftSum+=cards[i]; //First Sum
        int maxSum=leftSum;
        while(leftSum!=0){
            leftSum-=cards[leftIndex--];
            rightSum+=cards[rightIndex--];
            int sum = leftSum+rightSum;
            if(sum>maxSum) maxSum=sum;
        }
        return maxSum;
    }
    //Time Complexity: O(k+k)= O(2k)
    //Space Complexity: O(1)
}
