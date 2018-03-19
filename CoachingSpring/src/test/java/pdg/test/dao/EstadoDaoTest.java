package pdg.test.dao;



import static org.junit.Assert.*;

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
import pdg.dataaccess.dao.IEstadoDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Estado;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class EstadoDaoTest {


	private Logger log= LoggerFactory.getLogger(EstadoDaoTest.class);


	@Autowired
	private ITipoEstadoDAO tipoDao;
	
	@Autowired
	private IEstadoDAO estadoDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {

		TipoEstado miTipo = tipoDao.findById(2L);
		//System.out.println(miTipo.getNombreTipoEstado());
		Estado miEstado = new Estado();
		miEstado.setIdEstado(estadoDao.genSecuencia());
		miEstado.setTipoEstado(miTipo);
		miEstado.setNombreEstado("Inactivo");
		
		estadoDao.save(miEstado);
		

	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {

		
		Estado miEstado = estadoDao.findById(2L);
		
		System.out.println(miEstado.getNombreEstado());
		
		assertNotNull(miEstado);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		
		Estado miEstado = estadoDao.findById(2L);
		miEstado.setNombreEstado("Segunda prueba");
		estadoDao.update(miEstado);
		assertEquals("Segunda prueba", miEstado.getNombreEstado());
		
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {

		
		Estado miEstado = estadoDao.findById(2L);
		
		estadoDao.delete(miEstado);
		
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAll() {

		List<Estado> misEstados = estadoDao.findAll();
		
		for (Estado estado : misEstados) {
			
			System.out.println(estado.getNombreEstado());
		}
		
	}	


}
