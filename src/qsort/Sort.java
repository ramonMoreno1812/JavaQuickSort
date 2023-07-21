package qsort;

import java.util.Random;

public class Sort {
	
	// Overload method
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] arr, int lowIndex, int highIndex) {

		// base case if the array is sorted (1 element array.)
		if (lowIndex >= highIndex) {
			return;
		}

		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		T pivot = arr[pivotIndex];
		
		swap(arr, pivotIndex, highIndex);

		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			
			// arr[leftPointer] <= pivot && leftPointer < rightPointer
			while(arr[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) {
				
				leftPointer++;
			}
			//arr[rightPointer] >= pivot && leftPointer < rightPointer
			while(arr[rightPointer].compareTo(pivot) >=0 && leftPointer < rightPointer) {
	
				rightPointer--;
			}

			swap(arr, leftPointer, rightPointer);
		}
		
		swap(arr, leftPointer, highIndex);

		// Recursively sort each sub arrays
		quickSort(arr, lowIndex, leftPointer - 1);
		quickSort(arr, leftPointer + 1, highIndex);

	}
	
	// method to swap numbers in array
	private static <T> void swap(T[] arr, int index1, int index2) {
		
		T temp = arr[index1];
		
		arr[index1] = arr[index2];
		arr[index2] = temp;	
	}
	
	// print my array method
	public static <T> void printArray(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}










