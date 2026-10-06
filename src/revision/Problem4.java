package revision;
//Sliding Window: L4: Max Consecutive 1s III
public class Problem4 {
    public static void main(String[] args) {
        int k=3;
        int arr[]={1,1,1,0,0,0,1,1,1,1};
        int maxOnes = countMaxOnes(arr,k);
        System.out.println("Max Ones: "+maxOnes);
    }

    private static int countMaxOnes(int[] arr, int k) {
        int startIndex=0;
        int endIndex= 0;
        int maxOnes =0;
        int p=k;
        while(startIndex<=endIndex && endIndex< arr.length){
            if(arr[endIndex]==1){
                endIndex++;
                maxOnes = Math.max(maxOnes,endIndex-startIndex);
            }else{
                if(k!=0){
                    if(p>0){
                        p--;
                        endIndex++;
                        maxOnes = Math.max(maxOnes,endIndex-startIndex);
                    }
                    else{
                        if(arr[startIndex]==0)
                            p++;
                        if(p>k) p=k;
                        startIndex++;
                    }
                }else{
                    endIndex++;
                    startIndex = endIndex;
                }
            }
        }
        return maxOnes;
    }
}
