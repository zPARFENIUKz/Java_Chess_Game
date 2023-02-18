package chesses.realizations;

import chesses.ChessItem;
import chesses.color.ChessColor;
import chesses.type.ChessType;

public class Pawn extends ChessItem {
    public Pawn(ChessColor color) {
        super(ChessType.PAWN, color);
    }
}
