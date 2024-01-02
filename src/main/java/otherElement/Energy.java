package otherElement;

import com.example.turnundead.Constant;
import com.example.turnundead.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

/**
 * <p>
 *     <code>Energy</code> is a concrete implementation class.
 * </p>
 */
public class Energy extends Other {

    public long elapsedTime;

    public long recordedTime = 3021051038495L;

    public boolean timeIsRecorded = false;


    public Energy() {
        int r = new Random().nextInt(770);
        setImage("/Pictures/energy.png", 60, 60);
        setVelocity(0, Constant.DROP_SPEED);
        setPosition(r, 0);
    }




    @Override
    public void update(long time, GraphicsContext context) {
        elapsedTime = System.currentTimeMillis() - recordedTime;
        if (elapsedTime > 3000) {
            Game.energyList.remove(this);
        }

        if (positionY < 540) {
            setPosition(positionX + velocityX * 1 / 60, positionY + velocityY * 1 / 60);
        } else if (!timeIsRecorded) {
            recordedTime = System.currentTimeMillis();
            timeIsRecorded = true;
        }
        this.render(context);
    }


    public static void generateEnergy() {
        Game.GenerationElapsedTime = System.currentTimeMillis() - Game.GenerationRecordedTime;
        if (Game.GenerationElapsedTime >= 3000) {
            Game.energyList.add(new Energy());
            Game.GenerationRecordedTime = System.currentTimeMillis();
        }
    }


    public static void updateCurrentEnergy(GraphicsContext context) {
        String e = String.valueOf(Game.energy);
        context.setFont(new Font(20));
        context.setFill(Color.LIGHTGOLDENRODYELLOW);
        context.fillRect(21, 60, 56, 21);
        context.setFill(Color.BLACK);
        context.fillText(e, 33, 78, 37);
    }

}