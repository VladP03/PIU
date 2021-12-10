package PIUGame.Items;

import PIUGame.Graphics.Animation;
import PIUGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static PIUGame.Graphics.Assets.explosion_effect_image;

public class Explosion extends Item {

    private final Animation explosion_animation;
    private final int number_of_animations = 28;

    private int repeated_times = 0;

    public Explosion(RefLinks refLink, float x, float y) {
        super(refLink, x - 30, y - 70, 100, 100);

        explosion_animation = new Animation(1, explosion_effect_image);
    }

    @Override
    public void Update() {
        repeated_times++;
        explosion_animation.Update();
        if (animationDone()) {
            distroyAnimation();
        }
    }

    @Override
    public void Draw(Graphics g) {
        //g.drawImage(stone_image, (int)x, (int)y, 50, 50, null);
        //g.drawImage(stone_image, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);

        g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

        //g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);

//        g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);

        // draw the actual image
        g.drawImage(getCurrentAnimationFrame(), (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), width, height, null);

        //System.out.println("            exista");

    }


    private BufferedImage getCurrentAnimationFrame() {
        return explosion_animation.getCurrentFrame();
    }


    public boolean animationDone() {
        return repeated_times > number_of_animations;
    }

    public void distroyAnimation() {
        List<Explosion> explosions = refLink.getGame().getPlayState().getExplosions();
        for (int i = 0; i < explosions.size(); i++) {
            if (explosions.get(i) == this) {
                explosions.remove(this);
            }
        }
        refLink.getGame().getPlayState().setExplosions(explosions);
    }
}
