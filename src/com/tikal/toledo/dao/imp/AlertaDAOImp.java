package com.tikal.toledo.dao.imp;

import java.util.List;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.tikal.toledo.dao.AlertaDAO;
import com.tikal.toledo.model.AlertaInventario;
import com.tikal.toledo.model.Cliente;

public class AlertaDAOImp implements AlertaDAO{

	@Override
	public void add(AlertaInventario a) {
		ofy().save().entity(a).now();
	}

	@Override
	public void guardar(AlertaInventario a) {
		ofy().save().entity(a).now();
	}
	
	@Override
	public List<AlertaInventario> consultar() {
		
		return ofy().load().type(AlertaInventario.class).filter("estatus",true).list();
	}
	
	@Override
	public List<AlertaInventario> consultarAll() {
		
		return ofy().load().type(AlertaInventario.class).list();
	}

	@Override
	public void delete(AlertaInventario a) {
		ofy().delete().entity(a).now();
	}

	@Override
	public AlertaInventario consultar(Long id) {
		List<AlertaInventario> lista=ofy().load().type(AlertaInventario.class).filter("idProducto",id).list();
		if(lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	@Override
	public AlertaInventario getById(Long id) {
		return ofy().load().type(AlertaInventario.class).id(id).now();
		
	}

}
