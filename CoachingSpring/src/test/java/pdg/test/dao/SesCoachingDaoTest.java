package pdg.test.dao;



import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import pdg.dataaccess.dao.IEstadoDAO;
import pdg.dataaccess.dao.IProcCoachingDAO;
import pdg.dataaccess.dao.ISesCoachingDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.Estado;
import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;
import pdg.modelo.TipoEstado;
import pdg.modelo.logic.ICoachLogic;
import pdg.modelo.logic.ICoacheeLogic;
import pdg.modelo.logic.IProcCoachingLogic;
import pdg.modelo.logic.ISesCoachingLogic;

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
	
	
	@Autowired
	private ICoachLogic coach;
	
	
	@Autowired
	private ICoacheeLogic coachee;
	

	@Autowired
	private IProcCoachingLogic proc;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		
		SesCoaching sesion = new SesCoaching();
		sesion.setIdSesi(sesionDao.genSecuencia());
		sesion.setAccion("accion 3");
		sesion.setCompromiso("compromiso 3");
		Estado nuevoEstado = estadoDao.findById(1L);
		sesion.setEstado(nuevoEstado);
		sesion.setFocoSesion("Foco Sesion 3");
		
		Date fecha = new Date();
		String [] hora = fecha.toString().split(" ");
		sesion.setHora(hora[3]);
		sesion.setFecha(new Date());
		sesion.setIndicador("indicador 3");
		sesion.setProfundidad("profundidad 3");
		ProcCoaching nuevoProceso = procesoDao.findById(5L);
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
	try {
		Coach coac= coach.getCoach(1L);
		Coachee	client = coachee.getCoachee(5L);
//		List<SesCoaching> pro = procesoDao.sesionesProcesoCoachee(client.getIdCoachee(), coac.getIdCoach(), 2L);
//List<SesCoaching> totas= procesoDao.sesionesTotalesProcesoCoachee(client.getIdCoachee(), coac.getIdCoach());
//Double p = (double) (pro.size())/(totas.size());
//System.out.println(pro.size()/totas.size());
//System.out.println(pro.size() + "----------" + totas.size());
//	System.out.println(p);
		//proc.progresoProceso(coac.getIdCoach(), client.getIdCoachee());
		//List<SesCoaching> sesion = sesionDao.filtrarSesionPorEstado(2L,5L);
		System.out.println(		proc.progresoProceso(coac.getIdCoach(), client.getIdCoachee()) + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
//		for (SesCoaching sesCoaching : sesion) {
//			System.out.println( sesCoaching + "-----------------------------------------------------------");
//		}
//		for (SesCoaching sesCoaching : sesion) {
//			System.out.println(sesCoaching.getNumSes());
//		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
			
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
