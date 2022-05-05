import greenfoot.*;

//if touching platform, make it like it's grounded

public class PlayerFeetCollider extends Actor
{
    
    private Player john; 
    
    public void act()
    {
        john = (Player)getWorld().getObjects(Player.class).get(0);
        setLocation(john.getX(), john.getY()+20);
        if(isTouching(Platform.class)){
            Player.touchingPlatform = true;
        }
        else {
            john.touchingPlatform = false;
        }
    }
    
    public Platform getTouchingPlatform() {
        Platform platform = (Platform)getOneIntersectingObject(Platform.class);
        return platform;
    }
}
