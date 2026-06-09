package dynamicProgramming;

import java.util.Arrays;

public class DP12_MinPathSum {
    public static void main(String[] args) {
        int[][] arr= {{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int result  = minPathSumVV(arr);
        System.out.println("Result:"+result);
    }

    private static int minPathSumVV(int[][] arr) {
        int n= arr.length;
        int m=arr[0].length;
        int[][] resultArr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if (i == 0) resultArr[i][j] = arr[i][j];
                else resultArr[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(i+1<n){
                    if(j-1>=0)
                        resultArr[i+1][j-1] = Math.min(resultArr[i+1][j-1],resultArr[i][j]+arr[i+1][j-1]);
                    if(j+1<m)
                        resultArr[i+1][j+1] = Math.min(resultArr[i+1][j+1],resultArr[i][j]+arr[i+1][j+1]);
                    resultArr[i+1][j] = Math.min(resultArr[i+1][j],resultArr[i][j]+arr[i+1][j]);
                }
            }
        }
        return Arrays.stream(resultArr[n-1]).min().orElse(-1);
    }
}
