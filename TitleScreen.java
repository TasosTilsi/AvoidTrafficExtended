import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{

    private static final String TITLE = "Avoid Traffic Extended!!!";
    private static final String DESCRIPTION = "Have Fun with below keys.";
    private static final String BUTTON1_TEXT = "Free Roam Play";
    private static final String BUTTON2_TEXT = "Challenging Play";
    public static String PLAY = "";

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        prepare();
    }

    private void prepare()
    {
        Label.BG_COLOR = Color.YELLOW;
        Label titleLabel = new Label(TITLE,32);
        addObject(titleLabel, 200, 100);

        Label.BG_COLOR = new Color(0,0,0,0);
        Label descLabel = new Label(DESCRIPTION,25);
        addObject(descLabel, 200, 150);

        Label.BG_COLOR = Color.WHITE;
        Label w = new Label(" w ",26);
        Label s = new Label(" s ",26);
        Label a = new Label(" a ",26);
        Label d = new Label(" d ",26);
        addObject(w, 100, 185);
        addObject(s, 100, 215);
        addObject(a, 65, 215);
        addObject(d, 135, 215);

        Label.BG_COLOR = new Color(0,0,0,0);
        Label or = new Label("or",25);
        addObject(or, 200, 200);

        Label.BG_COLOR = Color.WHITE;
        w = new Label(" ↑ ",26);
        s = new Label(" ↓ ",26);
        a = new Label(" ← ",26);
        d = new Label(" → ",26);
        addObject(w, 300, 185);
        addObject(s, 300, 215);
        addObject(a, 265, 215);
        addObject(d, 335, 215);

        Label.BG_COLOR = Color.GREEN;
        Label playButton = new Label(BUTTON1_TEXT,32);
        addObject(playButton, 200, 400);

        Label.BG_COLOR = Color.ORANGE;
        playButton = new Label(BUTTON2_TEXT,32);
        addObject(playButton, 200, 450);
    }

    public void act(){
        click();
    }

    private void click()
    {
        try{
            if (Greenfoot.getMouseInfo().getActor()!=null){
                Label button = (Label) Greenfoot.getMouseInfo().getActor();
                //System.out.println(button.getDisplayedText());
                if (button.getDisplayedText().equalsIgnoreCase(BUTTON1_TEXT) && Greenfoot.mouseClicked(button)){
                    PLAY = BUTTON1_TEXT;
                    Greenfoot.setWorld(new TheStreet());
                }else if(button.getDisplayedText().equalsIgnoreCase(BUTTON2_TEXT) && Greenfoot.mouseClicked(button)){
                    PLAY = BUTTON2_TEXT;
                    Greenfoot.setWorld(new TheStreet()); 
                }
            }
        }catch(Exception e){
            //System.out.println(e);
        }
    }
}

