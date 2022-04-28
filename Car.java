import greenfoot.*; 

public class Car extends Actor
{ 
    TheStreet street;
    GreenfootSound clingFX = new GreenfootSound("cling.wav");
    boolean crashed=false;
    public void act() 
    {   
        street = (TheStreet) getWorld();
        moveCar();
        checkCollision();
        changeCar();
    }    

    private void moveCar(){

        if((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) && getX()<280){
            setLocation(getX()+street.getSpeed(),getY()); 
        }else if((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) && getX()>120){
            setLocation(getX()-street.getSpeed(),getY());
        }
    }

    private void checkCollision()
    {
        crashWithBike();

        if(isTouching(Traffic.class)){
            crashedWithSpeedOver50();
            if(!crashed){
                if (street.isPowerUp()){
                    removeTouching(Traffic.class);
                    street.setPowerUp(false);
                }else{
                    street.gameOver("You lost all your PowerUps!!!");
                }    
            }

        }else if(isTouching(PowerUp.class)){
            removeTouching(PowerUp.class);
            street.countPowerUp();
            if(street.isPowerUp()){
                street.addScore(1);
                clingFX.play();
            }else{
                street.setPowerUp(true); 
                street.addScore(1);
                clingFX.play();
            }
        }else if(isTouching(ExtraPoints.class)){
            removeTouching(ExtraPoints.class); 
            street.addScore(3);
            clingFX.play();
        }
    }

    private void crashWithBike(){
        if(isTouching(BikeTraffic.class)){
            street.gameOver("Crash with a Motorbike");
            crashed = true;
        }
    }

    private void crashedWithSpeedOver50(){
        if (street.getSpeed() > 5){
            street.gameOver("Speed was over 50 KM/H"); 
            crashed = true;
        }

    }

    private void changeCar(){
        if(street.isPowerUp()){
            setImage("car01-n.png");   
        }else{
            setImage("car03-n.png");    
        }
    }
}