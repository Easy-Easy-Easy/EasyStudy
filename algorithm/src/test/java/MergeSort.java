import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/31 20:02
 * @Version 1.0
 **/
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, tmp);
            mergeSort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);
        }
    }

    //合并两个有序数组
    public void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        while (left <= right) {
            arr[left] = tmp[left];
            left++;
        }
    }

    public static void main(String[] args) {
        int size = 10;
        int[] sourceArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sourceArray[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(sourceArray));
        MergeSort mergeSort = new MergeSort();
        int[] tmp = new int[10];
        mergeSort.mergeSort(sourceArray,0,9,tmp);
        System.out.println(Arrays.toString(sourceArray));
    }
}
