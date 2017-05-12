package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class FilterDead {

    
     public static Set<Cell> filterDead(HashSet<Cell> nextGeneration) {
		Iterator<Cell> iterator = nextGeneration.iterator();

		while(iterator.hasNext())
		{
			if(State.DEAD.equals(iterator.next().getState()))
			{
				iterator.remove();
			}
		}

		return nextGeneration;
	}
}
