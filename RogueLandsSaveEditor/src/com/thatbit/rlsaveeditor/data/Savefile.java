package com.thatbit.rlsaveeditor.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thatbit.rlsaveeditor.data.DataBlock.DataType;

public class Savefile {
	//The files content as plain String
	private String fileContent;
	//The Pattern holding the actual RegEx
	private Pattern pattern;
	//The Matcher which matches the String against the Pattern in the parseData Method
	private Matcher matcher;
	
	//The actual 'Parsed Data'
	private ArrayList<DataBlock> parsedData;
	
	public Savefile(){
		this.fileContent = "";
		//The Pattern for one 'Block' - last update v1.2
		this.pattern = Pattern.compile("(([a-zA-Z0-9.]|\\s)*:){2}(([a-zA-Z0-9.]|\\s)*(;|$)){1}");
		this.parsedData = new ArrayList<DataBlock>();
	}

	//Reading in the File to a String and returning the String after it was stored in fileContent
	public String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        this.fileContent = sb.toString();
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	//Searching with regex and parsing the DataBlocks
	public void parseData() throws IOException {
		//Applying the Pattern
		this.matcher = this.pattern.matcher(this.fileContent);
		//Clear Data
		this.parsedData.clear();
		//Go for every 'DataBlock'
		while(this.matcher.find()){
			DataBlock db = new DataBlock();
			db.parseString(this.matcher.group());
			this.parsedData.add(db);
		}
	}
	
	//Returns the data as plain String
	public String getFileAsStringContent(){
		return this.fileContent;
	}
	
	public String[][] getFileContentAsTwoDimensionalArray(){
		String[][] data = new String[parsedData.size()][3];
		
		for(int i = 0; i < parsedData.size();i++){
			data[i][0] = parsedData.get(i).getName();
			data[i][1] = parsedData.get(i).getValue().toString();
			data[i][2] = parsedData.get(i).getType().toString();
		}
		
		return data;
	}
	
	public boolean hasValue(final String name){
		if(parsedData != null){
			for(DataBlock b : parsedData){
				if(b.getName().equals(name)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Object getValue(final String name){
		if(parsedData != null){
			for(DataBlock b : parsedData){
				if(b.getName().equals(name)){
					return b.getValue();
				}
			}
		}
		return null;
	}
	
	public boolean setValue(final String name,Object value){
		if(parsedData != null){
			for(DataBlock b : parsedData){
				if(b.getName().equals(name)){
					b.setValue(value);
					return true;
				}
			}
		}
		return false;
	}
	
	//Recreates the original savefile string
	public String toSavefileString(){
		String sb = "";
		for(DataBlock b : parsedData){
			if(b.getType() == DataType.Int32){
				sb += " " + b.getName() + " : " + b.getValue().toString() + " : System.Int32 ;";
			}else if(b.getType() == DataType.String){
				sb += " " + b.getName() + " : " + b.getValue().toString() + " : System.String ;";
			}else{
				System.out.println("(Ignoring)Found unrecognized Type: " + b.getName());
			}
		}
		String savefile = sb.toString();
		//Cut off " ;" at the end
		savefile = savefile.substring(0, savefile.length()-2);
		return savefile;
	}
}
