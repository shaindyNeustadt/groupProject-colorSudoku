package groupProject.colorSudoku;

public class SudokuChecker {

	int[][] puzzle;
	boolean[] digits;

	public SudokuChecker() {
	}

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
		for (int i = 0; i < 9; i++) {
			if (!checkRow(i)) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (!checkColumn(i)) {
				return false;
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!checkSquare(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkRow(int r) {
		resetCheck();
		for (int c = 0; c < 9; c++) {
			if (!digitCheck(puzzle[r][c])) {
				return false;
			}
		}
		return true;
	}

	public boolean checkColumn(int c) {
		resetCheck();
		for (int r = 0; r < 9; r++) {
			if (!digitCheck(puzzle[r][c])) {
				return false;
			}
		}
		return true;
	}

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

	public boolean digitCheck(int n) {
		if (n != 0 && digits[n]) {
			return false;
		} else {
			digits[n] = true;
			return true;
		}
	}

	public void resetCheck() {
		digits = new boolean[10];
	}
}