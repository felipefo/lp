
Especificação do Trabalho de Linguagem de Programação

# Datas

### Primeira entrega(Parcial)

20/04/2017

| RF001 | O sistema deve permitir ao usuário fazer movimentos verticais |



### Entrega(Final)
18/05/2017

| RF003 | O sistema deve terminar o jogo e informar o vencedor caso a bola atinja o final da tela de um dos jogadoreso | 
| RF007 | O sistema deve permitir que os usuários joguem | 
| RF008 | O sistema deve mudar a trajetória da bola de acordo com a posição que o usuário acerta a bola | 
| RF002 | O sistema deve permitir ao usuário reiniciar o jogo a qualquer momento |
| RF004 | O sistema deve permitir que o usuário escolha jogar em dupla ou sozinho |
| RF005 | O sistema deve permitir exibir um plano de fundo | 
| RF006 | O sistema deve permitir exibir uma mensagem de quem ganhou ao final da partida | 


# Descrição do Mini-Mundo

O objetivo desse trabalho é criar um jogo em que se possa jogar em dupla. 
Cada jogador vai poder controlar uma barrinha que vai servir para rebater uma bola. 
O jogo acaba quando um jogodar errar a bora e ela atingir o final do lado da tela do jogador. 


# Requisitos do Sistema

| ID | Descrição |  
| --- | --- | 
| RF001 | O sistema deve permitir ao usuário fazer movimentos verticais |
| RF002 | O sistema deve permitir ao usuário reiniciar o jogo a qualquer momento |
| RF003 | O sistema deve terminar o jogo e informar o vencedor caso a bola atinja o final da tela de um dos jogadoreso | 
| RF004 | O sistema deve permitir que o usuário escolha jogar em dupla ou sozinho |
| RF005 | O sistema deve permitir exibir um plano de fundo | 
| RF006 | O sistema deve permitir exibir uma mensagem de quem ganhou ao final da partida | 
| RF007 | O sistema deve permitir que os usuários joguem | 
| RF008 | O sistema deve mudar a trajetória da bola de acordo com a posição que o usuário acerta a bola | 



# Regras 

O trabalho deve ser feito em dupla ou trio. <br>
Não serão aceitos trabalhos com mais de uma semana de atraso. <br>
A cada dia de atraso será descontado um ponto do trabalho. <br>
O trabalho deve ser enviado utilizando o github.com. O link do github do projeto deve ser enviado para o moodle.<br>
O sistema deve ser feito utilizando a linguagem java<br>
Você pode utilizar a biblioteca slick2d ou alguma outra biblioteca de jogo de java<br>
Você pode utilizar como base o projeto visto em sala de aula https://github.com/felipefo/lp/tree/master/GameChuvendoMonstros<br>
Você pode utilizar como base o projeto visto em sala de aulahttps://github.com/felipefo/lp/tree/master/GameTrabalhoLP
O trabalho vale 30 pontos.


# Critérios de Avaliação 

| Funcionalidade | % Nota| 
| --- | --- |
| RF001 | 10% |
| RF002 | 10%  |
| RF003 | 5%  | 
| RF004 | 20%  |
| RF005 | 5%  |
| RF006 | 10%  | 
| RF007 | 20%  | 
| RF008 | 10%  | 
| Apresentação para o professor | 10%  | 


# Tela de exemplo do jogo

![alt text](https://github.com/felipefo/lp/blob/master/Trabalho1/imagem_jogo.png)



'''''
//codigo modificado classe Raquete 


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

//codigo modificado classe Raquete 		
	
	


''''


''''
//ControleColisao

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


''''





