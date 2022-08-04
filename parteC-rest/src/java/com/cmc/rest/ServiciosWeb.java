package com.cmc.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cmc.evaluacion.parteC_commons.ParseData;
import com.cmc.evaluacion.parteC_entidades.Couta;
import com.cmc.evaluacion.parteC_entidades.Prestamo;
import com.cmc.evaluacion.parteC_servicios.CalculadoraAmortizacion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;



@Path("/servicios")
public class ServiciosWeb {
	
	
	@Path("/simulacion-prestamo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static javax.ws.rs.core.Response simularPrestamo(ParseData entradaDatos){
		Prestamo prestamo = new Prestamo(entradaDatos.getMonto(),entradaDatos.getInteresAnual(),entradaDatos.getPlazo());
		CalculadoraAmortizacion.generarTabla(prestamo,entradaDatos.getTipo());
		Couta[] coutas = prestamo.getCuotas();
		return javax.ws.rs.core.Response.status(200).entity(coutas).build();
	}
}
