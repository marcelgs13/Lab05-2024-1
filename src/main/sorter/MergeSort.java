package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values.length <= 1) return values;

        int mid = values.length/2;
        int leftArray[] = new int[mid];
        int rightArray[] = new int[values.length - mid];

        int i = 0;
        int j = 0;

        for(; i < values.length; i++){
            if (i < mid){
                leftArray[i] = values[i];
            } else {
                rightArray[j] = values[i];
                j++;
            }
        }
        sort(leftArray);
        sort(rightArray);
        merge(leftArray, rightArray, values);

        return values;
    }

    public static void merge(int[] left, int[] right, int[] values) {
        int leftSize = values.length / 2;
        int rightSize = values.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]){
                values[i] = left[l];
                i++;
                l++;
            } else {
                values[i] = right[l];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            values[i] = left[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            values[i] = right[r];
            i++;
            r++;
        }
    }
}