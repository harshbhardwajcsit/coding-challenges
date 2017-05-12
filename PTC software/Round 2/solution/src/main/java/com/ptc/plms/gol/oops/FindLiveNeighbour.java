package com.ptc.plms.gol.oops;

import java.util.Set;


public class FindLiveNeighbour{

    public static int findLiveNeighbourCount(Cell cell,Set<Cell> liveCells)
	{
		int count=0;
		for(Cell c:AbstractGameStratedgy.findNeighbours(cell, liveCells))
		{
			if(State.LIVE.equals(c.getState())) count++;
		}
		return count;
	}
}
