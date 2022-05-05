import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner; 

/**
 * Write a description of class Console here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Console extends Actor
{
    /**
     * Act - do whatever the Console wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean activated;
    
    public Console() {
        activated = false;    
    }
    
    public void act()
    {
        //String input = Greenfoot.ask("Please input a value");
        if(Greenfoot.isKeyDown("Enter")) {
            activated = true;
        }
        if(Greenfoot.isKeyDown(",")) {
            activated = false;
        }
        if(activated) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n" + "Enter Command: "); 
            String yes = scan.next();
            switch(yes) {
                case "help": 
                    System.out.println("free: static physics" + "\n" + 
                    "normal: normal physics" + "\n" + 
                    "end: end prompt" + "\n" + 
                    "stats: turn on stats" + "\n" +
                    "git: link to repository"); 
                    break;
                case "git":
                    System.out.println("https://github.com/BrendenDev/GitTest3");
                    break;
                case "stats":
                    Stats.on = !Stats.on; 
                    if(Stats.on) {
                        System.out.println("stats displayed");
                    }
                    else {
                        System.out.println("stats hidden");
                    }
                case "end": 
                    activated = false;
                    break;
                case "free": 
                    PlayerPhysics.freeMode = true; 
                    System.out.println("free mode on, move with arrow keys"); 
                    break;
                case "normal": 
                    PlayerPhysics.freeMode = false;
                    System.out.println("normal physics on, move with wasd");
                    break;
                default: System.out.println("Invalid"); 
                    activated = false;
                    break;
            }
            activated = false; 
            System.out.println("\n" + "Ended Prompt");
            
        }
    }
}
