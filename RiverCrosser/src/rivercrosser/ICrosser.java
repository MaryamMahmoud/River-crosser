package rivercrosser;

import java.awt.image.BufferedImage;


public interface ICrosser {
     
    String url = "C:\\Users\\LENOVO\\Desktop\\RiverCrosser-7\\RiverCrosser\\src\\rivercrosser\\";

    public boolean canSail();

    public int getEatingRank();

    public double getweight();

    public BufferedImage[]getImages();
    
    public ICrosser makecopy();

    public void setLabeltobeshown();

    public String getLabelToBeShown();

}
