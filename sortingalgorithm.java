import java.util.Random;

public class SortingAlgorithms {


  private static void mergesort(int[] inputArray)
	  {
	    int inputLength = inputArray.length;

	    if(inputLength < 2)
	    {
	      return;
	     }
	    int Middle = inputLength/2;
	    int[] leftarray = new int[Middle];
	    int[] rightarray = new int[inputLength - Middle];

	    for(int i = 0; i < Middle; i++)
	      {
	        leftarray[i] = inputArray[i]; 
	      }
	    for(int i = Middle; i < inputLength; i++)
	      {
	        rightarray[i - Middle] = inputArray[i];
	      }
	      mergesort(leftarray);
	      mergesort(rightarray);
	    
	      merge(inputArray, leftarray, rightarray);
	  }
	  // merge both 
	   private static void merge(int[] inputArray, int[] leftarray, int[] rightarray)
	  {
   
	  int leftside = leftarray.length;
	  int rightside = rightarray.length;
	  int i = 0;
	    int j = 0;
	      int k = 0;
	    while(i  < leftside && j < rightside){         // i less then new left side
	      if(leftarray[i] <= rightarray[j]){       // if right side element> left side
	        inputArray[k] = leftarray[i];          // we add left side element in K array
	        i++;
	      }
	      else {
	        inputArray[k] = rightarray[j];      //else right array element goes to K array
	        j++;
	      }
	      k++;
	    }
	    while (i < leftside){
	      inputArray[k] = leftarray[i];
	      i++;
	      k++;
	    }
	    while(j < rightside){
	      inputArray[k] = rightarray[j];
	      j++;
	      k++;
	    }

	    }

	    public static void quicksort(Comparable[] array) {
	        quicksort(array, 0, array.length - 1);
	    }

	    /**
	     * This method inserts element using insertion sort
	     *
	     * @param array array to be sort
	     * @param lowIndex lowest index
	     * @param highIndex highest index
	     */
	    private static void insertionSort(Comparable[] array, int lowIndex, int highIndex) {
	        for (int i = lowIndex + 1; i <= highIndex; i++) {
	            Comparable temp = array[i];
	            int j;

	            for (j = i; j > lowIndex && temp.compareTo(array[j - 1]) < 0; j--) {
	                array[j] = array[j - 1];
	            }
	            array[j] = temp;
	        }
	    }

	    /**
	     * This method implements quicksort with median-of-three partitioning and a
	     * cutoff of 15
	     *
	     * @param array array to be sort
	     * @param lowIndex lowest index
	     * @param highIndex highest index
	     */
	    static void quicksort(Comparable[] array, int lowIndex, int highIndex) {
	        //define cutoff
	        int CUTOFF = 15;
	      
	        if (lowIndex + CUTOFF > highIndex) {
	            //insert element using insertion sort
	            insertionSort(array, lowIndex, highIndex);
	        } else {
	            //find middle index of the array
	            int middle = (lowIndex + highIndex) / 2;
	            //compar element at middle with element at lowIndex 
	            if (array[middle].compareTo(array[lowIndex]) < 0) {
	                //swap reference if element at lowIndex is greater than element at middle
	                swapElement(array, lowIndex, middle);
	            }
	            //compare element at highIndex with element at lowIndex index 
	            if (array[highIndex].compareTo(array[lowIndex]) < 0) {
	                //swap reference if element at lowIndex is greater than element at highIndex
	                swapElement(array, lowIndex, highIndex);
	            }
	            if (array[highIndex].compareTo(array[middle]) < 0) {
	                //swap reference if element at highIndex is greater than element at middle
	                swapElement(array, middle, highIndex);
	            }

	            swapElement(array, middle, highIndex - 1);
	            //get pivot element
	            Comparable pivot = array[highIndex - 1];

	            int i, j;
	            for (i = lowIndex, j = highIndex - 1;;) {
	                while (array[++i].compareTo(pivot) < 0);
	                while (pivot.compareTo(array[--j]) < 0);
	                if (i >= j) {
	                    break;
	                }
	                swapElement(array, i, j);
	            }
	            swapElement(array, i, highIndex - 1);

	            //call method recursively
	            quicksort(array, lowIndex, i - 1);
	            quicksort(array, i + 1, highIndex);
	        }

	    }

