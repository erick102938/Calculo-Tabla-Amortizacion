package com.cmc.evaluacion.parteC_servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.cmc.evaluacion.parteC_entidades.Couta;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

public class CalculadoraAmortizacion {
	private static Logger logger = (Logger) LogManager.getLogger(CalculadoraAmortizacion.class);
	public static double calcularCuota(Prestamo prestamo){
		return (prestamo.getMonto()*prestamo.getInteres())/(1-Math.pow(1+prestamo.getInteres(),-1*prestamo.getPlazo()));
	}
	public static void generarTabla(Prestamo prestamo,String  tipoAmortizacion){
		if(tipoAmortizacion.equals("FR")){
			double valorCouta = calcularCuota(prestamo);
			prestamo.cuotas[0] = new Couta(1);
			prestamo.cuotas[0].setCuota(valorCouta);
			prestamo.cuotas[0].setCapitalInicio(prestamo.getMonto());
			prestamo.cuotas[0].setInteres(prestamo.getMonto()*prestamo.getInteres());
			prestamo.cuotas[0].setAbonoCapital(valorCouta-prestamo.cuotas[0].getInteres());
			prestamo.cuotas[0].setSaldo(prestamo.getMonto()-prestamo.cuotas[0].getAbonoCapital());
			for(int i=1;i<prestamo.cuotas.length;i++){
				prestamo.cuotas[i] = new Couta(i+1);
				prestamo.cuotas[i].setCuota(valorCouta);
				prestamo.cuotas[i].setCapitalInicio(prestamo.cuotas[i-1].getSaldo());
				prestamo.cuotas[i].setInteres(prestamo.cuotas[i].getCapitalInicio()*prestamo.getInteres());
				prestamo.cuotas[i].setAbonoCapital(valorCouta-prestamo.cuotas[i].getInteres());
				prestamo.cuotas[i].setSaldo(prestamo.cuotas[i].getCapitalInicio()-prestamo.cuotas[i].getAbonoCapital());
			}
		}
		if(tipoAmortizacion.equals("AL")){
			prestamo.cuotas[0] = new Couta(1);
			prestamo.cuotas[0].setCapitalInicio(prestamo.getMonto());
			prestamo.cuotas[0].setInteres(prestamo.getMonto()*prestamo.getInteres());
			prestamo.cuotas[0].setAbonoCapital(prestamo.getMonto()/prestamo.getPlazo());
			prestamo.cuotas[0].setCuota(prestamo.cuotas[0].getInteres()+prestamo.cuotas[0].getAbonoCapital());
			prestamo.cuotas[0].setSaldo(prestamo.cuotas[0].getCapitalInicio()-prestamo.cuotas[0].getAbonoCapital());
			for(int i=1;i<prestamo.cuotas.length;i++){
				prestamo.cuotas[i] = new Couta(i+1);
				prestamo.cuotas[i].setCapitalInicio(prestamo.cuotas[i-1].getSaldo());
				prestamo.cuotas[i].setInteres(prestamo.cuotas[i].getCapitalInicio()*prestamo.getInteres());
				prestamo.cuotas[i].setAbonoCapital(prestamo.getMonto()/prestamo.getPlazo());
				prestamo.cuotas[i].setCuota(prestamo.cuotas[i].getInteres()+prestamo.cuotas[i].getAbonoCapital());
				prestamo.cuotas[i].setSaldo(prestamo.cuotas[i].getCapitalInicio()-prestamo.cuotas[i].getAbonoCapital());
			}
		}
		

	}
	public static void mostrarTabla(Prestamo prestamo){
		Couta[] coutas = prestamo.getCuotas();
		for(int i=0;i<prestamo.cuotas.length;i++){
			System.out.print("\n"+coutas[i].toString());
		}
		System.out.print("\n");
		logger.info("valor del monto:" + prestamo.getMonto());
		logger.info("valor del interes:" + prestamo.getInteres());
		logger.info("numero de plazos:" + prestamo.getPlazo());
	}
}
