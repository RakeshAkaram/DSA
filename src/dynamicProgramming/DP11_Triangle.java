package dynamicProgramming;

import java.util.Arrays;

//Note: Fixed Starting point and variable ending point
public class DP11_Triangle {
    public static void main(String[] args) {
        int[][] arr={{1,0,0,0},{2,3,0,0},{3,6,7,0},{8,9,6,10}};
        int result = findMinPathSum(arr);
        System.out.println("Result:"+ result);
    }

    private static int findMinPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] resultArr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                resultArr[i][j]=Integer.MAX_VALUE;
            }
        }
        resultArr[0][0]=arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i+1<n){
                        resultArr[i+1][j] = Math.min(resultArr[i+1][j],resultArr[i][j]+arr[i+1][j]);
                    if(j+1<m)
                        resultArr[i+1][j+1] = Math.min(resultArr[i+1][j+1],resultArr[i][j]+arr[i+1][j+1]);
                }
            }
        }
        return Arrays.stream(resultArr[n-1]).min().orElse(-1);
    }
}
