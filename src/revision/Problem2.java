package revision;
//DP 35: Best Time to Buy and sell stock
public class Problem2 {
    public static void main(String[] args) {
        int arr[]= {7,1,5,3,6,4};
        int profit = buySellStock(arr);
        System.out.println("Profit: "+profit);
    }

    private static int buySellStock(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for(int i=1;i<arr.length;i++){
            int profit = arr[i]-min;
            maxProfit = Math.max(maxProfit,profit);
            min = Math.min(min,arr[i]);
        }
        return maxProfit;
    }
}
