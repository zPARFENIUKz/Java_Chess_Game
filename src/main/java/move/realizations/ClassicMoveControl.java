package move.realizations;

import board.Cell;
import board.ChessBoard;
import chesses.ChessItem;
import chesses.color.ChessColor;
import move.MoveControl;
import player.Player;

@SuppressWarnings("SuspiciousNameCombination")
public class ClassicMoveControl implements MoveControl {
    @Override
    public boolean isAvailableMove(Player player, int cellXPos, int cellYPos, int newCellXPos, int newCellYPos) {
        if (player == null) throw new NullPointerException("player can't be null");
        final ChessColor playerSide = player.getPlayerSide();
        final ChessBoard chessBoard = player.getChessBoard();

        // IndexOutOfBoundsException of some index is wrong
        final Cell startCell = chessBoard.getCell(cellYPos, cellXPos);
        final Cell resultCell = chessBoard.getCell(newCellYPos, newCellXPos);

        final ChessItem chessItem = startCell.getChessItem();
        if (chessItem == null) return false;
        if (!chessItem.getColor().equals(playerSide)) return false;

        final ChessItem chessItemToBeat = resultCell.getChessItem();
        if (chessItemToBeat == null || !chessItemToBeat.getColor().equals(playerSide)) {
            return switch (chessItem.getType()) {
                case PAWN -> movePawn(player, startCell, resultCell);
                case BISHOP -> moveBishop(startCell, resultCell);
                case KNIGHT -> moveKnight(startCell, resultCell);
                case ROOK -> moveRook(startCell, resultCell);
                case QUEEN -> moveQueen(startCell, resultCell);
                case KING -> moveKing(startCell, resultCell);
            };
        }
        return false;
    }

    protected boolean movePawn(Player player, Cell startCell, Cell resultCell) {
        final int playerStepCounter = player.getStepsCounter();
        // if pawn doesn't try to move by horizontal
        if (startCell.getXPos() == resultCell.getXPos()) {
            if (player.getStepsCounter() == 0) {
                if (player.getPlayerSide().equals(ChessColor.BLACK)) {
                    if (resultCell.getYPos() > startCell.getYPos()) {
                        if (resultCell.getYPos() <= startCell.getYPos() + 2) {
                            if (resultCell.getChessItem() == null) {
                                resultCell.setChessItem(startCell.getChessItem());
                                startCell.setChessItem(null);
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    // is player chess color is white
                    if (resultCell.getYPos() < startCell.getYPos()) {
                        if (resultCell.getYPos() >= startCell.getYPos() - 2) {
                            if (resultCell.getChessItem() == null) {
                                resultCell.setChessItem(startCell.getChessItem());
                                startCell.setChessItem(null);
                            } else {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                if (player.getPlayerSide().equals(ChessColor.BLACK)) {
                    if (resultCell.getYPos() > startCell.getYPos()) {
                        if (resultCell.getYPos() == startCell.getYPos() + 1) {
                            if (resultCell.getChessItem() == null) {
                                resultCell.setChessItem(startCell.getChessItem());
                                startCell.setChessItem(null);
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    if (resultCell.getYPos() < startCell.getYPos()) {
                        if (resultCell.getYPos() == startCell.getYPos() - 1) {
                            if (resultCell.getChessItem() == null) {
                                resultCell.setChessItem(startCell.getChessItem());
                                startCell.setChessItem(null);
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        } else {
            // if trying to beat somebody
            if (startCell.getXPos() == resultCell.getXPos() - 1
                    || startCell.getXPos() == resultCell.getXPos() + 1) {
                // black chess figures in the top part of the chess board, so it need to go down
                if (player.getPlayerSide().equals(ChessColor.BLACK)) {
                    if (resultCell.getYPos() == startCell.getYPos() + 1) {
                        final ChessItem resultCellChessItem = resultCell.getChessItem();
                        if (resultCellChessItem.getColor().equals(ChessColor.BLACK)) return false;
                        else {
                            resultCell.setChessItem(startCell.getChessItem());
                            startCell.setChessItem(null);
                            return true;
                        }
                    }
                } else {
                    if (resultCell.getYPos() == startCell.getYPos() - 1) {
                        final ChessItem resultCellChessItem = startCell.getChessItem();
                        if (resultCellChessItem.getColor().equals(ChessColor.WHITE)) return false;
                        else {
                            resultCell.setChessItem(startCell.getChessItem());
                            startCell.setChessItem(null);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


}
