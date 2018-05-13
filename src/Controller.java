/**
 * Created by gerardoayala on 3/3/16.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface Controller extends ActionListener {
    public Object obtieneDatoDelModel(int indice);
    public Object obtieneDatoDelView(char tipo);
    public void actualizaElView();
    public void solicitaActualizacionDelModel(String accion);
    public void actionPerformed(ActionEvent evento);
}//end Controller
