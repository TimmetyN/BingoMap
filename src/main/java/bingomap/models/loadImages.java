package bingomap.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class loadImages {

    public static ArrayList<BufferedImage> images(ArrayList<Material> items) throws IOException {
        ArrayList<BufferedImage> allImages = new ArrayList<BufferedImage>();

        for(int i = 0; i < items.size(); i++) {

            File imgfile = new File("plugins/bingo/items/"+items.get(i).toString().toLowerCase()+".png");
            BufferedImage img = ImageIO.read(imgfile);

            allImages.add(img);
        }

        return allImages;
    }
}
