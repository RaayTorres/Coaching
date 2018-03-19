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
import pdg.dataaccess.dao.IParametroDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Parametro;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class ParametroDaoTest {

	
	private Logger log= LoggerFactory.getLogger(ParametroDaoTest.class);
	
	
	@Autowired
	private IParametroDAO parametroDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		Parametro nuevoParametro = new Parametro();
		nuevoParametro.setIdParam(parametroDao.genSecuencia());
		nuevoParametro.setNumero(Double.parseDouble("4000"));
		nuevoParametro.setTexto("Pesos");
		
		parametroDao.save(nuevoParametro);
		
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
			
		Parametro nuevoParametro =  parametroDao.findById(1L);
		
		System.out.println(nuevoParametro.getTexto());
		
		assertNotNull(nuevoParametro);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		Parametro nuevoParametro =  parametroDao.findById(1L);
		nuevoParametro.setTexto("Dolares");
		
		parametroDao.update(nuevoParametro);
		
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {

		Parametro nuevoParametro =  parametroDao.findById(1L);
		
		parametroDao.delete(nuevoParametro);
		
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAll() {

		
		List<Parametro> losParametros = parametroDao.findAll();
		
		for (Parametro parametro : losParametros) {
			
			System.out.println(parametro.getTexto());
			
		}
	}	

	
}
