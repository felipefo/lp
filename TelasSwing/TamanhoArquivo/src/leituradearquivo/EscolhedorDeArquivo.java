
package leituradearquivo;

import java.io.File;
import javax.swing.JFileChooser;

public class EscolhedorDeArquivo {
  public String  escolhe() {
      JFileChooser chooser = new JFileChooser();      
      int retorno = chooser.showOpenDialog(null);
      if (retorno == JFileChooser.APPROVE_OPTION) {  
          File file = chooser.getSelectedFile();                    
          return file.length() /1024 + "kb";
      }
      return null;
  }
}
