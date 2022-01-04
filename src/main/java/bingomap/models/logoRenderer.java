package bingomap.models;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class logoRenderer extends MapRenderer {

    private BufferedImage image;
    private boolean done;

    public logoRenderer() {
        done = false;
    }

    public logoRenderer(String url) {
        done = false;
    }

    public boolean load(String url) {
        BufferedImage image = null;
        try {

            image = joinImage.joinBufferedImage();
            image = MapPalette.resizeImage(image);
        } catch (IOException e) {
            return false;
        }
        this.image = image;
        return true;

    }

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        if(done) return;

        canvas.drawImage(0,0,image);

        view.setTrackingPosition(false);
        done = true;
    }
}
