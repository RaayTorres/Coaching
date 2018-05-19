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
import pdg.dataaccess.dao.ICoacheeDAO;
import pdg.dataaccess.dao.IEstadoDAO;
import pdg.dataaccess.dao.ITipoDocumentoDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Coachee;
import pdg.modelo.Estado;
import pdg.modelo.TipoDocumento;
import pdg.modelo.TipoEstado;
import pdg.presentation.businessDelegate.IBusinessDelegate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class CoacheeDaoTest {

	
	private Logger log= LoggerFactory.getLogger(CoacheeDaoTest.class);
	
	
	@Autowired
	private ICoacheeDAO coacheeDao;

	@Autowired
	private IEstadoDAO estadoDao;
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDao;
	
	@Autowired
	private IBusinessDelegate delegadoDeNegocio;
	
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		
		
		
		Coachee coachee = new Coachee();
		coachee.setIdCoachee(coacheeDao.genSecuencia());
		coachee.setNombre("Leidy");
		coachee.setApellido("Malagon");
		coachee.setCelular("1234567");
		coachee.setCorreo("tebannew@gmail.com");
		coachee.setDireccion("Icesi");
		Estado nuevoEstado = estadoDao.findById(2L);
		coachee.setEstado(nuevoEstado);
		coachee.setHobbies("Deportes");
		coachee.setIdentificacion("190865212");
		byte [] abc = new byte[20];
		coachee.setFoto(abc);
		TipoDocumento nuevoTipo = tipoDocumentoDao.findById(2L);
		coachee.setTipoDocumento(nuevoTipo);
		
		
		coacheeDao.save(coachee);
		

	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {

		
		Coachee nuevo= coacheeDao.findById(2L);
		
		
		System.out.println(nuevo.getApellido());
		
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		Coachee nuevo= coacheeDao.findById(2L);
		nuevo.setApellido("Chilito");
		coacheeDao.update(nuevo);
		
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {

		Coachee nuevo= coacheeDao.findById(2L);
		
		coacheeDao.delete(nuevo);
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAll() {

		
		List<Coachee> listaCoachees = coacheeDao.findAll();
		
		for (Coachee coachee : listaCoachees) {
			
			System.out.println(coachee.getNombre() + " "+ coachee.getApellido());
			
		}
	}	

	
	@Test
	@Transactional(readOnly = true)
	public void fPrueba() throws Exception {
		
		String user = "190865212";
		String pass = "Icesi";
		//Coachee cliente = coacheeDao.consultarClientePorLogin(user);
		Coachee cliente = delegadoDeNegocio.validarCredencialesCoachee(user, pass);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println(cliente.getNombre()+ "--------------------------------------------------------------------");
		
		
	}

	
}
