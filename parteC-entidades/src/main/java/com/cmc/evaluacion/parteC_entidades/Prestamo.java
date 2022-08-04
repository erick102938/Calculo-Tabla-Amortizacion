package com.cmc.evaluacion.parteC_entidades;

import java.util.Arrays;

import com.cmc.evaluacion.parteC_commons.Utilitario;

public class Prestamo {
	private String codigo;
	private double monto;
	private double interes;
	private int plazo;
	public Couta[] cuotas;
	public Prestamo(double monto, double interes, int plazo,String codigo) {
		super();
		this.cuotas = new Couta[plazo];
		this.monto = monto;
		this.plazo = plazo;
		this.interes = interes/(12*100);
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	public Couta[] getCuotas() {
		for(int i=0;i<cuotas.length;i++){
			cuotas[i].setCuota(Utilitario.redondear(cuotas[i].getCuota()));
			cuotas[i].setCapitalInicio(Utilitario.redondear(cuotas[i].getCapitalInicio()));
			cuotas[i].setAbonoCapital(Utilitario.redondear(cuotas[i].getAbonoCapital()));
			cuotas[i].setInteres(Utilitario.redondear(cuotas[i].getInteres())); 
			cuotas[i].setSaldo(Utilitario.redondear(cuotas[i].getSaldo()));
		}
		return cuotas;
	}

	@Override
	public String toString() {
		return "Prestamo [cuotas=" + Arrays.toString(cuotas) + "]";
	}
	
}
