package com.sportsjobs.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class BaseDict implements Serializable {

	private String dict_id;
	private String dict_type_code;
	private String dict_type_name;
	private String dict_item_name;
	public String getDict_id() {
		return dict_id;
	}
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	private Integer start;
	private Integer rows;	
}
