
package com.example.hibernate;

import example.hibernate.model.Escola;
import example.hibernate.persistencia.EscolaDAOImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;


public class EscolaDAOTest extends TestCase {
    
    EscolaDAOImpl escolaDAO;
    
    public EscolaDAOTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        System.out.println("Setup! Inicio");
        escolaDAO = new EscolaDAOImpl();
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        System.out.println("tearDown! Fim");
        super.tearDown();
    }

    public Escola inserirEscola() {        
    
        Escola escola = new Escola();        
        escola.setCnpj("0001");
        escola.setNome("Escola ABC");        
        try {
            escolaDAO.inserir(escola);
        } catch (Exception ex) {
            Logger.getLogger(EscolaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return escola;
    }
    
    
    public void removerEscola(Escola escola) {        
              
        try {
            escolaDAO.deletar(escola);
        } catch (Exception ex) {
            Logger.getLogger(EscolaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    /**
     * Teste de insercao da classe escola no banco de dados. 
     */
    public void testInserirEscolaBuscaPorNome() {        
        System.out.println("buscaUsuarioPorNome");        
        Escola escolaInserido = inserirEscola(); //inserindo uma escola no banco de dados      
        String name = escolaInserido.getNome();//pegando o nome da escola
        List<Escola> result = escolaDAO.buscaEscolaPorNome(name);//fazendo uma busca no banco para saber se a escola foi realmente inserida
        assertEquals("Escola ABC", result.get(0).getNome());//verificnado se o nome da escola foi salvo corretamente        
        assertEquals("0001", result.get(0).getCnpj());//verificando se o cnpj da escola foi salvo corretamente
        removerEscola(escolaInserido);//removendo do banco para poder salvar novamente. 
    }
    
    
}
