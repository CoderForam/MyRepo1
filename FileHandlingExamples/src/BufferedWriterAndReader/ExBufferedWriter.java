package BufferedWriterAndReader;

//Java program to write content into file 
//using BufferedWriter

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class ExBufferedWriter {
	public static void main(String args[]) {
		final String fileName = "D:\\Foram\\work\\file2.txt";

		try {
			File objFile = new File(fileName);
			if (objFile.exists() == false) {
				if (objFile.createNewFile()) {
					System.out.println("File created successfully.");
				} else {
					System.out.println("File creation failed!!!");
					System.exit(0);
				}
			}

			// writting data into file
			String text;
			Scanner SC = new Scanner(System.in);

			System.out.println("Enter text to write into file: ");
			text = SC.nextLine();

			// instance of FileWriter
			System.out.println("---------" + objFile.getAbsolutePath());
			System.out.println("---------" + objFile.getAbsoluteFile());
			FileWriter objFileWriter = new FileWriter(objFile.getAbsoluteFile());
			// instnace (object) of BufferedReader with respect of FileWriter
			BufferedWriter objBW = new BufferedWriter(objFileWriter);
			// write into file
			objBW.write(text);
			objBW.close();

			System.out.println("File saved.");
			System.out.println("Now again opening the file and reading it...");
			
			if(objFile.exists()==false) {
				System.out.println("File does not exist !!");
				System.exit(0);
			}
			String readText;
			FileReader objFileReader = new FileReader(objFile.getAbsoluteFile());
			BufferedReader br = new BufferedReader(objFileReader);
			while((readText = br.readLine())!=null) {
				System.out.println(readText);
			}
			br.close();
			objFileReader.close();
			
		} catch (Exception Ex) {
			System.out.println("Exception : " + Ex.toString());
		}
	}
}
