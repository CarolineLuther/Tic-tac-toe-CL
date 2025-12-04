public class Board {
    private char[] cells;

    public Board() {
        cells = new char[9];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = ' ';
        }
    }

    public void print() {
        System.out.println();
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---+---+---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
        System.out.println("---+---+---");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
        System.out.println();
    }

    public boolean isMoveValid(int position) {
        return position >= 1 && position <= 9 && cells[position - 1] == ' ';
    }

    public void placeMove(int position, char symbol) {
        cells[position - 1] = symbol;
    }

    public boolean checkWin(char symbol) {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {
            if (cells[pattern[0]] == symbol &&
                    cells[pattern[1]] == symbol &&
                    cells[pattern[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c == ' ') return false;
        }
        return true;
    }
}