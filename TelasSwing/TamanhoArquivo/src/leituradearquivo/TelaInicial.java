
package leituradearquivo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial { 

   private JFrame janela;
   private JPanel painelPrincipal;
   private JLabel fileLabel = new JLabel();

    
public static void main(String[] args) {
    TelaInicial tela = new TelaInicial();
    tela.montaTela(); 
} 

public void montaTela() {
    preparaJanela();
    preparaPainelPrincipal(); 
    preparaBotaoCarregar(); 
    preparaBotaoSair();
    preparaLabel();
    mostraJanela(); 
}
// main e montaTela 
private void preparaJanela() { 
    janela = new JFrame("TelaInicial");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
 // outros metodos prepara...
 private void mostraJanela() { 
     janela.pack(); 
     janela.setSize(540, 540);
     janela.setVisible(true); 
}
 
 private void preparaPainelPrincipal() { 
    painelPrincipal = new JPanel(); 
    janela.add(painelPrincipal); 
}
 
private void preparaBotaoSair() {
JButton botaoSair = new JButton("Sair"); 
botaoSair.addActionListener(new ActionListener() {     
   @Override public void actionPerformed(ActionEvent e) {
      System.exit(0); 
  } 
}); 
 painelPrincipal.add(botaoSair);
 }

private void preparaBotaoCarregar() 
{ 
    JButton botaoCarregar = new JButton("Escolher Arquivo"); 
    botaoCarregar.addActionListener(new ActionListener() { 
    @Override
    public void actionPerformed(ActionEvent ae) {
    EscolhedorDeArquivo escolher = new EscolhedorDeArquivo();
    fileLabel.setText("Este arquivo tem:" + escolher.escolhe());    
}
});
painelPrincipal.add(botaoCarregar); 
}
private void preparaLabel() {
    fileLabel = new JLabel("Nome arquivo");     
    painelPrincipal.add(fileLabel);
}

}



