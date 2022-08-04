package com.cmc.evaluacion.parteC_servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.parteC_entidades.Cliente;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

import exceptions.DuplicatedException;
import exceptions.NotFoundException;

public class TestBanco {
	public static void main(String[] args) {
		/*Prestamo prestamo = new Prestamo(5000, 12, 15);
		CalculadoraAmortizacion.generarTabla(prestamo);
		//CalculadoraAmortizacion.mostrarTabla(prestamo);
		ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();
		prestamosCliente.add(prestamo);
		CalculadoraAmortizacion.mostrarTabla(prestamosCliente.get(0));*/
		
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18,"1"));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24,"1"));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24,"1"));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		for(Prestamo prest: prestamos){
			System.out.print(prest.getCodigo());
		}
		//System.out.print(prestamos.get(0).getCuotas()[0].getCapitalInicio());
		
	}
}
