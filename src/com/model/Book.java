package com.model;

public class Book {
	private int boookid;
	private String name;
	private String author;
	private int edition;
	private String publication;
	
	public int getBoookid() {
		return boookid;
	}
	public void setBoookid(int boookid) {
		this.boookid = boookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	@Override
	public String toString() {
		return "Book [boookid=" + boookid + ", name=" + name + ", author=" + author + ", edition=" + edition
				+ ", publication=" + publication + "]";
	}
	
	
}
