package com.entity;

import java.io.Serializable;

public class Candidato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String documento;
	private String nombre;
	private String apellido;
	private int eleccion;
	private int numero;
	
	public Candidato() {
	}
	
	public Candidato(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEleccion() {
		return eleccion;
	}
	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
