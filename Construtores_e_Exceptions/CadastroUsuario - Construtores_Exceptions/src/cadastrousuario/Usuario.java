/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrousuario;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Usuario {
    String login;    
    String nomeCompleto;
    private String email;
    private ArrayList contatos = new ArrayList();
    private String senha;   
    
    public Usuario(){        
    }        
    public Usuario(String login, String nomeCompleto){   
        this.login = login;
        this.nomeCompleto = nomeCompleto;
    } 
    public  Usuario(String login, String nomeCompleto, String senha)throws Exception {   
        this.login = login;
        this.nomeCompleto = nomeCompleto;
        this.setSenha(senha);            
    }          
    
    public void setSenha(String senha) throws Exception {
        if (senha.length() <= 6 )
            throw new Exception("Senha menor que 6.");
        
        if (senha.length() >= 40 )
            throw new Exception("Senha muito grande");        
        
        this.senha = senha;        
    }
    
    public boolean setEmail(String email){
        if (!email.contains("@") )
            return false;        
        this.email = email;
        return true;
    }  
    
    public void addContato(Contato novoContato){
        this.contatos.add(novoContato);
    }    
    public ArrayList getContatos(){
        return this.contatos;
    }

    
   
    public String imprimeUsuario(){
        String dados ="Nome:" + nomeCompleto + "\n Login:" + login + 
                "\n senha:" + senha+ "\n email:" + email;
        return dados;
    }
    public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }

}
