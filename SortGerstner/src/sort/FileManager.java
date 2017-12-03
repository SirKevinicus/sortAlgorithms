package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	
	public Integer[] getArrayFromFile(File file){
		Integer[] array = new Integer[0];
		try {
			Scanner scanner = new Scanner(file);
			int numInts = 0;
			while(scanner.hasNextInt()) {
				numInts++;
				scanner.nextInt();
			}
			array = new Integer[numInts];
			scanner.close();
			
			scanner = new Scanner(file);
			int i = 0;
			while(scanner.hasNextInt()){
			   array[i] = scanner.nextInt();
			   i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public void printArrayFromFile(File file) {
		Integer[] array = getArrayFromFile(file);
		for(int i: array) {
			System.out.println(i);
		}
	}
}