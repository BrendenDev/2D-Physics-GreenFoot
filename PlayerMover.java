import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PlayerMover extends Actor
{

    private Player john; 
    public void act()
    {
        if(!PlayerPhysics.freeMode) {
            normalMovement(); 
        }
        else {
            freeMovement();
        }
    }
    
    public void normalMovement() {
        john = (Player)getWorld().getObjects(Player.class).get(0);
        //jump if not at terminal velocity (logic makes more sense with context) 
        if(Greenfoot.isKeyDown("Space") && Player.jumping == false && Player.YVelocity >= -PlayerPhysics.terminalYVelocity) {
            jump();
        }
        //move right if not at terminal velocity
        if(Greenfoot.isKeyDown("D") && Player.XVelocity < PlayerPhysics.terminalXVelocity) {
            moveRight();
        }
        //move left if not at terminal velocity
        if(Greenfoot.isKeyDown("A") && Player.XVelocity > -PlayerPhysics.terminalXVelocity) {
            moveLeft(); 
        }
    }
    
    public void freeMovement() {
        john = (Player)getWorld().getObjects(Player.class).get(0);
        if(Greenfoot.isKeyDown("down") && Player.jumping == false && Player.YVelocity >= -PlayerPhysics.terminalYVelocity) {
            john.setLocation(john.getX(), john.getY()+1);
        }
        if(Greenfoot.isKeyDown("up") && Player.jumping == false && Player.YVelocity >= -PlayerPhysics.terminalYVelocity) {
            john.setLocation(john.getX(), john.getY()-1);
        }
        if(Greenfoot.isKeyDown("right") && Player.jumping == false && Player.YVelocity >= -PlayerPhysics.terminalYVelocity) {
            john.setLocation(john.getX()+1, john.getY());
        }
        if(Greenfoot.isKeyDown("left") && Player.jumping == false && Player.YVelocity >= -PlayerPhysics.terminalYVelocity) {
            john.setLocation(john.getX()-1, john.getY());
        }
    }
    
    public void jump() {
        Player.jumping = true;
        Player.YVelocity -= Player.jumpStrength;
    }
    
    public void moveLeft() {
        Player.XVelocity -= 0.5*Player.speed*Player.speed; 
    }
    
    public void moveRight() {
        Player.XVelocity += 0.5*Player.speed*Player.speed; 
    }
}
