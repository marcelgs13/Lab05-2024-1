package sorter;

public class QuickSorter implements Sorter {
    public int[] sort(int[] values) {
        // quicksort implementation
        return values;
    }

    public int partition(int[] values, int low, int high) {
        int pivo = values[low];
        int i = low;
        int temp = 0;
        for(int j = low + 1; j <= high; j++){
            if (values[j] <= pivo){
                i+=1;
                temp = values[i];
                values[i]= values[j];
                values[j] = temp;
            }
        }
        temp = values[i];
        values[i]= values[low];
        values[low]= temp;
        return i;

    }    
}
