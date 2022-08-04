package com.cmc.evaluacion.parteC_entidades;

import com.cmc.evaluacion.parteC_commons.Utilitario;

public class Couta {
	private int numero;
	private double cuota;
	private double capitalInicio;
	private double interes;
	private double abonoCapital;
	private double saldo;
	private boolean pagado;
	private double pendiente;
	
	
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public double getPendiente() {
		return pendiente;
	}
	public void setPendiente(double pendiente) {
		this.pendiente = pendiente;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
		this.pendiente = cuota;
	}
	public double getCapitalInicio() {
		return capitalInicio;
	}
	public void setCapitalInicio(double capitalInicio) {
		this.capitalInicio = capitalInicio;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getAbonoCapital() {
		return abonoCapital;
	}
	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Couta(int numero) {
		super();
		this.pagado = false;
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "\n| " + Utilitario.redondear(numero) + " | " + Utilitario.redondear(cuota)  + " | " + Utilitario.redondear(capitalInicio)  + " | "+ Utilitario.redondear(interes)  +" | "+ Utilitario.redondear(abonoCapital)  + " | " + Utilitario.redondear(saldo) +" | " + pagado + " | " + Utilitario.redondear(pendiente);
	}
	
}
