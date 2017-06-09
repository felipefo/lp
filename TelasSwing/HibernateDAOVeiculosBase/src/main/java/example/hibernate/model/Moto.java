/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hibernate.model;


public class Moto  extends Veiculo{
    
    private int cilindras;   
   
    public Moto(String marca){
        this.setMarca(marca);
    }    
    public int getCilindras() {
        return cilindras;
    }

    public void setCilindras(int cilindras) {
        this.cilindras = cilindras;
    }
        
}
