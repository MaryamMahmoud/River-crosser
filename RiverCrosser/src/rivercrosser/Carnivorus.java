package rivercrosser;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Carnivorus implements ICrosser {
    
    String str;
    BufferedImage [] image = new BufferedImage[2];
    int x;

    public Carnivorus(int x) {
        switch (x){
            case 1: {try {
                            image [0] = ImageIO.read(new File(url+"fox.png"));
                            image [1] = ImageIO.read(new File(url+"fox.png"));
                        } catch (IOException e) {
                        }
                    }break;
            case 2: {try {
                            image [0] = ImageIO.read(new File(url+"lion.png"));
                            image [1] = ImageIO.read(new File(url+"lion.png"));
                        } catch (IOException e) {
                        }
                    }break;
    }
        this.x = x; 
    }

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 2;
    }

    @Override
	public BufferedImage[] getImages() {
		return image;
	}
    @Override
    public ICrosser makecopy() {
        Carnivorus c = new Carnivorus(x);
        return c;
    }

    @Override
    public void setLabeltobeshown() {
        str = "Carivorus can't sail,can't be eaten but eats harbivorus";

    }

    @Override
    public String getLabelToBeShown() {
        return str;
    }

    @Override
    public double getweight() {
        return 0;
    }

}
