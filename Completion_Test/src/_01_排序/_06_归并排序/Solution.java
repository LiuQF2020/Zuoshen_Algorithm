package _01_排序._06_归并排序;

import java.util.Arrays;

public class Solution {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)  return;
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int l, int r) {
        if (l == r)  return;
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
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

    public static void main(String[] args) {
        int[] arr = {2, 1, 9};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
