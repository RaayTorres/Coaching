package pdg.test.dao;



import static org.junit.Assert.*;

import java.util.Date;
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
import pdg.dataaccess.dao.IProcCoachingDAO;
import pdg.dataaccess.dao.ISesCoachingDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Estado;
import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class SesCoachingDaoTest {

	
	private Logger log= LoggerFactory.getLogger(SesCoachingDaoTest.class);
	
	
	
	@Autowired
	private ISesCoachingDAO sesionDao;
	
	@Autowired
	private IEstadoDAO estadoDao;
	
	@Autowired
	private IProcCoachingDAO procesoDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		
		SesCoaching sesion = new SesCoaching();
		sesion.setIdSesi(sesionDao.genSecuencia());
		sesion.setAccion("accion 3");
		sesion.setCompromiso("compromiso 3");
		Estado nuevoEstado = estadoDao.findById(2L);
		sesion.setEstado(nuevoEstado);
		sesion.setFocoSesion("Foco Sesion 3");
		
		Date fecha = new Date();
		String [] hora = fecha.toString().split(" ");
		sesion.setHora(hora[3]);
		sesion.setFecha(new Date());
		sesion.setIndicador("indicador 3");
		sesion.setProfundidad("profundidad 3");
		ProcCoaching nuevoProceso = procesoDao.findById(2L);
		sesion.setProcCoaching(nuevoProceso);
		sesion.setIdHis(3L);
	
		sesionDao.save(sesion);
		
	
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {

		SesCoaching sesion = sesionDao.findById(2L);
		
		System.out.println(sesion.getCompromiso());
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		SesCoaching sesion = sesionDao.findById(2L);
		sesion.setCompromiso("Compromiso completo");
		sesionDao.update(sesion);
		
	}
	

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {
	

		SesCoaching sesion = sesionDao.findById(3L);
		sesionDao.delete(sesion);
	}	

	@Test
	@Transactional(readOnly = true)
	public void etest() {
		
		List<SesCoaching> sesion = sesionDao.findAll();
			
		//for (SesCoaching sesCoaching : sesion) {
		
		//	System.out.println(sesCoaching.getCompromiso());
	}	

	
	
	@Test
	@Transactional(readOnly = true)
	public void cleintessesionestest() {

	//	List<Coachee> sesi = sesion.clientesSesionesHoy();
		
//		System.out.println("prueba antes" + sesi.size() + new Date());
		
//	for (Coachee coachee : sesi) {
		
//.out.println(coachee.getApellido() + "prueba");
	//}
		
	}	
	
	
}
