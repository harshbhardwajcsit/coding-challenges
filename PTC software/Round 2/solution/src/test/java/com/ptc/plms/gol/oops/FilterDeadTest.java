package com.ptc.plms.gol.oops;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterDeadTest {

public void test(){
System.out.println("findNeighbours");

        HashSet<Cell> nextGeneration =new HashSet<Cell>();
        nextGeneration.add(new Cell(1,2,State.LIVE));
        nextGeneration.add(new Cell(1,3,State.DEAD));
        nextGeneration.add(new Cell(1,4,State.DEAD));
        nextGeneration.add(new Cell(2,2,State.LIVE));
        nextGeneration.add(new Cell(2,3,State.LIVE));

        //FilterDead instance = new FilterDead();
        Set<Cell> expResult = new HashSet<Cell>();
        expResult.add(new Cell(1,2,State.LIVE));
        expResult.add(new Cell(2,2,State.LIVE));
        expResult.add(new Cell(2,3,State.LIVE));


        Set<Cell> result = FilterDead.filterDead(nextGeneration);
        assertEquals(expResult, result);

    }


}