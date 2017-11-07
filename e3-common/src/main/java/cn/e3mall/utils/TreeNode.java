package cn.e3mall.utils;

import java.io.Serializable;

public class TreeNode implements Serializable{
	/**
	 *用来封装easyui的tree的一个节点
	 * 
	 * id :  节点id
	 * text ：node节点名称
	 * state : 分为 close(代表可以打开) 和  open(代表已经打开)
	 */
	private Long id;
	private String text;
	private  String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
