/**
 * Created by sivan on 10/16/18.
 */

import java.util.HashSet;
class findPairs
{
    static int arr[] = new int[]{12,1,1,1, 2,3,5,6,0, 7, -1, 5,11} ;

    // Returns number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    static void printpairs(int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && s.contains(temp))
            {
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", "+temp+")");
            }
            s.add(arr[i]);
        }
        System.out.println(s);
    }
    public static void printPairsnsquare(int sum)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++)
            {
                int second = arr[j];
                if ((first + second) == sum)
                {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }
        }
    }

    // Driver method to test the above function
    public static void main(String[] args) {

        int sum = 6;
        System.out.println("algo for n times: ");
        printpairs(sum);
        System.out.println("algo for n2 times");
        printPairsnsquare(sum);

    }
}
