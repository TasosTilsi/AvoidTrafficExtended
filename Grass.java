import greenfoot.*; 
public class Grass extends Actor
{
    boolean flag=true;
    public void act() 
    {
        TheStreet street = (TheStreet) getWorld();
        setLocation(getX(), getY()+street.getSpeed());
        if(getY()>=599)
        {
            if(flag){
                setLocation(330, 0);
                flag=false;
            }else{
                setLocation(70, 0);
                flag=true;
            }
            street.addMts();
        }

    }    
}
