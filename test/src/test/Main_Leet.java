package test;

public class Main_Leet {

	public static void main(String[] args) {

		int[] ar = { 20, 12, 4, 3, 1, 0, -1 };
		MergeSort ms = new MergeSort();
		ms.sort(ar, 0, ar.length - 1);

		for (int i : ar)
			System.out.print(i + " ");
	}
}

class MergeSort {

	void sort(int[] ar, int l, int r) {

		if (l >= r)
			return;

		int mid = (l + r) / 2;

		sort(ar, l, mid);
		sort(ar, mid + 1, r);

		mergeUtils(ar, l, mid, r);

	}

	void mergeUtils(int[] ar, int l, int m, int r) {

		int[] tmp = new int[r - l + 1];

		int i = l, j = m + 1, k = 0;

		while (i <= m && j <= r) {

			if (ar[i] > ar[j]) {
				tmp[k] = ar[j];
				j++;
			} else {
				tmp[k] = ar[i];
				i++;
			}
			k++;
		}

		while (i <= m) {
			tmp[k] = ar[i];
			i++;
			k++;
		}

		while (j <= r) {
			tmp[k] = ar[j];
			j++;
			k++;
		}

		for (int idx = l; idx < r + 1; idx++)
			ar[idx] = tmp[idx - l];
	}
}