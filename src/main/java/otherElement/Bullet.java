package otherElement;

import weapon.Weapon;

/**
 * <p>
 *     <code>Bullet</code> is a concrete implementation class.
 * </p>
 */
public class Bullet extends Other {

    public Bullet(Weapon weapon) {
        row = weapon.row;
        setImage("/Pictures/bullet.png", 50, 50);
        setPosition(weapon.positionX + 55, weapon.positionY + 5);
        setVelocity(100, 0);
    }



}