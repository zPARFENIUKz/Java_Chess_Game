package chesses.realizations;

import chesses.ChessItem;
import chesses.color.ChessColor;
import chesses.type.ChessType;

public class King extends ChessItem {
    public King(ChessColor color) {
        super(ChessType.KING, color);
    }
}
