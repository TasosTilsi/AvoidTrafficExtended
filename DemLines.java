import greenfoot.*; 
public class DemLines extends Actor
{
    public void act() 
    {
        TheStreet street = (TheStreet) getWorld();
        setLocation(getX(), getY()+street.getSpeed());
        if(getY()>=599)
        {
            setLocation(195, 0);  
            street.addMts();
        }      
    }    
}
