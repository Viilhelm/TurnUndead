package weapon;

import com.example.turnundead.Basic;
import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import ghost.Ghost;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import otherElement.Bullet;

/**
 * <p>
 *     <code>Hand</code> is a concrete implementation class.
 * </p>
 */
public class Hand extends Weapon {
    public final Image HAND_1 = createImage("/Pictures/hand.png");


    public Hand(int tileNumber) {
        super(tileNumber);
        Cost = Constant.HAND_COST;
        health = Constant.HAND_HEALTH;
        damage = Constant.HAND_DAMAGE;
        attackSpeed = Constant.HAND_ATTACK_SPEED;
        cooldownTime = Constant.HAND_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage(HAND_1);
        setVelocity(0, 0);
    }


    public Hand(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/Pictures/hand.png", width, height);
    }

    @Override
    public void update(long time, GraphicsContext context) {

        setImage(HAND_1);


        for (Ghost ghost : Game.ghostList) {
            if (ghost.row == row) {
                elapsedTime = System.currentTimeMillis() - recordedTime;

                if (elapsedTime >= attackSpeed * 1000) {
                    Bullet bullet = new Bullet(this);
                    this.bulletList.add(bullet);
                    recordedTime = System.currentTimeMillis();
                    break;
                }
            }
        }

        if (health <= 0) {
            Game.weaponList.remove(this);
            Game.tileHasWeapon.remove(tile);
        }

        this.updateHealthBar(context,Constant.HAND);
        this.render(context);

        for (Basic bullet : this.bulletList) {
            bullet.setPosition(bullet.positionX + bullet.velocityX * 1 / 60, bullet.positionY + bullet.velocityY * 1 / 60);

            for (Ghost ghost : Game.ghostList) {
                if (bullet.isOverlapped(ghost)) {
                    ghost.health -= damage;
                    this.bulletList.remove(bullet);
                    break;
                }
            }


            bullet.render(context);
        }


    }
}