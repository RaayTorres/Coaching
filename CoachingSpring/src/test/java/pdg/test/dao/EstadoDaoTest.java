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

		assertNotNull("estado es null",estadoDao);
		Estado miEstado = new Estado();
		TipoEstado miTipoEstado = tipoDao.findById(Double.parseDouble("1"));
		
		miEstado.setIdEstado(estadoDao.genSecuencia());
		miEstado.setTipoEstado(miTipoEstado);
		miEstado.setNombreEstado("Activo");

		estadoDao.save(miEstado);

	}

	@Test
	@Transactional(readOnly = true)
	public void btest() {

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void ctest() {

	}

	@Test
	@Transactional(readOnly = true)
	public void dtest() {

	}	

	@Test
	@Transactional(readOnly = true)
	public void etest() {

	}	


}
