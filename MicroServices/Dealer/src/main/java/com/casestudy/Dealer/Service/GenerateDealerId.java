package com.casestudy.Dealer.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GenerateDealerId {
	public static String Total() {

		GenerateDealerId test1 = new GenerateDealerId();

		return test1.doMethod();

	}

	public int getCount() {

		int count = 0;
		try {
			if (!new File("C:\\Users\\NAMKAPOO\\OneDrive - Capgemini\\Desktop\\Ids\\dealerId.txt").exists())
				return 1;
			else {
				BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\NAMKAPOO\\OneDrive - Capgemini\\Desktop\\Ids\\dealerId.txt")));
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\NAMKAPOO\\OneDrive - Capgemini\\Desktop\\Ids\\dealerId.txt")));
			bw.write(Integer.toString(count));
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String doMethod() {
		int count = getCount();
		String start = "DEA";
		String total = "";
		String with5digits = String.format("%05d", count);
		total = start + with5digits;
		count++;
		putCount(count);
		return total;
	}

}
