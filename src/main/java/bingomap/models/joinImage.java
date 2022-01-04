package bingomap.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class joinImage {

    //Plaats dit in je item manager shizzel dingens
    public static ArrayList<Material> items = new ArrayList<>();


    public static File filescheck = new File("plugins/bingo/items/check.png");

    public static BufferedImage check;

    public static BufferedImage joinBufferedImage() throws IOException {

        check = ImageIO.read(filescheck);

        int offset  = 5;

        int wid = 55;
        int height = 55;

        BufferedImage newImage = new BufferedImage(wid,height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();

        g2.setColor(Color.GRAY);

        //dit weghalen
        items.add(Material.DIAMOND_LEGGINGS);
        items.add(Material.FEATHER);

        ArrayList<BufferedImage> images = loadImages.images(items);

        int x = 0;
        int y = 0;

        for(int i = 0; i < images.size(); i ++) {
            g2.drawImage(images.get(i), null, x, y);
            x = x+images.get(i).getWidth();
        }

        //g2.drawImage(check, null, 3, 17);


        g2.dispose();

        return newImage;
    }
}
