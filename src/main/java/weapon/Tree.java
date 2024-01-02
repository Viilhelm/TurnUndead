package weapon;

import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * <p>
 *     <code>Tree</code> is a concrete implementation class.
 * </p>
 */
public class Tree extends Weapon {
    public final Image TREE_1 = createImage("/Pictures/tree.png");


    public final Image TREE_WOUNDED_1 = createImage("/Pictures/treeWounded.png");

    public Tree(int tileNumber) {
        super(tileNumber);
        Cost = Constant.TREE_COST;
        health = Constant.TREE_HEALTH;
        damage = Constant.TREE_DAMAGE;
        attackSpeed = Constant.TREE_ATTACK_SPEED;
        cooldownTime = Constant.TREE_COOLDOWN_TIME;
        firstPurchaseNoCooldown = false;
        setImage(TREE_1);
        setVelocity(0, 0);
    }


    public Tree(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/Pictures/tree.png", width, height);
    }

    /**
     * <p>
     *     <code>Tree</code>changes from as health decrease.
     * </p>
     */
    @Override
    public void update(long time, GraphicsContext context) {
        if (health <= Constant.TREE_HEALTH * 1 / 2) {

            setImage(TREE_WOUNDED_1);

        } else {

            setImage(TREE_1);
        }

        if (health <= 0) {
            Game.weaponList.remove(this);
            Game.tileHasWeapon.remove(tile);
        }

        this.updateHealthBar(context,Constant.TREE);
        this.render(context);
    }
}