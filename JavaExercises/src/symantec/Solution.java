package symantec;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int _a_cnt = 0, _b_cnt = 0;
		int[][] _a = new int[1001][1001];
		try {
			_a_cnt = sc.nextInt();
			_b_cnt = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Here: " + e.getMessage());
		}

		for (int i = 0; i < _a_cnt; i++) {
			for (int j = 0; j < _b_cnt; j++) {
				int _a_tmp = 0;
				try {
					_a_tmp = sc.nextInt();
				} catch (Exception e) {
				}
				_a[i][j] = _a_tmp;
			}
		}
		System.out.println(numberOfPaths(_a, _a_cnt, _b_cnt));
	}

	static int numberOfPaths(int[][] a, int M, int N) {
		System.out.println("M -> " + M);
		System.out.println("N-> " + N);

		int[][] solutions = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				solutions[i][j] = a[i][j];
			}
		}

		// return dynamicHelper(a, M, N, 0, 0, solutions);
		// return newArray(a, M, N, 0, 0);
		dynamicHelper(a, M, N, 0, 0, solutions);
		return solutions[0][0];
	}

	private static void dynamicHelper(int[][] a, int M, int N, int currentRow,
			int currentCol, int[][] solutions) {
		if (M == 0 || N == 0) {
			solutions[currentRow][currentCol] = 0;
			return;
		} else if (M == 1 && N == 2) {
			solutions[currentRow][currentCol] = 1;
			return;
		} else if (M == 2 && N == 1) {
			solutions[currentRow][currentCol] = 1;
			return;
		} else {
			/*
			 * if there is a 0 in the cell below the current then put one in the
			 * solutions
			 */
			/* should only process the bottom cell if more than 1 rows */
			if (M > 1) {
				if (a[currentRow + 1][currentCol] == 0) {
					solutions[currentRow + 1][currentCol] = 0;
				} else {
					/* solutions[currentRow+1][currentCol] = */dynamicHelper(a,
							M - 1, N, currentRow + 1, currentCol, solutions);
				}
			}
			/*
			 * if there is a 0 in the cell to the right of current then put one
			 * in solutions
			 */
			/* should only process rigth cell if more than 1 column */
			if (N > 1) {
				if (a[currentRow][currentCol + 1] == 0) {
					solutions[currentRow][currentCol + 1] = 0;
				} else {
					/* solutions[currentRow][currentCol+1] = */dynamicHelper(a,
							M, N - 1, currentRow, currentCol + 1, solutions);
				}
			}
			if (M == 1) {
				solutions[currentRow][currentCol] = solutions[currentRow][currentCol + 1];
			} else if (N == 1) {
				solutions[currentRow][currentCol] = solutions[currentRow + 1][currentCol];
			} else {
				solutions[currentRow][currentCol] = solutions[currentRow + 1][currentCol]
						+ solutions[currentRow][currentCol + 1];
			}
		}

	}

	private static int newArray(int[][] a, int M, int N, int currentRow,
			int currentCol) {
		/* seems like recursive solution would work for this problem */
		/*
		 * the base case should be if I am right above or to the left of the
		 * bottom right index then I have 1 way therefore I should return 1, if
		 * we are going out of range of the matrix then return 0 meaning if we
		 * make recursive call and the value of M or N gets thinner than 1
		 */
		/* right above base case */
		if (M == 0 || N == 0) {
			return 0;
		}
		if (M == 1 && N == 2) {
			return 1;
		}
		/* right to the left base case */
		if (M == 2 && N == 1) {
			return 1;
		}
		/*
		 * recursive case: if we are not handling 1x2 or 2x1 matrix then
		 * recursively call this method for two sub-problems handling the 0,1
		 * matrix value case
		 */
		/*
		 * assume that we are at 0,0 cell of this matrix now recursively call
		 * for the smaller matrix for one less row and one less column
		 */
		/* the the cell to the right of 0,0 contains 1 */
		/*
		 * if you are making a split then you are increasing the number of ways
		 * by 1, but if you cannot make a split then you are continuing down the
		 * same path therefore you are not increasing the number of ways,
		 * therefore split is what we have to check for
		 */
		int numWaysFromBottom = 0;
		int numWaysFromRight = 0;
		if (a[currentRow][currentCol + 1] == 1) {
			numWaysFromRight = newArray(a, M, N - 1, currentRow, currentCol + 1);
		}
		if (a[currentRow + 1][currentCol] == 1) {
			numWaysFromBottom = newArray(a, M - 1, N, currentRow + 1,
					currentCol);
		}

		return numWaysFromBottom + numWaysFromRight;
	}
}
