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
import pdg.dataaccess.dao.IEstadoDAO;
import pdg.dataaccess.dao.ITipoDocumentoDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Coach;
import pdg.modelo.Estado;
import pdg.modelo.TipoDocumento;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class CoachDaoTest {

	
	private Logger log= LoggerFactory.getLogger(CoachDaoTest.class);
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDao;
	
	@Autowired
	private IEstadoDAO estadoDao;
	
	@Autowired
	private ICoachDAO coachDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		

		Coach coach = new Coach();
		coach.setIdCoach(coachDao.genSecuencia());
		coach.setNombre("Altair");
		coach.setApellido("Lbn-LaAhad");
		coach.setCelular(Double.parseDouble("000011111"));
		coach.setCorreo("correo@hotmail.com");
		coach.setHoraPagada(Double.parseDouble("10"));
		coach.setHoraProbono(Double.parseDouble("10"));
		coach.setLogin("Ezio");
		coach.setContrasena("password");
		coach.setIdentificacion("123456789");
		Estado nuevoEstado = estadoDao.findById(Double.parseDouble("18"));
		coach.setEstado(nuevoEstado);
		TipoDocumento nuevoDocumento = tipoDocumentoDao.findById(Double.parseDouble("1"));
		coach.setTipoDocumento(nuevoDocumento);
		
		coachDao.save(coach);
		
		
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	
		Coach coach = coachDao.findById(Double.parseDouble("6"));
		System.out.println(coach.getNombre() + " " + coach.getApellido());
		
		assertNotNull(coach);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		Coach coach = coachDao.findById(Double.parseDouble("6"));
		coach.setApellido("Firenze");
		
		coachDao.update(coach);
		
		assertEquals("Firenze", coach.getApellido());
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {
	
		
		Coach coach = coachDao.findById(Double.parseDouble("6"));
		coachDao.delete(coach);
		
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAllTest() {

		
		List<Coach> listaCoach = coachDao.findAll();
		
		for (Coach coach : listaCoach) {
			
			System.out.println(coach.getNombre() + " " + coach.getApellido());
		}
		
	}	

	
}
