package dynamicProgramming;

public class FrogClimb {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30,10,20,30,10,40};
        int cost = climbStairs(arr);
        System.out.println("Cost: "+cost);
        int costByK = climbStairsByKSteps(arr,2);
        System.out.println("CostByK: "+costByK);
    }

    private static int climbStairs(int[] arr) {
        int memo[] = new int[arr.length];
        int i=2;
        if(arr.length>=1){
            memo[1]=Math.abs(arr[0]-arr[1]);
        }
        while(i<arr.length){
            int oneDist = memo[i-1]+Math.abs(arr[i-1]-arr[i]);
            int twoDist = memo[i-2]+Math.abs(arr[i-2]-arr[i]);
            memo[i] = Math.min(oneDist,twoDist);
            i++;
        }
        return memo[i-1];
    }
    private static int climbStairsByKSteps(int[] arr,int k) {
        int memo[] = new int[arr.length];
        int i=2;
        if(arr.length>=1){
            memo[1]=Math.abs(arr[0]-arr[1]);
        }
        while(i<arr.length){
            int minDist =  Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i>=j)
                 minDist = Math.min(memo[i-j]+Math.abs(arr[i-j]-arr[i]),minDist);
            }
            memo[i] = minDist;
            i++;
        }
        return memo[i-1];
    }
}
