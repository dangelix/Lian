package com.tikal.toledo.dao;

import java.util.List;

import com.tikal.toledo.model.AlertaInventario;

public interface AlertaDAO {

	void add(AlertaInventario a);
	
	void guardar(AlertaInventario a);
	
	List<AlertaInventario> consultar();
	
	List<AlertaInventario> consultarAll();
	
	void delete(AlertaInventario a);
	
	AlertaInventario consultar(Long id);
	AlertaInventario getById(Long id);
}
