package contate.me.sobekdev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        List<String> list = List.of("armorgrp.txt","etcitemgrp.txt","weapongrp.txt");
        String outputFile = "icon.xml";
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        	writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<list>\n");
        	String line;
        	for (String item : list) {
        		BufferedReader reader = new BufferedReader(new FileReader(item));
        		while ((line = reader.readLine()) != null) {
        			String[] arraySplit = line.split("\t");
        			if(arraySplit[1].equals("id"))
        				continue;
        			writer.write("\t<icon itemId=\""+arraySplit[1]+"\" iconName=\""+arraySplit[13]+"\" />\n");
        		}
        		reader.close();
			}
        	writer.close();
        	System.out.println(outputFile + " successfully created");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}