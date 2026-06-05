package dynamicProgramming;

public class NinjaTraining {
    public static void main(String[] args) {
        //int[][] arr= new int[n][3];
        int[][] arr= {{1,2,5},
                {3,1,1},{3,3,3}};
        int result = ninjaTraining(arr);
        System.out.println("Max Sum: "+result);
    }

    private static int ninjaTraining(int[][] arr) {
        if(arr.length<1) return -1;
        int n = arr.length;
        int m = arr[0].length;
        for(int i=1;i<n;i++){ //run this for all days from 2nd day to nth day
            for(int j=0;j<m;j++){ // To choose an activity
                if(j==0)
                    arr[i][j] = arr[i][j]+ Math.max(arr[i-1][1],arr[i-1][2]);
                else if(j==1)
                    arr[i][j] = arr[i][j]+ Math.max(arr[i-1][0],arr[i-1][2]);
                else if(j==2)
                    arr[i][j] = arr[i][j]+ Math.max(arr[i-1][0],arr[i-1][1]);
            }
        }
        return Math.max(arr[n-1][0],Math.max(arr[n-1][1],arr[n-1][2]));
    }
}
