package dynamicProgramming;

public class DP36_BuynSellStock2 {
    public static void main(String[] args) {
        int prices[]={7,1,5,4,2,6,8,3};
        int profit = buyNSellStock2(prices);
        System.out.println("Profit "+profit);
    }

    private static int buyNSellStock2(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        boolean hold = false;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i-1]<=prices[i])
                hold = true; //continue holding
            else if(prices[i-1]>prices[i]){
                if(hold)
                    profit+=prices[i-1]-buy; //Sell
                buy=prices[i]; //Buy
                hold= false;
            }
        }
        if(hold)
            profit+=prices[prices.length-1]-buy;
        return profit;
    }
}
