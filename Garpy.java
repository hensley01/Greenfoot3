import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garpy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garpy extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;

    public Garpy()
    {
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
    }

    /**
     * Act - do whatever the Garpy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
    }

    protected void movingAndTurning() 
    {
        if(Greenfoot.isKeyDown("left")) {
            if(getImage() == imageRight) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
            if(foundRock()) {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("right")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            move(5);
            if(foundRock()) {
                move(-5);
            }    
            if(Greenfoot.isKeyDown("up")) {
                if(getImage() == imageLeft) {
                    setImage(imageRight);
                }
                setRotation(-90);
                move(5);
                if(foundRock()) {
                    move(-5);
                }
            }
            if(Greenfoot.isKeyDown("down")) {
                if(getImage() == imageLeft) {
                    setImage(imageRight);
                }
                setRotation(90);
                move(5);
                if(foundRock()) {
                    move(-5);
                }
            }
        }
    }

    protected void collectingDiamonds() {
        Actor diamond;
        World world;
        diamond = getOneObjectAtOffset(0,0, Diamond.class);
        if(diamond != null) {//Wanneer Garp een diamant ziet
            world = getWorld();//in welke wereld zit Garp op het moment
            world.removeObject(diamond);//verwijder diamant van de wereld
        }
    }


    protected boolean foundRock() {
        Actor rock;
        rock = getOneObjectAtOffset(0,0,Rock.class);
        if(rock != null) {
            return true;
        }
        return false;
    }

    public void foundBomb() {
        Actor bomb;

        bomb = getOneObjectAtOffset(0,0,bomb.class);

        if(bomb != null) {
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}

