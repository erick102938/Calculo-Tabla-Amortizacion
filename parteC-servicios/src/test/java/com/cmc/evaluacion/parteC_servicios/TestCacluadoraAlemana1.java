package com.cmc.evaluacion.parteC_servicios;

import com.cmc.evaluacion.parteC_entidades.Couta;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

public class TestCacluadoraAlemana1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prestamo prestamo = new Prestamo(5000, 12, 12,"1");
		CalculadoraAmortizacion.generarTabla(prestamo,"AL");
		CalculadoraAmortizacion.mostrarTabla(prestamo);

	}
}
