package com.tikal.toledo.reporte;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.tikal.toledo.model.Producto;
import com.tikal.toledo.model.Tornillo;

public class ReporteRenglon {
	private Long id;
	private String nombre;
	private String medidas;
	private String clave;
	private float cantidad;
	private float precioMostrador;
	private float precioMayoreo;
	private float precioCredito;
	private String marca;
	private String proveedor;
	private String ultimoProveedor;
	
	public float getPrecioMostrador() {
		return precioMostrador;
	}

	public void setPrecioMostrador(float precioMostrador) {
		this.precioMostrador = precioMostrador;
	}

	public float getPrecioMayoreo() {
		return precioMayoreo;
	}

	public void setPrecioMayoreo(float precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}

	public float getPrecioCredito() {
		return precioCredito;
	}

	public void setPrecioCredito(float precioCredito) {
		this.precioCredito = precioCredito;
	}

	
	public String getUltimoProveedor() {
		return ultimoProveedor;
	}

	public void setUltimoProveedor(String ultimoProveedor) {
		this.ultimoProveedor = ultimoProveedor;
	}

	public ReporteRenglon(Producto p){
	//	this.id=p.getId();
		this.nombre=p.getNombre();
		this.medidas="";
		this.clave=p.getClave();
		this.cantidad=p.getExistencia();
		this.precioMostrador=p.getPrecioMostrador();
		this.precioCredito= p.getPrecioCredito();
		this.precioMayoreo= p.getPrecioMayoreo();
		this.marca=p.getMarca();
		this.proveedor=p.getProveedor();
		this.ultimoProveedor=p.getUltimoProveedor();
	}
	
	public ReporteRenglon(Tornillo p){
		this.id=p.getId();
		this.nombre=p.getNombre();
		this.medidas=p.getMedidas();
		this.clave=p.getClave();
		this.cantidad=p.getExistencia();
		this.precioMostrador=p.getPrecioMostrador();
		this.precioCredito= p.getPrecioCredito();
		this.precioMayoreo= p.getPrecioMayoreo();
		this.marca=p.getMarca();
		this.proveedor=p.getProveedor();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public void llenarRenglon(HSSFRow r){
		for(int i=0;i<10;i++){
			r.createCell(i);
		}
		
		//r.getCell(0).setCellValue(this.getId());
		r.getCell(0).setCellValue(this.getClave());
		r.getCell(1).setCellValue(this.getNombre());
		r.getCell(2).setCellValue(this.getMarca());
		r.getCell(3).setCellValue(this.getProveedor());
		r.getCell(4).setCellValue(this.getUltimoProveedor());
		r.getCell(5).setCellValue(this.getMedidas());
		r.getCell(6).setCellValue(this.getCantidad());
		r.getCell(7).setCellValue(this.getPrecioMostrador());
		r.getCell(8).setCellValue(this.getPrecioMayoreo());
		r.getCell(9).setCellValue(this.getPrecioCredito());
		
	}
	
}
