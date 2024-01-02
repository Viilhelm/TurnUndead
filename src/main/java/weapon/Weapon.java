package weapon;

import com.example.turnundead.Basic;
import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *     <code>Weapon</code> is the parent of each specific weapon.
 * </p>
 */
public class Weapon extends Basic {

    public int tile;

    public double damage;

    public double attackSpeed;

    public double Cost;

    public double cooldownTime;
    /**
     * Weapon record time, with <code>elapsedTime</code>to achieve weapon attack judgment.
     */
    public long recordedTime;

    public long elapsedTime;

    public long createdTime;

    public boolean firstPurchaseNoCooldown;

    public CopyOnWriteArrayList<Basic> bulletList = new CopyOnWriteArrayList<>();


    public Weapon(int tileNumber) {
        elapsedTime = 0;
        recordedTime = System.currentTimeMillis();
        createdTime = System.currentTimeMillis();
        Game.tileHasWeapon.add(tileNumber);
        tile = tileNumber;
        setPosition(Constant.newWeaponPosition[tileNumber][0], Constant.newWeaponPosition[tileNumber][1]);

        switch (tileNumber) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> row = 1;
            case 10, 11, 12, 13, 14, 15, 16, 17, 18 -> row = 2;
            case 19, 20, 21, 22, 23, 24, 25, 26, 27 -> row = 3;
            case 28, 29, 30, 31, 32, 33, 34, 35, 36 -> row = 4;
            case 37, 38, 39, 40, 41, 42, 43, 44, 45 -> row = 5;
            default -> row = 0;
        }
    }


    @Override
    public void update(long time, GraphicsContext context) {
        this.render(context);
    }

    /**
     * <p>
     *     The purchase cooldown display is achieved by changing the length of the translucent black rectangle displayed.
     * </p>
     */
    public void updateChosen(GraphicsContext context) {
        elapsedTime = System.currentTimeMillis() - recordedTime;
        double cooldownPercentage = (elapsedTime / (cooldownTime * 10)) > 100 ? 100 : (elapsedTime / (cooldownTime * 10));

        context.setFill(new Color(0.0F, 0.0F, 0.0F, 0.4F));
        context.fillRect(Constant.newWeaponPosition[tile][0], Constant.newWeaponPosition[tile][1], 60, 68 - 68 * cooldownPercentage / 100);
    }
}