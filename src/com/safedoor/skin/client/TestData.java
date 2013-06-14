package com.safedoor.skin.client;

import java.util.ArrayList;
import java.util.List;

public class TestData {
	
	private List<Data> data;
	private int records;
	
	public TestData(int records){
		this.records = records;
		data = new ArrayList<Data>();
		for(int i=0;i<records;i++){
			data.add(new Data("Name "+(i+1),Math.random()*200,"Note"));
		}
	}
	
	public List<Data> getData(){
		return data;
	}
	
}
