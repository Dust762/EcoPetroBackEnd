/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EstadoCamionServiceRemote {
    public List<EstadoCamion> mostrarEstadoCamiones();

    public EstadoCamion encontrarEstadoPorId(EstadoCamion ec);

    public void crearEstadoCamion(EstadoCamion ec);

    public void modificarEstadoCamion(EstadoCamion ec);

    public void eliminarEstadoCamion(EstadoCamion ec);
}
