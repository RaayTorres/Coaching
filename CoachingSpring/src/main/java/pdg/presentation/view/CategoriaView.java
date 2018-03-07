package pdg.presentation.view;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.CategoriaDTO;

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
public class CategoriaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CategoriaView.class);
    private InputText txtCatNombre;
    private InputText txtHoraPagada;
    private InputText txtHoraProbono;
    private InputText txtNombreCorto;
    private InputText txtIdCat;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CategoriaDTO> data;
    private CategoriaDTO selectedCategoria;
    private Categoria entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegate businessDelegatorView;

    public CategoriaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCategoria = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCategoria = null;

        if (txtCatNombre != null) {
            txtCatNombre.setValue(null);
            txtCatNombre.setDisabled(true);
        }

        if (txtHoraPagada != null) {
            txtHoraPagada.setValue(null);
            txtHoraPagada.setDisabled(true);
        }

        if (txtHoraProbono != null) {
            txtHoraProbono.setValue(null);
            txtHoraProbono.setDisabled(true);
        }

        if (txtNombreCorto != null) {
            txtNombreCorto.setValue(null);
            txtNombreCorto.setDisabled(true);
        }

        if (txtIdCat != null) {
            txtIdCat.setValue(null);
            txtIdCat.setDisabled(false);
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
            Double idCat = FacesUtils.checkDouble(txtIdCat);
            entity = (idCat != null)
                ? businessDelegatorView.getCategoria(idCat) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCatNombre.setDisabled(false);
            txtHoraPagada.setDisabled(false);
            txtHoraProbono.setDisabled(false);
            txtNombreCorto.setDisabled(false);
            txtIdCat.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCatNombre.setValue(entity.getCatNombre());
            txtCatNombre.setDisabled(false);
            txtHoraPagada.setValue(entity.getHoraPagada());
            txtHoraPagada.setDisabled(false);
            txtHoraProbono.setValue(entity.getHoraProbono());
            txtHoraProbono.setDisabled(false);
            txtNombreCorto.setValue(entity.getNombreCorto());
            txtNombreCorto.setDisabled(false);
            txtIdCat.setValue(entity.getIdCat());
            txtIdCat.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCategoria = (CategoriaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedCategoria"));
        txtCatNombre.setValue(selectedCategoria.getCatNombre());
        txtCatNombre.setDisabled(false);
        txtHoraPagada.setValue(selectedCategoria.getHoraPagada());
        txtHoraPagada.setDisabled(false);
        txtHoraProbono.setValue(selectedCategoria.getHoraProbono());
        txtHoraProbono.setDisabled(false);
        txtNombreCorto.setValue(selectedCategoria.getNombreCorto());
        txtNombreCorto.setDisabled(false);
        txtIdCat.setValue(selectedCategoria.getIdCat());
        txtIdCat.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCategoria == null) && (entity == null)) {
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
            entity = new Categoria();

            Double idCat = FacesUtils.checkDouble(txtIdCat);

            entity.setCatNombre(FacesUtils.checkString(txtCatNombre));
            entity.setHoraPagada(FacesUtils.checkDouble(txtHoraPagada));
            entity.setHoraProbono(FacesUtils.checkDouble(txtHoraProbono));
            entity.setIdCat(idCat);
            entity.setNombreCorto(FacesUtils.checkString(txtNombreCorto));
            businessDelegatorView.saveCategoria(entity);
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
                Double idCat = new Double(selectedCategoria.getIdCat());
                entity = businessDelegatorView.getCategoria(idCat);
            }

            entity.setCatNombre(FacesUtils.checkString(txtCatNombre));
            entity.setHoraPagada(FacesUtils.checkDouble(txtHoraPagada));
            entity.setHoraProbono(FacesUtils.checkDouble(txtHoraProbono));
            entity.setNombreCorto(FacesUtils.checkString(txtNombreCorto));
            businessDelegatorView.updateCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCategoria = (CategoriaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedCategoria"));

            Double idCat = new Double(selectedCategoria.getIdCat());
            entity = businessDelegatorView.getCategoria(idCat);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Double idCat = FacesUtils.checkDouble(txtIdCat);
            entity = businessDelegatorView.getCategoria(idCat);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCategoria(entity);
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

    public String action_modifyWitDTO(String catNombre, Double horaPagada,
        Double horaProbono, Double idCat, String nombreCorto)
        throws Exception {
        try {
            entity.setCatNombre(FacesUtils.checkString(catNombre));
            entity.setHoraPagada(FacesUtils.checkDouble(horaPagada));
            entity.setHoraProbono(FacesUtils.checkDouble(horaProbono));
            entity.setNombreCorto(FacesUtils.checkString(nombreCorto));
            businessDelegatorView.updateCategoria(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CategoriaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCatNombre() {
        return txtCatNombre;
    }

    public void setTxtCatNombre(InputText txtCatNombre) {
        this.txtCatNombre = txtCatNombre;
    }

    public InputText getTxtHoraPagada() {
        return txtHoraPagada;
    }

    public void setTxtHoraPagada(InputText txtHoraPagada) {
        this.txtHoraPagada = txtHoraPagada;
    }

    public InputText getTxtHoraProbono() {
        return txtHoraProbono;
    }

    public void setTxtHoraProbono(InputText txtHoraProbono) {
        this.txtHoraProbono = txtHoraProbono;
    }

    public InputText getTxtNombreCorto() {
        return txtNombreCorto;
    }

    public void setTxtNombreCorto(InputText txtNombreCorto) {
        this.txtNombreCorto = txtNombreCorto;
    }

    public InputText getTxtIdCat() {
        return txtIdCat;
    }

    public void setTxtIdCat(InputText txtIdCat) {
        this.txtIdCat = txtIdCat;
    }

    public List<CategoriaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCategoria();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CategoriaDTO> categoriaDTO) {
        this.data = categoriaDTO;
    }

    public CategoriaDTO getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(CategoriaDTO categoria) {
        this.selectedCategoria = categoria;
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
