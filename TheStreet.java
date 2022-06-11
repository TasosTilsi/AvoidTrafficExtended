import greenfoot.*; 

public class TheStreet extends World
{
    private int speed = 10;
    private int score = 0;
    private int km=0;
    private int m=0;
    public GreenfootSound rumFX = new GreenfootSound("rum.wav");
    private GreenfootSound crashFX = new GreenfootSound("crash.wav");

    private boolean powerUp=false;
    public int countPowerUp=0;
    private int trafficChooser=0;

    public TheStreet()
    {    
        super(400, 600, 1);
        prepare();
        displayScore();
        displayKm();
        displayVelocity();
    }

    public void started(){
        rumFX.playLoop();   
    }

    public void stopped(){
        rumFX.stop();   
    }

    public void act()
    {
        keyPressed();
        addTraffic();
        displayVelocity();
        addPowerUp();
        phoneRing();
        checkEP();
        rumFX.playLoop();
    }

    private void prepare(){
        speed=1;
        addObject(new DemLines(),195, 40);
        addObject(new DemLines(),195, 140);
        addObject(new DemLines(),195, 240);
        addObject(new DemLines(),195, 340);
        addObject(new DemLines(),195, 440);
        addObject(new DemLines(),195, 540);
        addObject(new Trees(),330, 40);
        addObject(new Grass(),70, 40);
        addObject(new Trees(),330, 140);
        addObject(new Grass(),70, 140);
        //addObject(new Person(),70, 140);
        addObject(new Trees(),330, 240);
        addObject(new Grass(),70, 240);
        addObject(new Trees(),330, 340);
        addObject(new Grass(),70, 340);
        addObject(new Trees(),330, 440);
        addObject(new Grass(),70, 440);
        addObject(new Trees(),330, 540);
        addObject(new Grass(),70, 540);
        addObject(new Car(),250,550);
        addObject(new SeatBelt(),330,500);

    } 

    private void keyPressed(){

        if(TitleScreen.PLAY.contains("Free")){
            String keyPressed = Greenfoot.getKey();
            try{
                if ((keyPressed.equals("w") || keyPressed.equals("up")) && getSpeed()<10){
                    speed++;  
                }else if((keyPressed.equals("s") || keyPressed.equals("down")) && getSpeed()>1){
                    speed--;    
                }
                //System.out.println(keyPressed + " Speed = " + speed +" "+" "+((keyPressed == "w" || keyPressed == "up")));
            }catch(Exception e){
                //System.out.println(e);
            }
        }else{
            scoreBelowZero();
            updateSpeed();

        }
        // System.out.println("Speed = " + speed);
    }

    public int getSpeed(){
        return speed;
    }

    public void addTraffic()
    {
        if(Greenfoot.getRandomNumber((11-getSpeed())*100)==1){
            addObject(chooseTraffic(),Greenfoot.getRandomNumber(160)+120,0);
        }
    }

    private Traffic chooseTraffic(){
        Traffic traffic;
        switch (trafficChooser){
            case 1:
                traffic = new TruckTraffic();
                trafficChooser++;
                break;
            case 2: 
                traffic = new BikeTraffic();
                trafficChooser++;
                break;
            case 3: 
                traffic = new PoliceTraffic();
                trafficChooser=0;
                break;
            default:
                traffic = new CarTraffic();
                trafficChooser++;
                break;
        }
        return traffic;
    }

    private void displayScore(){
        showText("Score "+score, 55, 20);
    }

    public void addScore(int points){
        score=score+points;
        displayScore();
    }

    private void displayKm(){
        showText("Km "+km, 340, 20);
    }

    public void addMts(){
        m+=50;
        if(m==1000){
            m=0;
            km++;
            displayKm();
        }
    }

    private void displayVelocity(){
        int velocity=getSpeed()*10;
        showText("Velocity ",350, 100);
        showText(+velocity+" Km/h",350,130);
    }

    public void setPowerUp(boolean powerUp){
        this.powerUp=powerUp;
    }

    public boolean isPowerUp(){
        return powerUp;
    }

    private void addPowerUp(){
        if(Greenfoot.getRandomNumber(1000)==1){
            addObject(new PowerUp(),Greenfoot.getRandomNumber(160)+120,0);
        }
    }

    public void countPowerUp(){
        countPowerUp++;
    }

    private void checkEP(){
        if (countPowerUp==3){
            countPowerUp=0;
            addObject(new ExtraPoints(),Greenfoot.getRandomNumber(160)+120,0);
        }
    }

    public void gameOver(String message){
        removeObjects(getObjects(ScoreBoard.class));
        addObject(new ScoreBoard(message,score), getWidth()/2, getHeight()/2);
        crashFX.play();
        Greenfoot.stop();
    }

    public void scoreBelowZero(){
        if (score<0){
            gameOver("Your score is below zero!!!");
        }
    }

    public void updateSpeed(){

        if (score<=20){
            speed=1;
        }else if (score>20 && score<=50){
            speed=2;
        }else if(score>50 && score<=80){
            speed=3;
        }else if(score>80 && score<=120){
            speed=4;
        }else if(score>120 && score<=160){
            speed=5;
        }else if(score>160 && score<=200){
            speed=6;
        }else if(score>200 && score<=250){
            speed=7;
        }else if(score>250 && score<=300){
            speed=8;
        }else if(score>360 && score<=400){
            speed=9;
        }else{
            speed=10;
        }
    }

    private void phoneRing(){
        //System.out.println(Phone.getInstance().phoneStatus);
        if(Phone.getInstance().phoneStatus.equals("Closed")){
            if(Greenfoot.getRandomNumber(1000)==1){
                addObject(Phone.getInstance(),70,540);
                Phone.getInstance().phoneStatus="Ringing";
            }
        }

    }

    public int getMeters(){
        return m;
    }

    public int getKiloMeters(){
        return km;
    }
}