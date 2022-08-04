
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cmc.evaluacion.parteC_entidades.Prestamo;
import com.cmc.evaluacion.parteC_servicios.CalculadoraAmortizacion;



@Path("/servicios")
public class PersonaRest {
	
	@Path("/simulacion-prestamo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static javax.ws.rs.core.Response simularPrestamo(double monto,double interesAnual,int plazo,String tipo){
		Prestamo prestamo = new Prestamo(monto,interesAnual,plazo);
		CalculadoraAmortizacion.generarTabla(prestamo,tipo);
		ArrayList<Cuota> coutas = prestamo.getCuotas();
		return javax.ws.rs.core.Response.status(200).entity(coutas).build();
	}
}
