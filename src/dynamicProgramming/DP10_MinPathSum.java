package dynamicProgramming;

public class DP10_MinPathSum {
    public static void main(String[] args) {
        int [][] arr ={{10,8,2},{10,5,100},{1,1,2}};
        int result = minPathSum(arr);
        System.out.println("Result: "+result);
    }

    private static int minPathSum(int[][] arr) {
        int n= arr.length;
        int m = arr[0].length;
        int[][] resultArr = new int[n][m];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                resultArr[i][j]=Integer.MAX_VALUE;
            }
        }
        resultArr[0][0] = arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i+1<n)
                    resultArr[i+1][j] = Math.min(resultArr[i+1][j],arr[i+1][j]+resultArr[i][j]);
                if(j+1<m)
                    resultArr[i][j+1] = Math.min(resultArr[i][j+1],arr[i][j+1]+resultArr[i][j]);
            }
        }
        return resultArr[n-1][m-1];
    }
}
