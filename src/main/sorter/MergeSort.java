package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values.length < 2) {
            return values;
        }
        int meio = values.length / 2;
        int[] left = new int[meio];
        int[] right = new int[values.length - meio];

        System.arraycopy(values, 0, left, 0, meio);
        System.arraycopy(values, meio, right, 0, values.length - meio);

        sort(left);
        sort(right);

        int[] resultado = merge(left, right);

        System.arraycopy(resultado, 0, values, 0, values.length);

        return merge(left, right);
    }

    

    public int[] merge(int[] left, int[] right) {
        int[] resultado = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                resultado[k] = left[i];
            } else {
                resultado[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            resultado[k] = left[i];
            i++;
            k++;
        }

        while ( j < right.length) {
            resultado[k] = right[j];
            j++;
            k++;
        }
        return resultado;
    }
}