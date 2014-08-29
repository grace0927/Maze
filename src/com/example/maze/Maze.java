package com.example.maze;

public class Maze {

	Graph maze;
	Vertice start;
	Vertice end;
	
	public Maze() {
		this.maze = new Graph(9);
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Vertice a = new Vertice(i, j);
				this.maze.addVertice(a);
			}
		}
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
	
	public static void main(String[] args) {
		Maze test = new Maze();
		
		

	}

}
