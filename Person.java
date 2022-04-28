import greenfoot.*; 
public class Person extends Traffic
{    
    public Person(){
        setLocation(80,440);
        System.out.println(getSpeed());
        System.out.println(getMovement());
    }

    public void act() 
    {

        move(1);
        addForce(new Vector(270, 1));
        //addForce(new Vector(90,1));
        moveTraffic();

    }    

    public void moveTraffic(){
        TheStreet street = (TheStreet) getWorld();
        //setLocation(80,getY()+street.getSpeed());
        if(getY()>=599){
            getWorld().removeObject(this); 
            street.addScore(1);
        }else if(isTouching(Traffic.class)){
            getWorld().removeObject(this);   
        }

        if(getX()>=335){
            getWorld().removeObject(this);   
        }
    }
}
