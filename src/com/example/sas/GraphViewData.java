package com.example.sas;
import com.jjoe64.graphview.GraphViewDataInterface;

public class GraphViewData implements GraphViewDataInterface{
	private double x,y;
	
	public GraphViewData(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

}
