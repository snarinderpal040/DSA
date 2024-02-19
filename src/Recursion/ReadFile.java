package Recursion;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader(new File("sample2.txt"));
			BufferedReader br = new BufferedReader(fr);) {
			
			while(br.readLine()!= null) {
				System.out.println(br.readLine() + "\n");
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
