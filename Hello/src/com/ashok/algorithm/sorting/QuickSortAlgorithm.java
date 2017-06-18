/**
 * 
 */
package com.ashok.algorithm.sorting;

/**
 * @author Ashok
 *
 */
public class QuickSortAlgorithm {

	
	public static void main(String[] args) {
		
		int arr[]={7,23,99,5,62,4,2,0,9};
		
		int start=0;
		int end=arr.length-1;
		quickSort(arr,start,end);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		 for(int i=0;i<arr.length;i++){
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	}

	private static void quickSort(int[] arr, int start, int end) {
	
		if(start<end){
			int pivot_loc=partition(arr,start,end);  //stores the position of pivot element
			//int pivot_loc=rand_partition(arr,start,end);
			quickSort(arr,start,pivot_loc-1);  //sorts the left side of pivot.
			quickSort(arr, pivot_loc+1, end); // sorts the right side of pivot
		}
	}

	
	private static int partition(int[] arr, int start, int end) {
		int i=start+1;
		int pivot=arr[start]; // Make the first element as pivot
		for(int j=start+1;j<=end;j++){
			 /*rearrange the array by putting elements which are less than pivot
		       on one side and which are greater that on other. */
			if(arr[j]<=pivot){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i+=1;
			}
		}
		int temp=arr[start]; //put the pivot element in its proper place.
		arr[start]=arr[i-1];
		arr[i-1]=temp;
		
		return i-1; // return the position of pivot
	}
	
 
	/*
	 * This function takes last element as pivot,
	    places the pivot element at its correct
	    position in sorted array, and places all
	    smaller (smaller than pivot) to left of
	    pivot and all greater elements to right
	    of pivot 
	private static int partition(int arr[], int low, int high)
	{
		
     int pivot = arr[high]; 
     int i = (low-1); // index of smaller element
     for (int j=low; j<=high-1; j++)
     {
         // If current element is smaller than or
         // equal to pivot
         if (arr[j] <= pivot)
         {
             i++;

             // swap arr[i] and arr[j]
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }
     }

     // swap arr[i+1] and arr[high] (or pivot)
     int temp = arr[i+1];
     arr[i+1] = arr[high];
     arr[high] = temp;

     return i+1;
 } */
	
	// the randomized version of the partition function :
		static int rand_partition ( int A[ ] , int start , int end ) {
		    //chooses position of pivot randomly by using rand() function .
		     int random = (int) (start + Math.random()%(end-start +1 )) ;

		     // swap ( A[random] , A[start]) ;       swap pivot with 1st element.
		      int temp=A[random];
		      A[random]=A[start];
		      A[start]=temp;
		      
		     return partition(A,start ,end) ;       //call the above partition function
		}

	

}
