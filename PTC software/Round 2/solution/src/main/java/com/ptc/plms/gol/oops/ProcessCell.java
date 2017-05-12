package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.rules.Rule;
import java.util.Set;

public class ProcessCell {
public static void processCell(Cell cell,Set<Cell> currentGeneration,Set<Cell> nextGeneration)
	{
		if(nextGeneration.contains(cell)) return; // already processed

		cell=cell.createCopy();

		State nextState=cell.getState();
		for(Rule rule:AbstractGameStratedgy.getRules())
		{
			nextState=rule.nextState(cell.getState(), FindLiveNeighbour.findLiveNeighbourCount(cell, currentGeneration));

			if(!cell.getState().equals(nextState))
			{
				break;
			}
		}

		cell.setState(nextState);
		nextGeneration.add(cell);
	}
}
