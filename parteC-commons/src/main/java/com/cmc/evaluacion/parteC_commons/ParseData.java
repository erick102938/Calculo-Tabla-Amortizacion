package com.cmc.evaluacion.parteC_commons;

public class ParseData {
	private double monto;
	private double interesAnual;
	private int plazo;
	private String tipo;
	public ParseData() {
		// TODO Auto-generated constructor stub
	}
	public ParseData(double monto, double interesAnual, int plazo, String tipo) {
		super();
		this.monto = monto;
		this.interesAnual = interesAnual;
		this.plazo = plazo;
		this.tipo = tipo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getInteresAnual() {
		return interesAnual;
	}
	public void setInteresAnual(double interesAnual) {
		this.interesAnual = interesAnual;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
