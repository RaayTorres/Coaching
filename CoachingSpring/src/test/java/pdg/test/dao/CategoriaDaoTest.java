package pdg.test.dao;



import static org.junit.Assert.*;

import java.math.BigDecimal;
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
public class CategoriaDaoTest {

	
	private Logger log= LoggerFactory.getLogger(CategoriaDaoTest.class);
	
	
	@Autowired
	private ICategoriaDAO categoriaDao;
	
	
	
	@Autowired
	private ITipoEstadoDAO tipoDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addtest() {
		
//		TipoEstado tip = new TipoEstado();
//		tip.setIdTestado(2.0);
//		tip.setNombreTipoEstado("ave");
//		try {
//			tipoDao.save(tip);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
		assertNotNull(categoriaDao);
		
		try {
		
		
		Categoria cat= new Categoria();
		
		cat.setCatNombre("prueba");
		cat.setHoraPagada(2.0);
		cat.setHoraProbono(5.0);
		cat.setIdCat(categoriaDao.genSecuencia());
		cat.setNombreCorto("pru");
		
			categoriaDao.save(cat);
		} catch (DaoException e) {
		
			e.printStackTrace();
		}

//		TiposDocumentos docs = tipo.findById(10L);
//
//		Clientes clientes= clienteDao.findById(codigoUser);
//		assertNull("ya existe",clientes);
//		clientes = new Clientes();
//		clientes.setCliNombre("Luis");
//		clientes.setCliId(codigoUser);
//		clientes.setCliTelefono("31569882");
//		clientes.setTiposDocumentos(docs);
//		clientes.setCliDireccion("myHome");
//		clientes.setCliMail("asd@asd.com");
//
//		clienteDao.save(clientes);		
	}
//
	@Test
	@Transactional(readOnly = true)
	public void btest() {
	

		Categoria cat= categoriaDao.findById(1.0);	
		log.info(cat.getCatNombre());
		assertNotNull("no existe",cat);
		
	}
//
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void ctest() {
		
		Categoria cat= categoriaDao.findById(1.0);
		cat.setNombreCorto("Tebio");
		
		try {
			categoriaDao.update(cat);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		assertNotNull(clienteDao);
//
//		Clientes clie= clienteDao.findById(codigoUser);
//		assertNotNull("ya existe",clie);
//
//		clie.setCliNombre("Jorge");
//		clienteDao.update(clie);
	}
//
//
	@Test
	@Transactional(readOnly = true)
	public void dtest() throws DaoException {
		
		Categoria cat= categoriaDao.findById(1.0);
		categoriaDao.delete(cat);
//		assertNotNull(clienteDao);
//
//		Clientes clie= clienteDao.findById(codigoUser);
//		assertNotNull("ya existe",clienteDao);
//
//		clienteDao.delete(clie);	
	}	
//
//
	@Test
	@Transactional(readOnly = true)
	public void etest() {
//		assertNotNull(clienteDao);
//
//		List<Clientes> losClientes = clienteDao.findAll();
//		assertNotNull(losClientes);
//
//		for (Clientes lista : losClientes) {
//			log.info("Nombre:" + lista.getCliNombre());
//			log.info("Tipo Documento " + lista.getTiposDocumentos().getTdocNombre());
//		}
//
	}	

	
}
