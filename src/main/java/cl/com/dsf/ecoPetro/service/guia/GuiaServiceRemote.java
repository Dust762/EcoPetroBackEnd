package cl.com.dsf.ecoPetro.service.guia;

import cl.com.dsf.ecoPetro.modelo.Guia;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface GuiaServiceRemote {
    public List<Guia> mostrarGuias();
    
    public Guia encontrarGuiaPorNroGuia(Guia g);
    
    public void agregarGuia(Guia g);
    
    public void modificarGuia(Guia g);
    
    public void eliminarGuia(Guia g);
    
    public List<Guia> listarGuiasPorFecha(String mes);
}
