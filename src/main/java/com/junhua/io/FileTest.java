package com.junhua.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileTest {

	
	/**
	 * <ul>
	 * 	<li>A class with the word InputStreamor OutputStreamin its name is used for reading or 
			writing binary data, respectively.
 		<li>A class with the word Readeror Writerin its name is used for reading or writing 
			character or string data, respectively. Most, but not all, input classes have a corresponding output class.
		<li>A low-level stream connects directly with the source of the data.
		<li>A high-level stream is built on top of another stream using wrapping.
		<li>A class with Bufferedin its name reads or writes data in groups of bytes or characters 
			and often improves performance in sequential file systems.
	 * </ul>
	 */

	
	public static void main(String[] args) {
//		inputStreamTest();
		readerTest();
	}
	
	public static void inputStreamTest(){
		File file  = new File("D:/ioTest.txt");
		byte[] buffer = new byte[255];
		char[] ch = new char[124];
		try {
			InputStream inputStream = new FileInputStream(file);
			OutputStream outputStream = new FileOutputStream("D:/ioTest2.txt");
			
			Reader inputStream2 = new InputStreamReader(inputStream);
			inputStream2.read(ch);
			while(inputStream.read(buffer)!=-1){
			}
			outputStream.write(buffer);
			
			for (char c : ch) {
				System.out.print(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void readerTest(){
		File file  = new File("D:/ioTest.txt");
		char[] ch = new char[1240];
		try {
			Reader reader = new FileReader(file);
			Writer writer = new FileWriter("D:/ioTest3.txt");
			BufferedReader bufferReader = new BufferedReader(reader);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			String s;
			while((s = bufferReader.readLine())!=null){
				System.out.println(s);
				bufferedWriter.write(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testNIO(){
		
	}
}
