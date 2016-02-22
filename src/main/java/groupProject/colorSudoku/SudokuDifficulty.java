package groupProject.colorSudoku;

public enum SudokuDifficulty {

	EASY(36, 49), MEDIUM(32, 35), HARD(22, 27);

	private final int min;
	private final int max;

	SudokuDifficulty(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMinimum() {
		return min;
	}

	public int getMaximum() {
		return max;
	}
}