package com.entity;

import java.io.Serializable;

public class Eleccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String fecha_inicio;
	private String fecha_fin;
	private int cargo;
	
	public Eleccion() {
	}
	
	public Eleccion(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
