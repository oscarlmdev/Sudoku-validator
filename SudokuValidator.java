import java.util.ArrayList;
import java.util.Arrays;

public class SudokuValidator {
    private ArrayList<Integer> sequence;
    private int l = 9;

    public SudokuValidator() {
        restartSequence();
    }

    private void restartSequence() {
        sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public static boolean validate(int[][] board) {
        return checkVertical(board) && checkHorizontal(board) && checkBoxes(board);
    }

    public static boolean checkVertical(int[][] board) {
        SudokuValidator sv = new SudokuValidator();
        for (int x = 0; x < sv.l; x++) {
            sv.restartSequence();
            for (int y = 0; y < sv.l; y++) {
                if (sv.sequence.contains(board[y][x])) {
                    sv.sequence.remove(Integer.valueOf(board[y][x]));
                } else return false;
            }
        } return true;
    }

    public static boolean checkHorizontal(int[][] board) {
        SudokuValidator sv = new SudokuValidator();
        for (int y = 0; y < sv.l; y++) {
            sv.restartSequence();
            for (int x = 0; x < sv.l; x++) {
                if (sv.sequence.contains(board[y][x])) {
                    sv.sequence.remove(Integer.valueOf(board[y][x]));
                } else return false;
            }
        } return true;
    }

    public static boolean checkBoxes(int[][] board) {
        SudokuValidator sv = new SudokuValidator();
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                sv.restartSequence();
                for (int x = 0 + i; x < 3 + i; x++) {
                    for (int y = 0 + j; y < 3 + j; y++) {
                        if (sv.sequence.contains(board[y][x])) {
                            sv.sequence.remove(Integer.valueOf(board[y][x]));
                        } else return false;
                    }
                }
            }
        } return true;
    }
}
