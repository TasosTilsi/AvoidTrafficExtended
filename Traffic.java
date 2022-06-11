import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Traffic extends SmoothMover
{
    public void act() 
    {
        moveTraffic();     
    }

    public void moveTraffic(){
        TheStreet street = (TheStreet) getWorld();
        setLocation(getX(), getY()+street.getSpeed());
        if(getY()>=599)
        {
            getWorld().removeObject(this); 
            street.addScore(1);
            //System.out.println("Phone = "+ Phone.getInstance().phoneStatus+ " ="+Phone.getInstance().scoreAffected());
            street.addScore(Phone.getInstance().scoreAffected());
            //System.out.println("Belt = "+ SeatBelt.getSeatBeltStatus()+ " ="+SeatBelt.affectedScore);
            street.addScore(SeatBelt.affectedScore);
        }else if(isTouching(Traffic.class)){
            getWorld().removeObject(this);   
        }
    }
}
