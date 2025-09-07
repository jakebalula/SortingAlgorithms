import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] sizes = {100, 1000, 10000, 100000};
    Random random = new Random();

    System.out.printf("%-10s %-20s %-20s%n", "Size", "Insertion Sort (ms)", "Merge Sort (ms)");

    for (int size: sizes) {
      int arr[] = new int[size];
      for (int i = 0; i < size; i++){
        arr[i] = random.nextInt(1000000); //creates random integers
      }
      //Save array to file
      String filename = "array_" + size + ".txt";
      try (FileWriter fw = new FileWriter(filename)) {
        for (int num : arr){
          fw.write(num + " ");
        }
      }
      //Copies array
      int[] arrCopy1 = arr.clone();
      int[] arrCopy2 = arr.clone();

      //Insertion Sort time
      long start = System.nanoTime();
      SortingAlgorithms.insertionSort(arrCopy1);
      long end = System.nanoTime();
      long insertionTime = (end - start) / 1000000; //converts into ms

      //Merge Sort time
      start = System.nanoTime();
      SortingAlgorithms.mergeSort(arrCopy2);
      end = System.nanoTime();
      long mergeTime = (end - start) / 1000000; //converts into ms

      //Print it all
      System.out.printf("%-10d %-20d %-20d%n", size, insertionTime, mergeTime);
    }
  }
}
