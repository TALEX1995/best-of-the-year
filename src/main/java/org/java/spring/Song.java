package org.java.spring;

public class Song {
	
	private static int nextId = 1;
	private int id;
	private String title;
	
	public Song(String title) {
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
