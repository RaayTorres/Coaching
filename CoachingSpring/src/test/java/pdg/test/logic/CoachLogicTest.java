package pdg.test.logic;

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
import pdg.dataaccess.dao.ICoachDAO;
import pdg.dataaccess.dao.IEstadoDAO;
import pdg.dataaccess.dao.ITipoDocumentoDAO;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.TipoDocumento;
import pdg.modelo.logic.ICoachLogic;
import pdg.modelo.logic.ICoacheeLogic;
import pdg.modelo.logic.IProcCoachingLogic;
import pdg.presentation.businessDelegate.IBusinessDelegate;
import pdg.test.dao.CoachDaoTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class CoachLogicTest {

	
private Logger log= LoggerFactory.getLogger(CoachDaoTest.class);
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDao;
	
	@Autowired
	private IEstadoDAO estadoDao;
	
	@Autowired
	private ICoachDAO coachDao;
	
	@Autowired
	private ICoachLogic coachLogic;

	@Autowired
	private ICoacheeLogic coacheeLogic;

	@Autowired
	private IProcCoachingLogic proc;
	
	@Autowired
	private IBusinessDelegate delegadoDeNegocio;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest()  {
		

		Coach coach = new Coach();
		coach.setIdCoach(coachDao.genSecuencia());
		coach.setNombre("Altair");
		coach.setApellido("Ibn-La'Ahad");
		coach.setCelular("11122334");
		coach.setCorreo("correo@hotmail.com");
		coach.setHoraPagada(Double.parseDouble("10"));
		coach.setHoraProbono(Double.parseDouble("10"));
		coach.setLogin("Altair");
		coach.setContrasena("password");
		coach.setIdentificacion("1234567891");
		TipoDocumento nuevoDocumento = tipoDocumentoDao.findById(1L);
		coach.setTipoDocumento(nuevoDocumento);
		
		try {
			coachLogic.saveCoach(coach);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
		
	}
	
	
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void progresoTest()  {
		
Coachee client;
try {
	Coach coach= coachLogic.getCoach(1L);
	client = coacheeLogic.getCoachee(5L);
	int o =proc.progresoProceso(coach.getIdCoach(), client.getIdCoachee());
	
	System.out.println(o + "");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
		
	}
	
	
}
