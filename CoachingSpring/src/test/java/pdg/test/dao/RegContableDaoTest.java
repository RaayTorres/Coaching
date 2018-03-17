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
import pdg.dataaccess.dao.ICoacheeDAO;
import pdg.dataaccess.dao.IRegContableDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.dataaccess.dao.RegContableDAO;
import pdg.modelo.Categoria;
import pdg.modelo.Coachee;
import pdg.modelo.RegContable;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class RegContableDaoTest {

	
	private Logger log= LoggerFactory.getLogger(RegContableDaoTest.class);
	
	
	@Autowired
	private IRegContableDAO registroDao;

	@Autowired
	private ICoacheeDAO coacheeDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws DaoException {
		
		
		RegContable registro = new RegContable();
		registro.setIdHis(registroDao.genSecuencia());
		Coachee coa = coacheeDao.findById(Double.parseDouble("4"));
		registro.setCoachee(coa);
		Date fecha = new Date();
		registro.setFechaPago(fecha);
		registro.setTipo("tipo 1");
		registro.setValor(Double.parseDouble("50000"));
		
		
		registroDao.save(registro);
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	
		RegContable nuevoRegistro = registroDao.findById(Double.parseDouble("3"));
		
		System.out.println(nuevoRegistro.getCoachee().getNombre() + " "+ nuevoRegistro.getFechaPago());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		
		RegContable nuevoRegistro = registroDao.findById(Double.parseDouble("3"));
		nuevoRegistro.setValor(Double.parseDouble("100000"));
		registroDao.update(nuevoRegistro);
	}

	@Test
	@Transactional(readOnly = true)
	public void dDeleteTest() throws DaoException {
	
		RegContable nuevoRegistro = registroDao.findById(Double.parseDouble("3"));
		registroDao.delete(nuevoRegistro);
		
	}	

	@Test
	@Transactional(readOnly = true)
	public void eFindAllTest() {

		List<RegContable> losRegistros = registroDao.findAll();
		
		for (RegContable regContable : losRegistros) {
			
			System.out.println( regContable.getValor());
		}
	}	

	
}
