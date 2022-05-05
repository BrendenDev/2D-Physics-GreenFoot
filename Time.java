import greenfoot.*;  

//deprecated class

public class Time extends Actor
{
    /**
     * Act - do whatever the Time wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static double deltaTime;
    private double initTime = System.currentTimeMillis(); 

    public void act()
    {
        //BROKEN NEED TO FIX
        deltaTime = (System.currentTimeMillis() - initTime) / 1000;
        //System.out.println(deltaTime%Math.floor(deltaTime)); 
    }
}
