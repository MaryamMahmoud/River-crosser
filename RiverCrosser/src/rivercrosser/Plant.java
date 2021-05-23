package rivercrosser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Plant implements ICrosser {
    
    String str;
    BufferedImage [] image = new BufferedImage[2];

    public Plant() {
        try {
        image [0] = ImageIO.read(new File(url+"plant.png"));
        image [1] = ImageIO.read(new File(url+"plant.png"));
    } catch (IOException e) {
        }
    }

    @Override
    public boolean canSail() {
        return false;
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
        Plant p = new Plant();
        return p;
    }

    @Override
    public void setLabeltobeshown() {
        str = "Plant can't sail,can't eat but can be eaten by harbivorus";
    }

    @Override
    public String getLabelToBeShown() {
        return str;
    }

}
