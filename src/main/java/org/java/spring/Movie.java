package org.java.spring;

public class Movie {
	
	private static int nextId = 1;
	private int id;
	private String title;
	
	public Movie(String title) {
		this.id = nextId;
		nextId++;
		setTitle(title);
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
