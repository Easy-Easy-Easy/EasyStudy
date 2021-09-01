import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author zheng
 * @Date 2021/9/1 10:04
 * @Version 1.0
 **/
public class QuickSort {
    public int partition(int[] arr, int left, int right) {
        int p = left;
        int j = left + 1;
        int i = j;
        while (i < arr.length) {
            if (arr[i] < arr[p]) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        swap(arr, p, j - 1);
        return j - 1;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int size = 10;
        int[] sourceArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sourceArray[i] = random.nextInt(100);
        }
        sourceArray = new int[]{
                34, 32, 73, 82, 56, 48, 78, 58, 66, 60
        };
        QuickSort sort = new QuickSort();
        sort.quickSort(sourceArray,0,9);
        System.out.println(Arrays.toString(sourceArray));
    }
}
