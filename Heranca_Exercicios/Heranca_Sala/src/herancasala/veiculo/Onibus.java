
package herancasala.veiculo;


public class Onibus extends Veiculo{
    boolean articulado;
    boolean elevadorAcessibilidade;

    public boolean isArticulado() {
        return articulado;
    }

    public void setArticulado(boolean articulado) {
        this.articulado = articulado;
    }

    public boolean isElevadorAcessibilidade() {
        return elevadorAcessibilidade;
    }

    public void setElevadorAcessibilidade(boolean elevadorAcessibilidade) {
        this.elevadorAcessibilidade = elevadorAcessibilidade;
    }
}
