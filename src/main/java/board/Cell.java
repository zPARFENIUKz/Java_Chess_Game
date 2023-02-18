package board;

import chesses.ChessItem;

public class Cell {
    private ChessItem chessItem = null;

    public Cell() {

    }

    public Cell(ChessItem chessItem) {
        this.chessItem = chessItem;
    }

    public ChessItem getChessItem() {
        return chessItem;
    }

    public void setChessItem(ChessItem chessItem) {
        this.chessItem = chessItem;
    }
}
