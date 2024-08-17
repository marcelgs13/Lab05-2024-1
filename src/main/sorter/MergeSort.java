package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values.length <= 1) return values;

        int middle = values.length/2;
        int leftArray[] = new int[middle];
        int rightArray[] = new int[values.length - middle];

        int i = 0;
        int j = 0;

        for(; i < values.length; i++){
            if (i < middle){
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

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        merge(left, right, result);
        return result;
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
                values[i] = right[r];
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