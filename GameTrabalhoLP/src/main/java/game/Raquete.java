
package game;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author felipe
 */
public class Raquete extends Observavel  {
   
    Image image;
    int posX;
    int posY;
    boolean ehRaqueteEsquerda;
    
    public Raquete(String pathImage, int posX, int posY, boolean ehEsquerda){        
        this.posX = posX;
        this.posY = posY;
        this.ehRaqueteEsquerda=ehEsquerda;    
        try {
            image = new Image(pathImage);
        } catch (SlickException ex) {
            Logger.getLogger(Raquete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Image getImage(){        
        return this.image;
    }
    public void render(){
        image.draw(this.posX, this.posY);
    }
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        if(ehRaqueteEsquerda )
        {
            if(posX > 0 && posX < 320)        
               this.posX = posX;
        }else
        {
            if(posX >= 320 && posX <= 640)
            this.posX = posX;
        }
    }
    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        
            this.posY = posY;    
        
        
    }
    
    
}
