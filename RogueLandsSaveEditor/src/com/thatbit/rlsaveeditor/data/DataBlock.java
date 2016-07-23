package com.thatbit.rlsaveeditor.data;

import java.io.IOException;

public class DataBlock {
	
	//For now only int32 has been found
	//The Idea is that you can savely cast the Value to integer if type = DataType.Int32
	public static enum DataType{
		Int32,
		String,
		Undefined
	}
	
	private DataType type;
	private String name;
	private Object value;
	
	public DataBlock() {
		// TODO Auto-generated constructor stub
	}

	public DataType getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Object getValue(){
		return this.value;
	}
	
	public void setValue(Object value){
		this.value = value;
	}
	
	//Parsing method not final, needs to be reworked!
	public void parseString(String content) throws IOException{
		String[] splitted = content.split("\\s+");
		this.name = splitted[1];
		if(splitted[5].equalsIgnoreCase("system.int32")){
			this.value = Integer.parseInt(splitted[3]);
			this.type = DataType.Int32;
		}else if(splitted[5].equalsIgnoreCase("system.string")){
			this.value = splitted[3];
			this.type = DataType.String;
		}else {
			this.value = "Failed to load";
			this.type = DataType.Undefined;
		}
	}
}
