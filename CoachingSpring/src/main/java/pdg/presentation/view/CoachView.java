package pdg.presentation.view;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.model.DefaultStreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.util.concurrent.BusySpinIdleStrategy;

import pdg.exceptions.ZMessManager;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.dto.CoachDTO;
import pdg.presentation.businessDelegate.IBusinessDelegate;
import pdg.utilities.FacesUtils;



@ManagedBean
@ViewScoped
public class CoachView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CoachView.class);
    private InputText txtApellido;
    private InputText txtCelular;
    private InputText txtContrasena;
    private InputText txtCorreo;
    private InputText txtHoraPagada;
    private InputText txtHoraProbono;
    private InputText txtIdentificacion;
    private InputText txtLogin;
    private InputText txtNombre;
    private InputText txtTelefono;
    //private InputText txtIdCat_Categoria;
    //private InputText txtIdEstado_Estado;
    //private InputText txtIdDoc_TipoDocumento;
    //private InputText txtIdCoach;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CoachDTO> data;
    private CoachDTO selectedCoach;
    private Coach entity;
    private boolean showDialog;
    private String passwordCoach;
    private Password txtClave;
  

    
    
    
    
	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	public String getPasswordCoach() {
		return passwordCoach;
	}

	public Password getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(Password txtClave) {
		this.txtClave = txtClave;
	}

	public void setPasswordCoach(String passwordCoach) {
		this.passwordCoach = passwordCoach;
	}

	private DefaultStreamedContent filedownload;

    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegate businessDelegatorView;

    public CoachView() {
        super();
       // getEntity();
    	//this.txtApellido.setValue(entity.getApellido());
    }

//    public String action_new() {
//        action_clear();
//        selectedCoach = null;
//        setShowDialog(true);
//
//        return "";
//    }
//
//    public String action_clear() {
//        entity = null;
//        selectedCoach = null;
//
//        if (txtApellido != null) {
//         //   txtApellido.setValue(null);
//            txtApellido.setDisabled(true);
//        }
//
//        if (txtCelular != null) {
//            txtCelular.setValue(null);
//            txtCelular.setDisabled(true);
//        }
//
//        if (txtContrasena != null) {
//            txtContrasena.setValue(null);
//            txtContrasena.setDisabled(true);
//        }
//
//        if (txtCorreo != null) {
//            txtCorreo.setValue(null);
//            txtCorreo.setDisabled(true);
//        }
//
//     
//
//        if (txtLogin != null) {
//            txtLogin.setValue(null);
//            txtLogin.setDisabled(true);
//        }
//
//        if (txtNombre != null) {
//            txtNombre.setValue(null);
//            txtNombre.setDisabled(true);
//        }
//
//        if (txtTelefono != null) {
//            txtTelefono.setValue(null);
//            txtTelefono.setDisabled(true);
//        }
//
//     
//        if (btnSave != null) {
//            btnSave.setDisabled(true);
//        }
//
//        if (btnDelete != null) {
//            btnDelete.setDisabled(true);
//        }
//
//        return "";
//    }

    public String edit() {
//        
//getEntity();

     //  Coach entit=	(Coach) FacesUtils.getfromSession("coach");


//        if (entity == null) {
            txtApellido.setDisabled(false);
            txtCelular.setDisabled(false);
            txtContrasena.setDisabled(false);
            txtCorreo.setDisabled(false);
//          //  txtHoraPagada.setDisabled(false);
//           // txtHoraProbono.setDisabled(false);
//          //  txtIdentificacion.setDisabled(false);
            txtLogin.setDisabled(false);
            txtNombre.setDisabled(false);
            txtTelefono.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(true);
         //   btnClear.setDisabled(true);
//         //   txtIdCat_Categoria.setDisabled(false);
//         //   txtIdEstado_Estado.setDisabled(false);
//         //   txtIdDoc_TipoDocumento.setDisabled(false);
//         //   txtIdCoach.setDisabled(false);
//            btnSave.setDisabled(false);
//        } else {
          //  txtApellido.setValue(entit.getApellido());
          //  txtApellido.setDisabled(false);
        //    txtCelular.setValue(entit.getCelular());
          //  txtCelular.setDisabled(false);
       //     txtContrasena.setValue(entit.getContrasena());
         //   txtContrasena.setDisabled(false);
        //    txtCorreo.setValue(entit.getCorreo());
          //  txtCorreo.setDisabled(false);
           /// txtHoraPagada.setValue(entity.getHoraPagada());
         //   txtHoraPagada.setDisabled(false);
         //   txtHoraProbono.setValue(entity.getHoraProbono());
         //   txtHoraProbono.setDisabled(false);
           // txtIdentificacion.setValue(entity.getIdentificacion());
          //  txtIdentificacion.setDisabled(false);
         //   txtLogin.setValue(entit.getLogin());
        //    txtLogin.setDisabled(false);
        //    txtNombre.setValue(entit.getNombre());
         //   txtNombre.setDisabled(false);
         //   txtTelefono.setValue(entit.getTelefono());
          //  txtTelefono.setDisabled(false);
         //   txtIdCat_Categoria.setValue(entity.getCategoria().getIdCat());
           // txtIdCat_Categoria.setDisabled(false);
           // txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
         //   txtIdEstado_Estado.setDisabled(false);
          //  txtIdDoc_TipoDocumento.setValue(entity.getTipoDocumento().getIdDoc());
         //   txtIdDoc_TipoDocumento.setDisabled(false);
         //   txtIdCoach.setValue(entity.getIdCoach());
          //  txtIdCoach.setDisabled(true);
         //   btnSave.setDisabled(false);
//
////            if (btnDelete != null) {
////                btnDelete.setDisabled(false);
////            }
//        }
            return "";
    }

