package dynamicProgramming;

import java.util.Arrays;

//Note: Its Variable start point and Variable Endpoint
public class DP12_MaxPathSum {
    public static void main(String[] args) {
        int[][] arr= {{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int result  = maxPathSum(arr);
        System.out.println("Result:"+result);
    }

    private static int maxPathSum(int[][] arr) {
        int n= arr.length;
        int m=arr[0].length;
        int[][] resultArr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if (i == 0) resultArr[i][j] = arr[i][j];
                else resultArr[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(i+1<n){
                    if(j-1>0)
                        resultArr[i+1][j-1] = Math.max(resultArr[i+1][j-1],resultArr[i][j]+arr[i+1][j-1]);
                    if(j+1<m)
                        resultArr[i+1][j+1] = Math.max(resultArr[i+1][j+1],resultArr[i][j]+arr[i+1][j+1]);
                    resultArr[i+1][j] = Math.max(resultArr[i+1][j],resultArr[i][j]+arr[i+1][j]);
                }
            }
        }
        return Arrays.stream(resultArr[n-1]).max().orElse(-1);
    }
}
