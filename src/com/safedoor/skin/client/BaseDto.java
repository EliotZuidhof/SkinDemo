package com.safedoor.skin.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.sencha.gxt.data.shared.TreeStore;

/**
 * The data object used for the customer tree
 * 
 * @author eliot.zuidhof
 *
 */
@SuppressWarnings("serial")
public class BaseDto implements Serializable, TreeStore.TreeNode<BaseDto>{

	//A changing static id
	private static Integer ID = 0;
	//an instance specific unique id
	private Integer id;
	//the data instance name
	private String name;
	private List<BaseDto> children;
	
	/**
	 * create a BaseDto object with a name and a unique id 
	 * @param name the DTO name
	 */
	public BaseDto(String name){
		this.name = name;
		this.id = ID++;
		this.children = new ArrayList<BaseDto>();
	}
	
	/**
	 * adds a child object to the BaseDto
	 * @param child the child to add
	 */
	public void addChild(BaseDto child){
		getChildren().add(child);
	}
	
	/*
	 ===================
	 GETTERS AND SETTERS
	 ===================
	*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BaseDto getData() {
		return this;
	}
	
	/**
	 * returns a list of children contained in the BaseDto object
	 */
	@Override
	public List<BaseDto> getChildren() {
		return children;
	}
	
	/**
	 * sets the children of this object
	 * @param children a list of children
	 */
	public void setChildren(List<BaseDto> children){
		this.children = children;
	}
	/*
	 =======================
	 END GETTERS AND SETTERS 
	 =======================
	*/
	
	@Override
	public String toString(){
		return name!=null? name:super.toString();
	}
}
