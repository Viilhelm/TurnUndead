package otherElement;

import com.example.turnundead.Basic;
import javafx.scene.canvas.GraphicsContext;

/**
 * <p>
 *     <code>Other</code> is the parent of all other elements.
 * </p>
 */
public class Other extends Basic {
    public Other() {
    }

    public Other(String path) {
        this();
        setImage(path);
    }
    public  void update(long time, GraphicsContext context){
        this.render(context);
    }
}
