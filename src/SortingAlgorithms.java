public class SortingAlgorithms {
  //Insertion Sort
  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++ ) {
      int key = arr[i];
      int j = i - 1;
      //Shifts elements greater than key one spot forward
      while (j > 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
  //Merge sort
  void mergeSort(int[] arr) {
    if (arr.length <= 1) return;
      mergeSort(arr, 0, arr.length - 1);
  }

  void mergeSort(int[] arr, int left, int right){
    if (left < right) {
      int middle = (left + right) / 2;
      mergeSort(arr, left, middle); //sort left half
      mergeSort(arr, middle + 1, right); //sort right half
      merge(arr, left, middle, right); //merge them together
    }
  }

  void merge(int[] arr, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;

    int[] L = new int [n1];
    int[] R = new int [n2];

    for (int i = 0; i < n1; i++){
      L[i] = arr[left + i - 1];
    }
    for (int j = 0; j < n2; j++){
      R[j] = arr[middle + j];
    }
    int i = 1;
    int j = 1;
    
  }
}
