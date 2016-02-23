package groupProject.colorSudoku;

public class SudokuChecker {
	int[][] puzzle;
	boolean[] digits;

	public SudokuChecker() {
	}

	/**
	 * check to be sure there is an entry 1-9 in each position in the matrix
	 * exit with false as soon as you find one that is not
	 * 
	 * @return true if the board has correct entries, false otherwise
	 */
	public boolean completed() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (puzzle[i][j] > 9 || puzzle[i][j] < 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkPuzzle(int[][] puzzle) {
		this.puzzle = puzzle;
		// use checkRow to check each row
		for (int i = 0; i < 9; i++) {
			if (!checkRow(i)) {
				return false;
			}
		}

		// use checkColumn to check each column

		for (int i = 0; i < 9; i++) {
			if (!checkColumn(i)) {
				return false;
			}
		}

		// use checkSquare to check each of the 9 blocks
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!checkSquare(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Ensures that row r is legal
	 * 
	 * @param r
	 *            the row to check
	 * @return true if legal, false otherwise.
	 */
	public boolean checkRow(int r) {
		resetCheck();
		for (int c = 0; c < 9; c++) {
			if (!digitCheck(puzzle[r][c])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Ensures that column c is legal
	 * 
	 * @param c
	 *            the column to check
	 * @return true if legal, false otherwise.
	 */
	public boolean checkColumn(int c) {
		resetCheck();
		for (int r = 0; r < 9; r++) {
			if (!digitCheck(puzzle[r][c])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Ensures that a given square is legal
	 * 
	 * @param row
	 *            the initial row of the square
	 * @param column
	 *            the intial column of the square
	 * @return true if legal, false otherwise.
	 */
	public boolean checkSquare(int row, int column) {
		resetCheck();
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (!digitCheck(puzzle[r + row][c + column]))
					return false;
			}
		}
		return true;
	}

	/**
	 * Keeps track of numbers used during a row/column/square check
	 * 
	 * @param n
	 *            the number currently being checked
	 * @return true if the number has not been used yet, false otherwise
	 */
	public boolean digitCheck(int n) {
		if (n != 0 && digits[n]) {
			return false;
		} else {
			digits[n] = true;
			return true;
		}
	}

	/**
	 * Resets digits to false
	 */
	public void resetCheck() {
		digits = new boolean[10];
	}
}