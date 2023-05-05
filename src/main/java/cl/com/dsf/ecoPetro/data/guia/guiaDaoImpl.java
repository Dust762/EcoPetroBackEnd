package cl.com.dsf.ecoPetro.data.guia;

import cl.com.dsf.ecoPetro.modelo.Dia;
import cl.com.dsf.ecoPetro.modelo.Guia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import org.joda.time.DateTime;

@Stateless
public class guiaDaoImpl implements guiaDao {

    @PersistenceContext(unitName = "ecoPetroPU")
    EntityManager em;

    @Override
    public List<Guia> mostrarGuias() {
        return em.createNamedQuery("Guia.findAll").getResultList();
    }

    @Override
    public Guia encontrarGuiaPorNroGuia(Guia g) {
        return em.find(Guia.class, g.getNroGuia());
    }

    @Override
    public void agregarGuia(Guia g) {
        em.persist(g);
        em.flush();
    }

    @Override
    public void modificarGuia(Guia g) {
        em.merge(g);
    }

    @Override
    public void eliminarGuia(Guia g) {
        em.remove(em.merge(g));
    }

    @Override
    public List<Guia> listarGuiasPorFecha(String mes) {
        Date d1 = null, d2 = null;
        Calendar c = new GregorianCalendar();
        String year = String.valueOf(c.get(Calendar.YEAR));
        String strInicial = year + "/" + mes + "/1";
        String strFinal = year + "/" + mes + "/31";

        try {
            d1 = new SimpleDateFormat("yyyy/MM/dd").parse(strInicial);
            d2 = new SimpleDateFormat("yyyy/MM/dd").parse(strFinal);

        } catch (ParseException ex) {
            Logger.getLogger(guiaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return em.createNamedQuery("Guia.findByMonthSelected").setParameter("fechaInicial", d1, TemporalType.DATE)
                .setParameter("fechaFinal", d2, TemporalType.DATE).getResultList();
    }

    @Override
    public String totalConsumoMensual(String mes) {
        int totalConsumo = 0;
        List<Guia> temp = listarGuiasPorFecha(mes);
        for (int i = 0; i < temp.size(); i++) {
            totalConsumo += temp.get(i).getLtrConsumidos();
        }
        String resumen = "El consumo de combustubles del mes: " + mes + " fue:" + totalConsumo;

        return resumen;
    }

    @Override
    public List<Dia> listarConsumoSemana(String mes, String semana) {
        List<Guia> guias = listarGuiasPorFecha(mes);
        List<Guia> temp = new ArrayList<>();
        List<Dia> dias = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int semanaSel = Integer.parseInt(semana);
        c.setMinimalDaysInFirstWeek(1);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        for (int i = 0; i < guias.size(); i++) {
            c.setTime(guias.get(i).getFecha());
            System.out.println("Se recorre la lista de guias");
            if (c.get(Calendar.WEEK_OF_MONTH) == semanaSel) {
                temp.add(guias.get(i));
            }
        }
        int dia = 0;
        for (int i = 0; i < temp.size(); i++) {
            int totalDia = 0;
            c.setTime(temp.get(i).getFecha());
            dia =c.get(Calendar.DAY_OF_WEEK);
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(i).getFecha().equals(temp.get(j).getFecha())) {
                    totalDia = totalDia + temp.get(i).getLtrConsumidos();
                }
            }
            Dia dt = new Dia(tranformarDia(dia),totalDia);
            dias.add(dt);
        }
        Map<String, Dia> mapDias = new HashMap<String,Dia>(dias.size());
        for(Dia d : dias){
            mapDias.put(d.getNombreDia(), d);
        }
        dias.clear();
        for (Entry<String, Dia> d : mapDias.entrySet()) {
            dias.add(d.getValue());
        }
        return dias;
    }
    
    private String tranformarDia(int dia) {
        String nombreDia;
        switch (dia) {
            case 1:
                nombreDia = "Domingo";
                break;
            case 2:
                nombreDia = "Lunes";
                break;
            case 3:
                nombreDia = "Martes";
                break;
            case 4:
                nombreDia = "Miercoles";
                break;
            case 5:
                nombreDia = "Jueves";
                break;
            case 6:
                nombreDia = "Viernes";
                break;
            case 7:
                nombreDia = "Sabado";
                break;
            default:
                nombreDia = "NO se encontro";
        }
        return nombreDia;
    }

}
