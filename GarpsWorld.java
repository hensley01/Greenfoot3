import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GarpsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpsWorld extends World
{
    private GreenfootSound sound;

    /**
     * Constructor for objects of class GarpsWorld.
     * 
     */
    public GarpsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400,1);
        populateTheWorld();
        sound = new GreenfootSound("musicmix.mp3");
    }
    
    protected void populateTheWorld() { 
        int teller;
        addObject(new Garpy(), getWidth() / 2, getHeight() / 2);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        for(teller = 0; teller < 10; teller ++) {
            addObject(new Diamond(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller = 0; teller < 5; teller ++); {
            addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller = 0; teller < 5; teller ++); {
            addObject(new bomb(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        setPaintOrder(Garpy.class, Gnomus.class, Diamond.class, Rock.class, bomb.class);
    }
    
        
    public void started() {
        sound.playLoop();
    }
    
    public void stopped() {
        sound.stop();
    }
}
