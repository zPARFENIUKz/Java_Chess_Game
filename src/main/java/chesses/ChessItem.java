package chesses;

import chesses.color.ChessColor;
import chesses.type.ChessType;

public abstract class ChessItem {
    private ChessType type;
    private final ChessColor color;

    public ChessItem(ChessType type, ChessColor color) {
        this.type = type;
        this.color = color;
    }

    public ChessType getType() {
        return type;
    }

    public ChessColor getColor() {
        return color;
    }
}