//    public String action_edit(ActionEvent evt) {
////        selectedCoach = (CoachDTO) (evt.getComponent().getAttributes()
////                                       .get("selectedCoach"));
////        txtApellido.setValue(selectedCoach.getApellido());
//        txtApellido.setDisabled(false);
//        txtCelular.setValue(selectedCoach.getCelular());
//        txtCelular.setDisabled(false);
//        txtContrasena.setValue(selectedCoach.getContrasena());
//        txtContrasena.setDisabled(false);
//        txtCorreo.setValue(selectedCoach.getCorreo());
//        txtCorreo.setDisabled(false);
//       // txtHoraPagada.setValue(selectedCoach.getHoraPagada());
//      //  txtHoraPagada.setDisabled(false);
//    //    txtHoraProbono.setValue(selectedCoach.getHoraProbono());
//      //  txtHoraProbono.setDisabled(false);
//      //  txtIdentificacion.setValue(selectedCoach.getIdentificacion());
//      //  txtIdentificacion.setDisabled(false);
//        txtLogin.setValue(selectedCoach.getLogin());
//        txtLogin.setDisabled(false);
//        txtNombre.setValue(selectedCoach.getNombre());
//        txtNombre.setDisabled(false);
//        txtTelefono.setValue(selectedCoach.getTelefono());
//        txtTelefono.setDisabled(false);
////        txtIdCat_Categoria.setValue(selectedCoach.getIdCat_Categoria());
////        txtIdCat_Categoria.setDisabled(false);
////        txtIdEstado_Estado.setValue(selectedCoach.getIdEstado_Estado());
////        txtIdEstado_Estado.setDisabled(false);
////        txtIdDoc_TipoDocumento.setValue(selectedCoach.getIdDoc_TipoDocumento());
////        txtIdDoc_TipoDocumento.setDisabled(false);
////        txtIdCoach.setValue(selectedCoach.getIdCoach());
////        txtIdCoach.setDisabled(true);
//        btnSave.setDisabled(false);
//        setShowDialog(true);
//
//        return "";
//    }

//    public String action_save() {
//        try {
//            if ((selectedCoach == null) && (entity == null)) {
//                action_create();
//            } else {
//                action_modify();
//            }
//
//            data = null;
//        } catch (Exception e) {
//            FacesUtils.addErrorMessage(e.getMessage());
//        }
//
//        return "";
//    }

