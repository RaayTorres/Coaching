package  pdg.presentation.view;
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
import pdg.modelo.dto.CoacheeDTO;
import pdg.presentation.businessDelegate.*;
import pdg.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */


@ManagedBean
@ViewScoped
public class CoacheeView implements Serializable {

	//	private static final long serialVersionUID = 1L;
	//	
	//	private static final Logger log = LoggerFactory.getLogger(CoacheeView.class);
	//	
	//public CoacheeView() {
	//super();
	//}
	//    private InputText txtApellido;
	//    private InputText txtCelular;
	//    private InputText txtCorreo;
	//    private InputText txtDireccion;
	//    private InputText txtFoto;
	//    private InputText txtHobbies;
	//    private InputText txtIdentificacion;
	//    private InputText txtNombre;
	//    private InputText txtTelefono;
	//    private InputText txtIdEstado_Estado;
	//    private InputText txtIdDoc_TipoDocumento;
	//    private InputText txtIdCoachee;
	//private CommandButton btnSave;
	//private CommandButton btnModify;
	//private CommandButton btnDelete;
	//private CommandButton btnClear;
	//private List<CoacheeDTO> data;
	//private CoacheeDTO selectedCoachee;
	//private Coachee entity;
	//private boolean showDialog;
	//    
	//@ManagedProperty(value="#{BusinessDelegatorView}")
	//private IBusinessDelegate businessDelegatorView;
	//
	//
	//		
	//	public String action_new(){
	//		action_clear();
	//		selectedCoachee = null;
	//		setShowDialog(true);
	//		return "";
	//	}
	//
	//	public String action_clear() {
	//		
	//		entity = null;
	//		selectedCoachee = null;
	//		
	//                    if(txtApellido != null){
	//			 txtApellido.setValue(null);
	//             txtApellido.setDisabled(true);
	//			}
	//                    if(txtCelular != null){
	//			 txtCelular.setValue(null);
	//             txtCelular.setDisabled(true);
	//			}
	//                    if(txtCorreo != null){
	//			 txtCorreo.setValue(null);
	//             txtCorreo.setDisabled(true);
	//			}
	//                    if(txtDireccion != null){
	//			 txtDireccion.setValue(null);
	//             txtDireccion.setDisabled(true);
	//			}
	//                    if(txtFoto != null){
	//			 txtFoto.setValue(null);
	//             txtFoto.setDisabled(true);
	//			}
	//                    if(txtHobbies != null){
	//			 txtHobbies.setValue(null);
	//             txtHobbies.setDisabled(true);
	//			}
	//                    if(txtIdentificacion != null){
	//			 txtIdentificacion.setValue(null);
	//             txtIdentificacion.setDisabled(true);
	//			}
	//                    if(txtNombre != null){
	//			 txtNombre.setValue(null);
	//             txtNombre.setDisabled(true);
	//			}
	//                    if(txtTelefono != null){
	//			 txtTelefono.setValue(null);
	//             txtTelefono.setDisabled(true);
	//			}
	//                    if(txtIdEstado_Estado != null){
	//			 txtIdEstado_Estado.setValue(null);
	//             txtIdEstado_Estado.setDisabled(true);
	//			}
	//                    if(txtIdDoc_TipoDocumento != null){
	//			 txtIdDoc_TipoDocumento.setValue(null);
	//             txtIdDoc_TipoDocumento.setDisabled(true);
	//			}
	//                        			    if(txtIdCoachee != null){
	//				   txtIdCoachee.setValue(null);
	//				   txtIdCoachee.setDisabled(false);	
	//				}
	//                        if(btnSave != null){
	//		  btnSave.setDisabled(true);
	//		}
	//		if (btnDelete != null) {
	//        	btnDelete.setDisabled(true);
	//        }
	//        return "";
	//        }
	//
	//										
	//	public void listener_txtId(){
	//    
	//	    try {
	//	    	        Double idCoachee = FacesUtils.checkDouble(txtIdCoachee);
	//	    	    	entity = idCoachee != null ? businessDelegatorView.getCoachee(idCoachee) : null;
	//	    } catch (Exception e) {
	//	    	entity = null;
	//	    }
	//	    
	//		if(entity==null){
	//	    	        txtApellido.setDisabled(false);
	//	    	        txtCelular.setDisabled(false);
	//	    	        txtCorreo.setDisabled(false);
	//	    	        txtDireccion.setDisabled(false);
	//	    	        txtFoto.setDisabled(false);
	//	    	        txtHobbies.setDisabled(false);
	//	    	        txtIdentificacion.setDisabled(false);
	//	    	        txtNombre.setDisabled(false);
	//	    	        txtTelefono.setDisabled(false);
	//	    	        txtIdEstado_Estado.setDisabled(false);
	//	    	        txtIdDoc_TipoDocumento.setDisabled(false);
	//	    	    	    	        txtIdCoachee.setDisabled(false);
	//	    	    		    btnSave.setDisabled(false);
	//		    }else{
	//		    		        txtApellido.setValue(entity.getApellido());txtApellido.setDisabled(false);
	//		    		        txtCelular.setValue(entity.getCelular());txtCelular.setDisabled(false);
	//		    		        txtCorreo.setValue(entity.getCorreo());txtCorreo.setDisabled(false);
	//		    		        txtDireccion.setValue(entity.getDireccion());txtDireccion.setDisabled(false);
	//		    		        txtFoto.setValue(entity.getFoto());txtFoto.setDisabled(false);
	//		    		        txtHobbies.setValue(entity.getHobbies());txtHobbies.setDisabled(false);
	//		    		        txtIdentificacion.setValue(entity.getIdentificacion());txtIdentificacion.setDisabled(false);
	//		    		        txtNombre.setValue(entity.getNombre());txtNombre.setDisabled(false);
	//		    		        txtTelefono.setValue(entity.getTelefono());txtTelefono.setDisabled(false);
	//		    		        txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());txtIdEstado_Estado.setDisabled(false);
	//		    		        txtIdDoc_TipoDocumento.setValue(entity.getTipoDocumento().getIdDoc());txtIdDoc_TipoDocumento.setDisabled(false);
	//		    		    		        txtIdCoachee.setValue(entity.getIdCoachee());txtIdCoachee.setDisabled(true);
	//		    		    btnSave.setDisabled(false);
	//		    if(btnDelete!=null){
	//		    	btnDelete.setDisabled(false);
	//		    }
	//	    }
	//    }
	//        
	//	public String action_edit(ActionEvent evt){
	//    	
	//    	selectedCoachee = (CoacheeDTO)(evt.getComponent().getAttributes().get("selectedCoachee"));		
	//            txtApellido.setValue(selectedCoachee.getApellido());txtApellido.setDisabled(false);
	//            txtCelular.setValue(selectedCoachee.getCelular());txtCelular.setDisabled(false);
	//            txtCorreo.setValue(selectedCoachee.getCorreo());txtCorreo.setDisabled(false);
	//            txtDireccion.setValue(selectedCoachee.getDireccion());txtDireccion.setDisabled(false);
	//            txtFoto.setValue(selectedCoachee.getFoto());txtFoto.setDisabled(false);
	//            txtHobbies.setValue(selectedCoachee.getHobbies());txtHobbies.setDisabled(false);
	//            txtIdentificacion.setValue(selectedCoachee.getIdentificacion());txtIdentificacion.setDisabled(false);
	//            txtNombre.setValue(selectedCoachee.getNombre());txtNombre.setDisabled(false);
	//            txtTelefono.setValue(selectedCoachee.getTelefono());txtTelefono.setDisabled(false);
	//            txtIdEstado_Estado.setValue(selectedCoachee.getIdEstado_Estado());txtIdEstado_Estado.setDisabled(false);
	//            txtIdDoc_TipoDocumento.setValue(selectedCoachee.getIdDoc_TipoDocumento());txtIdDoc_TipoDocumento.setDisabled(false);
	//                txtIdCoachee.setValue(selectedCoachee.getIdCoachee());txtIdCoachee.setDisabled(true);
	//            btnSave.setDisabled(false);
	//    	setShowDialog(true);
	//
	//    	return "";
	//    }
	//    
	//    public String action_save(){    	
	//        try {        	
	//        	if(selectedCoachee == null && entity==null){
	//        		action_create();
	//        	}else{
	//        		action_modify();
	//        	}
	//        	data = null;
	//        } catch (Exception e) {
	//            FacesUtils.addErrorMessage(e.getMessage());
	//        }
	//
	//        return "";
	//    	
	//    }
	//    
	//    public String action_create() {
	//        try {
	//        	entity = new Coachee();
	//
	//	    	        Double idCoachee = FacesUtils.checkDouble(txtIdCoachee);
	//	    
	//                        entity.setApellido(FacesUtils.checkString(txtApellido));
	//                                            	            		entity.setCelular(FacesUtils.checkDouble(txtCelular));
	//            	                                            entity.setCorreo(FacesUtils.checkString(txtCorreo));
	//                                entity.setDireccion(FacesUtils.checkString(txtDireccion));
	//                               // entity.setFoto(FacesUtils.check[B(txtFoto));
	//                                entity.setHobbies(FacesUtils.checkString(txtHobbies));
	//                                            	            		entity.setIdCoachee(idCoachee);
	//            	                                            entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
	//                                entity.setNombre(FacesUtils.checkString(txtNombre));
	//                                            	            		entity.setTelefono(FacesUtils.checkDouble(txtTelefono));
	//            	                                        entity.setEstado(FacesUtils.checkDouble(txtIdEstado_Estado) != null ? businessDelegatorView.getEstado(FacesUtils.checkDouble(txtIdEstado_Estado)) : null );
	//            entity.setTipoDocumento(FacesUtils.checkDouble(txtIdDoc_TipoDocumento) != null ? businessDelegatorView.getTipoDocumento(FacesUtils.checkDouble(txtIdDoc_TipoDocumento)) : null );
	//        	        businessDelegatorView.saveCoachee(entity);
	//	        FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
	//			action_clear();
	//        } catch (Exception e) {
	//        	entity = null;
	//        	FacesUtils.addErrorMessage(e.getMessage());
	//        }
	//        return "";
	//    }
	//		
	//	public String action_modify() {
	//        try {
	//        	if(entity==null){
	//		    		        Double idCoachee = new Double(selectedCoachee.getIdCoachee());
	//		    	    		entity = businessDelegatorView.getCoachee(idCoachee);
	//    		}
	//    		
	//        	    		entity.setApellido(FacesUtils.checkString(txtApellido));
	//    	        	    		entity.setCelular(FacesUtils.checkDouble(txtCelular));
	//    	        	    		entity.setCorreo(FacesUtils.checkString(txtCorreo));
	//    	        	    		entity.setDireccion(FacesUtils.checkString(txtDireccion));
	//    	        	    	//	entity.setFoto(FacesUtils.check[B(txtFoto));
	//    	        	    		entity.setHobbies(FacesUtils.checkString(txtHobbies));
	//    	        	        	    		entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
	//    	        	    		entity.setNombre(FacesUtils.checkString(txtNombre));
	//    	        	    		entity.setTelefono(FacesUtils.checkDouble(txtTelefono));
	//    	    	    	        entity.setEstado(FacesUtils.checkDouble(txtIdEstado_Estado) != null ? businessDelegatorView.getEstado(FacesUtils.checkDouble(txtIdEstado_Estado)) : null );
	//	    	        entity.setTipoDocumento(FacesUtils.checkDouble(txtIdDoc_TipoDocumento) != null ? businessDelegatorView.getTipoDocumento(FacesUtils.checkDouble(txtIdDoc_TipoDocumento)) : null );
	//	        	        businessDelegatorView.updateCoachee(entity);
	//			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
	//        } catch (Exception e) {
	//		   data=null;
	//           FacesUtils.addErrorMessage(e.getMessage());
	//        }
	//        return "";
	//	}
	//	
	//	public String action_delete_datatable(ActionEvent evt){
	//		try{
	//        	selectedCoachee = (CoacheeDTO)(evt.getComponent().getAttributes().get("selectedCoachee"));
	//    						Double idCoachee = new Double(selectedCoachee.getIdCoachee());
	//						entity = businessDelegatorView.getCoachee(idCoachee);
	//        	action_delete();
	//        }catch(Exception e ){
	//		 FacesUtils.addErrorMessage(e.getMessage());
	//		}    
	//        return "";
	//    }
	//	
	//	public String action_delete_master(){
	//		try{
	//					        Double idCoachee = FacesUtils.checkDouble(txtIdCoachee);
	//		    		    entity = businessDelegatorView.getCoachee(idCoachee);
	//        	action_delete();
	//        }catch(Exception e ){
	//		 FacesUtils.addErrorMessage(e.getMessage());
	//		}    
	//        return "";
	//    }
	//    
	//	public void action_delete() throws Exception{
	//		try{
	//			businessDelegatorView.deleteCoachee(entity);
	//    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
	//			action_clear();
	//            data= null;
	//		}catch(Exception e ){
	//			throw e;
	//		}  
	//	}	
	//	
	//    public String action_closeDialog(){
	//    	setShowDialog(false);
	//    	action_clear();    	
	//    	return "";
	//    }	
	//		
	////        public String action_modifyWitDTO(String apellido, Double celular, String correo, String direccion, [B foto, String hobbies, Double idCoachee, String identificacion, String nombre, Double telefono, Double idEstado_Estado, Double idDoc_TipoDocumento) throws Exception {
	////        try {
	////        
	////        	    		entity.setApellido(FacesUtils.checkString(apellido));
	////    	        	    		entity.setCelular(FacesUtils.checkDouble(celular));
	////    	        	    		entity.setCorreo(FacesUtils.checkString(correo));
	////    	        	    		entity.setDireccion(FacesUtils.checkString(direccion));
	////    	        	    		entity.setFoto(FacesUtils.check[B(foto));
	////    	        	    		entity.setHobbies(FacesUtils.checkString(hobbies));
	////    	        	        	    		entity.setIdentificacion(FacesUtils.checkString(identificacion));
	////    	        	    		entity.setNombre(FacesUtils.checkString(nombre));
	////    	        	    		entity.setTelefono(FacesUtils.checkDouble(telefono));
	////    	            businessDelegatorView.updateCoachee(entity);
	////		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
	////        } catch (Exception e) {
	////        //renderManager.getOnDemandRenderer("CoacheeView").requestRender();
	////        FacesUtils.addErrorMessage(e.getMessage());
	////        throw e;
	////        }
	////        return "";
	////        }
	//								
	//									
	//                                          
	//                                                                                            public InputText getTxtApellido() {
	//                                                return txtApellido;
	//                                                }
	//                                                public void setTxtApellido(InputText txtApellido) {
	//                                                this.txtApellido = txtApellido;
	//                                                }
	//                                                                                            public InputText getTxtCelular() {
	//                                                return txtCelular;
	//                                                }
	//                                                public void setTxtCelular(InputText txtCelular) {
	//                                                this.txtCelular = txtCelular;
	//                                                }
	//                                                                                            public InputText getTxtCorreo() {
	//                                                return txtCorreo;
	//                                                }
	//                                                public void setTxtCorreo(InputText txtCorreo) {
	//                                                this.txtCorreo = txtCorreo;
	//                                                }
	//                                                                                            public InputText getTxtDireccion() {
	//                                                return txtDireccion;
	//                                                }
	//                                                public void setTxtDireccion(InputText txtDireccion) {
	//                                                this.txtDireccion = txtDireccion;
	//                                                }
	//                                                                                            public InputText getTxtFoto() {
	//                                                return txtFoto;
	//                                                }
	//                                                public void setTxtFoto(InputText txtFoto) {
	//                                                this.txtFoto = txtFoto;
	//                                                }
	//                                                                                            public InputText getTxtHobbies() {
	//                                                return txtHobbies;
	//                                                }
	//                                                public void setTxtHobbies(InputText txtHobbies) {
	//                                                this.txtHobbies = txtHobbies;
	//                                                }
	//                                                                                            public InputText getTxtIdentificacion() {
	//                                                return txtIdentificacion;
	//                                                }
	//                                                public void setTxtIdentificacion(InputText txtIdentificacion) {
	//                                                this.txtIdentificacion = txtIdentificacion;
	//                                                }
	//                                                                                            public InputText getTxtNombre() {
	//                                                return txtNombre;
	//                                                }
	//                                                public void setTxtNombre(InputText txtNombre) {
	//                                                this.txtNombre = txtNombre;
	//                                                }
	//                                                                                            public InputText getTxtTelefono() {
	//                                                return txtTelefono;
	//                                                }
	//                                                public void setTxtTelefono(InputText txtTelefono) {
	//                                                this.txtTelefono = txtTelefono;
	//                                                }
	//                                                                                            public InputText getTxtIdEstado_Estado() {
	//                                                return txtIdEstado_Estado;
	//                                                }
	//                                                public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
	//                                                this.txtIdEstado_Estado = txtIdEstado_Estado;
	//                                                }
	//                                                                                            public InputText getTxtIdDoc_TipoDocumento() {
	//                                                return txtIdDoc_TipoDocumento;
	//                                                }
	//                                                public void setTxtIdDoc_TipoDocumento(InputText txtIdDoc_TipoDocumento) {
	//                                                this.txtIdDoc_TipoDocumento = txtIdDoc_TipoDocumento;
	//                                                }
	//                                                                                                                                                                                    public InputText getTxtIdCoachee() {
	//                                                return txtIdCoachee;
	//                                                }
	//                                                public void setTxtIdCoachee(InputText txtIdCoachee) {
	//                                                this.txtIdCoachee = txtIdCoachee;
	//                                                }
	//                                                                                        											
	//																						public List<CoacheeDTO> getData() {
	//												try{
	//													if(data==null){
	//													data = businessDelegatorView.getDataCoachee();
	//													}	
	//												
	//												}catch(Exception e){
	//												 e.printStackTrace();
	//												}
	//												return data;
	//											}
	//																						public void setData(List<CoacheeDTO> coacheeDTO){
	//												this.data=coacheeDTO;
	//											}
	//											
	//																						
	//											public CoacheeDTO getSelectedCoachee(){
	//												return selectedCoachee;
	//											}
	//											
	//											public void setSelectedCoachee (CoacheeDTO coachee ){
	//												this.selectedCoachee = coachee;
	//											}
	//											
	//											
	//                                            public CommandButton getBtnSave() {
	//                                            return btnSave;
	//                                            }
	//                                            public void setBtnSave(CommandButton btnSave) {
	//                                            this.btnSave = btnSave;
	//                                            }
	//                                            public CommandButton getBtnModify() {
	//                                            return btnModify;
	//                                            }
	//                                            public void setBtnModify(CommandButton btnModify) {
	//                                            this.btnModify = btnModify;
	//                                            }
	//                                            public CommandButton getBtnDelete() {
	//                                            return btnDelete;
	//                                            }
	//                                            public void setBtnDelete(CommandButton btnDelete) {
	//                                            this.btnDelete = btnDelete;
	//                                            }
	//                                            public CommandButton getBtnClear() {
	//                                            return btnClear;
	//                                            }
	//                                            public void setBtnClear(CommandButton btnClear) {
	//                                            this.btnClear = btnClear;
	//                                            }
	//                                            
	//                                            public TimeZone getTimeZone() {
	//                                             return java.util.TimeZone.getDefault();
	//                                             }
	//																							
	//											 public IBusinessDelegate getBusinessDelegatorView() {
	//											 return businessDelegatorView;
	//											 }
	//
	//											public void setBusinessDelegatorView(IBusinessDelegate businessDelegatorView) {
	//											this.businessDelegatorView = businessDelegatorView;
	//											}
	//											
	//											public boolean isShowDialog() {
	//												return showDialog;
	//											}
	//										
	//											public void setShowDialog(boolean showDialog) {
	//												this.showDialog = showDialog;
	//											}											
	//                                             
}
