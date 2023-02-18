package chesses.realizations;

import chesses.ChessItem;
import chesses.color.ChessColor;
import chesses.type.ChessType;

public class Queen extends ChessItem {
    public Queen(ChessColor color) {
        super(ChessType.QUEEN, color);
    }
}
