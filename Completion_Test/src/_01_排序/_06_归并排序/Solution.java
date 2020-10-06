package _01_排序._06_归并排序;

public class Solution {
    public static void merge(int[] arr) {
        if (arr == null || arr.length < 2)  return;
        merge(arr, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int l, int r) {
        if (l == r)  return;
        int mid = l + ((r - l) >> 1);
        merge(arr, l, mid);
        merge(arr, mid + 1, r);
        mergeSort(arr, l, mid, r);
    }

    public static void mergeSort(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
