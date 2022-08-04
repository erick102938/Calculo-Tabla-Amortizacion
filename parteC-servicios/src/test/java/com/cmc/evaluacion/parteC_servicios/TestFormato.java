package com.cmc.evaluacion.parteC_servicios;

import com.cmc.evaluacion.parteC_entidades.Couta;

public class TestFormato {
	public static void main(String[] args) {
		Couta couta = new Couta(1);
		couta.setCuota(444.24);
		couta.setInteres(50);
		couta.setCapitalInicio(5000);
		couta.setAbonoCapital(394.24134);
		couta.setSaldo(4605.76143);
		System.out.print(couta.toString());
	}
}
