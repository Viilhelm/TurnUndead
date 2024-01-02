package otherElement;

import com.example.turnundead.Game;
import ghost.Ghost;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *     <code>Pochita</code>implements the game's pochita, the last line of defense in the game
 * </p>
 */
public class Pochita extends Other {
    private boolean go = false;
    private static final CopyOnWriteArrayList<Pochita> pochitas = new CopyOnWriteArrayList<>();

    public  final Image POCHITA = new Image(Objects.requireNonNull(Pochita.class.getResource("/Pictures/pochita.png")).toString(),80,60,false,false);


    private Pochita(double x, double y, int row){
        this.setImage(POCHITA);
        this.setPosition(x,y);
        this.row = row;
    }



    public void update(long time, GraphicsContext context) {
        for(Ghost ghost :Game.ghostList){
            if(this.row == ghost.row && this.isOverlapped(ghost)){
                go=true;
            }
        }
        if(go){
            this.positionX += 5;
        }
        if(this.positionX>=800){
            Game.pochitas.remove(this);
        }
        this.render(context);
    }

    public static CopyOnWriteArrayList<Pochita> initialize(){
        pochitas.clear();
        pochitas.add(new Pochita(-15,100,1));
        pochitas.add(new Pochita(-15,200,2));
        pochitas.add(new Pochita(-15,290,3));
        pochitas.add(new Pochita(-15,390,4));
        pochitas.add(new Pochita(-15,490,5));
        return pochitas;
    }
}