	    public static final void swapElement(Object[] array, int first, int last) {
	        Object temp = array[first];
	        array[first] = array[last];
	        array[last] = temp;
	    }
		
	    private static void quicksort1(int[] array) {
	      quicksort1(array, 0, array.length - 1);  //overloading
	    }

	    private static void quicksort1(int[] array, int lowIndex, int highIndex) {                      //we are calling this method
	       int cutoff = 15;
	      if (lowIndex >= highIndex) {
	        return;
	      }

	      int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
	      int pivot = array[pivotIndex];
	      swap(array, pivotIndex, highIndex);

	      int leftPointer = partition(array, lowIndex, highIndex, pivot);

	      quicksort1(array, lowIndex, leftPointer - 1);
	      quicksort1(array, leftPointer + 1, highIndex);

	    }

	    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
	      int leftPointer = lowIndex;
	      int rightPointer = highIndex - 1;

	      while (leftPointer < rightPointer) {

	        // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
	        while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
	          leftPointer++;
	        }

	        // Walk from the right until we find a number less than the pivot, or hit the left pointer.
	        while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
	          rightPointer--;
	        }

	        swap(array, leftPointer, rightPointer);
	      }
	      
	      // This is different from what the video has, and fixes an issue where the last value could potentially be out of order. 
	      // Thanks to viewer Wilson Barbosa for suggesting the fix!
	      if(array[leftPointer] > array[highIndex]) {
	        swap(array, leftPointer, highIndex);
	      }
	      else {
	        leftPointer = highIndex;
	      }
	      
	      return leftPointer;
	    }

	    private static void swap(int[] array, int index1, int index2) {
	      int temp = array[index1];
	      array[index1] = array[index2];
	      array[index2] = temp;
	    }


	

    private static void printArray(int[] merge) {
        for (int i = 0; i < merge.length; i++) {
          System.out.println(merge[i]);
        }
        }

    private static void printArray(Comparable[] sort) {
        for (int i = 0; i < sort.length; i++) {
          System.out.println(sort[i]);
        }
        }
        

      
    public static void main(String[] args) {
        Random rand = new Random();
        
        int[] merge = new int[1000000];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < merge.length; i++) {
          merge[i] = rand.nextInt(1000000);
          }
        long endTime = System.currentTimeMillis();
        long timeElapsed1 = endTime - startTime;
        
        int[] sor = new int[1000000];
        long startime = System.currentTimeMillis();
        for (int i = 0; i < sor.length; i++) {
          sor[i] = rand.nextInt(1000000);
          }
        long endime = System.currentTimeMillis();
        long timeElapsed3 = endime - startime;
        
        
        Comparable[] sort = new Comparable[1000000];
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < sort.length; i++) {
            sort[i] = rand.nextInt(1000000);
        }
        long endtime = System.currentTimeMillis();
        long timeElapsed2 = endtime - starttime;
        
        
        System.out.println("\nThis is the random number merge sort");
        
        System.out.println("\nLIST:");
        printArray(merge);

        mergesort(merge);

        System.out.println("\nMERGESORT:");
        printArray(merge);
        
        System.out.println("\nThis is the random number quick sort");
        
        System.out.println("\nLIST:");
        printArray(sort);

        quicksort(sort);

        System.out.println("\n QUICKSORT:");
        printArray(sort);
        
        System.out.println("\nThis is the random number quick sort");
        
        System.out.println("\nLIST:");
        printArray(sor);

        quicksort1(sor);

        System.out.println("\n QUICKSORT:");
        printArray(sor);
        
        System.out.println("Using mergeSort It took -> " + timeElapsed1 + "seconds");
        System.out.println("Using quickSort Median and cutoff of 15 It took -> " + timeElapsed2 + "seconds");
        System.out.println("Using quickSort It took -> " + timeElapsed3 + "seconds");
  }
}
