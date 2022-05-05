import greenfoot.*;  
/**End Goal: 
 * Make a framework for a simple platform game
 * 
 * Progress: 
 * 4/15/22 Made a player physics and mover class.
 * 4/21/22 Polishing physics and mover class.
 * 4/25/22 Fixed major bugs physics/mover class. Added platform collision detection
 * 4/29/22 Got platform collision working.
 * 5/03/22 Polished platform collision. Started console
 * 
 * Goals: 
 * - Add enemies
 * - Add console
 * - Add Obstacle/Platforms
 *     - Add feet and head collision box
 * - Add actions for player
 * - Add new stages 
 * - Create algorithm for new stages and memory
 * - Portals
 */

public class Sand extends World
{

    public Sand()
    {    
        super(1000, 700, 1); 
        //addObject(new Time(), 0, 0); 
        addObject(new Player(), 50, 550); 
        addObject(new PlayerPhysics(),0,0); 
        addObject(new PlayerMover(),0,0); 
        addObject(new PlayerFeetCollider(), 0,0); 
        addObject(new Stats(), 200, 300);     
        addObject(new Platform(), 300, 600);
        addObject(new Console(),0,0); 
    }
}
