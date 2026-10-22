package dynamicProgramming;

public class DP37_BuynSellStock3 {
    static int profit=0;
    public static void main(String[] args) {
        int prices[]={1,2,3,4,5};
        int k=2;
        int profit = buyNSellStock3(prices,0,true,k);
        System.out.println("Profit "+profit);
    }
    //Recursive solution
    private static  int buyNSellStock3(int arr[],int index,boolean buy,int k){
        if(index>=arr.length ||k<=0) return 0;
        if(buy){
            profit = Math.max(-arr[index]+buyNSellStock3(arr,index+1,false,k), buyNSellStock3(arr, index+1, true,k));
        }else{
            profit = Math.max(arr[index]+buyNSellStock3(arr,index+1,true,k-1), buyNSellStock3(arr,index+1,false,k));
        }
        return profit;
    }
}

