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
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class CoacheeDaoTest {

	
	private Logger log= LoggerFactory.getLogger(CoacheeDaoTest.class);
	
	
	@Autowired
	private ICategoriaDAO categoriaDao;
	
	
	
	@Autowired
	private ITipoEstadoDAO tipoDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addtest() {
		
		

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
