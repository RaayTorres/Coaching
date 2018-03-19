package pdg.test.dao;



import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdg.dataaccess.api.DaoException;
import pdg.dataaccess.dao.ICategoriaDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class CategoriaDaoTest {

	
	private Logger log= LoggerFactory.getLogger(CategoriaDaoTest.class);
	
	
	@Autowired
	private ICategoriaDAO categoriaDao;
	
	
	
	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {

		Categoria nuevaCategoria = new Categoria();
		nuevaCategoria.setIdCat(categoriaDao.genSecuencia());
		nuevaCategoria.setCatNombre("Categoria 2");
		nuevaCategoria.setHoraPagada(Double.parseDouble("21"));
		nuevaCategoria.setHoraProbono(Double.parseDouble("10"));
		nuevaCategoria.setNombreCorto("C2");
		categoriaDao.save(nuevaCategoria);
		
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	

		Categoria nuevaCategoria = categoriaDao.findById(1L);
		System.out.println(nuevaCategoria.getCatNombre());
	
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {
		
		Categoria nuevaCategoria = categoriaDao.findById(1L);
		nuevaCategoria.setCatNombre("Categoria 3");
		categoriaDao.update(nuevaCategoria);
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {
		

		Categoria nuevaCategoria = categoriaDao.findById(1L);
		categoriaDao.delete(nuevaCategoria);

	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAllTest() {

		List<Categoria> lasCategorias = categoriaDao.findAll();
		
		for (Categoria categoria : lasCategorias) {
			
			System.out.println(categoria.getCatNombre());
		}
	}	

	
}
