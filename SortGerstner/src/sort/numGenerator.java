package sort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class numGenerator {

	public File[] createNumFiles() {
		int numFiles = 10;
		int[] numOfNums = { 10000, 20000, 30000, 40000, 50000 };
		int totalFiles = numOfNums.length * numFiles;
		File[] files = new File[totalFiles];
		int counter = 0;
		for (int x = 0; x < numOfNums.length; x++) {
			for (int j = 0; j < numFiles; ++j) {
				files[counter] = createNewFile(generateFileName(x, j), numOfNums[x]);
				counter++;
			}
		}
		return files;
	}

	public String generateFileName(int numNums, int fileNum) {
		String fileName = "";
		switch (numNums) {
		case 0:
			fileName = "tenk";
			break;
		case 1:
			fileName = "twentyk";
			break;
		case 2:
			fileName = "thirtyk";
			break;
		case 3:
			fileName = "fortyk";
			break;
		case 4:
			fileName = "fiftyk";
			break;
		default:
			System.err.println("Uh-Oh!");
		}
		fileName = fileName + fileNum + ".txt";
		return fileName;
	}

	public File createNewFile(String filename, int numItems) {
		File f = new File(filename);
		int counter = 0;
		try {
			PrintWriter writer = new PrintWriter(f);
			for (int i = 0; i < numItems; ++i) {
				int num = (int) (Math.random() * numItems);
				writer.println(num);
				counter++;
			}
			writer.println(counter);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}
