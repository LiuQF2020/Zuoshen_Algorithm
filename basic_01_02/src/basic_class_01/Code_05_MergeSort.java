package basic_class_01;
/*
已讲解
 */

import java.util.Arrays;

public class Code_05_MergeSort {

	public static void sortProcess(int[] arr) {
		if (arr == null || arr.length < 2)	return;
		sortProcess(arr, 0, arr.length - 1);
	}

	public static void sortProcess(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		// 相当于(l + r) / 2
		int mid = l + ((r - l) >> 1);

		// 从l到mid已经排好序：
		sortProcess(arr, l, mid);
		// 从mid+1到r已经排好序：
		sortProcess(arr, mid + 1, r);

		// 从l到mid已经排好序，且从mid+1到r已经排好序；
		// 但是此时总体无序，如何让总体有序？进行merge：
		merge(arr, l, mid, r);
	}

	public static void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = mid + 1;

		// 双指针，谁小填谁
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		// 走完上一个while之后，以下两个while有且只有一个会越界
		// 越界之后，将另一个数组的剩下部分填入help数组后面
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

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			sortProcess(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		sortProcess(arr);
		printArray(arr);

	}

}
