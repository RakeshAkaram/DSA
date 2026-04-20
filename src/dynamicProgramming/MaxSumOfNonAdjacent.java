package dynamicProgramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacent {
    public static void main(String[] args) {
        // Replaced single-example main with a multi-case test runner
        int[][] tests = new int[][]{
            {},
            {5},
            {5,1},
            {3,2,5,10,7},
            {10,2,4,5,3,6,7},
            {0,0,0},
            {5,5,10,100,10,5}
        };
        int[] expected = new int[]{
            0, // empty
            5, // single
            5, // two elements
            15, // 3+5+7
            24, // computed expected for original example
            0, // zeros
            110 // known test
        };

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int[] input = tests[i];
            int exp = expected[i];
            // maxSum mutates the array in-place, so pass a copy when we want to reuse the original
            int[] copy = new int[input.length];
            System.arraycopy(input, 0, copy, 0, input.length);
            int result = maxSum(copy);
            //int result = houseRobber(copy,0,input.length-1);
            boolean ok = result == exp;
            System.out.printf("Test %d: input=%s expected=%d got=%d => %s\n",
                    i + 1, toString(input), exp, result, ok ? "PASS" : "FAIL");
            if (ok) passed++;
        }
        System.out.printf("%d/%d tests passed.%n", passed, tests.length);
    }

    // small helper to format arrays nicely
    private static String toString(int[] a) {
        if (a == null) return "null";
        if (a.length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(a[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    // changed access to public so tests can call it; preserved algorithm
    public static int maxSum(int[] arr) {
     /*   f(n) = f(n)+ Max(f[n-2],f(n-3)); n->2..arr.length
           f(0) = f(0)
           f(1)=f(1)
        f(-1) = 0;*/
        int i = 2;
        int n = arr.length;
        if (n == 0) return 0;
        if (n < 3) {
            if (n == 1) {
                return arr[0];
            } else {
                return Math.max(arr[0], arr[1]);
            }
        }
        while (i < arr.length) {
            if (i - 3 < 0) {
                arr[i] = arr[i] + arr[i - 2];
            } else {
                arr[i] = arr[i] + Math.max(arr[i - 2], arr[i - 3]);
            }
            i++;
        }
        return Math.max(arr[n - 1], arr[n - 2]);
    }

    public static int maxSumHR(int[] arr,int startIndex,int endIndex) {

        int i = startIndex+2;
        int n = endIndex-startIndex;
        int arrResult[] = Arrays.copyOf(arr,arr.length);

        while (i < n) {
            if (i - 3 < 0) {
                arrResult[i] = arrResult[i] + arrResult[i - 2];
            } else {
                arrResult[i] = arrResult[i] + Math.max(arrResult[i - 2], arrResult[i - 3]);
            }
            i++;
        }
        return Math.max(arrResult[n - 1], arrResult[n - 2]);
    }

    public static int houseRobber(int arr[],int startIndex,int endIndex){
        int len = arr.length;
        int n = endIndex-startIndex+1;
        if (n == 0) return 0;
        if (n < 3) {
            if (n == startIndex+1) {
                return arr[startIndex];
            } else {
                return Math.max(arr[startIndex], arr[startIndex+1]);
            }
        }
        int withFirstElement = maxSumHR(arr,0,len-1);
        int withLastElement = maxSumHR(arr,1,len);
        return Math.max(withLastElement,withFirstElement);
    }
}
