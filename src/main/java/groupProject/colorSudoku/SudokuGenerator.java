package groupProject.colorSudoku;

import java.util.Random;

public class SudokuGenerator {

	private SudokuChecker sudokuChecker;
	public static final int BOARD_WIDTH = 9;
	public static final int BOARD_HEIGHT = 9;
	int[][] board;

	public SudokuGenerator() {
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		sudokuChecker = new SudokuChecker();
	}

	public int[][] nextBoard(int difficulty) {
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		nextCell(0, 0);
		makeHoles(difficulty);
		return board;
	}

	public boolean nextCell(int x, int y) {
		int nextX = x;
		int nextY = y;
		int[] toCheck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

		for (int i = top - 1; i > 0; i--) {
			current = r.nextInt(i);
			tmp = toCheck[current];
			toCheck[current] = toCheck[i];
			toCheck[i] = tmp;
		}

		for (int i = 0; i < toCheck.length; i++) {
			if (legalMove(x, y, toCheck[i])) {
				board[x][y] = toCheck[i];
				if (x == 8) {
					if (y == 8) {
						return true;
					} else {
						nextX = 0;
						nextY = y + 1;
					}
				} else {
					nextX = x + 1;
				}
				if (nextCell(nextX, nextY)) {
					return true;
				}
			}
		}
		board[x][y] = 0;
		return false;
	}

	private boolean legalMove(int x, int y, int current) {
		for (int i = 0; i < 9; i++) {
			if (current == board[x][i]) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (current == board[i][y]) {
				return false;
			}
		}
		int cornerX = 0;
		int cornerY = 0;
		if (x > 2) {
			if (x > 5) {
				cornerX = 6;
			} else {
				cornerX = 3;
			}
		}
		if (y > 2) {
			if (y > 5) {
				cornerY = 6;
			} else {
				cornerY = 3;
			}
		}
		for (int i = cornerX; i < 10 && i < cornerX + 3; i++) {
			for (int j = cornerY; j < 10 && j < cornerY + 3; j++) {
				if (current == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void makeHoles(int holesToMake) {
		double remainingSquares = 81;
		double remainingHoles = (double) holesToMake;

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				double holeChance = remainingHoles / remainingSquares;
				if (Math.random() <= holeChance) {
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}

	public void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(board[i][j] + "  ");
			System.out.println();
		}
		System.out.println();
	}

	public void setNumber(int row, int column, int number) {
		board[row][column] = number;
	}

	public boolean checkBoard() {
		sudokuChecker.checkPuzzle(board);
		return sudokuChecker.completed();
	}

	public int getBoard(int row, int column) {
		return board[row][column];
	}
}