package sort;

import java.io.File;

public class sortingAlgorithms {

	public static void main(String[] args) {
		// Making references
		numGenerator numGen = new numGenerator();
		FileManager fileMan = new FileManager();
		SortsClass tester = new SortsClass();

		long startTime;
		long endTime;
		//Create files and store them in files
		File[] files = numGen.createNumFiles();
		
		/*System.out.println("--------------");
		System.out.println("SELECTION SORT");
		System.out.println("--------------");
		
		for (int x = 0; x < files.length; x++) {
			Integer[] test = fileMan.getArrayFromFile(files[x]);
			startTime = System.currentTimeMillis();
			tester.selectionSort(test, test.length);
			endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		}*/
		
		System.out.println("--------------");
		System.out.println("INSERT SORT");
		System.out.println("--------------");
		for (int x = 0; x < files.length; x++) {
			Integer[] test = fileMan.getArrayFromFile(files[x]);
			startTime = System.currentTimeMillis();
			tester.insertionSort(test, test.length);
			endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		}
		
		System.out.println("--------------");
		System.out.println("MERGE SORT");
		System.out.println("--------------");
		for (int x = 0; x < files.length; x++) {
			Integer[] test = fileMan.getArrayFromFile(files[x]);
			startTime = System.currentTimeMillis();
			tester.mergesort(test, test[0], test[test.length]);
			endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		}
	}

}
