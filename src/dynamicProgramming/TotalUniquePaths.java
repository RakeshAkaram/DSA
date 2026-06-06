package dynamicProgramming;

public class TotalUniquePaths  {
    public static void main(String[] args) {
        int n=3;
        int m=3;
       int result = totalUniquePaths(n,m);
        System.out.println("Total Number of Ways: "+result);
    }

    private static int totalUniquePaths(int n, int m) {
        int[][] arr = new int[n][m];
        arr[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i+1<n)
                    arr[i+1][j]=arr[i+1][j]+arr[i][j];
                if(j+1<m)
                    arr[i][j+1]=arr[i][j+1]+arr[i][j];
            }
        }
        return arr[n-1][m-1];
    }
}
