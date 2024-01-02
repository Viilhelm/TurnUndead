package ghost;

import com.example.turnundead.Basic;
import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import otherElement.GhostCounter;
import otherElement.Pochita;
import weapon.Eye;
import weapon.Weapon;



/**
 * <p>
 *     <code>NormalGhost</code> is a concrete implementation class.
 * </p>
 */
public class NormalGhost extends Ghost {

    public final Image GHOST_1 = createImage("/Pictures/normalGhost.png");



    public final Image GHOST_ATTACK_1 = createImage("/Pictures/normalGhostAttack.png");

    public NormalGhost() {
        super();
        health = Constant.NORMAL_GHOST_HEALTH;
        damage = Constant.NORMAL_GHOST_DAMAGE;
        attackSpeed = Constant.NORMAL_GHOST_ATTACK_SPEED;
        setImage(GHOST_1);
        setVelocity(Constant.NORMAL_GHOST_MOVEMENT_SPEED, 0);
    }

    /**
     * Determine if it has collided with other plants.
     */
    public boolean isOverlapped(Basic otherBasic) {
        double offset = 30;
        if (this.row == otherBasic.row) {
            return !(this.positionX + this.width < otherBasic.positionX || otherBasic.positionX + otherBasic.width < this.positionX + offset);
        }
        return false;
    }

    /**
     * <p>
     *     If<code>NormalGhost</code>hits a weapon, it stops moving and attacks the weapon until the health bar of weapon reaches zero or<code>NormalGhost</code>dies.
     * </p>
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int flag = 0;



        setVelocity(Constant.NORMAL_GHOST_MOVEMENT_SPEED, 0);
        attackSpeed = Constant.NORMAL_GHOST_ATTACK_SPEED;


        for(Pochita pochita : Game.pochitas){
            if(this.row == pochita.row && this.isOverlapped(pochita)){
                this.health = 0;
            }
        }

        for (Weapon weapon : Game.weaponList) {
            if (this.isOverlapped(weapon) && !(weapon instanceof Eye)) {
                elapsedTime = System.currentTimeMillis() - recordedTime;
                flag = 1;

                setImage(GHOST_ATTACK_1);
                if (elapsedTime >= attackSpeed * 1000) {
                    weapon.health -= damage;
                    recordedTime = System.currentTimeMillis();
                    break;
                }

            }
        }

        if (flag == 0) {

            setImage(GHOST_1);
            this.setPosition(positionX + velocityX * 1 / 60, positionY + velocityY * 1 / 60);
        }




        if (health <= 0) {

            GhostCounter.setDeadGhostCount(GhostCounter.getDeadGhostCount()+1);
            Game.ghostList.remove(this);

        }
        this.updateHealthBar(context,Constant.NORMAL_GHOST);
        this.render(context);
    }
}