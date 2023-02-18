package board;

import chesses.ChessItem;

public abstract class ChessBoard {

    protected final Cell[][] cells;

    public ChessBoard(final int horizontalSize, final int verticalSize) {
        if (verticalSize <= 0 || horizontalSize <= 0) throw new IllegalArgumentException("board size can't be negative");
        this.cells = new Cell[verticalSize][horizontalSize];
    }

    public Cell getCell(final int xIndex, final int yIndex) {
        return cells[xIndex][yIndex];
    }
}
