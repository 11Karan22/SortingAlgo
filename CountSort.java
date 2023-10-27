/*
The first step is to calculate count of each element in the array and store it an array
 Then calculate the position of it position depend kregi ki previous element ka count kya hai which is written in count array
 Then we traverse from back
 */
public class CountSort {
    private static void sortUsingCountSort(int[] arr) {
        //size of count array would be equal to maximum element in array
        int maxi = arr[0];
        for (int j : arr) {
            maxi = Math.max(maxi, j);
        }
        int[] count = new int[maxi + 1];
        for (int j : arr) {
            count[j]++;
        }
        /*
         * Changing the values of count to denote the positions of elements
         */
        for (int i = 1; i <= maxi; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];//for copy the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            output[--count[arr[i]]] = arr[i];
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 6, 4, 3};
        sortUsingCountSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
//Time Complexity O(max(arr_length,Max_elem))
