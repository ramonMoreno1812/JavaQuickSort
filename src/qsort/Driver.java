// This main Driver class calls quick sort from this driver class, and from my Sort class.
// the quick sort from this class takes in a random int array and sorts it in ascending order. 
// The quickSort in my Sort class takes in generic arrays and also sorts them in ascending order. 
// Various types of arrays are used in my Generic sorting, including Integer[], String, and Integer[] of random ints.
// I am looking into separating my partition code in my sort class into a separate method so my code is more readable.

package qsort;
import java.util.Random;

public class Driver {
	
	public static void main(String[] args) {
		
//		// new random object
//		Random random = new Random();
//		// create an array of ints of size 20
//		int[] myRandomArr = new int[20];
//		
//		// print out array
//		for(int i = 0; i < myRandomArr.length; i++ ) {
//			// random numbers in array of size 20 from 0 - 99;
//			myRandomArr[i] = random.nextInt(100);
//		}
		
//		printArray(myRandomArr);
//		System.out.println();
		// it is ugly to have to pass in many parameters here, 
		// so overload the method that takes in an arr and in the over load method
		// add the rest of the arguments
//		quickSort(myRandomArr);
//		printArray(myRandomArr);
		
		// my arrays FOR GENERIC METHODS IN MY SORT Class	
		Integer[] integerArr = {40, 4, 12, 99, 3, 67, 23, 55, 1, 0};
		String[] myStringArr = {"Randy", "Kelvin", "Manelsa", "Forence","April", "Zinoger", "Alan"};
		Integer[] randIntegerArr = new Integer[20];
		populateArrayWithRandomIntegers(randIntegerArr);
		
		// print my arrays before sorting
		Sort.printArray(integerArr);
		System.out.println();
		Sort.printArray(myStringArr);
		System.out.println();
		Sort.printArray(randIntegerArr);
		System.out.println();
		System.out.println();
		
		// sort arrays then print them.
		Sort.quickSort(integerArr);
		Sort.quickSort(myStringArr);
		Sort.quickSort(randIntegerArr);
		
		// print my arrays after sorting
		Sort.printArray(integerArr);
		System.out.println();
		Sort.printArray(myStringArr);
		System.out.println();
		Sort.printArray(randIntegerArr);
		
	}
	
	public static Integer[] populateArrayWithRandomIntegers(Integer[] arr) {
		// random array of random integers
		Random rand = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		return arr;
	}
	
	////////////////////// QUICK SORT BELOW TAKES IN ONLY PRIMATIVE INTS AS ARGUMENTS ////////////////////
	// Overload method
	private static void quickSort(int[] arr) {
		// Arguments are one array, low index, and high index
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int lowIndex, int highIndex) {
		
		// base case if the array is sorted (1 element array.)
		if(lowIndex >= highIndex) {
			return;
		}
		
		// using a random pivot point is better for average times
		// this calculation gives you a rand index between low and high index that are passed in.
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		// Pivot point is equal to pivot index random num between low and high indices. 
		int pivot = arr[pivotIndex];
		// last setp is to swap the random num with last elemtn in array.
		swap(arr, pivotIndex, highIndex);
		
		int leftPointer = partition(arr, lowIndex, highIndex, pivot);
		
		// Recursively sort each sub arrays
		quickSort(arr, lowIndex, leftPointer - 1);
		quickSort(arr, leftPointer + 1, highIndex);
		
	}

	private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
		// declare pointers
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		// create pointers that move low and high pointers twoards each other.
		// once leftPointer runs into right pointer expression is false and knocks us out 
		while(leftPointer < rightPointer) {
			
			// if arr[index] is less than or = to piviot and as long as left pointer is less than right pointer
			// if 
			while(arr[leftPointer] <= pivot && leftPointer < rightPointer) {
				// Increment left pointer
				leftPointer++;
			}
			// as long as arr[index] is greater than piviot or the same num, and left pointer is less BUT not equal to 
			// right pointer
			while(arr[rightPointer] >= pivot && leftPointer < rightPointer) {
				// we are moving the right pointer left so decrement it.
				rightPointer--;
			}
			
			// swap elemtns that are at left and right pointers
			swap(arr, leftPointer, rightPointer);
		}
		// we know high index is the pivot part. 
		swap(arr, leftPointer, highIndex);
		return leftPointer;
	}
	
	// method to swap numbers in array
	private static void swap(int[] arr, int index1, int index2) {
		
		// create temp variable to hold a num
		// temp now hold value of the arry at index1.
		int temp = arr[index1];
		// value at arr index 1 is not the value it was at 2
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
	}
	
	
	// print my array
	private static void printArray(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
