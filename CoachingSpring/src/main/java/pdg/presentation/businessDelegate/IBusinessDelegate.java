package pdg.presentation.businessDelegate;

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

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegate {
    public List<Categoria> getCategoria() throws Exception;

    public void saveCategoria(Categoria entity) throws Exception;

    public void deleteCategoria(Categoria entity) throws Exception;

    public void updateCategoria(Categoria entity) throws Exception;

    public Categoria getCategoria(Long idCat) throws Exception;

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;

    public void validateCategoria(Categoria categoria)
        throws Exception;

    public List<Coach> getCoach() throws Exception;

    public void saveCoach(Coach entity) throws Exception;

    public void deleteCoach(Coach entity) throws Exception;

    public void updateCoach(Coach entity) throws Exception;

    public Coach getCoach(Long idCoach) throws Exception;

    public List<Coach> findByCriteriaInCoach(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Coach> findPageCoach(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCoach() throws Exception;

    public List<CoachDTO> getDataCoach() throws Exception;

    public void validateCoach(Coach coach) throws Exception;

    public List<Coachee> getCoachee() throws Exception;

    public void saveCoachee(Coachee entity) throws Exception;

    public void deleteCoachee(Coachee entity) throws Exception;

    public void updateCoachee(Coachee entity) throws Exception;

    public Coachee getCoachee(Long idCoachee) throws Exception;

    public List<Coachee> findByCriteriaInCoachee(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Coachee> findPageCoachee(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCoachee() throws Exception;

    public List<CoacheeDTO> getDataCoachee() throws Exception;

    public void validateCoachee(Coachee coachee) throws Exception;

    public List<Estado> getEstado() throws Exception;

    public void saveEstado(Estado entity) throws Exception;

    public void deleteEstado(Estado entity) throws Exception;

    public void updateEstado(Estado entity) throws Exception;

    public Estado getEstado(Long idEstado) throws Exception;

    public List<Estado> findByCriteriaInEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Estado> findPageEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstado() throws Exception;

    public List<EstadoDTO> getDataEstado() throws Exception;

    public void validateEstado(Estado estado) throws Exception;

    public List<Parametro> getParametro() throws Exception;

    public void saveParametro(Parametro entity) throws Exception;

    public void deleteParametro(Parametro entity) throws Exception;

    public void updateParametro(Parametro entity) throws Exception;

    public Parametro getParametro(Long idParam) throws Exception;

    public List<Parametro> findByCriteriaInParametro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Parametro> findPageParametro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberParametro() throws Exception;

    public List<ParametroDTO> getDataParametro() throws Exception;

    public void validateParametro(Parametro parametro)
        throws Exception;

    public List<ProcCoaching> getProcCoaching(Coach id) throws Exception;

    public void saveProcCoaching(ProcCoaching entity) throws Exception;

    public void deleteProcCoaching(ProcCoaching entity)
        throws Exception;

    public void updateProcCoaching(ProcCoaching entity)
        throws Exception;

    public ProcCoaching getProcCoaching(Long idProc)
        throws Exception;

    public List<ProcCoaching> findByCriteriaInProcCoaching(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ProcCoaching> findPageProcCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProcCoaching() throws Exception;

    public List<ProcCoachingDTO> getDataProcCoaching()
        throws Exception;

    public void validateProcCoaching(ProcCoaching procCoaching)
        throws Exception;

    public List<RegContable> getRegContable() throws Exception;

    public void saveRegContable(RegContable entity) throws Exception;

    public void deleteRegContable(RegContable entity) throws Exception;

    public void updateRegContable(RegContable entity) throws Exception;

    public RegContable getRegContable(Long idHis) throws Exception;

    public List<RegContable> findByCriteriaInRegContable(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RegContable> findPageRegContable(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRegContable() throws Exception;

    public List<RegContableDTO> getDataRegContable() throws Exception;

    public void validateRegContable(RegContable regContable)
        throws Exception;

    public List<SesCoaching> getSesCoaching() throws Exception;

    public void saveSesCoaching(SesCoaching entity) throws Exception;

    public void deleteSesCoaching(SesCoaching entity) throws Exception;

    public void updateSesCoaching(SesCoaching entity) throws Exception;

    public SesCoaching getSesCoaching(Long idSesi) throws Exception;

    public List<SesCoaching> findByCriteriaInSesCoaching(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SesCoaching> findPageSesCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSesCoaching() throws Exception;

    public List<SesCoachingDTO> getDataSesCoaching() throws Exception;

    public void validateSesCoaching(SesCoaching sesCoaching)
        throws Exception;

    public List<TipoDocumento> getTipoDocumento() throws Exception;

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    public TipoDocumento getTipoDocumento(Long idDoc)
        throws Exception;

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;

    public List<TipoEstado> getTipoEstado() throws Exception;

    public void saveTipoEstado(TipoEstado entity) throws Exception;

    public void deleteTipoEstado(TipoEstado entity) throws Exception;

    public void updateTipoEstado(TipoEstado entity) throws Exception;

    public TipoEstado getTipoEstado(Long idTestado) throws Exception;

    public List<TipoEstado> findByCriteriaInTipoEstado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoEstado> findPageTipoEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoEstado() throws Exception;

    public List<TipoEstadoDTO> getDataTipoEstado() throws Exception;

    public void validateTipoEstado(TipoEstado tipoEstado)
        throws Exception;
    
    
    public List<SesCoaching> sesionesHoy();
	 
	 public List<Coachee> clientesSesionesHoy();
	 
	 public Estado getEstadoSesion(int idEstado) throws Exception ;

	  public Coachee validarCredencialesCoachee(String user,String password)throws Exception;
	    
	    public Coach validarCredencialesCoach(String login, String passwd)throws Exception;
	    
	    Coachee consultarClienteByIdentificacion(String identificacion);

}
