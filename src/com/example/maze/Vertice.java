package com.example.maze;

public class Vertice implements Comparable<Vertice> {

	int x;
	int y;
	
	public Vertice(){
		this.x = 0;
		this.y = 0;
	}
	
	public Vertice(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean setX(int x) {
		this.x = x;
		return true;
	}
	
	public boolean setY(int y) {
		this.y = y;
		return true;
	}
	
	public int compareTo(Vertice a) {
		return (a.x - this.x) * (a.y - this.y);
	}
	
	public boolean isEqual(Vertice a) {
		if(a.x == this.x && a.y == this.y) {
			return true;
		} 
		return false;
	}
}
