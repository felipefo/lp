

package example.hibernate.persistencia;

import example.hibernate.model.Escola;
import static example.hibernate.persistencia.GenericDAO.sessao;
import java.util.List;

/**
 *
 * @author felipe
 */
public class EscolaDAOImpl  extends GenericDAO<Escola> {

     public List<Escola> buscaEscolaPorNome(String name){        
        sessao = HibernateUtil.getSession();
        transacao = sessao.beginTransaction();                                                       
        List<Escola> lista = sessao.createQuery("from Escola where nome like '%"+ name + "%'").list();
        sessao.flush();
        transacao.commit();
        sessao.close();
        return lista;
    }
    
}
