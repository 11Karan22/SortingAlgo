public class QuickSortAlgo {

    private static void quickSort(int[] input, int si, int ei) {
        if (si >= ei)//if one or no element then also it is sorted!
        {
            return;
        }
        int pivotPos = partition(input, si, ei);
        quickSort(input, si, pivotPos - 1);
        quickSort(input, pivotPos + 1, ei);
    }

    private static int partition(int[] input, int si, int ei) {
        int count = 0;
        int pivot = input[si];//let first elem be the pivot
        for (int i = si + 1; i < ei; i++) {
            if (input[i] < pivot) {
                count++;
            }
        }
        //now  place pivot at right position
        int pivotPos = si + count;
        //do swap with pivot element
        int temp = input[pivotPos];
        input[pivotPos] = input[si];
        input[si] = temp;

        int i = si;
        int j = ei;
        while (i < pivotPos && j > pivotPos) {
            if (input[i] <= pivot)//equal to for duplicates
            {
                i++;
            } else if (input[j] > pivot)//element at i is already bigger than pivot that's why we fall in this condition now we need to check for element at j
            {
                j--;
            } else {
                //swap
                int temp_var = input[i];
                input[i] = input[j];
                input[j] = temp_var;
                i++;
                j--;
            }
        }
        return pivotPos;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 11, 5, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int val : arr) {
            System.out.print(val + " ");
        }

    }
}
