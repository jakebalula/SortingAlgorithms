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
  public static void mergeSort(int[] arr) {
    if (arr.length <= 1) return;
    mergeSortRec(arr, 0, arr.length - 1);
  }

  private static void mergeSortRec(int[] arr, int left, int right){
    if (left < right) {
      int middle = (left + right) / 2;
      mergeSortRec(arr, left, middle); //sort left half
      mergeSortRec(arr, middle + 1, right); //sort right half
      merge(arr, left, middle, right); //merge them together
    }
  }

  private static void merge(int[] arr, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;

    int[] L = new int [n1];
    int[] R = new int [n2];

    //Copy data into L[] and R[]
    for (int i = 0; i < n1; i++){
      L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++){
      R[j] = arr[middle + 1 + j];
    }
    int i = 0;
    int j = 0;
    int k = left;
    //Merge the two sub arrays
    while (i < n1 && j < n2){
      if (L[i] <= R[j]){
        arr[k++] = L[i++];
      }
      else arr[k++] = R[j++];
    }
    //Copies any remaining elements of L[] and R[]
    while (i < n1) {
      arr[k++] = L[i++];
    }
    while (j < n2) {
      arr[k++] = R[j++];
    }
  }
}
