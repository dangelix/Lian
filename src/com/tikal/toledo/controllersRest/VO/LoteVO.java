package com.tikal.toledo.controllersRest.VO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;

import com.googlecode.objectify.annotation.Index;

import com.tikal.toledo.model.Lote;

public class LoteVO {
	private String nombre;
	private String marca;
	private String idLote;
	private String nombreProducto;
	private String fecha;
	private float cantidad;
	private float costo;
	private String proveedor;
	private String ubicacion;
	private String unidad;
	private float existencia;
	
	private String rack;
	
	private String cuadricula;
	
	private String nivel;
	
	private String posicion;
	
	@Index private Long idAlmacen;
	private String nombreAlmacen;
	
	
	public LoteVO(){
		
	}
	
	public LoteVO(Lote l, String nomProd,String marca, String unidad, float exis){
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date nueva = l.getFecha();
		nueva.setHours(nueva.getHours()-5);
		
		System.out.println("fecha menos 5 horas:"+nueva);
		l.setFecha(nueva);
		this.fecha= l.getFecha().toLocaleString();
		this.idLote=l.getId().toString();
		this.cantidad=l.getCantidad();
		this.costo=l.getCosto();
		this.nombreProducto=nomProd;
		this.unidad= unidad;
		this.existencia=exis;
		this.marca=marca;
		
	}
	
	public String getNombre() {;
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

		public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}
	
	
	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	

	public float getExistencia() {
		return existencia;
	}

	public void setExistencia(float existencia) {
		this.existencia = existencia;
	}

	public void llenarRenglonLotes(HSSFRow r){
		for(int i=0;i<7;i++){
			r.createCell(i);
		}
		
		r.getCell(0).setCellValue(this.getIdLote());
		r.getCell(1).setCellValue(this.getNombreProducto());
		r.getCell(2).setCellValue(this.getMarca());
		r.getCell(3).setCellValue(this.getUnidad());
		r.getCell(4).setCellValue(this.getFecha());
		r.getCell(5).setCellValue(this.getCosto());
		r.getCell(6).setCellValue(this.getExistencia());
		
			
//		if(this.factura!=null){
//		r.getCell(4).setCellValue(this.getFactura());
//		}else{
//			r.getCell(4).setCellValue("No facturado");
//		}
	}
}
