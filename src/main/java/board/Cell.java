package board;

import chesses.ChessItem;

public class Cell {
    private ChessItem chessItem = null;
    private final int xPos;
    private final int yPos;

    public Cell(final int xPos, final int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Cell(final int xPos, final int yPos, ChessItem chessItem) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.chessItem = chessItem;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public ChessItem getChessItem() {
        return chessItem;
    }

    public void setChessItem(ChessItem chessItem) {
        this.chessItem = chessItem;
    }
}
