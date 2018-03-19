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
public class TipoEstadoDaoTest {


	private Logger log= LoggerFactory.getLogger(TipoEstadoDaoTest.class);




	@Autowired
	private ITipoEstadoDAO tipoDao;


	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {

		assertNotNull("Tipo estado es null",tipoDao);
		TipoEstado miTipoEstado = new TipoEstado();

		miTipoEstado.setIdTestado(tipoDao.genSecuencia());
		miTipoEstado.setNombreTipoEstado("3");

		tipoDao.save(miTipoEstado);


	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {

		assertNotNull("Tipo estado es null",tipoDao);

		TipoEstado miTipoEstadi = tipoDao.findById(1L);

		System.out.println(miTipoEstadi.getNombreTipoEstado() + "<------------------------------------------------------------------------------------------------------");

		assertNotNull(miTipoEstadi);
	}


	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		assertNotNull("Tipo estado es null",tipoDao);

		TipoEstado miTipoEstadi = tipoDao.findById(3L);
		miTipoEstadi.setNombreTipoEstado("borrar");
		
		tipoDao.update(miTipoEstadi);
		assertNotNull(miTipoEstadi);


	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {

		assertNotNull("Tipo estado es null",tipoDao);

		TipoEstado miTipoEstadi = tipoDao.findById(3L);
		
		tipoDao.delete(miTipoEstadi);
		
		
		
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAll() {

		
		List<TipoEstado> misTiposEstados = tipoDao.findAll();
		
		for (TipoEstado tipoEstado : misTiposEstados) {
			
			System.out.println(tipoEstado.getNombreTipoEstado() );
		}
		
		
	}	


}
