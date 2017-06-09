

package example.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author felipe
 */

@Entity
@Table(name = "escola")

public class Escola {

    
    @Id
    @GeneratedValue(generator = "increment")    
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {        
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {        
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {        
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {        
        this.cnpj = cnpj;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {        
        this.id = id;
    }

           
}
