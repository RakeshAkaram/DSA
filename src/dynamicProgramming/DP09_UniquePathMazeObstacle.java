package dynamicProgramming;

public class DP09_UniquePathMazeObstacle {
    public static void main(String[] args) {
        /*int[][] arr = {{0,0,-1},
                {0,-1,0},{0,0,-1},{0,0,0}};*/
        //int[][] arr= {{0,0},{0,-1}};
        int[][] arr= {{-1,0}};
        int result = uniquePathMazeObstacle(arr);
        System.out.println("Result: "+result);
    }

    private static int uniquePathMazeObstacle(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        if(arr[n-1][m-1]==-1 || arr[0][0]==-1) return 0;
        arr[0][0]=1;
        for (int i =0;i<n;i++){
            for (int j=0;j<m;j++){
                if(arr[i][j]!=-1){
                    if(i+1<n && arr[i+1][j]!=-1)
                        arr[i+1][j] = arr[i+1][j]+arr[i][j];
                    if(j+1<m && arr[i][j+1]!=-1)
                        arr[i][j+1] = arr[i][j+1]+arr[i][j];
                }
            }
        }
        return arr[n-1][m-1];
    }
}
