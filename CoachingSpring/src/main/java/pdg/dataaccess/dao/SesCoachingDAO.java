package pdg.dataaccess.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import pdg.dataaccess.api.JpaDaoImpl;
import pdg.modelo.Estado;
import pdg.modelo.SesCoaching;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * SesCoaching entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.SesCoaching
 */
@Scope("singleton")
@Repository("SesCoachingDAO")
public class SesCoachingDAO extends JpaDaoImpl<SesCoaching, Double>
    implements ISesCoachingDAO {
    private static final Logger log = LoggerFactory.getLogger(SesCoachingDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ISesCoachingDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ISesCoachingDAO) ctx.getBean("SesCoachingDAO");
    }
    
    
    public List<SesCoaching> filtrarSesionPorEstado(Long esta) {
  		// nameSquence= "seq_prueba";
    List<SesCoaching> listado=  	
    	 entityManager.createNativeQuery("select * from SES_COACHING ses where ses.estado_id_estado=" + esta).getResultList();
    	//Double nue= new BigDecimal(nig).doubleValue();
    	
    	
  		return listado;
  	}
}
