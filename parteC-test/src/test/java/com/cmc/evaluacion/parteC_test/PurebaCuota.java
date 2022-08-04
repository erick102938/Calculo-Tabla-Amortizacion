package com.cmc.evaluacion.parteC_test;

import com.cmc.evaluacion.parteC_entidades.Prestamo;
import com.cmc.evaluacion.parteC_servicios.CalculadoraAmortizacion;

public class PurebaCuota {
	public static void main(String[] args) {
		double cuotaEsperada=242.43;
		
		Prestamo p=new Prestamo(5000,15,24,"1");
		double cuota=CalculadoraAmortizacion.calcularCuota(p);
		//redondear a 2 decimales
		cuota=Math.round(cuota*100.0)/100.0;
		
		System.out.println(cuota);
		
	}
}
