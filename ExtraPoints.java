import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ExtraPoints extends Actor
{
    public void act() 
    {

        moveTraffic();     
    }

    private void moveTraffic(){
        TheStreet street = (TheStreet) getWorld();
        setLocation(getX(), getY()+street.getSpeed());
        if(getY()>=599)
        {
            getWorld().removeObject(this); 
        }else if(isTouching(ExtraPoints.class)){
            getWorld().removeObject(this);   
        }
    }
}
