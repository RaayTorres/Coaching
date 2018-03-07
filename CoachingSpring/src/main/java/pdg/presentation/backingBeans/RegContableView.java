package pdg.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.RegContableDTO;

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
public class RegContableView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RegContableView.class);
    private InputText txtTipo;
    private InputText txtValor;
    private InputText txtIdCoachee_Coachee;
    private InputText txtIdHis;
    private Calendar txtFechaPago;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RegContableDTO> data;
    private RegContableDTO selectedRegContable;
    private RegContable entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RegContableView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRegContable = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRegContable = null;

        if (txtTipo != null) {
            txtTipo.setValue(null);
            txtTipo.setDisabled(true);
        }

        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
        }

        if (txtIdCoachee_Coachee != null) {
            txtIdCoachee_Coachee.setValue(null);
            txtIdCoachee_Coachee.setDisabled(true);
        }

        if (txtFechaPago != null) {
            txtFechaPago.setValue(null);
            txtFechaPago.setDisabled(true);
        }

        if (txtIdHis != null) {
            txtIdHis.setValue(null);
            txtIdHis.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaPago() {
        Date inputDate = (Date) txtFechaPago.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Double idHis = FacesUtils.checkDouble(txtIdHis);
            entity = (idHis != null)
                ? businessDelegatorView.getRegContable(idHis) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtTipo.setDisabled(false);
            txtValor.setDisabled(false);
            txtIdCoachee_Coachee.setDisabled(false);
            txtFechaPago.setDisabled(false);
            txtIdHis.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaPago.setValue(entity.getFechaPago());
            txtFechaPago.setDisabled(false);
            txtTipo.setValue(entity.getTipo());
            txtTipo.setDisabled(false);
            txtValor.setValue(entity.getValor());
            txtValor.setDisabled(false);
            txtIdCoachee_Coachee.setValue(entity.getCoachee().getIdCoachee());
            txtIdCoachee_Coachee.setDisabled(false);
            txtIdHis.setValue(entity.getIdHis());
            txtIdHis.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRegContable = (RegContableDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedRegContable"));
        txtFechaPago.setValue(selectedRegContable.getFechaPago());
        txtFechaPago.setDisabled(false);
        txtTipo.setValue(selectedRegContable.getTipo());
        txtTipo.setDisabled(false);
        txtValor.setValue(selectedRegContable.getValor());
        txtValor.setDisabled(false);
        txtIdCoachee_Coachee.setValue(selectedRegContable.getIdCoachee_Coachee());
        txtIdCoachee_Coachee.setDisabled(false);
        txtIdHis.setValue(selectedRegContable.getIdHis());
        txtIdHis.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRegContable == null) && (entity == null)) {
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
            entity = new RegContable();

            Double idHis = FacesUtils.checkDouble(txtIdHis);

            entity.setFechaPago(FacesUtils.checkDate(txtFechaPago));
            entity.setIdHis(idHis);
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setValor(FacesUtils.checkDouble(txtValor));
            entity.setCoachee((FacesUtils.checkDouble(txtIdCoachee_Coachee) != null)
                ? businessDelegatorView.getCoachee(FacesUtils.checkDouble(
                        txtIdCoachee_Coachee)) : null);
            businessDelegatorView.saveRegContable(entity);
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
                Double idHis = new Double(selectedRegContable.getIdHis());
                entity = businessDelegatorView.getRegContable(idHis);
            }

            entity.setFechaPago(FacesUtils.checkDate(txtFechaPago));
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setValor(FacesUtils.checkDouble(txtValor));
            entity.setCoachee((FacesUtils.checkDouble(txtIdCoachee_Coachee) != null)
                ? businessDelegatorView.getCoachee(FacesUtils.checkDouble(
                        txtIdCoachee_Coachee)) : null);
            businessDelegatorView.updateRegContable(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRegContable = (RegContableDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedRegContable"));

            Double idHis = new Double(selectedRegContable.getIdHis());
            entity = businessDelegatorView.getRegContable(idHis);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Double idHis = FacesUtils.checkDouble(txtIdHis);
            entity = businessDelegatorView.getRegContable(idHis);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRegContable(entity);
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

    public String action_modifyWitDTO(Date fechaPago, Double idHis,
        String tipo, Double valor, Double idCoachee_Coachee)
        throws Exception {
        try {
            entity.setFechaPago(FacesUtils.checkDate(fechaPago));
            entity.setTipo(FacesUtils.checkString(tipo));
            entity.setValor(FacesUtils.checkDouble(valor));
            businessDelegatorView.updateRegContable(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RegContableView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(InputText txtTipo) {
        this.txtTipo = txtTipo;
    }

    public InputText getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(InputText txtValor) {
        this.txtValor = txtValor;
    }

    public InputText getTxtIdCoachee_Coachee() {
        return txtIdCoachee_Coachee;
    }

    public void setTxtIdCoachee_Coachee(InputText txtIdCoachee_Coachee) {
        this.txtIdCoachee_Coachee = txtIdCoachee_Coachee;
    }

    public Calendar getTxtFechaPago() {
        return txtFechaPago;
    }

    public void setTxtFechaPago(Calendar txtFechaPago) {
        this.txtFechaPago = txtFechaPago;
    }

    public InputText getTxtIdHis() {
        return txtIdHis;
    }

    public void setTxtIdHis(InputText txtIdHis) {
        this.txtIdHis = txtIdHis;
    }

    public List<RegContableDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRegContable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RegContableDTO> regContableDTO) {
        this.data = regContableDTO;
    }

    public RegContableDTO getSelectedRegContable() {
        return selectedRegContable;
    }

    public void setSelectedRegContable(RegContableDTO regContable) {
        this.selectedRegContable = regContable;
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

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
