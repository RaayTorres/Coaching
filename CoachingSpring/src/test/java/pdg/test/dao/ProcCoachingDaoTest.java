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
import pdg.dataaccess.dao.ICoachDAO;
import pdg.dataaccess.dao.ICoacheeDAO;
import pdg.dataaccess.dao.IProcCoachingDAO;
import pdg.dataaccess.dao.IRegContableDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.ProcCoaching;
import pdg.modelo.RegContable;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class ProcCoachingDaoTest {

	
	private Logger log= LoggerFactory.getLogger(ProcCoachingDaoTest.class);
	
	
	@Autowired
	private IProcCoachingDAO procesoDao;
	
	@Autowired
	private ICoachDAO coachDao;
	
	@Autowired
	private ICoacheeDAO coacheeDao;
	
	@Autowired
	private IRegContableDAO registroDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		ProcCoaching nuevoProceso = new ProcCoaching();
		nuevoProceso.setIdProc(procesoDao.genSecuencia());
		Coach nuevoCoach= coachDao.findById(1L);
		nuevoProceso.setCoach(nuevoCoach);
		Coachee nuevoCliente = coacheeDao.findById(1L);
		nuevoProceso.setCoachee(nuevoCliente);
		//nuevoProceso.setIdTpago(20L);
		RegContable nuevoRegistro = registroDao.findById(2L);
		nuevoProceso.setRegContable(nuevoRegistro);
		nuevoProceso.setFocoProceso("nuevo foco");
		
		
		procesoDao.save(nuevoProceso);
	
		
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	
		ProcCoaching nuevoProceso = procesoDao.findById(2L);
		System.out.println(nuevoProceso.getCoachee().getNombre());
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdatTest() throws DaoException {

		ProcCoaching nuevoProceso = procesoDao.findById(2L);
		nuevoProceso.setCoach(coachDao.findById(3L));
		procesoDao.update(nuevoProceso);
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {

		ProcCoaching nuevoProceso = procesoDao.findById(2L);
		procesoDao.delete(nuevoProceso);
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAllTest() {

		
		List<ProcCoaching> losProcesos = procesoDao.findAll();
		
		for (ProcCoaching procCoaching : losProcesos) {
			
			//System.out.println(procCoaching.getCoach().getNombre());
			log.info(procCoaching.getCoach().getNombre());
		}
	}	

	
}
