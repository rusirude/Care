package com.leaf.Care.dto.common;

public class DropDownDTO {
	
	private String code;
	private String description;
	
	
	
	public DropDownDTO(String code, String description) {		
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
