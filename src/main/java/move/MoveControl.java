package move;

import player.Player;

public interface MoveControl {
    boolean isAvailableMove(Player player, int cellXPos, int cellYPos, int newCellXPos, int newCellYPos);
}
