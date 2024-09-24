
public class DS_EmployeeList_Sorter extends DS_EmployeeList_Array {

   public DS_EmployeeList_Sorter() {
      super(); // Call the constructor of the superclass
   }

    // Selection Sort
   public void selectionSort() {
      for (int i = 0; i < size - 1; i++) {
         int minIndex = i;
         for (int j = i + 1; j < size; j++) {
            if (EmployeeList[j].getID() < EmployeeList[minIndex].getID()) {
               minIndex = j;
            }
         }
            // Swap the elements
         Employee temp = EmployeeList[minIndex];
         EmployeeList[minIndex] = EmployeeList[i];
         EmployeeList[i] = temp;
      }
   }
   
   //double selection sort 
   public void doubleSelectionSort() {
      for (int i = 0, j = size - 1; i < j; i++, j--) {
         int minIndex = i, maxIndex = i;
      
         for (int k = i; k <= j; k++) {
            if (EmployeeList[k].getID() < EmployeeList[minIndex].getID()) {
               minIndex = k;
            }
            if (EmployeeList[k].getID() > EmployeeList[maxIndex].getID()) {
               maxIndex = k;
            }
         }
      
         Employee temp = EmployeeList[minIndex];
         EmployeeList[minIndex] = EmployeeList[i];
         EmployeeList[i] = temp;
      
         if (maxIndex == i) {
            maxIndex = minIndex;
         }
      
         temp = EmployeeList[maxIndex];
         EmployeeList[maxIndex] = EmployeeList[j];
         EmployeeList[j] = temp;
      }
   }

    // Bubble Sort
   public void bubbleSort() {
      for (int i = 0; i < size - 1; i++) {
         for (int j = 0; j < size - i - 1; j++) {
            if (EmployeeList[j].getID() > EmployeeList[j + 1].getID()) {
                    // Swap elements
               Employee temp = EmployeeList[j];
               EmployeeList[j] = EmployeeList[j + 1];
               EmployeeList[j + 1] = temp;
            }
         }
      }
   }

    // Insertion Sort
   public void insertionSort() {
      for (int i = 1; i < size; i++) {
         Employee key = EmployeeList[i];
         int j = i - 1;
         while (j >= 0 && EmployeeList[j].getID() > key.getID()) {
            EmployeeList[j + 1] = EmployeeList[j];
            j = j - 1;
         }
         EmployeeList[j + 1] = key;
      }
   }

    // Quick Sort
   public void quickSort() {
      quickSort(0, size - 1);
   }

   private void quickSort(int low, int high) {
      if (low < high) {
         int pi = partition(low, high);
         quickSort(low, pi - 1);
         quickSort(pi + 1, high);
      }
   }

   private int partition(int low, int high) {
      int pivot = EmployeeList[high].getID();
      int i = (low - 1);
      for (int j = low; j < high; j++) {
         if (EmployeeList[j].getID() < pivot) {
            i++;
            Employee temp = EmployeeList[i];
            EmployeeList[i] = EmployeeList[j];
            EmployeeList[j] = temp;
         }
      }
      Employee temp = EmployeeList[i + 1];
      EmployeeList[i + 1] = EmployeeList[high];
      EmployeeList[high] = temp;
      return i + 1;
   }

    // Merge Sort
   public void mergeSort() {
      mergeSort(0, size - 1);
   }

   private void mergeSort(int left, int right) {
      if (left < right) {
         int middle = (left + right) / 2;
         mergeSort(left, middle);
         mergeSort(middle + 1, right);
         merge(left, middle, right);
      }
   }

   private void merge(int left, int middle, int right) {
      int n1 = middle - left + 1;
      int n2 = right - middle;
   
      Employee[] L = new Employee[n1];
      Employee[] R = new Employee[n2];
   
      for (int i = 0; i < n1; ++i) {
         L[i] = EmployeeList[left + i];
      }
      for (int j = 0; j < n2; ++j) {
         R[j] = EmployeeList[middle + 1 + j];
      }
   
      int i = 0, j = 0;
      int k = left;
      while (i < n1 && j < n2) {
         if (L[i].getID() <= R[j].getID()) {
            EmployeeList[k] = L[i];
            i++;
         } else {
            EmployeeList[k] = R[j];
            j++;
         }
         k++;
      }
   
      while (i < n1) {
         EmployeeList[k] = L[i];
         i++;
         k++;
      }
   
      while (j < n2) {
         EmployeeList[k] = R[j];
         j++;
         k++;
      }
   }
}