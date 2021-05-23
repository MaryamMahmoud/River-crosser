package rivercrosser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static rivercrosser.ICrosser.url;

public class Children implements ICrosser {

    String str;
    BufferedImage[] image = new BufferedImage[2];
    int weight;

    public Children(int weight) {
        try {
            image[0] = ImageIO.read(new File(url + "kid.png"));
            image[1] = ImageIO.read(new File(url + "kid.png"));
        } catch (IOException e) {
        }
        this.weight = weight;
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public int getEatingRank() {
        return 0;
    }

    @Override
    public double getweight() {
        return 0;
    }

    @Override
    public BufferedImage[] getImages() {
        return image;
    }

    @Override
    public ICrosser makecopy() {
        Children c = new Children(weight);
        return c;
    }

    @Override
    public void setLabeltobeshown() {
        str = "children can row";
    }

    @Override
    public String getLabelToBeShown() {
        return str;
    }

}
