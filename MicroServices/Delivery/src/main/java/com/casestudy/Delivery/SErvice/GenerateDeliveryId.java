package com.casestudy.Delivery.SErvice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GenerateDeliveryId {
	public static String Total() {

		GenerateDeliveryId test1 = new GenerateDeliveryId();

		return test1.doMethod();

	}

	public int getCount() {

		int count = 0;
		try {
			if (!new File("C:\\Users\\naman\\Desktop\\Ids\\deliveryId.txt").exists())
				return 1;
			else {
				BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\naman\\Desktop\\Ids\\deliveryId.txt")));
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\naman\\Desktop\\Ids\\deliveryId.txt")));
			bw.write(Integer.toString(count));
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String doMethod() {
		int count = getCount();
		String start = "DY";
		String total = "";
		String with5digits = String.format("%05d", count);
		total = start + with5digits;
		count++;
		putCount(count);
		return total;
	}

}
