package sorter;

public class QuickSorter implements Sorter {
    @Override
    public int[] sort(int[] values) {
        quickSort(values, 0, values.length - 1);
        return values;
    }

    public void quickSort(int[] values, int low, int high) {
        if (high <= low) return;
        int pivot = partition(values, low, high);
        quickSort(values, low, pivot - 1);
        quickSort(values, pivot + 1, high);
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
