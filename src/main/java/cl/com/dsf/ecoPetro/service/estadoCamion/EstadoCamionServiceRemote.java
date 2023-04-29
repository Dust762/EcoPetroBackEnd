/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estadocamion;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EstadoCamionServiceRemote {
    public List<Estadocamion> mostrarEstadoCamiones();

    public Estadocamion encontrarEstadoPorId(Estadocamion ec);

    public void crearEstadoCamion(Estadocamion ec);

    public void modificarEstadoCamion(Estadocamion ec);

    public void eliminarEstadoCamion(Estadocamion ec);
}