//    public String action_create() {
//        try {
//            entity = new Coach();
//
//            Double idCoach = FacesUtils.checkDouble(txtIdCoach);
//
//            entity.setApellido(FacesUtils.checkString(txtApellido));
//            entity.setCelular(FacesUtils.checkDouble(txtCelular));
//            entity.setContrasena(FacesUtils.checkString(txtContrasena));
//            entity.setCorreo(FacesUtils.checkString(txtCorreo));
//            entity.setHoraPagada(FacesUtils.checkDouble(txtHoraPagada));
//            entity.setHoraProbono(FacesUtils.checkDouble(txtHoraProbono));
//            entity.setIdCoach(idCoach);
//            entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
//            entity.setLogin(FacesUtils.checkString(txtLogin));
//            entity.setNombre(FacesUtils.checkString(txtNombre));
//            entity.setTelefono(FacesUtils.checkDouble(txtTelefono));
//            entity.setCategoria((FacesUtils.checkDouble(txtIdCat_Categoria) != null)
//                ? businessDelegatorView.getCategoria(FacesUtils.checkDouble(
//                        txtIdCat_Categoria)) : null);
//            entity.setEstado((FacesUtils.checkDouble(txtIdEstado_Estado) != null)
//                ? businessDelegatorView.getEstado(FacesUtils.checkDouble(
//                        txtIdEstado_Estado)) : null);
//            entity.setTipoDocumento((FacesUtils.checkDouble(
//                    txtIdDoc_TipoDocumento) != null)
//                ? businessDelegatorView.getTipoDocumento(FacesUtils.checkDouble(
//                        txtIdDoc_TipoDocumento)) : null);
//            businessDelegatorView.saveCoach(entity);
//            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
//            action_clear();
//        } catch (Exception e) {
//            entity = null;
//            FacesUtils.addErrorMessage(e.getMessage());
//        }
//
//        return "";
//    }
//
    public String action_modify() {
        try {
          Coach enti=	(Coach) FacesUtils.getfromSession("coach");
//
//            txtApellido.setValue(entity.getApellido());
//           // txtApellido.setDisabled(false);
//            txtCelular.setValue(entity.getCelular());
//        //    txtCelular.setDisabled(false);
//            txtContrasena.setValue(entity.getContrasena());
//          //  txtContrasena.setDisabled(false);
//            txtCorreo.setValue(entity.getCorreo());
//        //    txtCorreo.setDisabled(false);
//           /// txtHoraPagada.setValue(entity.getHoraPagada());
//         //   txtHoraPagada.setDisabled(false);
//         //   txtHoraProbono.setValue(entity.getHoraProbono());
//         //   txtHoraProbono.setDisabled(false);
//           // txtIdentificacion.setValue(entity.getIdentificacion());
//          //  txtIdentificacion.setDisabled(false);
//            txtLogin.setValue(entity.getLogin());
//         //   txtLogin.setDisabled(false);
//            txtNombre.setValue(entity.getNombre());
//           // txtNombre.setDisabled(false);
//            txtTelefono.setValue(entity.getTelefono());
//         //   txtTelefono.setDisabled(false);

            entity.setApellido(FacesUtils.checkString(txtApellido));
            entity.setCelular(FacesUtils.checkString(txtCelular));
            entity.setContrasena(FacesUtils.checkString(txtContrasena));
            entity.setCorreo(FacesUtils.checkString(txtCorreo));
           entity.setLogin(FacesUtils.checkString(txtLogin));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setTelefono(FacesUtils.checkString(txtTelefono));
//            entity.setCategoria((FacesUtils.checkDouble(txtIdCat_Categoria) != null)
//                ? businessDelegatorView.getCategoria(FacesUtils.checkDouble(
//                        txtIdCat_Categoria)) : null);
//            entity.setEstado((FacesUtils.checkDouble(txtIdEstado_Estado) != null)
//                ? businessDelegatorView.getEstado(FacesUtils.checkDouble(
//                        txtIdEstado_Estado)) : null);
//            entity.setTipoDocumento((FacesUtils.checkDouble(
//                    txtIdDoc_TipoDocumento) != null)
//                ? businessDelegatorView.getTipoDocumento(FacesUtils.checkDouble(
//                        txtIdDoc_TipoDocumento)) : null);
            System.out.println("JOder tio");
            businessDelegatorView.updateCoach(entity);
            
            txtApellido.setDisabled(true);
            txtCelular.setDisabled(true);
            txtContrasena.setDisabled(true);
            txtCorreo.setDisabled(true);
//          //  txtHoraPagada.setDisabled(false);
//           // txtHoraProbono.setDisabled(false);
//          //  txtIdentificacion.setDisabled(false);
            txtLogin.setDisabled(true);
            txtNombre.setDisabled(true);
            txtTelefono.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
            
          FacesUtils.addInfoMessage("Se guardo con exito");
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }
//
//    public String action_delete_datatable(ActionEvent evt) {
//        try {
//            selectedCoach = (CoachDTO) (evt.getComponent().getAttributes()
//                                           .get("selectedCoach"));
//
//            Double idCoach = new Double(selectedCoach.getIdCoach());
//            entity = businessDelegatorView.getCoach(idCoach);
//            action_delete();
//        } catch (Exception e) {
//            FacesUtils.addErrorMessage(e.getMessage());
//        }
//
//        return "";
//    }
//
//    public String action_delete_master() {
//        try {
//            Double idCoach = FacesUtils.checkDouble(txtIdCoach);
//            entity = businessDelegatorView.getCoach(idCoach);
//            action_delete();
//        } catch (Exception e) {
//            FacesUtils.addErrorMessage(e.getMessage());
//        }
//
    
    
    

    
    
//        return "";
//    }
//
//    public void action_delete() throws Exception {
//        try {
//            businessDelegatorView.deleteCoach(entity);
//            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
//            action_clear();
//            data = null;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public String action_closeDialog() {
//        setShowDialog(false);
//        action_clear();
//
//        return "";
//    }
//
//    public String action_modifyWitDTO(String apellido, Double celular,
//        String contrasena, String correo, Double horaPagada,
//        Double horaProbono, Double idCoach, String identificacion,
//        String login, String nombre, Double telefono, Double idCat_Categoria,
//        Double idEstado_Estado, Double idDoc_TipoDocumento)
//        throws Exception {
//        try {
//            entity.setApellido(FacesUtils.checkString(apellido));
//            entity.setCelular(FacesUtils.checkDouble(celular));
//            entity.setContrasena(FacesUtils.checkString(contrasena));
//            entity.setCorreo(FacesUtils.checkString(correo));
//            entity.setHoraPagada(FacesUtils.checkDouble(horaPagada));
//            entity.setHoraProbono(FacesUtils.checkDouble(horaProbono));
//            entity.setIdentificacion(FacesUtils.checkString(identificacion));
//            entity.setLogin(FacesUtils.checkString(login));
//            entity.setNombre(FacesUtils.checkString(nombre));
//            entity.setTelefono(FacesUtils.checkDouble(telefono));
//            businessDelegatorView.updateCoach(entity);
//            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
//        } catch (Exception e) {
//            //renderManager.getOnDemandRenderer("CoachView").requestRender();
//            FacesUtils.addErrorMessage(e.getMessage());
//            throw e;
//        }
//
//        return "";
//    }
    
    

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public Coach getEntity() {
    	entity=	(Coach) FacesUtils.getfromSession("coach");

		return entity;
	}

	public void setEntity(Coach entity) {
		this.entity = entity;
	}

	public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(InputText txtCelular) {
        this.txtCelular = txtCelular;
    }

    public InputText getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(InputText txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

//    public InputText getTxtHoraPagada() {
//        return txtHoraPagada;
//    }
//
//    public void setTxtHoraPagada(InputText txtHoraPagada) {
//        this.txtHoraPagada = txtHoraPagada;
//    }
//
//    public InputText getTxtHoraProbono() {
//        return txtHoraProbono;
//    }
//
//    public void setTxtHoraProbono(InputText txtHoraProbono) {
//        this.txtHoraProbono = txtHoraProbono;
//    }
//
//    public InputText getTxtIdentificacion() {
//        return txtIdentificacion;
//    }
//
//    public void setTxtIdentificacion(InputText txtIdentificacion) {
//        this.txtIdentificacion = txtIdentificacion;
//    }

    public InputText getTxtLogin() {
        return txtLogin;
    }

    public void setTxtLogin(InputText txtLogin) {
        this.txtLogin = txtLogin;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

//    public InputText getTxtIdCat_Categoria() {
//        return txtIdCat_Categoria;
//    }
//
//    public void setTxtIdCat_Categoria(InputText txtIdCat_Categoria) {
//        this.txtIdCat_Categoria = txtIdCat_Categoria;
//    }
//
//    public InputText getTxtIdEstado_Estado() {
//        return txtIdEstado_Estado;
//    }
//
//    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
//        this.txtIdEstado_Estado = txtIdEstado_Estado;
//    }
//
//    public InputText getTxtIdDoc_TipoDocumento() {
//        return txtIdDoc_TipoDocumento;
//    }
//
//    public void setTxtIdDoc_TipoDocumento(InputText txtIdDoc_TipoDocumento) {
//        this.txtIdDoc_TipoDocumento = txtIdDoc_TipoDocumento;
//    }
//
//    public InputText getTxtIdCoach() {
//        return txtIdCoach;
//    }
//
//    public void setTxtIdCoach(InputText txtIdCoach) {
//        this.txtIdCoach = txtIdCoach;
//    }

    public List<CoachDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCoach();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CoachDTO> coachDTO) {
        this.data = coachDTO;
    }

    public CoachDTO getSelectedCoach() {
        return selectedCoach;
    }

    public void setSelectedCoach(CoachDTO coach) {
        this.selectedCoach = coach;
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
    
    
    
//	public void upload(FileUploadEvent event) {
//
//		UploadedFile file = event.getFile();
//
//		try {
//
//			
//
//			if (file != null) {
//
//				byte[] arch = file.getContents();
//
//				Coachee ent= businessDelegatorView.getCoachee(3L);
//				ent.setFoto(arch);
//				
//				businessDelegatorView.updateCoachee(ent);
//				
//				
//				//saveRubricFileReport(miPlan.getIdEvalReport(), file.getFileName(),
//				//		miPlan2.getOutcomeCycleA().getOutcome().getCriterion() + "Assessment Evaluation Report", arch);
//				FacesUtils.addInfoMessage("file loaded");
//			}
//
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//			FacesUtils.addErrorMessage("", "upload failed");
//		}
//
//	}
//
//	private String getExtension(String name) {
//
//		StringBuilder builder = new StringBuilder(name);
//		String sCadenaInvertida = builder.reverse().toString();
//		String extension = "";
//
//		for (int i = 0; i < sCadenaInvertida.length(); i++) {
//
//			if (sCadenaInvertida.charAt(i) != '.') {
//				extension += sCadenaInvertida.charAt(i);
//			} else {
//				break;
//			}
//
//		}
//
//		StringBuilder builder2 = new StringBuilder(extension);
//		String sCadenaInvertida2 = builder2.reverse().toString();
//
//		return sCadenaInvertida2;
//	}
//
//    
//    
//	public DefaultStreamedContent getFiledownload() {
//		//EvalReport miPlan = getEvalReport();
//		try {
//
//			//businessDelegate.validateDownloadReport((miPlan.getIdEvalReport()));
//			//EvalReport plansito = businessDelegate.findByIdEvalReport(miPlan.getIdEvalReport());
//			//String nameFile = plansito.getRubricFile().getFileName();
//		//	byte[] arch = plansito.getRubricFile().getFileRaw();
//			//InputStream is = new ByteArrayInputStream(arch);
//
//		//	String extension = getExtension(nameFile);
//
//		//	DefaultStreamedContent nuevo = new DefaultStreamedContent(is, extension, nameFile);
//
//			//filedownload = nuevo;
//		} catch (Exception e) {
//			FacesUtils.addErrorMessage("", e.getMessage());
//		}
//
//		return filedownload;
//	}
    
    public String actionSave() {
    	System.out.println("Action coach save");
    	entity = new Coach();
    	 try {
			
    		 entity.setIdCoach(businessDelegatorView.genSecuenciaCoach());
    		 entity.setApellido(FacesUtils.checkString(txtApellido));
    		 entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
    		 String apeliido = txtApellido.getValue().toString();
             entity.setCelular(FacesUtils.checkString(txtCelular));
             entity.setContrasena(FacesUtils.checkString(txtContrasena));
             entity.setCorreo(FacesUtils.checkString(txtCorreo));
            entity.setLogin(FacesUtils.checkString(txtLogin));
             entity.setNombre(FacesUtils.checkString(txtNombre));
             entity.setTelefono(FacesUtils.checkString(txtTelefono));
            entity.setTipoDocumento(businessDelegatorView.getTipoDocumento(1L));
             //long horaPagada= Long.valueOf(txtHoraPagada.getValue().toString()).longValue();
             double horaPagada= Double.parseDouble(txtHoraPagada.getValue().toString());
             entity.setHoraPagada(horaPagada);
             double horaPro = Double.parseDouble(txtHoraProbono.getValue().toString());
             entity.setHoraProbono(horaPro);
             
             businessDelegatorView.saveCoach(entity);
    		 FacesUtils.addInfoMessage("Se guardo con exito");
		} catch (Exception e) {
			e.getMessage();
			FacesUtils.addErrorMessage("No se pudo realizar el registro" + " " + e.getMessage());
		}  
    	
    	return "";
    }
    
    public String volverAction() {
    	System.out.println("volver action");
    	
    	return "/login.xhtml";
    	
    }
    
}
