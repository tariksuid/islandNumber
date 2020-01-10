package test;

public class Main {

	public static void main(String[] args) {

		
		int[][] ar = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		Solution s = new Solution();
		System.out.println(s.numIslands(ar));

	}

}

////////////////
class Solution {

	int numOfOnes = 0;

	public int numIslands(int[][] ar) {

		int counter = 0;
//i:num of rows and ar[i].len = #ofColumns 

		boolean[][] visited = new boolean[ar.length][ar[0].length];
		int maxIsland = 0;
		for (int i = 0; i < ar.length; i++)
			for (int j = 0; j < ar[i].length; j++) {

				if (ar[i][j] == 1 && !visited[i][j]) {

					findAllNeighbors(ar, visited, i, j);
					counter++;

					maxIsland = Math.max(maxIsland, numOfOnes);

				}

				numOfOnes = 0;
			}

		System.out.println(maxIsland);

		return counter;

	}

	void findAllNeighbors(int[][] ar, boolean[][] visited, int i, int j) {

		numOfOnes++;
		visited[i][j] = true;
		// left[
		if (i - 1 >= 0 && !visited[i - 1][j] && ar[i - 1][j] == 1)
			findAllNeighbors(ar, visited, i - 1, j);

		// right
		if (i + 1 < ar.length && !visited[i + 1][j] && ar[i + 1][j] == 1)
			findAllNeighbors(ar, visited, i + 1, j);
		// below
		if (j - 1 >= 0 && !visited[i][j - 1] && ar[i][j - 1] == 1)
			findAllNeighbors(ar, visited, i, j - 1);
		// above
		if (j + 1 < ar[i].length && !visited[i][j + 1] && ar[i][j + 1] == 1)
			findAllNeighbors(ar, visited, i, j + 1);

		/**
		 * all the diagonal directions that are possible
		 */
		// i-1 , j-1
		if (i - 1 >= 0 && j - 1 >= 0 && !visited[i - 1][j - 1] && ar[i - 1][j - 1] == 1)
			findAllNeighbors(ar, visited, i - 1, j - 1);

		// i-1 , j+1

		if (i - 1 >= 0 && j + 1 < ar[i].length && !visited[i - 1][j + 1] && ar[i - 1][j + 1] == 1)
			findAllNeighbors(ar, visited, i - 1, j + 1);

		// i+1, j-1

		if (j - 1 >= 0 && i + 1 < ar.length && !visited[i + 1][j - 1] && ar[i + 1][j - 1] == 1)
			findAllNeighbors(ar, visited, i + 1, j - 1);
		// i+1 , j+1
		if (j + 1 < ar[i].length && i + 1 < ar.length && !visited[i + 1][j + 1] && ar[i + 1][j + 1] == 1)
			findAllNeighbors(ar, visited, i + 1, j + 1);

	}

}