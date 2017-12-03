package sort;

public class SortTester {
	public void testSelection(int[] nums, int n) {
		long startTime = System.currentTimeMillis();

		// ---------------------------------------------------
		// Sorts the items in an array into ascending order.
		// Precondition: theArray is an array of n items.
		// Postcondition: theArray is sorted into
		// ascending order.
		// Calls: indexOfLargest.
		// ---------------------------------------------------
		// last = index of the last item in the subarray of
		// items yet to be sorted
		// largest = index of the largest item found
		for (int last = n - 1; last >= 1; last--) {
			// Invariant: theArray[last+1..n-1] is sorted
			// and > theArray[0..last]
			// select largest item in theArray[0..last]
			int largest = indexOfLargest(nums, last + 1);
			// swap largest item theArray[largest] with
			// theArray[last]
			int temp = nums[largest];
			nums[largest] = nums[last];
			nums[last] = temp;
		} // end for
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	}

	private static int indexOfLargest(int[] theArray, int size) {
		// ---------------------------------------------------
		// Finds the largest item in an array.
		// Precondition: theArray is an array of size items;
		// size >= 1.
		// Postcondition: Returns the index of the largest
		// item in the array.
		// ---------------------------------------------------
		int indexSoFar = 0; // index of largest item found so far
		// Invariant: theArray[indexSoFar]>=theArray[0..currIndex-1]
		for (int currIndex = 1; currIndex < size; ++currIndex) {
			if (theArray[currIndex] > (theArray[indexSoFar])) {
				indexSoFar = currIndex;
			} // end if
		} // end for
		return indexSoFar; // index of largest item
	} // end indexOfLargest

	public void testInsertion(int[] theArray, int n) {
		long startTime = System.currentTimeMillis();
		// ---------------------------------------------------
		// Sorts the items in an array into ascending order.
		// Precondition: theArray is an array of n items.
		// Postcondition: theArray is sorted into ascending
		// order.
		// ---------------------------------------------------
		// unsorted = first index of the unsorted region,
		// loc = index of insertion in the sorted region,
		// nextItem = next item in the unsorted region
		// initially, sorted region is theArray[0],
		// unsorted region is theArray[1..n-1];
		for (int unsorted = 1; unsorted < n; ++unsorted) {
			// Invariant: theArray[0..unsorted-1] is sorted
			// find the right position (loc) in
			// theArray[0..unsorted] for theArray[unsorted],
			// which is the first item in the unsorted
			// region; shift, if necessary, to make room
			int nextItem = theArray[unsorted];
			int loc = unsorted;
			while ((loc > 0) && (theArray[loc - 1] > (nextItem))) {
				// shift theArray[loc-1] to the right
				theArray[loc] = theArray[loc - 1];
				loc--;
			} // end while
				// insert nextItem into sorted region
			theArray[loc] = nextItem;
		} // end for
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	} // end insertionSort

	private static void merge(int[] theArray, int first, int mid, int last) {
		// ---------------------------------------------------------
		// Merges two sorted array segments theArray[first..mid] and
		// theArray[mid+1..last] into one sorted array.
		// Precondition: first <= mid <= last. The subarrays
		// theArray[first..mid] and theArray[mid+1..last] are
		// each sorted in increasing order.
		// Postcondition: theArray[first..last] is sorted.
		// Implementation note: This method merges the two
		// subarrays into a temporary array and copies the result
		// into the original array anArray.
		// ---------------------------------------------------------
		int maxSize = theArray.length;
		// temporary array
		int[] tempArray = new int[maxSize];
		// initialize the local indexes to indicate the subarrays
		int first1 = first; // beginning of first subarray
		int last1 = mid; // end of first subarray
		int first2 = mid + 1; // beginning of second subarray
		int last2 = last; // end of second subarray
		// while both subarrays are not empty, copy the
		// smaller item into the temporary array
		int index = first1; // next available location in
		// tempArray
		while ((first1 <= last1) && (first2 <= last2)) {
			// Invariant: tempArray[first1..index-1] is in order
			if (theArray[first1] < (theArray[first2])) {
				tempArray[index] = theArray[first1];
				first1++;
			} else {
				tempArray[index] = theArray[first2];
				first2++;
			} // end if
			index++;
		} // end while
		// finish off the nonempty subarray
		// finish off the first subarray, if necessary
		while (first1 <= last1) {
			// Invariant: tempArray[first1..index-1] is in order
			tempArray[index] = theArray[first1];
			first1++;
			index++;
		} // end while
		// finish off the second subarray, if necessary
		while (first2 <= last2) {
			// Invariant: tempArray[first1..index-1] is in order
			tempArray[index] = theArray[first2];
			first2++;
			index++;
		} // end while
		// copy the result back into the original array
		for (index = first; index <= last; ++index) {
			theArray[index] = tempArray[index];
		} // end for
	} // end merge

	public static void mergesort(int[] theArray, int first, int last) {
		// ---------------------------------------------------------
		// Sorts the items in an array into ascending order.
		// Precondition: theArray[first..last] is an array.
		// Postcondition: theArray[first..last] is sorted in
		// ascending order.
		// Calls: merge.
		// ---------------------------------------------------------
		if (first < last) {
			// sort each half
			int mid = (first + last) / 2; // index of midpoint
			// sort left half theArray[first..mid]
			mergesort(theArray, first, mid);
			// sort right half theArray[mid+1..last]
			mergesort(theArray, mid + 1, last);
			// merge the two halves
			merge(theArray, first, mid, last);
		} // end if
	} // end mergesort

}
