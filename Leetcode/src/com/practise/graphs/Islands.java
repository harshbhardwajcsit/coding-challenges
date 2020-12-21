package com.practise.graphs;

import com.practise.graphs.utils.BFS;


/*
------ finding connected component approach -----
step - 1 : visit every cell of a matrix and check if it is not already processed and can be visited
           start BFS traversal with that cell, so in process we can visit every cell connected to it.
           once a single traversal is complete, mark that as a individual island.
 */
public class Islands {

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                        {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
                };

        int M = mat.length;
        int N = mat[0].length;

        // stores if cell is processed or not
        boolean[][] processed = new boolean[M][N];

        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // start BFS from each unprocessed node and
                // increment island count
                if (mat[i][j] == 1 && !processed[i][j]) {
                    new BFS(mat, processed, i, j);
                    island++;
                }
            }
        }

        System.out.print("Number of islands are " + island);
    }
}

