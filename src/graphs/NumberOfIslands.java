package graphs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {
    private static int[][] data;
    private static int[][] visited;
    public static void main(String[] args) {
        //Step 1: Get data
        getData();
        //Step 2: Algorithm
        int count=numberOfIslands(data);
        System.out.println("Total Number of Islands: "+count);
    }

    private static int numberOfIslands(int[][] data) {
        int count=0;
        for(int i=0;i<data.length;i++){
            for (int j=0;j<data[0].length;j++){
                if(data[i][j]==1 && visited[i][j]==0){
                    System.out.println("Starting node index: ("+i+","+j+")");
                    count++;
                    bfs(i,j);
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j]=1;
        while(!queue.isEmpty()){
            int[] pair=queue.poll();
            // Check in all 8 directions
            int m=-1;
            while(m<2){
                int n=-1;
                while (n<2){
                    int iIndex=pair[0]+m;
                    int jIndex=pair[1]+n;
                    if((iIndex<data.length && iIndex>=0) &&  (jIndex< data[0].length && jIndex>=0)){
                        if(visited[iIndex][jIndex]==0 && data[iIndex][jIndex]==1){
                            System.out.println("Index Added to Queue:("+iIndex+","+jIndex+")");
                            queue.add(new int[]{iIndex,jIndex});
                            visited[iIndex][jIndex]=1;
                        }
                    }
                    n++;
                }
                m++;
            }

        }
    }

    private static void getData(){
        System.out.println("Enter the Row and Columns values");
        int m,col;
        Scanner scanner = new Scanner(System.in);
        m=scanner.nextInt();
        col=scanner.nextInt();

        data=new int[m][col];
        visited=new int[m][col];

        System.out.println("Enter the data:");
        for (int i=0;i<m;i++)
            for (int j=0;j<col;j++)
                data[i][j]=scanner.nextInt();
    }

}
//Sample Inputs 1
/*Enter the Row and Columns values
4 5
Enter the data:
1 1 1 1 0
1 1 1 1 1
1 1 0 0 0
0 0 0 0 0
Starting node index: (0,0)
Total Number of Islands: 1*/

//Sample Inputs 2
/*Enter the Row and Columns values
4 5
Enter the data:
1 1 0 0 0
1 1 0 1 0
0 0 0 0 0
0 0 0 1 1
Starting node index: (0,0)
Total Number of Islands: 3*/
