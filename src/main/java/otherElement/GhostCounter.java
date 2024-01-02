package otherElement;

import com.example.turnundead.Basic;
import com.example.turnundead.Game;
import com.example.turnundead.Level;
import ghost.NormalGhost;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * progress bars
 */
public class GhostCounter extends Other {
    private static int deadGhostCount=0;




    public static void updateCounter(GraphicsContext context) {

        double gameLen = Level.level[(Level.level.length-1)][0]*1000L;
        double progress = Game.gameElapsedtime;

        double progressPercentage = progress/gameLen*120;
        if(Level.level[(Level.level.length-1)][0]*1000L - Game.gameElapsedtime <=0){
            progressPercentage = 120;
        }
        context.strokeRoundRect(670,38,120,20,5,5);
        context.setFill(Color.RED);
        context.fillRoundRect(790-progressPercentage,38,progressPercentage,20 ,5,5);

        Basic CounterImage = new NormalGhost();
        CounterImage.setImage("/Pictures/normalGhost.png",40,40);
        CounterImage.setPosition(765-progressPercentage,32);
        CounterImage.render(context);
    }


    public static void setDeadGhostCount(int Died) {
        deadGhostCount = Died;
    }


    public static int getDeadGhostCount() {
        return deadGhostCount;
    }


}