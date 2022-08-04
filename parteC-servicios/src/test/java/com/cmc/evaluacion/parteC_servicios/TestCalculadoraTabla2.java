package com.cmc.evaluacion.parteC_servicios;

import com.cmc.evaluacion.parteC_commons.TipoAmortizacion;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

public class TestCalculadoraTabla2 {
	public static void main(String[] args) {
		Prestamo prestamo = new Prestamo(50000, 24, 12,"1");
		CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.ALEMANA);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
	}
}
