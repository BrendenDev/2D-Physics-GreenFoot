import greenfoot.*;  

/**Player vs. john explanation
 * Player is referring to the class and its properties like velocity, jump strength, and etc
 * john is referring to the object itself. so any time I need to access/modify the physical object's location or visual aspects. also methods
 */

public class Player extends Actor
{

    public static double gravity; 
    public static double YVelocity; 
    public static double XVelocity;
    public static double speed; 
    public static boolean jumping; 
    public static double jumpStrength; 
    public static boolean touchingPlatform; 
    public Player() {
        gravity = 1;
        jumpStrength = 5;
        YVelocity = 0;
        XVelocity = 0;
        speed = 1; 
        jumping = false;
        touchingPlatform = false; 
    }
    
    public void act()
    {
    }
    
    //returns true if touching edge
    public boolean checkXBounds() {
        if(getX() >= getWorld().getWidth() - 15 || getX() <= 15) {
            return true;
        }
        return false;
    }
    
    //returns true if grounded
    public boolean checkGrounded() {
        if(getY() <= getWorld().getHeight() - 30) {
            return false;
        }
        return true;
    }
  
}
