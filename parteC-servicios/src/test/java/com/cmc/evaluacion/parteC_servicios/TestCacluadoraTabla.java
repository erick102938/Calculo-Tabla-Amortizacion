package com.cmc.evaluacion.parteC_servicios;

import com.cmc.evaluacion.parteC_commons.TipoAmortizacion;
import com.cmc.evaluacion.parteC_entidades.Couta;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

public class TestCacluadoraTabla {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prestamo prestamo = new Prestamo(5000, 12, 12,"1");
		CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.FRANCESA);
		CalculadoraAmortizacion.mostrarTabla(prestamo);

	}
}
