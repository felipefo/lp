package game;

import java.awt.Rectangle;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author felipe
 * Classe reponsavel por fazer o controle entre os objetos do jogo.
 * 
 */
public class ControleColisao  extends Colisao{

    private Raquete raqueteDireita = null;
    private Raquete raqueteEsquerda = null;
    private Bola bola = null;
    private GameContainer controller;    
    
    public ControleColisao(GameContainer controller) {
        this.controller = controller;        
    }
    
    //Esta classe é responsavel por tratar a colisão entre a bola e a raquete
    //Nela você deve colocar a lógica para rebater a bola..
    
    @Override    
    public void update(Observavel ob) {
        //esse metodo seta as informacoes de requete direita e a bola;
        //não remover esse metodo
        iniciaInformacoesRaqueteEBola(ob);        
        if (this.raqueteDireita != null && this.bola != null) {
            Rectangle first = new Rectangle(raqueteDireita.getPosX(), raqueteDireita.getPosY(),
                    raqueteDireita.getImage().getWidth() - 20, raqueteDireita.getImage().getHeight() - 20);
            Rectangle second = new Rectangle(bola.getPosX(), bola.getPosY(),
                    bola.getImage().getWidth() - 20, bola.getImage().getHeight() - 20);
            if (first.intersects(second)) {
                
                bola.inverteMovimento();
            }
        }
    } 
    
    //substituir esse codigo no projeto de voces
    private void iniciaInformacoesRaqueteEBola(Observavel ob){        
        if (ob instanceof Raquete){ 
            
            if(!((Raquete)ob).ehRaqueteEsquerda)
                this.raqueteDireita = (Raquete) ob;
            else if(((Raquete)ob).ehRaqueteEsquerda)
                this.raqueteEsquerda = (Raquete) ob;
        }else if (ob instanceof Bola){ 
            this.bola = (Bola) ob;
        }
    }
}
