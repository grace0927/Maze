package com.example.maze;

import java.util.*;

public class Maze {

	Graph maze;
	Vertice start;
	Vertice end;
	
	public Maze() {
		this.maze = new Graph(9);
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Vertice a = new Vertice(i, j);
				if(i==0 && j==0) {
					this.start = a;
				}
				if(i==2 && j==2) {
					this.end = a;
				}
				this.maze.addVertice(a);
			}
		}
	}
	
	public boolean addEdge(Vertice a, Vertice b){
		if(maze.getVertice(a)!=null && maze.getVertice(b)!=null) {
			maze.addEdge(maze.getVertice(a), maze.getVertice(b));
			return true;
		}
		return false;
	}
	
	public boolean setStart(Vertice a) {
		if(maze.getVertice(a) != null) {
			this.start = maze.getVertice(a);
			return true;
		}
		return false;
	}
	
	public boolean setEnd(Vertice a) {
		if(maze.getVertice(a) != null) {
			this.end = maze.getVertice(a);
			return true;
		}
		return false;
	}
	
	public void run() {
		List<Vertice> path = new LinkedList<>();
		path = maze.findPath(this.start, this.end);
		if(path == null) {
			System.out.println("can not find path");
		} else {
			for(Vertice vertice : path) {
				System.out.println("(" + vertice.getX() + "," + vertice.getY() + ") -> ");
			}
			System.out.println("end");
		}
	}
	
	public static void main(String[] args) {
		Maze test = new Maze();
		
		test.addEdge(new Vertice(0,0), new Vertice(0,1));
		test.addEdge(new Vertice(0,0), new Vertice(2,0));
		test.addEdge(new Vertice(2,0), new Vertice(2,1));
		test.addEdge(new Vertice(2,1), new Vertice(1,1));
		test.addEdge(new Vertice(1,1), new Vertice(1,2));
		test.addEdge(new Vertice(1,2), new Vertice(0,2));
		test.addEdge(new Vertice(1,2), new Vertice(2,2));
		
		test.run();

	}

}
