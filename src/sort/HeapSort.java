package sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int len = arr.length;
        if (len < 2){
            return;
        }
        for (int i = 0; i < len; i++) {
            heapInsert(arr, i);
        }
        swap(arr, 0, --len);
        while (len > 0){
            heapify(arr, 0, len);
            swap(arr, 0 , --len);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size){

            int largest = left;
            if (left +1 < size){
                largest = (arr[left] == Math.max(arr[left], arr[left + 1])) ? left : left + 1;
            }
            if (arr[index] >= arr[largest]){
                break;
            }
            if (arr[largest] > arr[index]){
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        new HeapSort().heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    /*
    public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
     */
}
