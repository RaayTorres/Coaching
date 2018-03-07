package pdg.presentation.view;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.TipoDocumentoDTO;

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
public class TipoDocumentoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoView.class);
    private InputText txtTdocNombre;
    private InputText txtIdDoc;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoDocumentoDTO> data;
    private TipoDocumentoDTO selectedTipoDocumento;
    private TipoDocumento entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegate businessDelegatorView;

    public TipoDocumentoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoDocumento = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoDocumento = null;

        if (txtTdocNombre != null) {
            txtTdocNombre.setValue(null);
            txtTdocNombre.setDisabled(true);
        }

        if (txtIdDoc != null) {
            txtIdDoc.setValue(null);
            txtIdDoc.setDisabled(false);
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
            Double idDoc = FacesUtils.checkDouble(txtIdDoc);
            entity = (idDoc != null)
                ? businessDelegatorView.getTipoDocumento(idDoc) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtTdocNombre.setDisabled(false);
            txtIdDoc.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtTdocNombre.setValue(entity.getTdocNombre());
            txtTdocNombre.setDisabled(false);
            txtIdDoc.setValue(entity.getIdDoc());
            txtIdDoc.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoDocumento"));
        txtTdocNombre.setValue(selectedTipoDocumento.getTdocNombre());
        txtTdocNombre.setDisabled(false);
        txtIdDoc.setValue(selectedTipoDocumento.getIdDoc());
        txtIdDoc.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoDocumento == null) && (entity == null)) {
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
            entity = new TipoDocumento();

            Double idDoc = FacesUtils.checkDouble(txtIdDoc);

            entity.setIdDoc(idDoc);
            entity.setTdocNombre(FacesUtils.checkString(txtTdocNombre));
            businessDelegatorView.saveTipoDocumento(entity);
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
                Double idDoc = new Double(selectedTipoDocumento.getIdDoc());
                entity = businessDelegatorView.getTipoDocumento(idDoc);
            }

            entity.setTdocNombre(FacesUtils.checkString(txtTdocNombre));
            businessDelegatorView.updateTipoDocumento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTipoDocumento"));

            Double idDoc = new Double(selectedTipoDocumento.getIdDoc());
            entity = businessDelegatorView.getTipoDocumento(idDoc);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Double idDoc = FacesUtils.checkDouble(txtIdDoc);
            entity = businessDelegatorView.getTipoDocumento(idDoc);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoDocumento(entity);
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

    public String action_modifyWitDTO(Double idDoc, String tdocNombre)
        throws Exception {
        try {
            entity.setTdocNombre(FacesUtils.checkString(tdocNombre));
            businessDelegatorView.updateTipoDocumento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoDocumentoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtTdocNombre() {
        return txtTdocNombre;
    }

    public void setTxtTdocNombre(InputText txtTdocNombre) {
        this.txtTdocNombre = txtTdocNombre;
    }

    public InputText getTxtIdDoc() {
        return txtIdDoc;
    }

    public void setTxtIdDoc(InputText txtIdDoc) {
        this.txtIdDoc = txtIdDoc;
    }

    public List<TipoDocumentoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoDocumento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoDocumentoDTO> tipoDocumentoDTO) {
        this.data = tipoDocumentoDTO;
    }

    public TipoDocumentoDTO getSelectedTipoDocumento() {
        return selectedTipoDocumento;
    }

    public void setSelectedTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.selectedTipoDocumento = tipoDocumento;
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
