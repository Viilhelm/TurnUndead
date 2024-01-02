package weapon;

import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import ghost.Ghost;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



/**
 * <p>
 *     <code>Eye</code> is a concrete implementation class.
 * </p>
 */
public class Eye extends Weapon {

    public boolean isUsed = false;

    public final Image EYE_1 = createImage("/Pictures/eye.png");



    public Eye(int tileNumber) {
        super(tileNumber);
        Cost = Constant.EYE_COST;
        health = Constant.EYE_HEALTH;
        damage = Constant.EYE_DAMAGE;
        attackSpeed = Constant.EYE_ATTACK_SPEED;
        cooldownTime = Constant.EYE_COOLDOWN_TIME;
        firstPurchaseNoCooldown = false;
        setImage(EYE_1);
        setVelocity(0, 0);
        setPosition(positionX - 12, positionY - 5);
    }

    public Eye(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/Pictures/eye.png", width, height);
    }


    @Override
    public void update(long time, GraphicsContext context) {

        setImage(EYE_1);

        elapsedTime = System.currentTimeMillis() - recordedTime;

        if (elapsedTime >= attackSpeed * 1000) {
            for (Ghost ghost : Game.ghostList) {
                int tile = Constant.getTile(ghost.positionX + ghost.width / 2, ghost.positionY + ghost.height / 2);

                if (this.row == ghost.row) {
                    if (tile == this.tile || tile + 1 == this.tile || tile - 1 == this.tile) {
                        ghost.health -= damage;
                    }
                } else {
                    if (tile - 9 == this.tile || tile + 9 == this.tile || tile + 8 == this.tile ||
                            tile - 8 == this.tile || tile + 10 == this.tile || tile - 10 == this.tile) {
                        ghost.health -= damage;
                    }
                }
            }
            isUsed = true;
        }

        if (health <= 0 || isUsed) {
            Game.weaponList.remove(this);
            Game.tileHasWeapon.remove(tile);
        }

        this.updateHealthBar(context,Constant.EYE);
        this.render(context);
    }
}