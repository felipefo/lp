package game;

/**
 *
 * @author felipe
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import java.io.*;

public class SimpleSlickGame extends BasicGame {
    private int timeCount = 0;    
    private Image land;
    private Bola bola;
    private Image gameover;
    private Image ganhouJogo;

    boolean ganhou=false;
    int time;
  
    Raquete raqueteDireita;
    Raquete raqueteEsquerda;

    public SimpleSlickGame(String gamename) {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        
        try {
            File file = new File(".");
            String filePath = file.getCanonicalPath();
            land = new Image(filePath + "\\src\\main\\java\\quadra.jpg");
            raqueteDireita = new Raquete(filePath + "\\src\\main\\java\\raquete.png", 540, 240);
            raqueteEsquerda = new Raquete(filePath + "\\src\\main\\java\\raquete.png", 10, 240);
            //Voce precisa adicionar a raquete da esquerda também!!
            
            bola = new Bola(filePath + "\\src\\main\\java\\bola.png", 500, -100);
            gameover = new Image(filePath + "\\src\\main\\java\\gameover.png");
            ganhouJogo = new Image(filePath + "\\src\\main\\java\\ganhou.png");

            
            raqueteDireita.addMonitores(bola);
            raqueteEsquerda.addMonitores(bola);
            ControleColisao controleColisao = new ControleColisao(gc);
            raqueteDireita.addMonitores(controleColisao);            
            raqueteEsquerda.addMonitores(controleColisao);
            bola.addMonitores(controleColisao);
            
        } catch (IOException ex) {
            Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(land, 0, 0);
        g.drawString("Time : " + time/1000, 530, 20);
        raqueteDireita.render();
        raqueteEsquerda.render();
        bola.render(); 
       
        //limita o tempo do jogo em 100 segundos...
        if(time/1000 >= 100){
            gc.pause();
            ganhouJogo.draw(200,200);
        }
        
        if(gc.isPaused())
            gameover.draw(200,200);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
            appgc.setDisplayMode(640, 480, false);            
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {        
        if(!gc.isPaused()){
         time += i;
        
         //aqui você precisar fazer a raquete da esquerda se movimentar também 
         //para isso utilize, por exemplo, a letra "a" para esquerda, "d" para direita
         //"w" para ir para cima e "s" para ir para baixo.
         
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_A)){
            this.raqueteEsquerda.setPosX(this.raqueteEsquerda.getPosX() - 2);        
        }    
        
        
        
        if (input.isKeyDown(Input.KEY_UP))
            this.raqueteDireita.setPosY(this.raqueteDireita.getPosY() - 2);        
        if (input.isKeyDown(Input.KEY_DOWN)) 
            this.raqueteDireita.setPosY(this.raqueteDireita.getPosY() + 2);        
        if (input.isKeyDown(Input.KEY_LEFT)) 
            this.raqueteDireita.setPosX(this.raqueteDireita.getPosX() - 2);        
        if (input.isKeyDown(Input.KEY_RIGHT))
            this.raqueteDireita.setPosX(this.raqueteDireita.getPosX() + 2);        
        timeCount++;
        if (timeCount == 40){ 
            raqueteDireita.noificarTodos();                    
            raqueteEsquerda.noificarTodos();                    
            bola.noificarTodos();
            timeCount=0;
            }
        }
        
    }
}
