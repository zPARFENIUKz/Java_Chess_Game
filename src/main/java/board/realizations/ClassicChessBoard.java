package board.realizations;

import board.ChessBoard;
import chesses.ChessItem;

public class ClassicChessBoard extends ChessBoard {
    private static final int HORIZONTAL_SIZE = 8;
    private static final int VERTICAL_SIZE = 8;
    public ClassicChessBoard() {
        super(HORIZONTAL_SIZE, VERTICAL_SIZE);
    }
}
