
package junit;

import junit.modelo.Usuario;
import junit.visao.TelaUsuario;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("Felipe");
        TelaUsuario telaUsuario = new TelaUsuario();
        telaUsuario.setVisible(true);
    }
    
}
