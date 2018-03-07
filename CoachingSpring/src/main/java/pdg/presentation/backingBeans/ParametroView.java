package  pdg.presentation.backingBeans;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.io.Serializable;
import java.sql.*;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.RowEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  pdg.exceptions.*;
import pdg.modelo.*;
import pdg.modelo.dto.ParametroDTO;
import pdg.presentation.businessDelegate.*;
import pdg.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */
 

@ManagedBean
@ViewScoped
public class ParametroView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(ParametroView.class);
	
public ParametroView() {
super();
}
    private InputText txtNumero;
    private InputText txtTexto;
    private InputText txtTextoBlob;
    private InputText txtTextoClob;
    private InputText txtIdParam;
private CommandButton btnSave;
private CommandButton btnModify;
private CommandButton btnDelete;
private CommandButton btnClear;
private List<ParametroDTO> data;
private ParametroDTO selectedParametro;
private Parametro entity;
private boolean showDialog;
    
@ManagedProperty(value="#{BusinessDelegatorView}")
private IBusinessDelegatorView businessDelegatorView;


		
	public String action_new(){
		action_clear();
		selectedParametro = null;
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		
		entity = null;
		selectedParametro = null;
		
                    if(txtNumero != null){
			 txtNumero.setValue(null);
             txtNumero.setDisabled(true);
			}
                    if(txtTexto != null){
			 txtTexto.setValue(null);
             txtTexto.setDisabled(true);
			}
                    if(txtTextoBlob != null){
			 txtTextoBlob.setValue(null);
             txtTextoBlob.setDisabled(true);
			}
                    if(txtTextoClob != null){
			 txtTextoClob.setValue(null);
             txtTextoClob.setDisabled(true);
			}
                        			    if(txtIdParam != null){
				   txtIdParam.setValue(null);
				   txtIdParam.setDisabled(false);	
				}
                        if(btnSave != null){
		  btnSave.setDisabled(true);
		}
		if (btnDelete != null) {
        	btnDelete.setDisabled(true);
        }
        return "";
        }

										
	public void listener_txtId(){
    
	    try {
	    	        Double idParam = FacesUtils.checkDouble(txtIdParam);
	    	    	entity = idParam != null ? businessDelegatorView.getParametro(idParam) : null;
	    } catch (Exception e) {
	    	entity = null;
	    }
	    
		if(entity==null){
	    	        txtNumero.setDisabled(false);
	    	        txtTexto.setDisabled(false);
	    	        txtTextoBlob.setDisabled(false);
	    	        txtTextoClob.setDisabled(false);
	    	    	    	        txtIdParam.setDisabled(false);
	    	    		    btnSave.setDisabled(false);
		    }else{
		    		        txtNumero.setValue(entity.getNumero());txtNumero.setDisabled(false);
		    		        txtTexto.setValue(entity.getTexto());txtTexto.setDisabled(false);
		    		        txtTextoBlob.setValue(entity.getTextoBlob());txtTextoBlob.setDisabled(false);
		    		        txtTextoClob.setValue(entity.getTextoClob());txtTextoClob.setDisabled(false);
		    		    		        txtIdParam.setValue(entity.getIdParam());txtIdParam.setDisabled(true);
		    		    btnSave.setDisabled(false);
		    if(btnDelete!=null){
		    	btnDelete.setDisabled(false);
		    }
	    }
    }
        
	public String action_edit(ActionEvent evt){
    	
    	selectedParametro = (ParametroDTO)(evt.getComponent().getAttributes().get("selectedParametro"));		
            txtNumero.setValue(selectedParametro.getNumero());txtNumero.setDisabled(false);
            txtTexto.setValue(selectedParametro.getTexto());txtTexto.setDisabled(false);
            txtTextoBlob.setValue(selectedParametro.getTextoBlob());txtTextoBlob.setDisabled(false);
            txtTextoClob.setValue(selectedParametro.getTextoClob());txtTextoClob.setDisabled(false);
                txtIdParam.setValue(selectedParametro.getIdParam());txtIdParam.setDisabled(true);
            btnSave.setDisabled(false);
    	setShowDialog(true);

    	return "";
    }
    
    public String action_save(){    	
        try {        	
        	if(selectedParametro == null && entity==null){
        		action_create();
        	}else{
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
        	entity = new Parametro();

	    	        Double idParam = FacesUtils.checkDouble(txtIdParam);
	    
                                    	            		entity.setIdParam(idParam);
            	                                                        	            		entity.setNumero(FacesUtils.checkDouble(txtNumero));
            	                                            entity.setTexto(FacesUtils.checkString(txtTexto));
                                //entity.setTextoBlob(FacesUtils.check[B(txtTextoBlob));
                                entity.setTextoClob(FacesUtils.checkString(txtTextoClob));
                        	        businessDelegatorView.saveParametro(entity);
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
        	if(entity==null){
		    		        Double idParam = new Double(selectedParametro.getIdParam());
		    	    		entity = businessDelegatorView.getParametro(idParam);
    		}
    		
        	        	    		entity.setNumero(FacesUtils.checkDouble(txtNumero));
    	        	    		entity.setTexto(FacesUtils.checkString(txtTexto));
    	        	    		//entity.setTextoBlob(FacesUtils.check[B(txtTextoBlob));
    	        	    		entity.setTextoClob(FacesUtils.checkString(txtTextoClob));
    	    	        	        businessDelegatorView.updateParametro(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
		   data=null;
           FacesUtils.addErrorMessage(e.getMessage());
        }
        return "";
	}
	
	public String action_delete_datatable(ActionEvent evt){
		try{
        	selectedParametro = (ParametroDTO)(evt.getComponent().getAttributes().get("selectedParametro"));
    						Double idParam = new Double(selectedParametro.getIdParam());
						entity = businessDelegatorView.getParametro(idParam);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
	
	public String action_delete_master(){
		try{
					        Double idParam = FacesUtils.checkDouble(txtIdParam);
		    		    entity = businessDelegatorView.getParametro(idParam);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
    
	public void action_delete() throws Exception{
		try{
			businessDelegatorView.deleteParametro(entity);
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
            data= null;
		}catch(Exception e ){
			throw e;
		}  
	}	
	
    public String action_closeDialog(){
    	setShowDialog(false);
    	action_clear();    	
    	return "";
    }	
		
//        public String action_modifyWitDTO(Double idParam, Double numero, String texto, [B textoBlob, String textoClob) throws Exception {
//        try {
//        
//        	        	    		entity.setNumero(FacesUtils.checkDouble(numero));
//    	        	    		entity.setTexto(FacesUtils.checkString(texto));
//    	        	    		entity.setTextoBlob(FacesUtils.check[B(textoBlob));
//    	        	    		entity.setTextoClob(FacesUtils.checkString(textoClob));
//    	            businessDelegatorView.updateParametro(entity);
//		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
//        } catch (Exception e) {
//        //renderManager.getOnDemandRenderer("ParametroView").requestRender();
//        FacesUtils.addErrorMessage(e.getMessage());
//        throw e;
//        }
//        return "";
//        }
								
									
                                          
                                                                                            public InputText getTxtNumero() {
                                                return txtNumero;
                                                }
                                                public void setTxtNumero(InputText txtNumero) {
                                                this.txtNumero = txtNumero;
                                                }
                                                                                            public InputText getTxtTexto() {
                                                return txtTexto;
                                                }
                                                public void setTxtTexto(InputText txtTexto) {
                                                this.txtTexto = txtTexto;
                                                }
                                                                                            public InputText getTxtTextoBlob() {
                                                return txtTextoBlob;
                                                }
                                                public void setTxtTextoBlob(InputText txtTextoBlob) {
                                                this.txtTextoBlob = txtTextoBlob;
                                                }
                                                                                            public InputText getTxtTextoClob() {
                                                return txtTextoClob;
                                                }
                                                public void setTxtTextoClob(InputText txtTextoClob) {
                                                this.txtTextoClob = txtTextoClob;
                                                }
                                                                                                                                                                                    public InputText getTxtIdParam() {
                                                return txtIdParam;
                                                }
                                                public void setTxtIdParam(InputText txtIdParam) {
                                                this.txtIdParam = txtIdParam;
                                                }
                                                                                        											
																						public List<ParametroDTO> getData() {
												try{
													if(data==null){
													data = businessDelegatorView.getDataParametro();
													}	
												
												}catch(Exception e){
												 e.printStackTrace();
												}
												return data;
											}
																						public void setData(List<ParametroDTO> parametroDTO){
												this.data=parametroDTO;
											}
											
																						
											public ParametroDTO getSelectedParametro(){
												return selectedParametro;
											}
											
											public void setSelectedParametro (ParametroDTO parametro ){
												this.selectedParametro = parametro;
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

											public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
											this.businessDelegatorView = businessDelegatorView;
											}
											
											public boolean isShowDialog() {
												return showDialog;
											}
										
											public void setShowDialog(boolean showDialog) {
												this.showDialog = showDialog;
											}											
                                             
									}
