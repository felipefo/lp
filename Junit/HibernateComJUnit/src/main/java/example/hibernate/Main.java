package example.hibernate;

import example.hibernate.model.Escola;
import example.hibernate.persistencia.GenericDAO;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {    		
    
        public static String DB_PATH="";
    
	public static void main(String[] args) throws Exception {                                    
            
            GenericDAO dao = new GenericDAO();
            dao.listar(Escola.class);                      
            
            TelaInicial1 tela = new TelaInicial1();
            tela.setVisible(true);
            
            
	}                
}
