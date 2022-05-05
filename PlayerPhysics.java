import greenfoot.*;
public class PlayerPhysics extends Actor
{

    private Player john;
    public static double terminalXVelocity;
    public static double terminalYVelocity;
    public static double friction;
    public static boolean freeMode;
    
    public PlayerPhysics() {
        freeMode = false; 
        friction = 0.03;
        terminalYVelocity = 8;
        terminalXVelocity = 5;
    }
    
    public void act()
    {
        john = (Player)getWorld().getObjects(Player.class).get(0);
        //for freemode
        if(!freeMode) {
            normalPhysics(); 
        }
        else {
            freeModePhysics();
        }
    }
    
    public void freeModePhysics() {
        Player.XVelocity = 0; 
        Player.YVelocity = 0; 
    }
    
    public void normalPhysics() {
        //apply gravity if john is not grounded
        if(!john.checkGrounded()) {
            //or touching platform
            if(Player.touchingPlatform) {
                touchingPlatform();
                Player.jumping = false;
            }
            else {
                if (Player.YVelocity <= terminalYVelocity) {
                    Player.YVelocity += 0.5*Player.gravity*Player.gravity; 
                }
                john.setLocation(john.getX() + (int)Player.XVelocity, john.getY()+ (int)Player.YVelocity);
            }
           
        }
        //on-ground logic 
        else if(Player.jumping) {
            Player.jumping = false; 
        }
        //sets velocity to 0 if touching sides and moving
        else if(john.checkXBounds() && Math.abs(Player.XVelocity) >= 1.5) {
            Player.XVelocity = 0;
        }
        //bounces you back onto page if too far off (on x axis)
        else if(john.checkXBounds()) {
            if(john.getX() < 15) {
                john.setLocation(15, john.getY());
            }
            if(john.getX() > getWorld().getWidth() - 15) {
                john.setLocation(getWorld().getWidth() - 15, john.getY());
            }
        }
        else{
            touchingGround(); 
        }
        john.setLocation(john.getX() + (int)Player.XVelocity, john.getY() + (int)Player.YVelocity);
    }
    
    public void touchingGround() {
        //Y velocity and position whenever touching ground
            Player.YVelocity = 0;
            john.setLocation(john.getX(), getWorld().getHeight() - 29);
            //making sure X velocity is not decreasing forever
            //logic is courtesy of Mr.Sarnowski
            if(Math.abs(Player.XVelocity) <= 0.4) {
            Player.XVelocity = 0; 
            }
            //friction 
            else if(Math.abs(Player.XVelocity) > 0){
            Player.XVelocity -= Player.XVelocity*friction;
        }
    }
        
    public void touchingPlatform() {
            //Y velocity and position whenever feetcollider touching platform
            PlayerFeetCollider feet = (PlayerFeetCollider)getWorld().getObjects(PlayerFeetCollider.class).get(0);
            Platform platform = feet.getTouchingPlatform(); 
            //making sure don't get null pointer exception and that john can jump while on platform
            if(platform!=null && !john.jumping) {
                Player.YVelocity = 0;
                john.setLocation(john.getX(), platform.getY() - 29);
                //making sure X velocity is not decreasing forever
                if(Math.abs(Player.XVelocity) <= 0.4) {
                Player.XVelocity = 0; 
                }
                //friction 
                else if(Math.abs(Player.XVelocity) > 0){
                Player.XVelocity -= Player.XVelocity*friction*platform.platformFrictionModifier;
            }
        }
    }
}
