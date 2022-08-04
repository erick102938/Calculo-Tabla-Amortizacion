package com.cmc.evaluacion.parteC_servicios;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.core.Logger;

import com.cmc.evaluacion.parteC_commons.TipoAmortizacion;
import com.cmc.evaluacion.parteC_entidades.Cliente;
import com.cmc.evaluacion.parteC_entidades.Prestamo;

import exceptions.DuplicatedException;
import exceptions.NotFoundException;

public class Banco {
	private HashMap<String, ArrayList<Prestamo>> prestamos = new HashMap<String, ArrayList<Prestamo>>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public HashMap<String, ArrayList<Prestamo>> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(HashMap<String, ArrayList<Prestamo>> prestamos) {
		this.prestamos = prestamos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente buscarCliente(String cedulaCliente){
		for(Cliente cliente: clientes){
			if(cliente.getCedula().equals(cedulaCliente)){
				return cliente;
			}
		}
		return null;
	}
	public void registrarCliente(Cliente nuevoCliente) throws DuplicatedException{
		if(buscarCliente(nuevoCliente.getCedula())==null){
			clientes.add(nuevoCliente);
		}else{
			throw new DuplicatedException("el cliente ya existe");
		}
	}
	
	public boolean validarCodigo(ArrayList<Prestamo> prestamosCliente,Prestamo prestamo){
		for(Prestamo prest: prestamosCliente){
			if(prest.getCodigo().equals(prestamo.getCodigo())){
				return true;
			}
		}
		return false;
	}
	public void asignarPrestamo(String cedulaCliente,Prestamo prestamo) throws NotFoundException{
		if(buscarCliente(cedulaCliente)!=null){
			if(prestamos.get(cedulaCliente)==null){
				ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();
				CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.FRANCESA);
				prestamosCliente.add(prestamo);
				prestamos.put(cedulaCliente,prestamosCliente);
				
			}else{
				ArrayList<Prestamo> prestamosCliente = prestamos.get(cedulaCliente);
				if(!validarCodigo(prestamosCliente,prestamo)){
					CalculadoraAmortizacion.generarTabla(prestamo,TipoAmortizacion.FRANCESA);
					prestamosCliente.add(prestamo);
					prestamos.put(cedulaCliente,prestamosCliente);
				}
			}
		}else{
			throw new NotFoundException("no es cliente del banco");
		}
	}
	public ArrayList<Prestamo> buscarPrestamos(String cedulaCliente){
		if(prestamos.get(cedulaCliente)!=null){
			return prestamos.get(cedulaCliente);
		}
		return null;
	}
	
	public void pagar(String cedulaCliente,String codigoPrestamo,double montoCancelar) throws NotFoundException{
		if(buscarCliente(cedulaCliente)!=null){
			if(prestamos.get(cedulaCliente)!=null){
				ArrayList<Prestamo> prestamosCliente = prestamos.get(cedulaCliente);
				AdminPagos.pagar(prestamosCliente,codigoPrestamo, montoCancelar);
			}else{
				throw new NotFoundException("No existen prestamos");
			}
		}
	}

}
