package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
    /*
    * "0" - Empty Space
    * "1" - Fresh Orange
    * "2" - Rotten Orange*/
    static Scanner scanner;
    private static int[][] data;
    private static int[][] output;
    static Queue<int[]> queue=new LinkedList<>();
    static int maxLevel=0;

    public static void main(String[] args) {
        //Step 1: getData
        getData();
        //step 2: RottenOranges to its Adjacent
        if(rottenOrange())
            System.out.println("All the Oranges were Rotten to level: "+maxLevel);
        else
            System.out.println("Not all Oranges were rotten");

    }

    private static boolean rottenOrange() {
        output=data.clone();

        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                if(data[i][j]==2){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        bfs();

        // START
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
        // END
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                if(output[i][j]==1)
                    return false;
            }
        }

        return true;
    }

    private static void bfs() {

        int rowSize=output.length;
        int colSize=output[0].length;
        int r,c,count;

        while(!queue.isEmpty()){
            int [] hdata=queue.poll();
            r=hdata[0];
            c=hdata[1];
            count=hdata[2];

            if(count>maxLevel) maxLevel = count; // To Know which level where all the oranges were got rotten

            //1. top
            if(r-1>=0 && output[r-1][c]==1){
                queue.add(new int[]{r-1,c,count+1});
                output[r-1][c]=2;
            }
            //2. down
            if(r+1<rowSize && output[r+1][c]==1){
                queue.add(new int[]{r+1,c,count+1});
                output[r+1][c]=2;
            }
            //3. left
            if(c-1>=0 && output[r][c-1]==1){
                queue.add(new int[]{r,c-1,count+1});
                output[r][c-1]=2;
            }
            //4. right
            if(c+1<colSize && output[r][c+1]==1){
                queue.add(new int[]{r,c+1,count+1});
                output[r][c+1]=2;
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
