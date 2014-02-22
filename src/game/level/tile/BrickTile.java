package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;

public class BrickTile extends Tile
{
    public BrickTile(Sprite sprite)
    {
        super(sprite);
    }

    public void render(int x, int y, Screen screen)
    {
        screen.renderTile(x << 4, y << 4, sprite);
    }

    public boolean solid()
    {
        return true;
    }
}
