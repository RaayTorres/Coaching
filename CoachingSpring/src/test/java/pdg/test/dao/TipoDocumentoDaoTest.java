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
import pdg.dataaccess.dao.ITipoDocumentoDAO;
import pdg.dataaccess.dao.ITipoEstadoDAO;
import pdg.modelo.Categoria;
import pdg.modelo.TipoDocumento;
import pdg.modelo.TipoEstado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@FixMethodOrder(MethodSorters.JVM)
@Rollback(false)
public class TipoDocumentoDaoTest {

	
	private Logger log= LoggerFactory.getLogger(TipoDocumentoDaoTest.class);
	
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumento;
	private TipoDocumento miTipoDocumento;
	

	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void aSaveTest() throws Exception {
		
		assertNotNull("Tipo de documento es null",tipoDocumento);
	
		
		
		miTipoDocumento = new TipoDocumento();
		miTipoDocumento.setIdDoc(tipoDocumento.genSecuencia());
		
		miTipoDocumento.setTdocNombre("Pasaporte Italiano");
		
		tipoDocumento.save(miTipoDocumento);
	}

	@Test
	@Transactional(readOnly = true)
	public void bBuscarTest() {
	
		TipoDocumento nuevoTipo = tipoDocumento.findById(Double.parseDouble("1"));
		
		System.out.println(nuevoTipo.getTdocNombre() + "-------------------------------------------------------------------<");
		
		assertNotNull(nuevoTipo);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void cUpdateTest() throws DaoException {

		TipoDocumento nuevoTipo = tipoDocumento.findById(Double.parseDouble("1"));
		
		nuevoTipo.setTdocNombre("pasaporte");
		
		System.out.println(nuevoTipo.getTdocNombre() + "-------------------------------------------------------------------<");
		tipoDocumento.update(nuevoTipo);
		
		assertNotNull(nuevoTipo);
	}


	@Test
	@Transactional(readOnly = true)
	public void dEliminarTest() throws DaoException {
	
		TipoDocumento nuevoTipo = tipoDocumento.findById(Double.parseDouble("1"));
		
		tipoDocumento.delete(nuevoTipo);
		
	}	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void eFindAll() {

		List<TipoDocumento> misTiposDocumentos = tipoDocumento.findAll();
		
		for (TipoDocumento tipoDocumento : misTiposDocumentos) {
			
			System.out.println(tipoDocumento.getTdocNombre() + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++s");
		}
		
		
	}	

	
}
