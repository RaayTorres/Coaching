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
import pdg.modelo.Coachee;
import pdg.modelo.Estado;
import pdg.modelo.TipoDocumento;
import pdg.modelo.TipoEstado;
import pdg.presentation.businessDelegate.IBusinessDelegate;

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
	
	@Autowired
	private IBusinessDelegate delegadoDeNegocio;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		

		Coach coach = new Coach();
		coach.setIdCoach(coachDao.genSecuencia());
		coach.setNombre("Ezio");
		coach.setApellido("Auditore");
		coach.setCelular("11122333");
		coach.setCorreo("correo@hotmail.com");
		coach.setHoraPagada(Double.parseDouble("10"));
		coach.setHoraProbono(Double.parseDouble("10"));
		coach.setLogin("Ezio");
		coach.setContrasena("password");
		coach.setIdentificacion("123456789");
		TipoDocumento nuevoDocumento = tipoDocumentoDao.findById(1L);
		coach.setTipoDocumento(nuevoDocumento);
		
		coachDao.save(coach);
		
		
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	
		Coach coach = coachDao.findById(2L);
		System.out.println(coach.getNombre() + " " + coach.getApellido());
		
		assertNotNull(coach);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		Coach coach = coachDao.findById(2L);
		coach.setApellido("Firenze");
		
		coachDao.update(coach);
		
		assertEquals("Firenze", coach.getApellido());
		
		
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {
	
		
		Coach coach = coachDao.findById(2L);
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

	
	@Test
	@Transactional(readOnly = true)
	public void fPrueba() throws Exception {
	
		
		
		String login = "Ezio";
		String pass ="password";
		
//		Coach nuevoCoach = coachDao.consultarCoachPorLogin(login);
//		System.out.println(nuevoCoach.getNombre()+" "+ nuevoCoach.getApellido());
		
		Coach nuevoCoach = delegadoDeNegocio.validarCredencialesCoach(login, pass);
		System.out.println(nuevoCoach.getNombre()+" "+ nuevoCoach.getApellido());
		
		
		
	}
	
}
