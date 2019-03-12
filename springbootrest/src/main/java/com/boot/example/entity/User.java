package com.boot.example.entity;

public class User {
	private int id;
	private String name;
	private String folderId;
	private String orgname;
	
	public User() {
		
	}
	public User(int id, String name, String folderId, String orgname) {
		super();
		this.id = id;
		this.name = name;
		this.folderId = folderId; 
		this.orgname = orgname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFolderId() {
		return folderId;
	}
	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
}
