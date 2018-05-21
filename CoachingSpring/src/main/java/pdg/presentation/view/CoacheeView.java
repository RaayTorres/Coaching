package  pdg.presentation.view;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.annotation.RequestScope;

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
@RequestScoped
public class CoacheeView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(CoacheeView.class);

	public CoacheeView() {
		super();
	}
	private InputText txtApellido;
	private InputText txtCelular;
	private InputText txtCorreo;
	private InputText txtDireccion;
	private InputText txtFoto;
	private InputText txtHobbies;
	private InputText txtIdentificacion;
	private InputText txtNombre;
	private InputText txtTelefono;
	private InputText txtIdEstado_Estado;
	private InputText txtIdDoc_TipoDocumento;
	private InputText txtIdCoachee;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CoacheeDTO> data;
	private CoacheeDTO selectedCoachee;
	private Coachee entity;
	private boolean showDialog;

	private CommandButton btnRedirigir;
	private CommandButton  btnRedirigirMas;

	private SelectOneMenu somTipoUsuario;
	private List<SelectItem> losTipoUsuarioItem;


	//private Image img;

	private List<SesCoaching> sesHoy;
	private List<Coachee> clientesHoy;

	List <StreamedContent> imageFromDB;


	private DefaultStreamedContent filedownload;

	private DefaultStreamedContent imgVerMas;

	@ManagedProperty(value="#{BusinessDelegatorView}")
	private IBusinessDelegate businessDelegatorView;



	public InputText getTxtApellido() {
		return txtApellido;
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
	public InputText getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(InputText txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	public InputText getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public InputText getTxtFoto() {
		return txtFoto;
	}
	public void setTxtFoto(InputText txtFoto) {
		this.txtFoto = txtFoto;
	}
	public InputText getTxtHobbies() {
		return txtHobbies;
	}
	public void setTxtHobbies(InputText txtHobbies) {
		this.txtHobbies = txtHobbies;
	}
	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}
	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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
	public InputText getTxtIdEstado_Estado() {
		return txtIdEstado_Estado;
	}
	public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
		this.txtIdEstado_Estado = txtIdEstado_Estado;
	}
	public InputText getTxtIdDoc_TipoDocumento() {
		return txtIdDoc_TipoDocumento;
	}
	public void setTxtIdDoc_TipoDocumento(InputText txtIdDoc_TipoDocumento) {
		this.txtIdDoc_TipoDocumento = txtIdDoc_TipoDocumento;
	}
	public InputText getTxtIdCoachee() {
		return txtIdCoachee;
	}
	public void setTxtIdCoachee(InputText txtIdCoachee) {
		this.txtIdCoachee = txtIdCoachee;
	}

	public List<CoacheeDTO> getData() {
		try{
			if(data==null){

				data = businessDelegatorView.getDataCoachee();


			}	

		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
	public void setData(List<CoacheeDTO> coacheeDTO){
		this.data=coacheeDTO;
	}


	public CoacheeDTO getSelectedCoachee(){
		return selectedCoachee;
	}

	public void setSelectedCoachee (CoacheeDTO coachee ){
		this.selectedCoachee = coachee;
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

	public void setBusinessDelegatorView(IBusinessDelegate businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}											


	public void setFiledownload(DefaultStreamedContent filedownload) {
		this.filedownload = filedownload;
	}

	public void upload(FileUploadEvent event) {

		UploadedFile file = event.getFile();

		try {



			if (file != null) {

				byte[] arch = file.getContents();

				Coachee ent= businessDelegatorView.getCoachee(9L);
				//	Coachee ent= businessDelegatorView.getCoachee(10L);
				//	Coachee ent= businessDelegatorView.getCoachee(1L);
				//	Coachee ent= businessDelegatorView.getCoachee(6L);
				//	Coachee ent= businessDelegatorView.getCoachee(7L);
				//		Coachee ent= businessDelegatorView.getCoachee(8L);
				ent.setFoto(arch);

				businessDelegatorView.updateCoachee(ent);


				//saveRubricFileReport(miPlan.getIdEvalReport(), file.getFileName(),
				//		miPlan2.getOutcomeCycleA().getOutcome().getCriterion() + "Assessment Evaluation Report", arch);
				FacesUtils.addInfoMessage("file loaded");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage("", "upload failed");
		}

	}

	private String getExtension(String name) {

		StringBuilder builder = new StringBuilder(name);
		String sCadenaInvertida = builder.reverse().toString();
		String extension = "";

		for (int i = 0; i < sCadenaInvertida.length(); i++) {

			if (sCadenaInvertida.charAt(i) != '.') {
				extension += sCadenaInvertida.charAt(i);
			} else {
				break;
			}

		}

		StringBuilder builder2 = new StringBuilder(extension);
		String sCadenaInvertida2 = builder2.reverse().toString();

		return sCadenaInvertida2;
	}



	public DefaultStreamedContent getFiledownload() {
		//EvalReport miPlan = getEvalReport();
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			}else {
				//businessDelegate.validateDownloadReport((miPlan.getIdEvalReport()));
				//EvalReport plansito = businessDelegate.findByIdEvalReport(miPlan.getIdEvalReport());
				String id = context.getExternalContext().getRequestParameterMap()
						.get("id");

				//				String id2 = context.getExternalContext().getRequestParameterMap()
				//						.get("id2");

				Coachee ent= businessDelegatorView.getCoachee(Long.parseLong(id));

				//Coachee ent2= businessDelegatorView.getCoachee(Long.parseLong(id2));
				entity = ent;
				FacesUtils.putinSession("coachee", ent);

				//Coachee ent2= businessDelegatorView.getCoachee(3L);

				//String nameFile = plansito.getRubricFile().getFileName();
				byte[] arch = ent.getFoto() ;
				//	byte[] arch2 =ent2.getFoto();


				//arch.
				InputStream is = new ByteArrayInputStream(arch);

				//	String extension = getExtension(nameFile);

				DefaultStreamedContent nuevo = new DefaultStreamedContent(is, ".jpg", "prueba");

				filedownload = nuevo;
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage("", e.getMessage());
		}

		return filedownload;
	}






	public void setImageFromDB(	List<StreamedContent> imageFromDB) {
		this.imageFromDB = imageFromDB;
	}

	//	public 	List<StreamedContent> getImageFromDB() throws Exception {
	//		FacesContext context = FacesContext.getCurrentInstance();
	//
	//		//		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	//		//			return new List<DefaultStreamedContent()>;
	//		//		} else {
	//
	//		//	ByteArrayOutputStream bos =
	//
	//		// Reading image from database assuming that product image (bytes)
	//		// of product id I1 which is already stored in the database.
	//		//byte[] image = null;
	//		if (imageFromDB == null) {
	//			imageFromDB = new ArrayList<StreamedContent>();
	//			try {
	//				List<Coachee> ent= businessDelegatorView.getCoachee();
	//
	//				for (Coachee coachee : ent) {
	//					InputStream input =  new ByteArrayInputStream(coachee.getFoto());
	//					//String nameFile = plansito.getRubricFile().getFileName();
	//					//	byte[] arch = ent.getFoto();
	//					DefaultStreamedContent e = new DefaultStreamedContent(input,
	//							"image/jpg");
	//					System.out.println( e + "+++++++++++++++++++++");
	//					imageFromDB.add(e); 	
	//					imageFromDB.get(0);
	//				}
	//
	//			} catch (SQLException e) { // TODO Auto-generated catch block
	//				e.printStackTrace();					// e.printStackTrace();
	//			}
	//		}


	//
	//
	//		return imageFromDB;
	//
	//		//}
	//	}


	public List<SesCoaching> getSesHoy() {
		
		Coach co =(Coach) FacesUtils.getfromSession("coach");
		if (sesHoy== null) {
			sesHoy= businessDelegatorView.sesionesHoy(co);
		}

		return sesHoy;
	}

	public void setSesHoy(List<SesCoaching> sesHoy) {
		this.sesHoy = sesHoy;
	}

	public List<Coachee> getClientesHoy() {
		
		Coach co =(Coach) FacesUtils.getfromSession("coach");

		if (clientesHoy== null) {
			clientesHoy= businessDelegatorView.clientesSesionesHoy(co);
		}

		return clientesHoy;
	}

	public void setClientesHoy(List<Coachee> clientesHoy) {
		this.clientesHoy = clientesHoy;
	}
	public CommandButton getBtnRedirigir() {
		return btnRedirigir;
	}
	public void setBtnRedirigir(CommandButton btnRedirigir) {
		this.btnRedirigir = btnRedirigir;
	}




	public String actionRedirigir() {


		return "/XHTML/crearCoachee.xhtml";

	}


	//Redirigir ver mas 

	public CommandButton getBtnRedirigirMas() {
		return btnRedirigirMas;
	}
	public void setBtnRedirigirMas(CommandButton btnRedirigirMas) {
		this.btnRedirigirMas = btnRedirigirMas;
	}




	public String actionRedirigirMas() {
		// Recuerde ingresar el Coachee en las sesion como coachee
		//	Coachee ch=new Coachee();
		// FacesUtils.putinSession("coachee", entity);

		return "/XHTML/verMasCoachee.xhtml";

	}

	///
	public String actionSave() {
		try {
			entity = new Coachee();


			entity.setApellido(FacesUtils.checkString(txtApellido));
			entity.setCelular(txtCelular.getValue().toString());
			entity.setCorreo(FacesUtils.checkString(txtCorreo));
			entity.setDireccion(txtDireccion.getValue().toString());

			entity.setHobbies(FacesUtils.checkString(txtHobbies));
			entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			//businessDelegatorView.getEstado(1L)
			entity.setEstado(businessDelegatorView.getEstado(2L));
			entity.setTipoDocumento(businessDelegatorView.getTipoDocumento(1L));
			entity.setLogin(FacesUtils.checkString(txtIdentificacion));
			String con= Math.random()+ "contra";
			entity.setContrasena(con);

			businessDelegatorView.saveCoachee(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);

		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}



	public DefaultStreamedContent getImgVerMas() {
		//EvalReport miPlan = getEvalReport();
		getEntity();
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			}else {
				//businessDelegate.validateDownloadReport((miPlan.getIdEvalReport()));
				//EvalReport plansito = businessDelegate.findByIdEvalReport(miPlan.getIdEvalReport());
				//				String id = context.getExternalContext().getRequestParameterMap()
				//						.get("id");
					Coachee coach = (Coachee) FacesUtils.getfromSession("coachee");
				Coachee ent= businessDelegatorView.getCoachee(coach.getIdCoachee());
				//Coachee ent2= businessDelegatorView.getCoachee(3L);

				//String nameFile = plansito.getRubricFile().getFileName();
				byte[] arch = ent.getFoto() ;
				//	byte[] arch2 =ent2.getFoto();


				//arch.
				InputStream is = new ByteArrayInputStream(arch);

				//	String extension = getExtension(nameFile);

				DefaultStreamedContent nuevo = new DefaultStreamedContent(is, ".jpg", "prueba");

				imgVerMas = nuevo;
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage("", e.getMessage());
		}

		return imgVerMas;
	}
	public Coachee getEntity() {

		entity = (Coachee) FacesUtils.getfromSession("coachee");
		return entity;
	}
	public void setEntity(Coachee entity) {
		this.entity = entity;
	}




	public List<SelectItem> getLosTipoUsuarioItem() throws Exception {

		if(losTipoUsuarioItem==null){
			losTipoUsuarioItem=new ArrayList<SelectItem>();
			List<TipoDocumento> losTiposUsuario=businessDelegatorView.getTipoDocumento();
			for (TipoDocumento tiposUsuarios: losTiposUsuario) {
				losTipoUsuarioItem.add(new SelectItem(tiposUsuarios.getTdocNombre()));
			}
		}

		return losTipoUsuarioItem;
	}
	public SelectOneMenu getSomTipoUsuario() {
		return somTipoUsuario;
	}
	public void setSomTipoUsuario(SelectOneMenu somTipoUsuario) {
		this.somTipoUsuario = somTipoUsuario;
	}
	public void setLosTipoUsuarioItem(List<SelectItem> losTipoUsuarioItem) {
		this.losTipoUsuarioItem = losTipoUsuarioItem;
	}


	//	<h:form style="width: 100%" enctype="multipart/form-data">
	//	<p:growl id="msgs" showDetail="true" />
	//	<div class="divConsulta2">
	//		<div
	//			style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 100%">
	//
	//			<h5 style="text-align: center; color: black">Gestión Clientes</h5>
	//
	//
	//
	//			<ui:repeat var="apt" value="#{coacheeView.data}">
	//				<p:separator style="width:1000px;height:5px" />
	//				<p:panelGrid columns="1" layout="grid">
	//					<f:facet name="header">
	//						<p:graphicImage value="#{coacheeView.filedownload}" width="200"
	//							height="100" styleClass="content">
	//							<f:param name="id" value="#{apt.idCoachee}" />
	//
	//						</p:graphicImage>
	//					</f:facet>
	//
	//
	//					<h:outputText value="#{apt.nombre} #{apt.apellido}" />
	//					<h:outputText value="#{apt.identificacion}" />
	//				</p:panelGrid>
	//			</ui:repeat>
	//
	//
	//		</div>
	//
	//	</div>
	//</h:form>



	//	  <f:facet name="footer">
	//      <p:commandButton update=":form:carDetail" oncomplete="PF('carDialog').show()" icon="ui-icon-search">
	//          <f:setPropertyActionListener value="#{car}" target="#{carouselView.selectedCar}" />
	//      </p:commandButton>
	//  </f:facet>


	//	<p:carousel value="#{coacheeView.data}" headerText="Custom"
	//			var="car" itemStyle="height:200px;text-align:center"
	//			numVisible="1" easing="easeOutBounce" style="width:250px"
	//			cricular="true">
	//			
	//					<p:graphicImage value="#{coacheeView.filedownload}" width="200"
	//			height="100" styleClass="content">
	//			<f:param name="id" value="#{car.idCoachee}" />
	//				</p:graphicImage>
	//			<h:panelGrid columns="2" style="width:100%"
	//				columnClasses="label,value">
	//				<f:facet name="header">
	//			
	//
	//				</f:facet>
	//
	//				<h:outputText value="Id:" />
	//				<h:outputText value="#{car.nombre}" />
	//
	//				<h:outputText value="Year" />
	//				<h:outputText value="#{car.identificacion}" />
	//
	//				<h:outputText value="Color:" />
	//				<h:outputText value="121" />
	//
	//				<h:outputText value="Price" />
	//				<h:outputText value="1156" />
	//
	//
	//			</h:panelGrid>
	//		</p:carousel>




}
