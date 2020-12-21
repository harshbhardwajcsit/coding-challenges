package com.practise.graphs.utils;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    // Below arrays details all 8 possible movements from a cell
    // (top, right, bottom, left and 4 diagonal moves)
    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};

    public BFS(int[][] mat, boolean[][] processed, int i, int j) {

        // create an empty queue and enqueue source node
        Queue<Pair> q = new ArrayDeque<>();

        //add Pair/node to Queue
        q.add(new Pair(i, j));

        // mark source node as processed
        processed[i][j] = true;

        // loop till queue is empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            // check for all 8 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 8; k++) {
                // Skip if location is invalid or already processed
                if (canProcess(mat, x + row[k], y + col[k], processed)) {
                    // skip if location is invalid or it is already
                    // processed or consists of water
                    processed[x + row[k]][y + col[k]] = true;
                    q.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    public static boolean canProcess(int[][] mat, int x, int y,
                                     boolean[][] processed) {
        return (x >= 0) && (x < processed.length) &&
                (y >= 0) && (y < processed[0].length) &&
                (mat[x][y] == 1 && !processed[x][y]);
    }

}
