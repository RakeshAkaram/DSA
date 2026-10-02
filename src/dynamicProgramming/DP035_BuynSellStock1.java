package dynamicProgramming;

public class DP035_BuynSellStock1 {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int profit = buyNSellStock(arr);
        System.out.println(profit);
    }

    private static int buyNSellStock(int[] arr) {
        int minValueTillIndexI = arr[0];
        int maxProfit =  0;
        for(int val:arr){
            int profit = val-minValueTillIndexI;
            maxProfit = Math.max(maxProfit,profit);
            minValueTillIndexI = Math.min(minValueTillIndexI,val);
        }
        return maxProfit;
    }
}
