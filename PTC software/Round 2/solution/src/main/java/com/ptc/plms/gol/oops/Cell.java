package com.ptc.plms.gol.oops;

/**
 * 
 * @author hdhingra
 *
 */
public class Cell {

	private final int x,y;
	private State state;

	public Cell(int x,int y)
	{
		this(x,y,State.DEAD);
	}
	
	public Cell(int x,int y,State state)
	{
		this.x=x;
		this.y=y;
		this.state = state;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Cell createCopy() {
		return new Cell(x,y,state);
	}
	
}
