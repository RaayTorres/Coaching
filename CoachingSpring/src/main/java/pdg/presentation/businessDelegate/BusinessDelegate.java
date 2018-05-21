package pdg.presentation.businessDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import pdg.modelo.Categoria;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.Estado;
import pdg.modelo.Parametro;
import pdg.modelo.ProcCoaching;
import pdg.modelo.RegContable;
import pdg.modelo.SesCoaching;
import pdg.modelo.TipoDocumento;
import pdg.modelo.TipoEstado;
import pdg.modelo.dto.CategoriaDTO;
import pdg.modelo.dto.CoachDTO;
import pdg.modelo.dto.CoacheeDTO;
import pdg.modelo.dto.EstadoDTO;
import pdg.modelo.dto.ParametroDTO;
import pdg.modelo.dto.ProcCoachingDTO;
import pdg.modelo.dto.RegContableDTO;
import pdg.modelo.dto.SesCoachingDTO;
import pdg.modelo.dto.TipoDocumentoDTO;
import pdg.modelo.dto.TipoEstadoDTO;
import pdg.modelo.logic.CategoriaLogic;
import pdg.modelo.logic.CoachLogic;
import pdg.modelo.logic.CoacheeLogic;
import pdg.modelo.logic.EstadoLogic;
import pdg.modelo.logic.ICategoriaLogic;
import pdg.modelo.logic.ICoachLogic;
import pdg.modelo.logic.ICoacheeLogic;
import pdg.modelo.logic.IEstadoLogic;
import pdg.modelo.logic.IParametroLogic;
import pdg.modelo.logic.IProcCoachingLogic;
import pdg.modelo.logic.IRegContableLogic;
import pdg.modelo.logic.ISesCoachingLogic;
import pdg.modelo.logic.ITipoDocumentoLogic;
import pdg.modelo.logic.ITipoEstadoLogic;
import pdg.modelo.logic.ParametroLogic;
import pdg.modelo.logic.ProcCoachingLogic;
import pdg.modelo.logic.RegContableLogic;
import pdg.modelo.logic.SesCoachingLogic;
import pdg.modelo.logic.TipoDocumentoLogic;
import pdg.modelo.logic.TipoEstadoLogic;
import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegate implements IBusinessDelegate {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegate.class);
    @Autowired
    private ICategoriaLogic categoriaLogic;
    @Autowired
    private ICoachLogic coachLogic;
    @Autowired
    private ICoacheeLogic coacheeLogic;
    @Autowired
    private IEstadoLogic estadoLogic;
    @Autowired
    private IParametroLogic parametroLogic;
    @Autowired
    private IProcCoachingLogic procCoachingLogic;
    @Autowired
    private IRegContableLogic regContableLogic;
    @Autowired
    private ISesCoachingLogic sesCoachingLogic;
    @Autowired
    private ITipoDocumentoLogic tipoDocumentoLogic;
    @Autowired
    private ITipoEstadoLogic tipoEstadoLogic;

    public List<Categoria> getCategoria() throws Exception {
        return categoriaLogic.getCategoria();
    }

    public void saveCategoria(Categoria entity) throws Exception {
        categoriaLogic.saveCategoria(entity);
    }

    public void deleteCategoria(Categoria entity) throws Exception {
        categoriaLogic.deleteCategoria(entity);
    }

    public void updateCategoria(Categoria entity) throws Exception {
        categoriaLogic.updateCategoria(entity);
    }

    public Categoria getCategoria(Long idCat) throws Exception {
        Categoria categoria = null;

        try {
            categoria = categoriaLogic.getCategoria(idCat);
        } catch (Exception e) {
            throw e;
        }

        return categoria;
    }

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return categoriaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return categoriaLogic.findPageCategoria(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCategoria() throws Exception {
        return categoriaLogic.findTotalNumberCategoria();
    }

    public List<CategoriaDTO> getDataCategoria() throws Exception {
        return categoriaLogic.getDataCategoria();
    }

    public void validateCategoria(Categoria categoria)
        throws Exception {
        categoriaLogic.validateCategoria(categoria);
    }

    public List<Coach> getCoach() throws Exception {
        return coachLogic.getCoach();
    }

    public void saveCoach(Coach entity) throws Exception {
        coachLogic.saveCoach(entity);
    }

    public void deleteCoach(Coach entity) throws Exception {
        coachLogic.deleteCoach(entity);
    }

    public void updateCoach(Coach entity) throws Exception {
        coachLogic.updateCoach(entity);
    }

    public Coach getCoach(Long idCoach) throws Exception {
        Coach coach = null;

        try {
            coach = coachLogic.getCoach(idCoach);
        } catch (Exception e) {
            throw e;
        }

        return coach;
    }

    public List<Coach> findByCriteriaInCoach(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return coachLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Coach> findPageCoach(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return coachLogic.findPageCoach(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCoach() throws Exception {
        return coachLogic.findTotalNumberCoach();
    }

    public List<CoachDTO> getDataCoach() throws Exception {
        return coachLogic.getDataCoach();
    }

    public void validateCoach(Coach coach) throws Exception {
        coachLogic.validateCoach(coach);
    }

    public List<Coachee> getCoachee() throws Exception {
        return coacheeLogic.getCoachee();
    }

    public void saveCoachee(Coachee entity) throws Exception {
        coacheeLogic.saveCoachee(entity);
    }

    public void deleteCoachee(Coachee entity) throws Exception {
        coacheeLogic.deleteCoachee(entity);
    }

    public void updateCoachee(Coachee entity) throws Exception {
        coacheeLogic.updateCoachee(entity);
    }

    public Coachee getCoachee(Long idCoachee) throws Exception {
        Coachee coachee = null;

        try {
            coachee = coacheeLogic.getCoachee(idCoachee);
        } catch (Exception e) {
            throw e;
        }

        return coachee;
    }

    public List<Coachee> findByCriteriaInCoachee(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return coacheeLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Coachee> findPageCoachee(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return coacheeLogic.findPageCoachee(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCoachee() throws Exception {
        return coacheeLogic.findTotalNumberCoachee();
    }

    public List<CoacheeDTO> getDataCoachee() throws Exception {
        return coacheeLogic.getDataCoachee();
    }

    public void validateCoachee(Coachee coachee) throws Exception {
        coacheeLogic.validateCoachee(coachee);
    }

    public List<Estado> getEstado() throws Exception {
        return estadoLogic.getEstado();
    }

    public void saveEstado(Estado entity) throws Exception {
        estadoLogic.saveEstado(entity);
    }

    public void deleteEstado(Estado entity) throws Exception {
        estadoLogic.deleteEstado(entity);
    }

    public void updateEstado(Estado entity) throws Exception {
        estadoLogic.updateEstado(entity);
    }

    public Estado getEstado(Long idEstado) throws Exception {
        Estado estado = null;

        try {
            estado = estadoLogic.getEstado(idEstado);
        } catch (Exception e) {
            throw e;
        }

        return estado;
    }

    public List<Estado> findByCriteriaInEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return estadoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return estadoLogic.findPageEstado(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEstado() throws Exception {
        return estadoLogic.findTotalNumberEstado();
    }

    public List<EstadoDTO> getDataEstado() throws Exception {
        return estadoLogic.getDataEstado();
    }

    public void validateEstado(Estado estado) throws Exception {
        estadoLogic.validateEstado(estado);
    }

    public List<Parametro> getParametro() throws Exception {
        return parametroLogic.getParametro();
    }

    public void saveParametro(Parametro entity) throws Exception {
        parametroLogic.saveParametro(entity);
    }

    public void deleteParametro(Parametro entity) throws Exception {
        parametroLogic.deleteParametro(entity);
    }

    public void updateParametro(Parametro entity) throws Exception {
        parametroLogic.updateParametro(entity);
    }

    public Parametro getParametro(Long idParam) throws Exception {
        Parametro parametro = null;

        try {
            parametro = (Parametro) parametroLogic.getParametro();
        } catch (Exception e) {
            throw e;
        }

        return parametro;
    }

    public List<Parametro> findByCriteriaInParametro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return parametroLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Parametro> findPageParametro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return parametroLogic.findPageParametro(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberParametro() throws Exception {
        return parametroLogic.findTotalNumberParametro();
    }

    public List<ParametroDTO> getDataParametro() throws Exception {
        return parametroLogic.getDataParametro();
    }

    public void validateParametro(Parametro parametro)
        throws Exception {
        parametroLogic.validateParametro(parametro);
    }

    public List<ProcCoaching> getProcCoaching(Coach id) throws Exception {
        return procCoachingLogic.getProcCoaching(id);
    }

    public void saveProcCoaching(ProcCoaching entity) throws Exception {
        procCoachingLogic.saveProcCoaching(entity);
    }

    public void deleteProcCoaching(ProcCoaching entity)
        throws Exception {
        procCoachingLogic.deleteProcCoaching(entity);
    }

    public void updateProcCoaching(ProcCoaching entity)
        throws Exception {
        procCoachingLogic.updateProcCoaching(entity);
    }

    public ProcCoaching getProcCoaching(Long idProc)
        throws Exception {
        ProcCoaching procCoaching = null;

        try {
            procCoaching = procCoachingLogic.getProcCoaching(idProc);
        } catch (Exception e) {
            throw e;
        }

        return procCoaching;
    }

    public List<ProcCoaching> findByCriteriaInProcCoaching(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return procCoachingLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ProcCoaching> findPageProcCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return procCoachingLogic.findPageProcCoaching(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberProcCoaching() throws Exception {
        return procCoachingLogic.findTotalNumberProcCoaching();
    }

    public List<ProcCoachingDTO> getDataProcCoaching()
        throws Exception {
        return procCoachingLogic.getDataProcCoaching();
    }

    public void validateProcCoaching(ProcCoaching procCoaching)
        throws Exception {
        procCoachingLogic.validateProcCoaching(procCoaching);
    }

    public List<RegContable> getRegContable() throws Exception {
        return regContableLogic.getRegContable();
    }

    public void saveRegContable(RegContable entity) throws Exception {
        regContableLogic.saveRegContable(entity);
    }

    public void deleteRegContable(RegContable entity) throws Exception {
        regContableLogic.deleteRegContable(entity);
    }

    public void updateRegContable(RegContable entity) throws Exception {
        regContableLogic.updateRegContable(entity);
    }

    public RegContable getRegContable(Long idHis) throws Exception {
        RegContable regContable = null;

        try {
            regContable = regContableLogic.getRegContable(idHis);
        } catch (Exception e) {
            throw e;
        }

        return regContable;
    }

    public List<RegContable> findByCriteriaInRegContable(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return regContableLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<RegContable> findPageRegContable(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return regContableLogic.findPageRegContable(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRegContable() throws Exception {
        return regContableLogic.findTotalNumberRegContable();
    }

    public List<RegContableDTO> getDataRegContable() throws Exception {
        return regContableLogic.getDataRegContable();
    }

    public void validateRegContable(RegContable regContable)
        throws Exception {
        regContableLogic.validateRegContable(regContable);
    }

    public List<SesCoaching> getSesCoaching() throws Exception {
        return sesCoachingLogic.getSesCoaching();
    }

    public void saveSesCoaching(SesCoaching entity) throws Exception {
        sesCoachingLogic.saveSesCoaching(entity);
    }

    public void deleteSesCoaching(SesCoaching entity) throws Exception {
        sesCoachingLogic.deleteSesCoaching(entity);
    }

    public void updateSesCoaching(SesCoaching entity) throws Exception {
        sesCoachingLogic.updateSesCoaching(entity);
    }

    public SesCoaching getSesCoaching(Long idSesi) throws Exception {
        SesCoaching sesCoaching = null;

        try {
            sesCoaching = sesCoachingLogic.getSesCoaching(idSesi);
        } catch (Exception e) {
            throw e;
        }

        return sesCoaching;
    }

    public List<SesCoaching> findByCriteriaInSesCoaching(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return sesCoachingLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<SesCoaching> findPageSesCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return sesCoachingLogic.findPageSesCoaching(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSesCoaching() throws Exception {
        return sesCoachingLogic.findTotalNumberSesCoaching();
    }

    public List<SesCoachingDTO> getDataSesCoaching() throws Exception {
        return sesCoachingLogic.getDataSesCoaching();
    }

    public void validateSesCoaching(SesCoaching sesCoaching)
        throws Exception {
        sesCoachingLogic.validateSesCoaching(sesCoaching);
    }

    public List<TipoDocumento> getTipoDocumento() throws Exception {
        return tipoDocumentoLogic.getTipoDocumento();
    }

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.saveTipoDocumento(entity);
    }

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.deleteTipoDocumento(entity);
    }

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoLogic.updateTipoDocumento(entity);
    }

    public TipoDocumento getTipoDocumento(Long idDoc)
        throws Exception {
        TipoDocumento tipoDocumento = null;

        try {
            tipoDocumento = tipoDocumentoLogic.getTipoDocumento(idDoc);
        } catch (Exception e) {
            throw e;
        }

        return tipoDocumento;
    }

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoDocumentoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoDocumentoLogic.findPageTipoDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoDocumento() throws Exception {
        return tipoDocumentoLogic.findTotalNumberTipoDocumento();
    }

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        return tipoDocumentoLogic.getDataTipoDocumento();
    }

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception {
        tipoDocumentoLogic.validateTipoDocumento(tipoDocumento);
    }

    public List<TipoEstado> getTipoEstado() throws Exception {
        return tipoEstadoLogic.getTipoEstado();
    }

    public void saveTipoEstado(TipoEstado entity) throws Exception {
        tipoEstadoLogic.saveTipoEstado(entity);
    }

    public void deleteTipoEstado(TipoEstado entity) throws Exception {
        tipoEstadoLogic.deleteTipoEstado(entity);
    }

    public void updateTipoEstado(TipoEstado entity) throws Exception {
        tipoEstadoLogic.updateTipoEstado(entity);
    }

    public TipoEstado getTipoEstado(Long idTestado) throws Exception {
        TipoEstado tipoEstado = null;

        try {
            tipoEstado = tipoEstadoLogic.getTipoEstado(idTestado);
        } catch (Exception e) {
            throw e;
        }

        return tipoEstado;
    }

    public List<TipoEstado> findByCriteriaInTipoEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoEstadoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoEstado> findPageTipoEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoEstadoLogic.findPageTipoEstado(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoEstado() throws Exception {
        return tipoEstadoLogic.findTotalNumberTipoEstado();
    }

    public List<TipoEstadoDTO> getDataTipoEstado() throws Exception {
        return tipoEstadoLogic.getDataTipoEstado();
    }

    public void validateTipoEstado(TipoEstado tipoEstado)
        throws Exception {
        tipoEstadoLogic.validateTipoEstado(tipoEstado);
    }

	@Override
	public List<SesCoaching> sesionesHoy() {
		
		return sesCoachingLogic.sesionesHoy();
	}

	@Override
	public List<Coachee> clientesSesionesHoy() {
		
		return sesCoachingLogic.clientesSesionesHoy();
	}

	
	
	
	@Override
	public Estado getEstadoSesion(int idEstado) throws Exception {
		
		return estadoLogic.getEstadoSesion(idEstado);
	}
	

	public Coachee validarCredencialesCoachee(String user, String password) throws Exception{

		return coacheeLogic.validarCredenciales(user, password);
	}

	@Override
	public Coach validarCredencialesCoach(String login, String passwd) throws Exception {
		
		
		return coachLogic.validarCredencialesCoach(login, passwd);
	}

	@Override
	public Coachee consultarClienteByIdentificacion(String identificacion) {
	
		return coacheeLogic.consultarClienteByIdentificacion(identificacion);
	}
	
}
