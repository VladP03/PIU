package PIUGame.GameCamera;

import PIUGame.Items.Item;
import PIUGame.RefLinks;
import PIUGame.Tiles.Tile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameCamera {
    private final RefLinks refLink;
    private float xOffset, yOffset;

    public void centerOnEntity(Item e) {
        xOffset = e.getX() - (float) (refLink.getWidth() / 2.) + (float) (e.getWidth() / 2.);
        yOffset = e.getY() - (float) (refLink.getHeight() / 2.) + (float) (e.getHeight() / 2.);

        checkForBlankSpace();
    }


    // verifica marginile hartii
    private void checkForBlankSpace() {
        checkForBlankSpaceOnWidth();
        checkForBlankSpaceOnHeight();
    }

    private void checkForBlankSpaceOnWidth() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > refLink.getMap().getWidth() * Tile.TILE_WIDTH - refLink.getWidth()) {
            xOffset = refLink.getMap().getWidth() * Tile.TILE_WIDTH - refLink.getWidth();
        }
    }

    private void checkForBlankSpaceOnHeight() {
        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > refLink.getMap().getHeight() * Tile.TILE_HEIGHT - refLink.getHeight()) {
            yOffset = refLink.getMap().getHeight() * Tile.TILE_HEIGHT - refLink.getHeight();
        }
    }
}
