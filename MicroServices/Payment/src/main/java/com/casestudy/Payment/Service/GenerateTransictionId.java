package com.casestudy.Payment.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class GenerateTransictionId {
	
	public static String Total() {

		GenerateTransictionId test1 = new GenerateTransictionId();

		return test1.doMethod();

	}

	public int getCount() {

		int count = 0;
		try {
			if (!new File("C:\\Users\\naman\\Desktop\\Ids\\transictionId.txt").exists())
				return 1;
			else {
				BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\naman\\Desktop\\Ids\\transictionId.txt")));
				String s = br.readLine();
				count = Integer.parseInt(s);
				br.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public void putCount(int count) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\naman\\Desktop\\Ids\\transictionId.txt")));
			bw.write(Integer.toString(count));
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String doMethod() {
		int count = getCount();
		String start = "TRS";
		String total = "";
		String with5digits = String.format("%05d", count);
		total = start + with5digits+"SHCRT";
		count++;
		putCount(count);
		return total;
	}


}
