package pdg.presentation.view;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import pdg.utilities.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
@ViewScoped
@ManagedBean(name = "PrincipalView")
public class PrincipalView {


	public String clientesAction() {
		System.out.println("clientesAction");
		return "/XHTML/gestionCoacheeView.xhtml";
		
	}
	
	public String perfilAction() {
		System.out.println("perfilAction");
	//	return "/XHTML/NewFile.xhtml";
		//return "/XHTML/coach.xhtml";
		return "/XHTML/coachDefinitivo.xhtml";
	}
	public String pagosAction() {
		System.out.println("PagosAction");
		return "/XHTML/agendarSesion.xhtml";
	}
	public String procesosAction() {
		System.out.println("ProcesosAction");
		//return "/XHTML/procCoachingListDataTable.xhtml";
		return "/XHTML/procesosDefinitivo.xhtml";
	}
	
	public String sesionesAction() {
		System.out.println("SesionesAction");
		//return "/XHTML/principalFinal.xhtml";
		return "/XHTML/principalFinal.xhtml";
	}
	
	
	 
	}


