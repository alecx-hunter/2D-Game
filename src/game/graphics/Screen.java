package game.graphics;

import game.entity.projectile.Projectile;

import java.util.Random;

public class Screen
{
    private int width, height;
    private int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private int xOffset, yOffset;
    private Random random = new Random();

    public Screen(int width, int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)
            tiles[i] = random.nextInt(0xffffff);
    }

    public void clear()
    {
        for (int i = 0; i < pixels.length; i++)
            pixels[i] = 0;
    }

    public void renderTile(int xp, int yp, Sprite sprite)
    {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.size; y++)
        {
            int ya = y + yp;
            for (int x = 0; x < sprite.size; x++)
            {
                int xa = x + xp;
                if (xa < -sprite.size || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;

                int color = sprite.pixels[x + y * sprite.size];
                if (color != 0xffff00ff)
                    pixels[xa + ya * width] = sprite.pixels[x + y * sprite.size];
            }
        }
    }

    public void renderPlayer(int xp, int yp, Sprite sprite)
    {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.size; y++)
        {
            int ya = y + yp;
            for (int x = 0; x < sprite.size; x++)
            {
                int xa = x + xp;
                if (xa < -sprite.size || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;

                int color = sprite.pixels[x + y * sprite.size];
                if (color != 0xffff00ff)
                    pixels[xa + ya * width] = sprite.pixels[x + y * sprite.size];
            }
        }
    }

    public void renderProjectile(int xp, int yp, Projectile p)
    {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < p.getSpriteSize(); y++)
        {
            int ya = y + yp;
            for (int x = 0; x < p.getSpriteSize(); x++)
            {
                int xa = x + xp;
                if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;

                int color = p.getSprite().pixels[x + y * p.getSpriteSize()];
                if (color != 0xffff00ff)
                    pixels[xa + ya * width] = p.getSprite().pixels[x + y * p.getSpriteSize()];
            }
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[] getPixels()
    {
        return pixels;
    }

    public void setOffset(int xOffset, int yOffset)
    {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getxOffset()
    {
        return xOffset;
    }

    public int getyOffset()
    {
        return yOffset;
    }
}