package com.safedoor.skin.client;

import java.util.Date;

/**
 * Data for the DataGrid object.
 * This data is just a random collection of different properties
 * 
 * @author eliot.zuidhof
 *
 */
public class Data {
	
	//A changing static id
	private static Integer ID=0;
	
	/*
	 ===============
	 DATA PROPERTIES
	 ===============
	*/
	private String name;
	private String symbol;
	private Integer id;
	private Double price;
	private Double change;
	private String date;
	private Boolean available;
	private Boolean checked;
	private Boolean compliant;
	private String notes;
	
	/**
	 * Create the 10 item data object.
	 * Most of the elements are auto-generated
	 * 
	 * @param name The name of the data entry
	 * @param price Just a random number
	 * @param notes A random string
	 */
	public Data(String name, Double price, String notes){
		this.name = name;
		this.symbol = name.substring(0, 2);
		this.id = ID++;
		this.price = price;
		this.change = (Math.random()*10)-5;
		this.date = new Date().toString();
		this.available = (Math.random()>0.5);
		this.checked = (Math.random()>0.5);
		this.compliant = (Math.random()>0.5);
		this.notes = notes;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	/*
	 ===================
	 GETTERS AND SETTERS
	 ===================
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Boolean isCompliant() {
		return compliant;
	}
	public void setCompliant(boolean compliant) {
		this.compliant = compliant;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
