
package cadastrousuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class CadastroUsuario {

    public static void main(String[] args) {
       String opcao = JOptionPane.showInputDialog("Escolha a opção"
                + "\n(1)criar usuário"
                + "\n(2)listar usuário JOptionPane"
                + "\n(3)listar usuário Console\n");
             
        int opcaoEscolhida = Integer.parseInt(opcao);
        Listar listar = new Listar();
        if (opcaoEscolhida == 1){            
            String nomeCompleto = JOptionPane.showInputDialog("Nome completo:");
            String login = JOptionPane.showInputDialog("Login:");                
            Usuario usuario = new Usuario(login, nomeCompleto);
            pedeSenha(usuario);            
            
            boolean cadastraContato = true;
            while(cadastraContato){
                Contato contato = new Contato();
                contato.nomeCompleto = JOptionPane.showInputDialog("Nome completo:");
                contato.email = JOptionPane.showInputDialog("Email:");            
                usuario.addContato(contato);                                        
                String cadastarCotnato = JOptionPane.showInputDialog("Continuar Cadastrando contato (Sim) ou (não)");                
                if(cadastarCotnato.equalsIgnoreCase("sim")){                
                    cadastraContato = true;
                }else cadastraContato = false;                
            }
            
            ManipulaCSVUsuario.saveUsuario(usuario);
        }else if (opcaoEscolhida == 2){
            listar.listarJOptionPane();
        }else if (opcaoEscolhida == 3) {
            listar.listarConsole();
        }
        
    }
        
    public static void  pedeSenha(Usuario usuario) {
        try {
            usuario.setSenha(JOptionPane.showInputDialog("Senha:"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() );
            pedeSenha(usuario);
        }
    }
    
}
