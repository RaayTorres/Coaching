package pdg.presentation.view;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.ProcCoachingDTO;

import pdg.presentation.businessDelegate.*;

import pdg.utilities.*;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProcCoachingView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingView.class);
    private InputText txtIdTpago;
    private InputText txtIdCoach_Coach;
    private InputText txtIdCoachee_Coachee;
    private InputText txtIdHis_RegContable;
    private InputText txtIdProc;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProcCoachingDTO> data;
    private ProcCoachingDTO selectedProcCoaching;
    private ProcCoaching entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegate businessDelegatorView;

    public ProcCoachingView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedProcCoaching = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedProcCoaching = null;

        if (txtIdTpago != null) {
            txtIdTpago.setValue(null);
            txtIdTpago.setDisabled(true);
        }

        if (txtIdCoach_Coach != null) {
            txtIdCoach_Coach.setValue(null);
            txtIdCoach_Coach.setDisabled(true);
        }

        if (txtIdCoachee_Coachee != null) {
            txtIdCoachee_Coachee.setValue(null);
            txtIdCoachee_Coachee.setDisabled(true);
        }

        if (txtIdHis_RegContable != null) {
            txtIdHis_RegContable.setValue(null);
            txtIdHis_RegContable.setDisabled(true);
        }

        if (txtIdProc != null) {
            txtIdProc.setValue(null);
            txtIdProc.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Double idProc = FacesUtils.checkDouble(txtIdProc);
            entity = (idProc != null)
                ? businessDelegatorView.getProcCoaching(idProc) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdTpago.setDisabled(false);
            txtIdCoach_Coach.setDisabled(false);
            txtIdCoachee_Coachee.setDisabled(false);
            txtIdHis_RegContable.setDisabled(false);
            txtIdProc.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIdTpago.setValue(entity.getIdTpago());
            txtIdTpago.setDisabled(false);
            txtIdCoach_Coach.setValue(entity.getCoach().getIdCoach());
            txtIdCoach_Coach.setDisabled(false);
            txtIdCoachee_Coachee.setValue(entity.getCoachee().getIdCoachee());
            txtIdCoachee_Coachee.setDisabled(false);
            txtIdHis_RegContable.setValue(entity.getRegContable().getIdHis());
            txtIdHis_RegContable.setDisabled(false);
            txtIdProc.setValue(entity.getIdProc());
            txtIdProc.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedProcCoaching = (ProcCoachingDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedProcCoaching"));
        txtIdTpago.setValue(selectedProcCoaching.getIdTpago());
        txtIdTpago.setDisabled(false);
        txtIdCoach_Coach.setValue(selectedProcCoaching.getIdCoach_Coach());
        txtIdCoach_Coach.setDisabled(false);
        txtIdCoachee_Coachee.setValue(selectedProcCoaching.getIdCoachee_Coachee());
        txtIdCoachee_Coachee.setDisabled(false);
        txtIdHis_RegContable.setValue(selectedProcCoaching.getIdHis_RegContable());
        txtIdHis_RegContable.setDisabled(false);
        txtIdProc.setValue(selectedProcCoaching.getIdProc());
        txtIdProc.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedProcCoaching == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new ProcCoaching();

            Double idProc = FacesUtils.checkDouble(txtIdProc);

            entity.setIdProc(idProc);
            entity.setIdTpago(FacesUtils.checkDouble(txtIdTpago));
            entity.setCoach((FacesUtils.checkDouble(txtIdCoach_Coach) != null)
                ? businessDelegatorView.getCoach(FacesUtils.checkDouble(
                        txtIdCoach_Coach)) : null);
            entity.setCoachee((FacesUtils.checkDouble(txtIdCoachee_Coachee) != null)
                ? businessDelegatorView.getCoachee(FacesUtils.checkDouble(
                        txtIdCoachee_Coachee)) : null);
            entity.setRegContable((FacesUtils.checkDouble(txtIdHis_RegContable) != null)
                ? businessDelegatorView.getRegContable(FacesUtils.checkDouble(
                        txtIdHis_RegContable)) : null);
            businessDelegatorView.saveProcCoaching(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Double idProc = new Double(selectedProcCoaching.getIdProc());
                entity = businessDelegatorView.getProcCoaching(idProc);
            }

            entity.setIdTpago(FacesUtils.checkDouble(txtIdTpago));
            entity.setCoach((FacesUtils.checkDouble(txtIdCoach_Coach) != null)
                ? businessDelegatorView.getCoach(FacesUtils.checkDouble(
                        txtIdCoach_Coach)) : null);
            entity.setCoachee((FacesUtils.checkDouble(txtIdCoachee_Coachee) != null)
                ? businessDelegatorView.getCoachee(FacesUtils.checkDouble(
                        txtIdCoachee_Coachee)) : null);
            entity.setRegContable((FacesUtils.checkDouble(txtIdHis_RegContable) != null)
                ? businessDelegatorView.getRegContable(FacesUtils.checkDouble(
                        txtIdHis_RegContable)) : null);
            businessDelegatorView.updateProcCoaching(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedProcCoaching = (ProcCoachingDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedProcCoaching"));

            Double idProc = new Double(selectedProcCoaching.getIdProc());
            entity = businessDelegatorView.getProcCoaching(idProc);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Double idProc = FacesUtils.checkDouble(txtIdProc);
            entity = businessDelegatorView.getProcCoaching(idProc);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteProcCoaching(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(Double idProc, Double idTpago,
        Double idCoach_Coach, Double idCoachee_Coachee, Double idHis_RegContable)
        throws Exception {
        try {
            entity.setIdTpago(FacesUtils.checkDouble(idTpago));
            businessDelegatorView.updateProcCoaching(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProcCoachingView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdTpago() {
        return txtIdTpago;
    }

    public void setTxtIdTpago(InputText txtIdTpago) {
        this.txtIdTpago = txtIdTpago;
    }

    public InputText getTxtIdCoach_Coach() {
        return txtIdCoach_Coach;
    }

    public void setTxtIdCoach_Coach(InputText txtIdCoach_Coach) {
        this.txtIdCoach_Coach = txtIdCoach_Coach;
    }

    public InputText getTxtIdCoachee_Coachee() {
        return txtIdCoachee_Coachee;
    }

    public void setTxtIdCoachee_Coachee(InputText txtIdCoachee_Coachee) {
        this.txtIdCoachee_Coachee = txtIdCoachee_Coachee;
    }

    public InputText getTxtIdHis_RegContable() {
        return txtIdHis_RegContable;
    }

    public void setTxtIdHis_RegContable(InputText txtIdHis_RegContable) {
        this.txtIdHis_RegContable = txtIdHis_RegContable;
    }

    public InputText getTxtIdProc() {
        return txtIdProc;
    }

    public void setTxtIdProc(InputText txtIdProc) {
        this.txtIdProc = txtIdProc;
    }

    public List<ProcCoachingDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProcCoaching();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProcCoachingDTO> procCoachingDTO) {
        this.data = procCoachingDTO;
    }

    public ProcCoachingDTO getSelectedProcCoaching() {
        return selectedProcCoaching;
    }

    public void setSelectedProcCoaching(ProcCoachingDTO procCoaching) {
        this.selectedProcCoaching = procCoaching;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegate getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegate businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
