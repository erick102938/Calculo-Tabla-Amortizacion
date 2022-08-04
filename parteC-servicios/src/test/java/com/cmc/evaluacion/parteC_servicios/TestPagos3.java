package com.cmc.evaluacion.parteC_servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.parteC_entidades.Cliente;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

import exceptions.DuplicatedException;
import exceptions.NotFoundException;

public class TestPagos3 {
	public static void main(String[] args) {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(50000,12, 18,"1"));

		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		for(Prestamo prest: prestamos){
			System.out.print(prest.toString());
		}
		try {
			b.pagar("0514616123", "1", 3049.0);
			System.out.print("\n\n\n\n");
			for(Prestamo prest: prestamos){
				System.out.print(prest.toString());
			}

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
