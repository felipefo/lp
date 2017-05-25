/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hibernate.persistencia;

import example.hibernate.model.Proprietario;
import example.hibernate.model.Veiculo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author felip
 */
public class ProprietarioPersistencia {
        protected static Session sessao;
    protected Transaction transacao;
   
    public void inserir( Proprietario obj ) throws Exception
    {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            sessao.save(obj);
            sessao.flush();
            transacao.commit();
            sessao.close();
    }
    
    public void alterar( Proprietario obj ) throws Exception
    {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            sessao.update(obj);
            sessao.flush();
            transacao.commit();
            sessao.close();
    }
    public void deletar( Proprietario obj ) throws Exception
    {
            sessao = HibernateUtil.getSession();
            transacao = sessao.beginTransaction();
            sessao.delete(obj);
            sessao.flush();
            transacao.commit();
            sessao.close();
    }
    public List<Proprietario> listar() throws Exception
    {
        sessao = HibernateUtil.getSession();
        transacao = sessao.beginTransaction();
        List objts;
        objts = null;
        Criteria selectAll = sessao.createCriteria(Proprietario.class);
        transacao.commit();
        objts = selectAll.list();
        sessao.close();
        return objts;
    }
     public Proprietario listar(Class clazz, String pk) throws Exception
    {
        sessao = HibernateUtil.getSession();
        transacao = sessao.beginTransaction();
        //Object objt = sessao.load(clazz, new Integer(Integer.parseInt(pk)) );
        Object ob =  sessao.load(clazz, new Integer(Integer.parseInt(pk)));
        transacao.commit();
        sessao.flush();
        sessao.close();
        return (Proprietario)ob;
    } 
     
    
}
