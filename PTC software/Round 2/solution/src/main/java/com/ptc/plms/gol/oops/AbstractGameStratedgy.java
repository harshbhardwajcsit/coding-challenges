package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Set;

import com.ptc.plms.gol.oops.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public abstract class AbstractGameStratedgy implements GameStratedy {

	private Rule [] rules; 
	
	@Override
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	@Override
	public Rule[] getRules() {
		return rules;
	}
	
	@Override
	public Set<Cell> findNeighbours(Cell cell,Set<Cell> liveCells)
	{
		HashSet<Cell> neighbours=new HashSet<Cell>(); 
		
		int x=cell.getX();
		int y=cell.getY();
		Cell tempCell;
		for(int i=x-1;i<=x+1;i++)
		{
			if(i<0) continue;
			
			for(int j=y-1;j<=y+1;j++)
			{
				if(j<0) continue;
				
				tempCell=new Cell(i, j);
				if(liveCells.contains(tempCell))
				{
					tempCell.setState(State.LIVE);
				}
				neighbours.add(tempCell);
			}
		}
		
		return neighbours;
	}
}
