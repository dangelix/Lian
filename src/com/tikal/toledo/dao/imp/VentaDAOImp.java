package com.tikal.toledo.dao.imp;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Cursor;
import com.tikal.toledo.dao.VentaDAO;
import com.tikal.toledo.model.Venta;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class VentaDAOImp implements VentaDAO{

	@Override
	public void guardar(Venta v) {
		ofy().save().entity(v).now();
	}

	@Override
	public Venta cargar(Long id) {
		return ofy().load().type(Venta.class).id(id).now();
	}

	@Override
	public List<Venta> buscar(Date fi, Date ff) {
		System.out.println("inicio:"+fi);System.out.println("fin:"+ff);
		List<Venta> lista= ofy().load().type(Venta.class).filter("fecha >=",fi).filter("fecha <=",ff).order("- fecha").list();
		return lista;
	}

	@Override
	public List<Venta> todos(int page) {
		return ofy().load().type(Venta.class).order("- fecha").offset(25*(page-1)).limit(25).list();
	}

	@Override
	public List<Venta> todos_() {
		return ofy().load().type(Venta.class).order("- fecha").list();
	}
	
	@Override
	public int pages() {
		return ((ofy().load().type(Venta.class).count()-1)/50)+1;
	}

}
