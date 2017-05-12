package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.rules.Rule;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;


public class FindLiveNeighbourTest {

    @Test
    public void testFindLiveNeighbourCount() {
        System.out.println("findLiveNeighbourCount");
        Cell cell = new Cell(2,3);
        Set<Cell> liveCells = new HashSet<Cell>();
        liveCells.add(new Cell(1,2));
        liveCells.add(new Cell(2,2));
        liveCells.add(new Cell(1,4));
        liveCells.add(new Cell(3,4));
       
        int expResult = 4;
        int result = FindLiveNeighbour.findLiveNeighbourCount(cell, liveCells);
        assertEquals(expResult, result);
      
    }

}