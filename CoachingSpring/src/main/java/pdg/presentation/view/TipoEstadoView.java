package pdg.presentation.view;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.TipoEstadoDTO;

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
public class TipoEstadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoEstadoView.class);
    private InputText txtNombreTipoEstado;
    private InputText txtIdTestado;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoEstadoDTO> data;
    private TipoEstadoDTO selectedTipoEstado;
    private TipoEstado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegate businessDelegatorView;

    public TipoEstadoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoEstado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoEstado = null;

        if (txtNombreTipoEstado != null) {
            txtNombreTipoEstado.setValue(null);
            txtNombreTipoEstado.setDisabled(true);
        }

        if (txtIdTestado != null) {
            txtIdTestado.setValue(null);
            txtIdTestado.setDisabled(false);
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
            Double idTestado = FacesUtils.checkDouble(txtIdTestado);
            entity = (idTestado != null)
                ? businessDelegatorView.getTipoEstado(idTestado) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoEstado.setDisabled(false);
            txtIdTestado.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoEstado.setValue(entity.getNombreTipoEstado());
            txtNombreTipoEstado.setDisabled(false);
            txtIdTestado.setValue(entity.getIdTestado());
            txtIdTestado.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoEstado = (TipoEstadoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedTipoEstado"));
        txtNombreTipoEstado.setValue(selectedTipoEstado.getNombreTipoEstado());
        txtNombreTipoEstado.setDisabled(false);
        txtIdTestado.setValue(selectedTipoEstado.getIdTestado());
        txtIdTestado.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoEstado == null) && (entity == null)) {
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
            entity = new TipoEstado();

            Double idTestado = FacesUtils.checkDouble(txtIdTestado);

            entity.setIdTestado(idTestado);
            entity.setNombreTipoEstado(FacesUtils.checkString(
                    txtNombreTipoEstado));
            businessDelegatorView.saveTipoEstado(entity);
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
                Double idTestado = new Double(selectedTipoEstado.getIdTestado());
                entity = businessDelegatorView.getTipoEstado(idTestado);
            }

            entity.setNombreTipoEstado(FacesUtils.checkString(
                    txtNombreTipoEstado));
            businessDelegatorView.updateTipoEstado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoEstado = (TipoEstadoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedTipoEstado"));

            Double idTestado = new Double(selectedTipoEstado.getIdTestado());
            entity = businessDelegatorView.getTipoEstado(idTestado);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Double idTestado = FacesUtils.checkDouble(txtIdTestado);
            entity = businessDelegatorView.getTipoEstado(idTestado);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoEstado(entity);
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

    public String action_modifyWitDTO(Double idTestado, String nombreTipoEstado)
        throws Exception {
        try {
            entity.setNombreTipoEstado(FacesUtils.checkString(nombreTipoEstado));
            businessDelegatorView.updateTipoEstado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoEstadoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoEstado() {
        return txtNombreTipoEstado;
    }

    public void setTxtNombreTipoEstado(InputText txtNombreTipoEstado) {
        this.txtNombreTipoEstado = txtNombreTipoEstado;
    }

    public InputText getTxtIdTestado() {
        return txtIdTestado;
    }

    public void setTxtIdTestado(InputText txtIdTestado) {
        this.txtIdTestado = txtIdTestado;
    }

    public List<TipoEstadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoEstado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoEstadoDTO> tipoEstadoDTO) {
        this.data = tipoEstadoDTO;
    }

    public TipoEstadoDTO getSelectedTipoEstado() {
        return selectedTipoEstado;
    }

    public void setSelectedTipoEstado(TipoEstadoDTO tipoEstado) {
        this.selectedTipoEstado = tipoEstado;
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
