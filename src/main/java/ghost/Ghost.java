package ghost;

import com.example.turnundead.Basic;
import com.example.turnundead.Game;
import com.example.turnundead.Level;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * <p>
 *     <code>Ghost</code>is the parent of each specific ghost.
 * </p>
 */
public class Ghost extends Basic {

    public double damage;

    public double attackSpeed;

    public long recordedTime;

    public long elapsedTime;



    public Ghost() {
        elapsedTime = 0;
        recordedTime = System.currentTimeMillis();


        int r = (new Random().nextInt(5)) + 1;
        switch (r) {
            case 1 -> {
                setPosition(750, 80);
                row = 1;
            }
            case 2 -> {
                setPosition(750, 170);
                row = 2;
            }
            case 3 -> {
                setPosition(750, 270);
                row = 3;
            }
            case 4 -> {
                setPosition(750, 360);
                row = 4;
            }
            case 5 -> {
                setPosition(750, 450);
                row = 5;
            }
            default -> {
                setPosition(0, 0);
                row = 0;
            }
        }
    }


    @Override
    public void update(long time, GraphicsContext context) {
        this.render(context);
    }




    public static void generateGhost() {
        Game.gameElapsedtime = System.currentTimeMillis() - Game.gameRecordedTime;

        if (Game.currentGhost < Level.level.length && Game.gameElapsedtime >= Level.level[Game.currentGhost][0] * 1000L) {

            Game.ghostList.add(new NormalGhost());

            Game.currentGhost++;
        }
    }


}