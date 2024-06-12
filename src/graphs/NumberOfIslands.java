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
        getDate();
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
            // Check in all 8 directions

        }
    }

    private static void getDate(){
        System.out.println("Enter the Row and Columns values");
        int row,col;
        Scanner scanner = new Scanner(System.in);
        row=scanner.nextInt();
        col=scanner.nextInt();

        data=new int[row][col];
        visited=new int[row][col];

        System.out.println("Enter the data:");
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                data[i][j]=scanner.nextInt();
    }

}
