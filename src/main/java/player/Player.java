package player;

import board.ChessBoard;
import chesses.color.ChessColor;
import move.MoveControl;


public class Player {
    protected ChessBoard chessBoard;
    protected ChessColor playerSide;
    protected int stepsCounter = 0;

    protected MoveControl moveControl;

    public void setMoveControl(MoveControl moveControl) {
        this.moveControl = moveControl;
    }

    public void setStepsCounter(int stepsCounter) {
        this.stepsCounter = stepsCounter;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public ChessColor getPlayerSide() {
        return playerSide;
    }

    public void setPlayerSide(ChessColor playerSide) {
        this.playerSide = playerSide;
    }

    public int getStepsCounter() {
        return stepsCounter;
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public boolean moveChessItem(final int cellXPos, final int cellYPos, final int newCellXPos, final int newCellYPos) {
        if (moveControl.isAvailableMove(this, cellXPos, cellYPos, newCellXPos, newCellYPos)) {
            ++stepsCounter;
            return true;
        }
        return false;
    }

}
