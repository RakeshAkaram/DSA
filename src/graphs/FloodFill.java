package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FloodFill {
    private static int[][] data;
    private static int[][] output;
    private static int colorToFlood,newColor;
    static Scanner scanner;
    public static void main(String[] args) {
        //step 1: Get the data
        getData();
        //step 2: Apply Flood Fill algorithm
        floodFill();
        //step 3: Output the result
        for (int i=0;i< data.length;i++){
            for(int j=0;j<data[0].length;j++)
                System.out.print(output[i][j]);
            System.out.println();
        }

    }

    private static void floodFill() {

        System.out.println("Choose a Color to Replace the Color with: ");
        newColor=scanner.nextInt();
        System.out.println("Enter the position where the Flood Fill should start: ");
        int[] position=new int[]{scanner.nextInt(),scanner.nextInt()};

        output=data.clone();
        System.out.println("Flood Fill started from the index: ("+position[0]+","+position[1]+")");


        colorToFlood=data[position[0]][position[1]];
        System.out.println("Color choosen to Flood Fill: "+colorToFlood);

        bfs(position[0],position[1]);

    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{row,col});
        output[row][col]=newColor;

        while(!queue.isEmpty()){
            int[] pair=queue.poll();
            int iInx=pair[0];
            int jInx=pair[1];

            //Left
            if(iInx-1>=0 && data[iInx-1][jInx]==colorToFlood && output[iInx-1][jInx]!=newColor){
                queue.add(new int[]{iInx-1,jInx});
                output[iInx-1][jInx]=newColor;
            }
            //Right
            if(iInx+1<data.length && data[iInx+1][jInx]==colorToFlood && output[iInx+1][jInx]!=newColor){
                queue.add(new int[]{iInx+1,jInx});
                output[iInx+1][jInx]=newColor;
            }

            //Top
            if(jInx-1>=0 && data[iInx][jInx-1]==colorToFlood && output[iInx][jInx-1]!=newColor){
                queue.add(new int[]{iInx,jInx-1});
                output[iInx][jInx-1]=newColor;
            }
            //Bottom
            if(jInx+1<data[0].length && data[iInx][jInx+1]==colorToFlood && output[iInx][jInx+1]!=newColor){
                queue.add(new int[]{iInx,jInx+1});
                output[iInx][jInx+1]=newColor;
            }
        }
    }

    private static void getData(){
        System.out.println("Enter the Row and Columns values");
        int row,col;
        scanner = new Scanner(System.in);
        row=scanner.nextInt();
        col=scanner.nextInt();

        data=new int[row][col];

        System.out.println("Enter the data:");
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                data[i][j]=scanner.nextInt();
    }
}

/*
Enter the Row and Columns values
3 3
Enter the data:
        1 1 1
        1 1 0
        0 0 1
Choose a Color to Replace the Color with:
        3
Enter the position where the Flood Fill should start:
        1 1
Flood Fill started from the index: (1,1)
Color choosen to Flood Fill: 1
        333
        330
        001*/
