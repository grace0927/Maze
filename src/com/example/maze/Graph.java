package com.example.maze;

import java.util.*;

public class Graph {
	List<Vertice> vertices = new ArrayList<>();
	HashMap<Vertice, ArrayList<Vertice>> adj = new HashMap<>();
	
	int size;
	int capacity;
	
	public Graph() {
		this.size = 0;
	}
	
	public Graph(int capacity) {
		this.size = 0;
		this.capacity = capacity;
	}
	
	public Graph(Graph g) {
		this.vertices = g.getVertices();
		this.adj = g.getAdj();
		this.size = g.getSize();
		this.capacity = g.getCapacity();
	}
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public HashMap<Vertice, ArrayList<Vertice>> getAdj() {
		return adj;
	}
	
	public boolean addVertice(Vertice a) {
		if(this.getVertice(a) != null) {
			System.out.println("already exists");
			return false;
		}
		if(this.size <= this.capacity) {
			vertices.add(a);
			this.size++;
			ArrayList<Vertice> verticeAdj = new ArrayList<>();
			adj.put(a, verticeAdj);
			return true;
		}
		return false;
	}
	
	public boolean addEdge(Vertice a, Vertice b) {
		if(vertices.contains(a) && vertices.contains(b)) {
			adj.get(a).add(b);
			adj.get(b).add(a);
			return true;
		}
		return false;
	}
	
	public Vertice getVertice(Vertice a) {
		for(Vertice vertice : vertices) {
			if(vertice.isEqual(a)) {
				return vertice;
			}
		}
		return null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public boolean isAdj(Vertice a, Vertice b) {
		if(vertices.contains(a) && vertices.contains(b)) {
			if(adj.get(a).contains(b)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean removeVertice(Vertice a) {
		if(vertices.contains(a)) {
			ArrayList<Vertice> adjVertices = adj.get(a);
			for(Vertice adjVertice : adjVertices) {
				adj.get(adjVertice).remove(a);
			}
			adj.remove(a);
			vertices.remove(a);
			this.size--;
			return true;
		}
		return false;
	}
	
	public List<Vertice> findPath(Vertice start, Vertice end) {
		if(vertices.contains(start) && vertices.contains(end)) {
			List<Vertice> result = new LinkedList<>();
			
			result.add(start);
			if(this.isAdj(start, end)){
				result.add(end);
				return result;
			} else {
				Graph temp = new Graph(this);
				List<Vertice> adjVertices = temp.getAdj().get(start);
				temp.removeVertice(start);
				for(Vertice adjVertice : adjVertices) {
					if(temp.findPath(adjVertice, end)!=null){
						result.addAll(temp.findPath(adjVertice, end));
						return result;
					} else {
						return null;
					}
				}
			}
		}
		return null;
	}
}
